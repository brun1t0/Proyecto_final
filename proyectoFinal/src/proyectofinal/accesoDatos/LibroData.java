/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.accesoDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.Entidades.*;

/**
 *
 * @author Usuario
 */
public class LibroData {
    private Connection con = null;
    public LibroData(){
  //  con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro) {

        String sql = "INSERT INTO `libro`(`isbn`, `titulo`, `autor`, `año`, `tipo`, `editorial`, `estado`) "
                + "VALUES ("+libro.getIsbn()+",'"+libro.getTipo()+"','autor1',"+libro.getAnio()+" ,'"+libro.getTipo()+"','"+libro.getEditorial()+"', 1)";

       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            int fila = ps.executeUpdate();
            
            if (fila > 0) {
                
                System.out.println("Se ha guardado el libro con éxito, ISBN:" + libro.getIsbn());
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar libro." + ex.getMessage());
        }
    }
    
    
    public Libro buscarLibroPorISBN(int isbn){
    String sql = "SELECT `isbn`, `titulo`, `autor`, `año`, `tipo`, `editorial`, `estado` FROM `libro` WHERE isbn = "+isbn+" AND estado = true";
    
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        Libro libro = new Libro();
            if (rs.next()) {
            libro.setIsbn(isbn);
            libro.setTitulo(rs.getString(2));
           // libro.setAutor(rs.getString(3));
            libro.setAnio(rs.getInt(4));
            libro.setTipo(rs.getString(5));
            libro.setEditorial(rs.getString(6));
            libro.setEstado(rs.getBoolean(7));
                System.out.println("El libro se ha encontrado con éxito.");
                return libro;
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro");
        }
        return null;
        
        
    }
    
}

