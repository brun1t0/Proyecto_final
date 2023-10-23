package proyectofinal.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public String guardarEjemplar(String isbn, boolean estado) {
        Libro libro = ld.buscarLibroPorISBN(Long.parseLong(isbn));
        if (libro != null) {
            String sql = "INSERT INTO `Ejemplar`(`isbn`, `estado`) VALUES (?, ?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, isbn);
                ps.setBoolean(2, estado);
                int fila = ps.executeUpdate();
                if (fila > 0) {
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        String idCodigo = String.valueOf(generatedKeys.getLong(1));
                        System.out.println("Se ha guardado el ejemplar con éxito para el ISBN: " + isbn + ", y el idCodigo generado es: " + idCodigo);
                        return idCodigo;
                    }
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " Error al guardar el ejemplar: " + ex.getMessage());
            }
        }
        return null;
    }

    public void actualizarEjemplar(int idCodigo, Long nuevoISBN) {
        try {
            String sql = "UPDATE Ejemplar SET ISBN = ? WHERE IdCodigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, nuevoISBN);
            ps.setInt(2, idCodigo);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("ISBN actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el ISBN.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el ISBN.");
        }
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
    String sql = "SELECT idCodigo, estado, isbn FROM ejemplar WHERE idCodigo = ? AND estado = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCodigo);
        ps.setBoolean(2, estado);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            boolean estado1 = rs.getBoolean(2);
            long isbn = rs.getLong(3);
            Libro lib = ld.buscarLibroPorISBN(isbn);
            Ejemplar ej = new Ejemplar(lib, idCodigo, estado1);
            return ej;
        } else {
            String mensaje = "El ejemplar con el código " + idCodigo + " no existe. Por favor, ingrese un código válido.";
            JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
        ps.close();
    } catch (SQLException e) {
        String errorMensaje = "Error al buscar ejemplares por idCodigo: " + e.getMessage();
        JOptionPane.showMessageDialog(null, errorMensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
}

    public List<Ejemplar> buscarEjemplarPorNombre(String nombreEjemplar) {
        List<Ejemplar> ejemplares = new ArrayList<>();
        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.estado, ejemplar.isbn, libro.titulo "
                    + "FROM ejemplar JOIN libro ON (ejemplar.isbn = libro.isbn) "
                    + "WHERE libro.titulo LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombreEjemplar + "%");
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

    public List<Ejemplar> buscarEjemplarPorAutor(String autor) {
        List<Ejemplar> ejemplares = new ArrayList<>();
        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.estado, ejemplar.isbn, libro.titulo "
                    + "FROM ejemplar JOIN libro ON (ejemplar.isbn = libro.isbn) "
                    + "WHERE libro.autor LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + autor + "%");
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
                System.out.println("No se encontraron ejemplares para el autor: " + autor);
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

    public void eliminarEjemplar(int idCodigo) {
        try {
            String sql = "UPDATE ejemplar SET estado = 0 WHERE idCodigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCodigo);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("El ejemplar con idCodigo " + idCodigo + " ha sido eliminado.");
            } else {
                System.out.println("No se pudo eliminar el ejemplar con idCodigo " + idCodigo);
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al desactivar el ejemplar: " + e.getMessage());
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

    public void devolverEjemplar(int idCodigo) {
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

    public boolean verificarExistenciaISBN(long isbn) {
        try {
            String sql = "SELECT COUNT(*) FROM ejemplar WHERE ISBN = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Ejemplar obtenerEjemplarPorISBN(long isbn) {
        try {
            String sql = "SELECT ejemplar.idCodigo, ejemplar.estado, ejemplar.isbn, libro.autor, libro.titulo, libro.anio, libro.tipo, libro.editorial "
                    + "FROM ejemplar "
                    + "JOIN libro ON ejemplar.isbn = libro.isbn "
                    + "WHERE ejemplar.isbn = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, isbn);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idCodigo = rs.getInt("idCodigo");
                boolean estado = rs.getBoolean("estado");
                String autor = rs.getString("autor");
                String titulo = rs.getString("titulo");
                int año = rs.getInt("anio");
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");

                Libro libro = new Libro(isbn, titulo, año, tipo, editorial, estado, autor);
                Ejemplar ejemplar = new Ejemplar(libro, idCodigo, estado, isbn);
                return ejemplar;
            } else {
                System.out.println("No se encontró el ejemplar para el ISBN: " + isbn);
            }

            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el ejemplar por ISBN: " + e.getMessage());
        }

        return null;
    }
}
