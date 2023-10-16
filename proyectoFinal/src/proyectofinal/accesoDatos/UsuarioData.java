package proyectofinal.accesoDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.Entidades.Lector;

public class UsuarioData {

    private Connection con = null;

    public UsuarioData() {

        con = Conexion.getConexion();
    }

    public void registrarLector(Lector usuario) {
        String sql = "INSERT INTO `usuario`(`nombre`, `domicilio`, `mail`,  `estado`) "
                + "VALUES ('" + usuario.getNombre() + "','" + usuario.getDomicilio() + "','" + usuario.getMail() + "', 1)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int validacion = ps.executeUpdate();
            if (validacion > 0) {
                System.out.println("Se registro correctamente el usuario");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario." + ex.getMessage());
        }
    }

    public Lector buscarLectorPorId(int nroSocio) {
        String sql = "SELECT * FROM usuario WHERE idSocio = ? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);
            ResultSet rs = ps.executeQuery();
            Lector usuario = new Lector();

            if (rs.next()) {
                usuario.setNroSocio(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setDomicilio(rs.getString(3));
                usuario.setMail(rs.getString(4));
                usuario.setEstado(rs.getBoolean(5));
                System.out.println("El usuario se a encontrado con exito.");

                return usuario;
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Usuario" + ex.getMessage());

        }
        return null; // Devuelve null si no se encuentra el lector

    }

    public void modificarDatosDeLector(Lector usuario) {
        String sql = "UPDATE usuario SET `nombre`= '" + usuario.getNombre() + "',`domicilio`= '" + usuario.getDomicilio() + 
                "',`mail`= '"+ usuario.getMail() + "',`estado`= " + usuario.isEstado() + " WHERE idSocio = " + usuario.getNroSocio();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int modif = ps.executeUpdate();

            if (modif > 0) {
                System.out.println("Se modifico el usuario con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el usuario" + ex.getMessage());
        }

    }

    public void eliminarLector(int nroSocio) {
        String sql = "UPDATE usuario SET estado = 0 WHERE idSocio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);
            int validacion = ps.executeUpdate();
                if(validacion > 0){
                 System.out.println("Se eliminó correctamente el usuario"+ nroSocio);   
                }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario." + ex.getMessage());
        }
    }
}
