/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyectofinal.vistas;

/**
 *
 * @author Lucas
 */
public class vistaGestorDePrestamos extends javax.swing.JInternalFrame {

    /**
     * Creates new form vistaPrestamos
     */
    public vistaGestorDePrestamos() {
        initComponents();
        this.setSize(800 ,600);
        this.setTitle("Gestor de Presamos");
        this.setResizable(false);
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
        jlbTitulo = new javax.swing.JLabel();
        jlbDesc1 = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();
        jlbLector = new javax.swing.JLabel();
        jlbDesc2 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jlbEjemplar = new javax.swing.JLabel();
        jtEjemplar = new javax.swing.JTextField();
        jlbInicioPrestamo = new javax.swing.JLabel();
        jlbFinPrestamo = new javax.swing.JLabel();
        jcbLector = new javax.swing.JComboBox<>();
        jpFooter = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();

        jlbTitulo.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Gestor de Prestamos");

        jlbDesc1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlbDesc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDesc1.setText("Desde aqui puede crear prestamos de libros");

        javax.swing.GroupLayout jpHeadLayout = new javax.swing.GroupLayout(jpHead);
        jpHead.setLayout(jpHeadLayout);
        jpHeadLayout.setHorizontalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpHeadLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbDesc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpHeadLayout.setVerticalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDesc1)
                .addContainerGap())
        );

        jlbLector.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbLector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLector.setText("Lector");

        jlbDesc2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlbDesc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDesc2.setText("Indique aqui las fechas de prestamo");

        jlbEjemplar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbEjemplar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbEjemplar.setText("Ejemplar");

        jtEjemplar.setText(" ");

        jlbInicioPrestamo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbInicioPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbInicioPrestamo.setText("Inicio");

        jlbFinPrestamo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbFinPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFinPrestamo.setText("Fin");

        jcbLector.setToolTipText("");
        jcbLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlbDesc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbInicioPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbFinPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtEjemplar)
                            .addComponent(jcbLector, 0, 200, Short.MAX_VALUE))))
                .addGap(0, 80, Short.MAX_VALUE))
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlbDesc2)
                .addGap(18, 18, 18)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbInicioPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbFinPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jbNuevo.setText("Nuevo");
        jbNuevo.setEnabled(false);
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.setEnabled(false);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.setEnabled(false);
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFooterLayout = new javax.swing.GroupLayout(jpFooter);
        jpFooter.setLayout(jpFooterLayout);
        jpFooterLayout.setHorizontalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
     
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
     
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jcbLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JComboBox<String> jcbLector;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JLabel jlbDesc1;
    private javax.swing.JLabel jlbDesc2;
    private javax.swing.JLabel jlbEjemplar;
    private javax.swing.JLabel jlbFinPrestamo;
    private javax.swing.JLabel jlbInicioPrestamo;
    private javax.swing.JLabel jlbLector;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHead;
    private javax.swing.JTextField jtEjemplar;
    // End of variables declaration//GEN-END:variables
}
