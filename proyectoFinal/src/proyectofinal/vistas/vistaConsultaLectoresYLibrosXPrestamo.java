/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.Entidades.Prestamo;
import proyectofinal.accesoDatos.LibroData;
import proyectofinal.accesoDatos.PrestamoData;
import proyectofinal.accesoDatos.UsuarioData;

/**
 *
 * @author Otro
 */
public class vistaConsultaLectoresYLibrosXPrestamo extends javax.swing.JInternalFrame {
       private PrestamoData pd = new PrestamoData();
       private LibroData ld = new LibroData();
       private UsuarioData us = new UsuarioData();
       private DefaultTableModel model = new DefaultTableModel();
     
    /**
     * Creates new form vistaConsultaLectoresYLibrosXPrestamo
     */
    public vistaConsultaLectoresYLibrosXPrestamo() {
        initComponents();
        
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha Fin");
        model.addColumn("Nombre del Lector");
        model.addColumn("Libro");
        model.addColumn("Estado");
        
        jTable1.setModel(model);
        jTBEstadoPresionado.setSelected(true);
        actualizarTabla();
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
        jBSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTBEstadoPresionado = new javax.swing.JToggleButton();
        jlbTitulo = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setText("Estado del Prestamo: ");

        jTBEstadoPresionado.setText("Estado");
        jTBEstadoPresionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBEstadoPresionadoActionPerformed(evt);
            }
        });

        jlbTitulo.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Consulta de libros y lectores por prestamo");

        javax.swing.GroupLayout jpHeadLayout = new javax.swing.GroupLayout(jpHead);
        jpHead.setLayout(jpHeadLayout);
        jpHeadLayout.setHorizontalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpHeadLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(jTBEstadoPresionado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpHeadLayout.setVerticalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBEstadoPresionado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jpHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBodyLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jpBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        JDesktopPane desktopPane = getDesktopPane();
        if (desktopPane != null) {
            desktopPane.getDesktopManager().closeFrame(this);
        }
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTBEstadoPresionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBEstadoPresionadoActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jTBEstadoPresionadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jTBEstadoPresionado;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpHead;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla(){
        for(int i = model.getRowCount()-1; i >= 0; i--){ 
            model.removeRow(i);
        }
        if(jTBEstadoPresionado.isSelected()){
            for (Prestamo prestamo : pd.buscarTodosLosPrestamosPorEstado(true)) {
                model.addRow(new Object[]{prestamo.getFechaInicio(), prestamo.getFechaFin(), prestamo.getLector().getNombre(), prestamo.getEjemplar().getLibro().getTitulo(), prestamo.isEstado()});
            }
        }else{
             for (Prestamo prestamo : pd.buscarTodosLosPrestamosPorEstado(false)) {
                model.addRow(new Object[]{prestamo.getFechaInicio(), prestamo.getFechaFin(), prestamo.getLector().getNombre(), prestamo.getEjemplar().getLibro().getTitulo(), prestamo.isEstado()});
             }
        }
    }
}