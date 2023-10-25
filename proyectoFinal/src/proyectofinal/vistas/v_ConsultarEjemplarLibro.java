
package proyectofinal.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.Entidades.Ejemplar;
import proyectofinal.accesoDatos.EjemplarData;

public class v_ConsultarEjemplarLibro extends javax.swing.JInternalFrame {
    private EjemplarData ed = new EjemplarData();
    public v_ConsultarEjemplarLibro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCBTipoConsulta = new javax.swing.JComboBox<>();
        jTFConsultaBuscar = new javax.swing.JTextField();
        jBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaConsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jBsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane2.setViewportView(jtTablaConsulta);

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de Ejemplares");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFConsultaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Ejemplares");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            totalEjemplares
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFConsultaBuscar;
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
