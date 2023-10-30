
package proyectofinal;


import java.time.LocalDate;
import java.util.Date;
import proyectofinal.Entidades.*;
import proyectofinal.accesoDatos.*;


public class Main {


    public static void main(String[] args) {
       //Fijense si responde el programa.
        UsuarioData ud = new UsuarioData();
        EjemplarData ed = new EjemplarData();

    Lector lec = ud.buscarLectorPorId(2);
        System.out.println(lec);
        System.out.println("");
         System.out.println("");
          System.out.println("");
           System.out.println("");
           
           
    Ejemplar ejem = ed.buscarEjemplarPorIdCodigo(3, true);
        System.out.println(ejem);
         System.out.println("");
          System.out.println("");
           System.out.println("");
            System.out.println("");
    Date fechaInicio = new Date(2023, 05, 20);
    Date fechaFin = new Date(2023, 05, 25);
    Prestamo pres = new Prestamo(fechaInicio, fechaFin , ejem, lec, true);

    PrestamoData pd = new PrestamoData();
    pd.crearPrestamo(pres);
     System.out.println("");
      System.out.println("");
       System.out.println("");
        System.out.println("");
        
        System.out.println(pd.buscarPrestamoPorEjemplar(3).toString());
        
        
         System.out.println("");
          System.out.println("");
           System.out.println("");
            System.out.println("");
            for (Prestamo prestamo : pd.buscarPrestamosPorLector(2)) {
             System.out.println(prestamo.getEjemplar());
              System.out.println("");
        }
        System.out.println(""); 
         System.out.println("");
          System.out.println("");
           System.out.println("");
    pd.finalizarPrestamo(pres);
    
    }



}
