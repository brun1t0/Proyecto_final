package proyectofinal.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.Entidades.Ejemplar;
import proyectofinal.Entidades.Libro;

public class EjemplarData {

    private Connection con = null;
    private LibroData ld = new LibroData();

    public EjemplarData() {
        con = Conexion.getConexion();
    }

    public List<Ejemplar> buscarEjemplarisbn(long isbn) {
        
        List<Ejemplar> ejemplares = new ArrayList<>();

        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.estado, ejemplar.isbn, libro.titulo "
                    + "FROM ejemplar "
                    + "JOIN libro ON ejemplar.isbn = libro.isbn "
                    + "WHERE ejemplar.isbn = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, isbn);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCodigo = rs.getInt("idCodigo");
                boolean estado = rs.getBoolean("estado");
                long isbnResult = rs.getLong("isbn");

                Libro libro = ld.buscarLibroPorISBN(isbnResult);

                if (libro != null) {
                    Ejemplar ejemplar = new Ejemplar(libro, idCodigo, estado, isbnResult);
                    ejemplares.add(ejemplar);
                    System.out.println("Título del libro: " + libro.getTitulo());
                }
            }
            if (ejemplares.isEmpty()) {
                System.out.println("No se encontraron ejemplares para el ISBN: " + isbn);
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar ejemplares: " + e.getMessage());
        }

        return ejemplares;
    }

    public Ejemplar buscarEjemplarPorIdCodigo(int idCodigo, boolean estado) {
    String sql = "SELECT idCodigo, estado, isbn FROM ejemplar WHERE idCodigo = "+idCodigo+" AND estado = "+ estado;
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
       

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boolean estado1 = rs.getBoolean(2);
                long isbn = rs.getLong(3);
                
                Libro lib = ld.buscarLibroPorISBN(isbn);
                Ejemplar ej = new Ejemplar(lib, idCodigo, estado1);
                return ej;
            }

            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar ejemplares por idCodigo: " + e.getMessage());
        }

        return null;
    }

    public List<Ejemplar> buscarEjemplarPorNombre(String nombreEjemplar) {
        List<Ejemplar> ejemplares = new ArrayList<>();

        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.estado, ejemplar.isbn, libro.titulo"
                    + "FROM ejemplar JOIN libro ON (ejemplar.isbn = libro.isbn) "
                    + "WHERE libro.titulo LIKE '%"+ nombreEjemplar +"%'";
            
            PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCodigo = rs.getInt("idCodigo");
                boolean estado = rs.getBoolean("estado");
                long isbnResult = rs.getLong("isbn");
                

                Libro libro = ld.buscarLibroPorISBN(isbnResult);

                    Ejemplar ejemplar = new Ejemplar(libro, idCodigo, estado, isbnResult);
                    ejemplares.add(ejemplar);
                    System.out.println("Título del libro: " + libro.getTitulo());

            }
            if (ejemplares.isEmpty()) {
                System.out.println("No se encontraron ejemplares para el nombre: " + nombreEjemplar);
            }
            
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar ejemplares: " + e.getMessage());
        }
        return ejemplares;
    }

    public int listarCantidadDeEjemplaresDisponibles() {
        List<Ejemplar> ejemplares = new ArrayList<>();
        int cantidadLibrosDisponibles = 0;

        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.isbn, ejemplar.estado"
                    + "FROM ejemplar "
                    + "WHERE ejemplar.estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
              
                cantidadLibrosDisponibles++;
            }

            System.out.println("Cantidad de libros disponibles: " + cantidadLibrosDisponibles);
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al listar ejemplares: " + e.getMessage());
        }

        return cantidadLibrosDisponibles;
    }

    public List<Ejemplar> listarEjemplaresDisponiblesPorLibro(long isbn) {
        List<Ejemplar> ejemplares = new ArrayList<>();
        int cantidadLibrosDisponibles = 0;

        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.isbn, libro.titulo "
                    + "FROM ejemplar JOIN libro ON (ejemplar.isbn = libro.isbn) "
                    + "WHERE ejemplar.estado = 1 AND ejemplar.isbn = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, isbn);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCodigo = rs.getInt("idCodigo");
                String tituloLibro = rs.getString("titulo");
                Libro libro = ld.buscarLibroPorISBN(isbn);
                

                Ejemplar ejemplar = new Ejemplar(libro, idCodigo, true, isbn);
                ejemplar.setNombreLibro(tituloLibro);
                ejemplares.add(ejemplar);
                cantidadLibrosDisponibles++;
            }
            System.out.println("Cantidad de libros disponibles para el libro con ISBN " + isbn + ": " + cantidadLibrosDisponibles);
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al listar ejemplares: " + e.getMessage());
        }
        return ejemplares;
    }

    public void modificarEstadoEjemplar(long isbn, boolean nuevoEstado) {
        try {
            String sql = "UPDATE ejemplar SET estado = ? WHERE isbn = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, nuevoEstado);
            ps.setLong(2, isbn);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("El estado del ejemplar con ISBN " + isbn + " ha sido modificado.");
            } else {
                System.out.println("No se pudo modificar el estado del ejemplar con ISBN " + isbn);
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al modificar el estado del ejemplar: " + e.getMessage());
        }
    }
    
    public void prestarEjemplar(int idCodigo) {
        String sql = "UPDATE `ejemplar` SET `estado`= 0 WHERE idCodigo =" + idCodigo + " AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int filaEliminada = ps.executeUpdate();

            if (filaEliminada > 0) {
                System.out.println("Se ha eliminado el libro correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al prestar libro " + ex.getMessage());
        }

    }
    
    public void devolverEjemplar(int idCodigo){
    String sql = "UPDATE ejemplar SET estado = 1 WHERE idCodigo = " + idCodigo;
           
        try {
             PreparedStatement psUpdateEjemplar = con.prepareStatement(sql);
            int validar = psUpdateEjemplar.executeUpdate();
            
            if (validar > 0) {
                System.out.println("El libro se ha devuelto correctamente");
            }
            psUpdateEjemplar.close();
        } catch (SQLException ex) {
            System.out.println("Error al devolver el libro");
        }
    
    }

}
