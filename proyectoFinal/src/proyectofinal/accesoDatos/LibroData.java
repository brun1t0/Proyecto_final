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


    public LibroData() {

        con = Conexion.getConexion();

    }

    public void guardarLibro(Libro libro) {

        String sql = "INSERT INTO `libro`(`isbn`, `titulo`, autor, `año`, `tipo`, `editorial`, `estado`) "
                + "VALUES (" + libro.getIsbn() + ",'" + libro.getTitulo() + "','" + libro.getAutor() + "'," + libro.getAnio() + " ,'" + libro.getTipo() + "','" + libro.getEditorial() + "', " + libro.isEstado() + ")";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            int fila = ps.executeUpdate();

            if (fila > 0) {

                JOptionPane.showMessageDialog(null, "Se ha guardado un libro con éxito. " + "ISBN: " + libro.getIsbn());
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ya hay un libro con ese ISBN.");
        }
    }

    public Libro buscarLibroPorISBN(long isbn) {
        String sql = "SELECT * FROM libro WHERE isbn = " + isbn + " AND estado = 1";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            Libro libro = new Libro();

            if (rs.next()) {

                libro.setIsbn(isbn);
                libro.setTitulo(rs.getString(3));
                libro.setAutor(rs.getString(2));
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

    public ArrayList<Libro> buscarLibrosPorTitulo(String titulo) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        String sql = "SELECT * FROM `libro` WHERE titulo LIKE '%" + titulo + "%' AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);
            }
            ps.close();
            return listaLibros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());

        }

        return null;
    }

    public ArrayList<Libro> listarLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        String sql = "SELECT * FROM `libro` WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);

            }
            ps.close();
            return listaLibros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());
        }
        return null;
    }

    public void modificarLibro(Libro libro) {

        String sql = "UPDATE `libro` SET `autor`='" + libro.getAutor() + "',`titulo`='" + libro.getTitulo() + "',`año`= " + libro.getAnio() + ",`tipo`='" + libro.getTipo() + "',`editorial`='" + libro.getEditorial() + "',`estado`= " + libro.isEstado() + " WHERE isbn = " + libro.getIsbn();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int verificar = ps.executeUpdate();

            if (verificar > 0) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado un libro con éxito. " + "ISBN: " + libro.getIsbn());

            } else{JOptionPane.showMessageDialog(null, "No existe un libro con ese ISBN.");}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());
        }

    }

    public ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM `libro` WHERE autor LIKE '%" + autor + "%' AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);

            }
            ps.close();
            return listaLibros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());
        }
        return null;

    }

    public ArrayList<Libro> buscarLibrosPorAnio(int anio) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        String sql = "SELECT * FROM `libro` WHERE año =" + anio + " AND estado = true";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);
            }

            return listaLibros;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());

        }

        return null;
    }

    public ArrayList<Libro> buscarLibrosPorTipo(String tipo) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM `libro` WHERE tipo LIKE '%" + tipo + "%' AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);
            }

            return listaLibros;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());

        }

        return null;
    }

    public ArrayList<Libro> buscarLibrosPorEditorial(String editorial) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM `libro` WHERE editorial LIKE '%" + editorial + "%' AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(2));
                listaLibros.add(libro);
            }

            return listaLibros;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());

        }

        return null;
    }

    public void eliminarLibro(long isbn) {
        String sql = "UPDATE `libro` SET `estado`= 0 WHERE isbn =" + isbn + " AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int filaEliminada = ps.executeUpdate();

            if (filaEliminada > 0) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado un libro con éxito. " + "ISBN: " + isbn);
            }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningún libro con ese ISBN.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar libro " + ex.getMessage());
        }

    }
    
    public Libro buscarPorISBNSinEstado(long isbn) {
        String sql = "SELECT * FROM libro WHERE isbn = " + isbn;

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            Libro libro = new Libro();

            if (rs.next()) {

                libro.setIsbn(isbn);
                libro.setTitulo(rs.getString(3));
                libro.setAutor(rs.getString(2));
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


