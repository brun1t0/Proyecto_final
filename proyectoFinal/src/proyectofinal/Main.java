
package proyectofinal;


import proyectofinal.Entidades.*;
import proyectofinal.accesoDatos.*;

/**
 *
 * @author Usuario
 */
public class Main {

   
    public static void main(String[] args) {
        
        UsuarioData usuario = new UsuarioData();
        Lector usur = usuario.buscarLectorPorId(21);
        //usur.setMail("perdomo@gmail.com");
        usuario.eliminarLector(21);
       // usuario.registrarLector(usur);
       System.out.println(usur);
        
    }

}
