
package proyectofinal;

import proyectofinal.Entidades.Libro;
import proyectofinal.accesoDatos.LibroData;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LibroData ld = new LibroData();
       
       Libro libro = new Libro(123456, "Campo de Fresas", 2005, "Drama", "Billiken", true);
       ld.guardarLibro(libro);
       
       ld.buscarLibroPorISBN(123456);
    }
    
}
