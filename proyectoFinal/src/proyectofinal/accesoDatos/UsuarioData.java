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
                + "VALUES ('" + usuario.getNombre() + "','" + usuario.getDomicilio() + "','" + usuario.getMail() + "', "+usuario.isEstado()+")";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int validacion = ps.executeUpdate();
            if (validacion > 0) {
               JOptionPane.showMessageDialog(null, "Se registro correctamente usuario.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario." + ex.getMessage());
        }
    }

    public Lector buscarLectorPorId(int nroSocio) {
        String sql = "SELECT * FROM usuario WHERE idSocio = " + nroSocio;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
           // ps.setInt(1, nroSocio);
            ResultSet rs = ps.executeQuery();
            Lector usuario = new Lector();

            if (rs.next()) {
                usuario.setNroSocio(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setDomicilio(rs.getString(3));
                usuario.setMail(rs.getString(4));
                usuario.setEstado(rs.getBoolean(5));
              

                return usuario;
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Usuario" + ex.getMessage());

        }
        return null; // Devuelve null si no se encuentra el lector

    }

    public void modificarDatosDeLector(Lector usuario) {
        
        String sql = "UPDATE usuario SET `nombre` = '" + usuario.getNombre() + "', `domicilio` = '" + usuario.getDomicilio() + 
                "', `mail` = '"+ usuario.getMail() + "', `estado` = " + usuario.isEstado() + " WHERE idSocio = " + usuario.getNroSocio();
        System.out.println(sql);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int modif = ps.executeUpdate();
            //System.out.println(this.buscarLectorPorId(usuario.getNroSocio()));
            if (modif > 0) {
                JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
            }else{
                System.out.println("No se modifico ningun usuario");
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
                   JOptionPane.showMessageDialog(null, "Se eliminó el usuario con ID: " + nroSocio);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario con el Id proporcionado.");
                }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario." + ex.getMessage());
        }
    }
}
