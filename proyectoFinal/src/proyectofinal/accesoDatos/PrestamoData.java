/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.accesoDatos;

import java.sql.*;
import java.util.*;
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
private List<Prestamo> listaP = new ArrayList<>(); 

    public PrestamoData(){
    con = Conexion.getConexion();
    con=Conexion.getConexion();
       ejData=new EjemplarData();
       uData=new UsuarioData();
       liData=new LibroData();
    }
    
//Metodos
    
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
        String sqlUpdateEjemplar = "UPDATE ejemplar SET estado = ? WHERE idCodigo = ?";
        PreparedStatement psUpdateEjemplar = con.prepareStatement(sqlUpdateEjemplar);
        psUpdateEjemplar.setInt(1, 0);  // Actualiza el estado del ejemplar a "0"
        psUpdateEjemplar.setInt(2, p.getEjemplar().getCodigo());
        psUpdateEjemplar.executeUpdate();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al crear préstamo: " + ex.getMessage());
    }
}
 
    
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


    
   
    
    
    
    
    


    
    
    
    
    
    
}
