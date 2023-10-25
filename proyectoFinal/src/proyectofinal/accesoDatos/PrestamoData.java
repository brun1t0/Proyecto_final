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
import org.mariadb.jdbc.export.Prepare;
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

    public PrestamoData() {
        con = Conexion.getConexion();
        con = Conexion.getConexion();
        ejData = new EjemplarData();
        uData = new UsuarioData();
        liData = new LibroData();
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear préstamo: " + ex.getMessage());
        }
    }

    public void finalizarPrestamo(Prestamo p) {
        try {
            // Actualizar el estado del préstamo
            String sql = "UPDATE Prestamo SET estado = 0 WHERE idSocio = ? AND idCodigo = ?";
            PreparedStatement psUpdatePrestamo = con.prepareStatement(sql);

            psUpdatePrestamo.setInt(1, p.getLector().getNroSocio());
            psUpdatePrestamo.setInt(2, p.getEjemplar().getIdCodigo());
            int rowsUpdated = psUpdatePrestamo.executeUpdate();

            if (rowsUpdated > 0) {
                // Actualizar el estado del ejemplar a disponible (true)
                ejData.devolverEjemplar(p.getEjemplar().getIdCodigo());
            }
            psUpdatePrestamo.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al realizar la devolución: " + ex.getMessage());
        }
    }

    public void modificarPrestamo(int idSocio, int idCodigo, java.util.Date fechaInicio, java.util.Date nuevaFecha) {
    try {
        String sql = "UPDATE Prestamo SET fechaFin = ? WHERE idSocio = ? AND idCodigo = ? AND fechaInicio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(nuevaFecha.getTime()));
        ps.setInt(2, idSocio);
        ps.setInt(3, idCodigo);
        ps.setDate(4, new java.sql.Date(fechaInicio.getTime()));

        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Prestamo modificado exitosamente.");
        } else {
            System.out.println("No se encontraron préstamos para modificar.");
        }

        ps.close();
    } catch (SQLException ex) {
        System.err.println("Error al modificar el préstamo: " + ex.getMessage());
    }
}


    
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar préstamo por ejemplar: " + ex.getMessage());
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
            ps.close();
            return listaPrestamo;

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Prestamo buscarPrestamoPorIdSocioCodigoYFecha(int idSocio, int idCodigo, java.util.Date fechaInicio) {
    try {
        // Construir la consulta SQL para buscar el préstamo
        String sql = "SELECT * FROM Prestamo WHERE idSocio = ? AND idCodigo = ? AND fechaInicio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idSocio);
        ps.setInt(2, idCodigo);
        ps.setDate(3, new java.sql.Date(fechaInicio.getTime())); // Convertir a java.sql.Date

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
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar préstamo: " + ex.getMessage());
    }
    return null;
}

    public List<Lector> obtenerLectoresQuePidieronPrestamos() {
        try {
            List<Lector> listaLector = new ArrayList<>();
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
public List<Map<String, Object>> obtenerLectoresConPrestamosVencidos() {
    try {
        List<Map<String, Object>> lectoresConPrestamosVencidos = new ArrayList<>();
        String sql = "SELECT usuario.idSocio, usuario.nombre, usuario.domicilio, usuario.mail, prestamo.fechaFin "
                + "FROM Prestamo "
                + "JOIN usuario ON (Prestamo.idSocio = usuario.idSocio) "
                + "WHERE Prestamo.estado = 1 AND Prestamo.fechaFin < CURDATE()";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Map<String, Object> data = new HashMap<>();
            data.put("idSocio", rs.getInt("usuario.idSocio"));
            data.put("nombre", rs.getString("usuario.nombre"));
            data.put("domicilio", rs.getString("usuario.domicilio"));
            data.put("mail", rs.getString("usuario.mail"));
            data.put("fechaFin", rs.getDate("prestamo.fechaFin"));
            
            lectoresConPrestamosVencidos.add(data);
        }

        return lectoresConPrestamosVencidos;
    } catch (SQLException ex) {
        Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}





    
    
    public List<Map<String, Object>> obtenerLectoresConPrestamosProximosAVencer() {
    try {
        List<Map<String, Object>> lectoresConPrestamosProximosAVencer = new ArrayList<>();
        String sql = "SELECT usuario.idSocio, usuario.nombre, usuario.domicilio, usuario.mail, usuario.estado, prestamo.fechaInicio, prestamo.fechaFin "
                + "FROM Prestamo "
                + "JOIN usuario ON (Prestamo.idSocio = usuario.idSocio) "
                + "WHERE Prestamo.estado = 1 AND Prestamo.fechaFin >= CURDATE()";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Map<String, Object> data = new HashMap<>();
            data.put("idSocio", rs.getInt("usuario.idSocio"));
            data.put("nombre", rs.getString("usuario.nombre"));
            data.put("domicilio", rs.getString("usuario.domicilio"));
            data.put("mail", rs.getString("usuario.mail"));
            data.put("estado", rs.getBoolean("usuario.estado"));
            data.put("fechaInicio", rs.getDate("prestamo.fechaInicio"));
            data.put("fechaFin", rs.getDate("prestamo.fechaFin"));

            lectoresConPrestamosProximosAVencer.add(data);
        }

        return lectoresConPrestamosProximosAVencer;
    } catch (SQLException ex) {
        Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}





    public Ejemplar obtenerLibrosPrestadosEnUnaFechaPredeterminada(LocalDate fecha) {

        return null;
    }

}
