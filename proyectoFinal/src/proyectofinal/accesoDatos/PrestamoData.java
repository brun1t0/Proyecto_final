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
private EjemplarData ejData;
private UsuarioData uData;
private LibroData liData;


    private Connection con = null;
//    private EjemplarData ejData;
//    private UsuarioData uData;
//    private LibroData liData;
    

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
        int validar = ps.executeUpdate();
        ejData.prestarEjemplar(p.getEjemplar().getIdCodigo());
        // Actualizar el estado del ejemplar
        if (validar > 0) {
            
            System.out.println("Se ha prestado un ejemplar correctamente.");

        }
        
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


  //Busqueda de prestamos    

    public Prestamo buscarPrestamoPorEjemplar(int idCodigo) {
    try {
        // Buscar un préstamo por ID de ejemplar
        String sql = "SELECT * FROM Prestamo WHERE idCodigo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCodigo);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            Prestamo prestamo = new Prestamo();
            // Configurar los atributos del préstamo
            prestamo.setFechaInicio(rs.getDate(1));
            prestamo.setFechaFin(rs.getDate(2));
            prestamo.setEstado(rs.getBoolean(3));
            // Recuperar el lector y ejemplar asociados al préstamo
            prestamo.setLector(uData.buscarLectorPorId(rs.getInt(4)));
            prestamo.setEjemplar(ejData.buscarEjemplarPorIdCodigo(idCodigo, false));
            return prestamo;
        }
    }
    return null;
}
    
    
    public List<Prestamo> buscarPrestamosPorLector(int idLector) {
        List<Prestamo> listaPrestamo = new ArrayList<>();

        String sql = "SELECT * FROM `prestamo` WHERE estado = 1 AND idSocio = " + idLector;
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rowsUpdate = ps.executeQuery();

            EjemplarData ejData = new EjemplarData();
            UsuarioData uData = new UsuarioData();

            while (rowsUpdate.next()) {

                Ejemplar ej = ejData.buscarEjemplarPorIdCodigo(rowsUpdate.getInt("idCodigo"), false);
                
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

    
    public List<Lector> obtenerLectoresQuePidieronPrestamos(){
    try {
        List<Lector> listaLector = new ArrayList<>();
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
        List<Ejemplar> listaEj = new ArrayList<>();
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
