/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.accesoDatos;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.Entidades.*;

/**
 *
 * @author Usuario
 */
public class PrestamoData {

    private Connection con = null;
//    private EjemplarData ejData;
//    private UsuarioData uData;
//    private LibroData liData;
    private List<Prestamo> listaPrestamo = new ArrayList<>();
    private List<Lector> listaLector = new ArrayList<>();
    private List<Ejemplar> listaEj = new ArrayList<>();
    private EjemplarData ejData = new EjemplarData();
    private UsuarioData uData = new UsuarioData();
    private LibroData lData = new LibroData();

    public PrestamoData() {
        con = Conexion.getConexion();
        ejData = new EjemplarData();
        uData = new UsuarioData();
        lData = new LibroData();

    }

//Metodos
    //Gestion de prestamo  
    public void crearPrestamo(Prestamo p) {
        try {
            // Insertar un nuevo préstamo en la base de datos
            String sql = "INSERT INTO Prestamo (fechaInicio, fechaFin, estado, idSocio, idCodigo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate(2, new java.sql.Date(p.getFechaFin().getTime()));
            ps.setBoolean(3, p.isEstado());
            ps.setInt(4, p.getLector().getNroSocio());
            ps.setInt(5, p.getEjemplar().getIdCodigo());
            ps.executeUpdate();

            // Actualizar el estado del ejemplar
            String sql2 = "UPDATE ejemplar SET estado = ? WHERE idCodigo = ?";
            PreparedStatement psUpdateEjemplar = con.prepareStatement(sql2);
            psUpdateEjemplar.setInt(1, 0);  // Actualiza el estado del ejemplar a "0"
            psUpdateEjemplar.setInt(2, p.getEjemplar().getIdCodigo());
            psUpdateEjemplar.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear préstamo: " + ex.getMessage());
        }
    }

    public void finalizarPrestamo(Prestamo p) {
        try {
            // Actualizar el estado del préstamo
            String sql = "UPDATE Prestamo SET estado = ? WHERE idSocio = ? AND idCodigo = ?";
            PreparedStatement psUpdatePrestamo = con.prepareStatement(sql);
            psUpdatePrestamo.setBoolean(1, p.isEstado());
            psUpdatePrestamo.setInt(2, p.getLector().getNroSocio());
            psUpdatePrestamo.setInt(3, p.getEjemplar().getIdCodigo());
            int rowsUpdated = psUpdatePrestamo.executeUpdate();

            if (rowsUpdated > 0) {
                // Actualizar el estado del ejemplar a disponible (true)
                String sql2 = "UPDATE ejemplar SET estado = ? WHERE idCodigo = ?";
                PreparedStatement psUpdateEjemplar = con.prepareStatement(sql2);
                psUpdateEjemplar.setBoolean(1, true);  // Cambiar el estado a "disponible" (true)
                psUpdateEjemplar.setInt(2, p.getEjemplar().getIdCodigo());
                psUpdateEjemplar.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al realizar la devolución: " + ex.getMessage());
        }
    }

    //Busqueda de prestamos    
    public List<Prestamo> buscarPrestamoPorEjemplar(int idCodigo) {
        try {
            String sql = "SELECT * FROM `prestamo` WHERE prestamo.estado = 1 AND prestamo.idCodigo = " + idCodigo;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar ejemplar = ejData.buscarEjemplarPorIdCodigo(idCodigo);
                Lector lector = uData.buscarLectorPorId(rs.getInt(4));
                Prestamo p = new Prestamo(rs.getDate(1), rs.getDate(2), ejemplar, lector, rs.getBoolean(3));
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Prestamo> buscarPrestamosPorLector(int Lector) {
        try {
            String sql = "SELECT * FROM `prestamo` WHERE prestamo.estado = 1 AND prestamo.idSocio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, Lector);
            ResultSet rowsUpdate = ps.executeQuery();
            while (rowsUpdate.next()) {
                Ejemplar ej = ejData.buscarEjemplarPorIdCodigo(rowsUpdate.getInt(5));
                Lector lec = uData.buscarLectorPorId(rowsUpdate.getInt(4));
                Prestamo p = new Prestamo(rowsUpdate.getDate(1), rowsUpdate.getDate(2), ej, lec, rowsUpdate.getBoolean(3));
                listaPrestamo.add(p);
            }
            return listaPrestamo;
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Lector> obtenerLectoresQuePidieronPrestamos() {
        try {
            String sql = "SELECT usuario.idSocio, usuario.nombre, usuario.domicilio, usuario.mail, usuario.estado FROM `prestamo` JOIN usuario ON (prestamo.idSocio = usuario.idSocio) WHERE prestamo.estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lec = new Lector(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
                listaLector.add(lec);
            }
            return listaLector;
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Ejemplar> obtenerLibrosPrestadosEnUnaFechaPredeterminada(LocalDate fecha) {
        try {
           
            String sql = "SELECT ejemplar.idCodigo, ejemplar.isbn, ejemplar.estado FROM prestamo "
                    + "JOIN ejemplar ON prestamo.idCodigo = ejemplar.idCodigo "
                    + "JOIN libro ON ejemplar.isbn = libro.isbn "
                    + "WHERE fechaInicio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = lData.buscarLibroPorISBN(rs.getLong(2));
                Ejemplar ej = new Ejemplar(libro, rs.getInt(1), rs.getBoolean(3));
                listaEj.add(ej);
            }

            if (listaEj.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron libros prestados en la fecha indicada.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

            return listaEj;
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
