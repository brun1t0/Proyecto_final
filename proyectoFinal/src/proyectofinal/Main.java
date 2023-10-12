package proyectofinal;

import java.time.LocalDate;
import java.util.List;
import proyectofinal.Entidades.*;
import proyectofinal.accesoDatos.*;

public class Main {

//    public static void main(String[] args) {
//
//        PrestamoData prestamoData = new PrestamoData();
//        LocalDate fecha = LocalDate.of(2023, 10, 11);  // Reemplaza con la fecha deseada
//        List<Ejemplar> librosPrestados = prestamoData.obtenerLibrosPrestadosEnUnaFechaPredeterminada(fecha);
//        
//        System.out.println("Libros encontrados:");
//        for (Ejemplar ejemplar : librosPrestados) {
//           
//            System.out.println(ejemplar.getLibro().toString());
//            
//        }
//    }

    public static void main(String[] args) {
        PrestamoData prestamoData = new PrestamoData();

        // Reemplaza '1' con el ID del ejemplar que deseas buscar
        int idCodigo = 16;

        List<Prestamo> prestamos = prestamoData.buscarPrestamoPorEjemplar(idCodigo);

        if (prestamos != null) {
            for (Prestamo prestamo : prestamos) {
                System.out.println("Prestamo encontrado: " + prestamo);
            }
        } else {
            System.out.println("No se encontraron préstamos para el ejemplar con ID " + idCodigo);
        }
    }
}
