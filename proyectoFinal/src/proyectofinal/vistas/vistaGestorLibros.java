/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyectofinal.vistas;

import javax.swing.JOptionPane;
import proyectofinal.Entidades.Libro;
import proyectofinal.accesoDatos.LibroData;

/**
 *
 * @author Usuario
 */
public class vistaGestorLibros extends javax.swing.JInternalFrame {
private LibroData ld = new LibroData();
    /**
     * Creates new form gestorPrestamos
     */
    public vistaGestorLibros() {
        initComponents();
        inicializarComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tIsbn = new javax.swing.JTextField();
        tTitulo = new javax.swing.JTextField();
        tAnio = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        tAutor = new javax.swing.JTextField();
        tEditorial = new javax.swing.JTextField();
        rbEstado = new javax.swing.JRadioButton();
        bBuscar = new javax.swing.JButton();
        jpFooter = new javax.swing.JPanel();
        bSalir = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestor de libros");

        javax.swing.GroupLayout jpHeadLayout = new javax.swing.GroupLayout(jpHead);
        jpHead.setLayout(jpHeadLayout);
        jpHeadLayout.setHorizontalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpHeadLayout.setVerticalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 792, -1));

        jLabel2.setText("Título:");

        jLabel3.setText("Año:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Autor:");

        jLabel6.setText("Editorial:");

        jLabel7.setText("Estado:");

        jLabel8.setText("Numero ISBN:");

        bBuscar.setText("Buscar por ISBN");
        bBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEstado)
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 307, Short.MAX_VALUE)
                            .addComponent(tTitulo)
                            .addComponent(tIsbn))
                        .addGap(18, 18, 18)
                        .addComponent(bBuscar)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jpBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 620, -1));

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFooterLayout = new javax.swing.GroupLayout(jpFooter);
        jpFooter.setLayout(jpFooterLayout);
        jpFooterLayout.setHorizontalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 511, 786, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        Long isbn = null;
        String titulo = null;
        Integer anio = null;
        String tipo = null;
        String editorial = null;
        Boolean estado = null;
        String autor = null;
        try {
            isbn = Long.parseLong(tIsbn.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Solo puede ingresar números enteros en este campo.");
        }

        try {
            titulo = tTitulo.getText();

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al guardar el título");
        }

        try {
            anio = Integer.parseInt(tAnio.getText());

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Solo puede ingresar números enteros en este campo.");
        }

        try {
            tipo = cbTipo.getItemAt(cbTipo.getSelectedIndex());

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al guardar el tipo.");
        }

        try {
            editorial = tEditorial.getText();

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "error al guardar la editorial.");
        }

        try {
            estado = rbEstado.isEnabled();

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al guardar el estado.");
        }

        try {

            autor = tAutor.getText();
        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al guardar el autor.");
        }

        try {
            Libro libro = new Libro(isbn, titulo, anio, tipo, editorial, estado, autor);
            ld.guardarLibro(libro);
            

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "No se ha podido guardar el libro, reinténtelo nuevamente.");
        }

    }//GEN-LAST:event_bGuardarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        Long isbn = null;
        String titulo = null;
        Integer anio = null;
        String tipo = null;
        String editorial = null;
        Boolean estado = null;
        String autor = null;
        try {
            isbn = Long.parseLong(tIsbn.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Solo puede ingresar números enteros en este campo.");
        }

        try {
            titulo = tTitulo.getText();

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al modificar el título");
        }

        try {
            anio = Integer.parseInt(tAnio.getText());

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Solo puede ingresar números enteros en este campo.");
        }

        try {
            tipo = cbTipo.getItemAt(cbTipo.getSelectedIndex());

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al modificar el tipo.");
        }

        try {
            editorial = tEditorial.getText();

        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "error al modificar la editorial.");
        }

        try {
            estado = rbEstado.isSelected();
            
        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al modificar el estado.");
        }

        try {

            autor = tAutor.getText();
        } catch (NullPointerException nf) {
            JOptionPane.showMessageDialog(this, "Error al modificar el autor.");
        }
        
         try {
            Libro libro = new Libro(isbn, titulo, anio, tipo, editorial, estado, autor);
            ld.modificarLibro(libro);
           

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "No se ha podido modificar el libro, reinténtelo nuevamente.");
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        try{
        long isbn = Long.parseLong(tIsbn.getText());
        ld.eliminarLibro(isbn);
       
        }catch(NumberFormatException nf){
        JOptionPane.showMessageDialog(this, "No se ha podido eliminar el libro. Intente usar un formato numérico entero.");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        Long isbn = null;
        
        try{
        isbn = Long.parseLong(tIsbn.getText());
        Libro libroEncontrado = ld.buscarPorISBNSinEstado(isbn);
        
        tTitulo.setText(libroEncontrado.getTitulo());
        tAnio.setText(libroEncontrado.getAnio()+"");
        cbTipo.setSelectedItem(libroEncontrado.getTipo());
        tAutor.setText(libroEncontrado.getAutor());
        tEditorial.setText(libroEncontrado.getEditorial());
        rbEstado.setSelected(libroEncontrado.isEstado());
        
        }catch(NumberFormatException nf){
         JOptionPane.showMessageDialog(this, "No se ha podido buscar el libro. Intente usar un formato numérico entero.");
        }catch(NullPointerException np){JOptionPane.showMessageDialog(this, "El ISBN ingresado no existe.");}
      
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        tIsbn.setText("");
        tTitulo.setText("");
        tAnio.setText("");
        cbTipo.setSelectedItem("Acción");
        tAutor.setText("");
        tEditorial.setText("");
        rbEstado.setSelected(false);
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHead;
    private javax.swing.JRadioButton rbEstado;
    private javax.swing.JTextField tAnio;
    private javax.swing.JTextField tAutor;
    private javax.swing.JTextField tEditorial;
    private javax.swing.JTextField tIsbn;
    private javax.swing.JTextField tTitulo;
    // End of variables declaration//GEN-END:variables

    public void inicializarComboBox() {
        cbTipo.addItem("Acción");
        cbTipo.addItem("Aventura");
        cbTipo.addItem("Fantasía");
        cbTipo.addItem("Horror");
        cbTipo.addItem("Ciencia ficción");
        cbTipo.addItem("Sci-fi");
        cbTipo.addItem("Comedia");
        cbTipo.addItem("Drama");
        cbTipo.addItem("Educativo");
        cbTipo.addItem("Informativo");
        cbTipo.addItem("Terror");
        cbTipo.addItem("Thriller");
        cbTipo.addItem("Infantil");
        cbTipo.addItem("Novela");
       
    }
}