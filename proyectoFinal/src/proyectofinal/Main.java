
package proyectofinal;


import proyectofinal.vistas.vistaPrincipal;


public class Main {


   public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vistaPrincipal ventanaPrincipal = new vistaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        });
    }



}
