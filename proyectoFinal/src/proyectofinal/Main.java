
package proyectofinal;


import proyectofinal.Entidades.*;
import proyectofinal.accesoDatos.*;

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
    Libro Coraline = new Libro(2221232, "Coralifdsfdsfne: La puerta secreta", 2009, "Fantasía","Bloomsburry" , true, "Neil Gaiman");
//        
   ld.guardarLibro(Coraline);
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
//        System.out.println(ld.buscarLibroPorISBN(2221232));
//        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
        for (Libro libro : ld.buscarLibrosPorTitulo("Coraline")) {
            System.out.println(libro.toString());
        }
        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
//        for (Libro libro : ld.listarLibros()) {
//            System.out.println(libro.toString());
//        }
//        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
        Libro Coraline1 = new Libro(2221232, "Coraline y la puerta secreta", 2009, "Fantasía","Bloomsburry" , true, "Neil Gaiman");
//        
        ld.modificarLibro(Coraline1);
        for (Libro libro : ld.buscarLibrosPorAutor("Neil Gaiman")) {
        System.out.println(libro.toString());  
        }
        
    }

}
