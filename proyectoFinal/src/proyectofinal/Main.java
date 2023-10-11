
package proyectofinal;


import java.util.Date;
import proyectofinal.Entidades.*;
import proyectofinal.accesoDatos.*;


public class Main {


    public static void main(String[] args) {

    PrestamoData prestamoData = new PrestamoData();

        Lector lector = new Lector();
        lector.setNroSocio(8);  // Reemplaza con el número de socio del lector existente
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setCodigo(16);  // Reemplaza con el código del ejemplar existente
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaInicio(new Date());
        prestamo.setFechaFin(new Date());
        prestamo.setEstado(true);  // Define el estado como sea necesario

        prestamo.setLector(lector);
        prestamo.setEjemplar(ejemplar);
        prestamoData.finalizarPrestamo(prestamo);
        //prestamoData.crearPrestamo(prestamo);
    }



}
