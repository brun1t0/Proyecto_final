
package proyectofinal.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import proyectofinal.Entidades.Ejemplar;
import proyectofinal.accesoDatos.EjemplarData;

public class vistaConsultarEjemplarLibro extends javax.swing.JInternalFrame {
    private EjemplarData ed = new EjemplarData();
    public vistaConsultarEjemplarLibro() {
        initComponents();
        setearTabla();
    }
    
    public void setearTabla() {
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.LEADING);

    int numColumnas = jtTablaConsulta.getColumnCount(); // Obtener el número total de columnas

    for (int i = 0; i < numColumnas; i++) {
        jtTablaConsulta.getColumnModel().getColumn(i).setCellRenderer(tcr);
    }

        TableColumnModel columnModel = jtTablaConsulta.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(220);
        columnModel.getColumn(3).setPreferredWidth(35);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCBTipoConsulta = new javax.swing.JComboBox<>();
        jTFConsultaBuscar = new javax.swing.JTextField();
        jBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaConsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jpFooter = new javax.swing.JPanel();
        jBsalir = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 36)); // NOI18N
        jLabel1.setText("Consulta de Ejemplares");

        javax.swing.GroupLayout jpHeadLayout = new javax.swing.GroupLayout(jpHead);
        jpHead.setLayout(jpHeadLayout);
        jpHeadLayout.setHorizontalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpHeadLayout.setVerticalGroup(
            jpHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel5.setText("Seleccione el tipo de busqueda a realizar");

        jCBTipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por Codigo de Ejemplar", "Buscar por ISBN de Ejemplar", "Buscar por Nombre de Ejemplar", "Buscar por Autor de Ejemplar" }));
        jCBTipoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoConsultaActionPerformed(evt);
            }
        });

        jTFConsultaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFConsultaBuscarActionPerformed(evt);
            }
        });

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jtTablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Autor", "Título", "Año", "Tipo", "Editorial", "Disponibles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTablaConsulta.setShowGrid(false);
        jScrollPane2.setViewportView(jtTablaConsulta);

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de Ejemplares");

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBodyLayout.createSequentialGroup()
                .addGap(0, 230, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFConsultaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFConsultaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 780, 330));

        jBsalir.setText("Salir");
        jBsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBsalirMouseClicked(evt);
            }
        });
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFooterLayout = new javax.swing.GroupLayout(jpFooter);
        jpFooter.setLayout(jpFooterLayout);
        jpFooterLayout.setHorizontalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFooterLayout.createSequentialGroup()
                .addContainerGap(663, Short.MAX_VALUE)
                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFooterLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jpFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 800, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBTipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoConsultaActionPerformed
    
    }//GEN-LAST:event_jCBTipoConsultaActionPerformed

    private void jTFConsultaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFConsultaBuscarActionPerformed

    }//GEN-LAST:event_jTFConsultaBuscarActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        int opcionSeleccionada = jCBTipoConsulta.getSelectedIndex();
    String textoBusqueda = jTFConsultaBuscar.getText();
    List<Ejemplar> resultado = new ArrayList<>();
    switch (opcionSeleccionada) {
        case 0:
            try {
                int idCodigo = Integer.parseInt(textoBusqueda);
                Ejemplar ejemplar = ed.buscarEjemplarPorIdCodigo(idCodigo, true);
                if (ejemplar != null) {
                    resultado.add(ejemplar);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case 1:
            try {
                long isbn = Long.parseLong(textoBusqueda);
                List<Ejemplar> ejemplares = ed.buscarEjemplarisbn(isbn);
                resultado.addAll(ejemplares);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case 2:
            resultado = ed.buscarEjemplarPorNombre(textoBusqueda);
            break;
        case 3:
            resultado = ed.buscarEjemplarPorAutor(textoBusqueda);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción de búsqueda válida.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    DefaultTableModel modelo = (DefaultTableModel) jtTablaConsulta.getModel();
    modelo.setRowCount(0); 
    if (!resultado.isEmpty()) {
        int totalEjemplares = resultado.size();
        modelo.addRow(new Object[]{
            resultado.get(0).getLibro().getIsbn(),
            resultado.get(0).getLibro().getAutor(),
            resultado.get(0).getLibro().getTitulo(),
            resultado.get(0).getLibro().getAnio(),
            resultado.get(0).getLibro().getTipo(),
            resultado.get(0).getLibro().getEditorial(),
            totalEjemplares+" Unidades"
        });
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron resultados.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBsalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBsalirMouseClicked

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private javax.swing.JButton jBuscar;
    private javax.swing.JComboBox<String> jCBTipoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFConsultaBuscar;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHead;
    private javax.swing.JTable jtTablaConsulta;
    // End of variables declaration//GEN-END:variables
private int calcularTotalEjemplaresDisponibles(long isbn) {
    List<Ejemplar> ejemplares = ed.buscarEjemplarisbn(isbn);
    int total = 0;
    for (Ejemplar ejemplar : ejemplares) {
        if (ejemplar.isEstado()) {
            total++;
        }
    }
    return total;
}



}
