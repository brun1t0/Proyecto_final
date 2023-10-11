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
private List<Prestamo> listaP = new ArrayList<>(); 

    public PrestamoData(){
    con = Conexion.getConexion();
    con=Conexion.getConexion();
       ejData=new EjemplarData();
       uData=new UsuarioData();
       liData=new LibroData();
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
        ps.setInt(5, p.getEjemplar().getCodigo());
        ps.executeUpdate();

        // Actualizar el estado del ejemplar
        String sql2 = "UPDATE ejemplar SET estado = ? WHERE idCodigo = ?";
        PreparedStatement psUpdateEjemplar = con.prepareStatement(sql2);
        psUpdateEjemplar.setInt(1, 0);  // Actualiza el estado del ejemplar a "0"
        psUpdateEjemplar.setInt(2, p.getEjemplar().getCodigo());
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
        psUpdatePrestamo.setInt(3, p.getEjemplar().getCodigo());
        int rowsUpdated = psUpdatePrestamo.executeUpdate();
        
        if (rowsUpdated > 0) {
            // Actualizar el estado del ejemplar a disponible (true)
            String sql2 = "UPDATE ejemplar SET estado = ? WHERE idCodigo = ?";
            PreparedStatement psUpdateEjemplar = con.prepareStatement(sql2);
            psUpdateEjemplar.setBoolean(1, true);  // Cambiar el estado a "disponible" (true)
            psUpdateEjemplar.setInt(2, p.getEjemplar().getCodigo());
            psUpdateEjemplar.executeUpdate();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al realizar la devolución: " + ex.getMessage());
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
            prestamo.setFechaInicio(rs.getDate("fechaInicio"));
            prestamo.setFechaFin(rs.getDate("fechaFin"));
            prestamo.setEstado(rs.getBoolean("estado"));
            // Recuperar el lector y ejemplar asociados al préstamo
//            prestamo.setLector(uData.obtenerLectorPorId(rs.getInt("idSocio")));
//            prestamo.setEjemplar(ejData.obtenerEjemplarPorId(idCodigo));
//            return prestamo;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar préstamo por ejemplar: " + ex.getMessage());
    }
    return null;
}
    
    
    public List<Prestamo> buscarPrestamosPorLector(int Lector){
    try {
        List<Prestamo> listaPrestamo = new ArrayList<>();
        String sql= "SELECT * FROM `prestamo` WHERE prestamo.estado = 1 AND prestamo.idSocio = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(2, Lector);
        ResultSet rowsUpdate = ps.executeQuery();
        while (rowsUpdate.next()){
        //Prestamo p = new Prestamo(rowsUpdate.getDate(1), rowsUpdate.getDate(2), rowsUpdate.getInt(5), rowsUpdate.getInt(4), rowsUpdate.getBoolean(3));
        }
        return null;
    } catch (SQLException ex) {
        Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
    
    public Lector obtenerLectoresQuePidieronPrestamos(){
    
    return null;
    
    }
    
    public Ejemplar obtenerLibrosPrestadosEnUnaFechaPredeterminada(LocalDate fecha){
        
    return null;
    }

    
   
    
    
    
    
    


    
    
    
    
    
    
}
