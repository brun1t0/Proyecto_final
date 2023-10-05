/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.accesoDatos;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
	
    con = Conexion.getConexion(); 
	
    }
    
    public void guardarLibro(Libro libro, int idAutor) {

        String sql = "INSERT INTO `libro`(`isbn`, `titulo`, `idAutor`, `año`, `tipo`, `editorial`, `estado`) "
                + "VALUES ("+libro.getIsbn()+",'"+libro.getTitulo()+"',"+idAutor +","+libro.getAnio()+" ,'"+libro.getTipo()+"','"+libro.getEditorial()+"', 1)";

       
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
    String sql = "SELECT * FROM libro JOIN autor ON (libro.idAutor = autor.idAutor) WHERE isbn = "+isbn+" AND estado = 1";
    
        try {
            
        
         
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        Libro libro = new Libro();
        
            if (rs.next()) {
                
            Autor autor = new Autor(rs.getInt(2), rs.getString(8), rs.getString(9));   
                
            libro.setIsbn(isbn);
            libro.setTitulo(rs.getString(2));
            libro.setAutor(autor);
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
    
    public ArrayList<Libro> buscarLibrosPorTitulo(String titulo){
    ArrayList<Libro> listaLibros = new ArrayList<>();
        
    String sql = "SELECT * FROM `libro` JOIN autor ON (libro.idAutor = autor.idAutor) WHERE titulo LIKE '%"+titulo+"%' AND estado = 1";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
        Autor autor = new Autor(rs.getInt(8), rs.getString(9), rs.getString(10));
        Libro libro = new Libro(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), autor);
        listaLibros.add(libro);
        }
        ps.close();
        return listaLibros;
        
        
    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());
    
    }
    
    return null;
    }
    
}


