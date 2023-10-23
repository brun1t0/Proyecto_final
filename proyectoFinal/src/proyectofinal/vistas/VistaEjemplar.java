package proyectofinal.vistas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.Entidades.Ejemplar;
import proyectofinal.Entidades.Libro;
import proyectofinal.accesoDatos.EjemplarData;

public class VistaEjemplar extends javax.swing.JInternalFrame {

    private EjemplarData ed = new EjemplarData();
    private boolean estado;

    public VistaEjemplar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jBnuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaEjemplares = new javax.swing.JTable();
        jTFBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFidCodigo = new javax.swing.JTextField();
        jTFisbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRBestado = new javax.swing.JRadioButton();
        jCBTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jBModificar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel1.setText("Administración de Ejemplares");

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de Ejemplares");

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jBnuevo.setText("Nuevo");
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

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

        jtTablaEjemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdCodigo", "ISBN", "Autor", "Título", "Año", "Tipo", "Editorial", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtTablaEjemplares);

        jTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("IdCodigoEjemplar");

        jTFidCodigo.setEditable(false);
        jTFidCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFidCodigoActionPerformed(evt);
            }
        });

        jTFisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFisbnActionPerformed(evt);
            }
        });

        jLabel4.setText("ISBN");

        jRBestado.setText("Estado");

        jCBTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por Codigo de Ejemplar", "Buscar por ISBN de Ejemplar", "Buscar por Nombre de Ejemplar", "Buscar por Autor de Ejemplar" }));
        jCBTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoBusquedaActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleccione el tipo de busqueda a realizar");

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCBTipoBusqueda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(195, 195, 195)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFidCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBestado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFidCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRBestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        boolean estado = true;
        int indiceSeleccionado = jCBTipoBusqueda.getSelectedIndex();
        String valorBusqueda = jTFBuscar.getText();
        DefaultTableModel model = (DefaultTableModel) jtTablaEjemplares.getModel();
        model.setRowCount(0);
        jTFBuscar.setText("");
        if (indiceSeleccionado == 0) {
            try {
                int idCodigo = Integer.parseInt(valorBusqueda);
                Ejemplar ejemplar = ed.buscarEjemplarPorIdCodigo(idCodigo, estado);
                if (ejemplar != null) {
                    model.addRow(new Object[]{
                        ejemplar.getIdCodigo(),
                        ejemplar.getLibro().getIsbn(),
                        ejemplar.getLibro().getAutor(),
                        ejemplar.getLibro().getTitulo(),
                        ejemplar.getLibro().getAnio(),
                        ejemplar.getLibro().getTipo(),
                        ejemplar.getLibro().getEditorial(),
                        ejemplar.getEstado()
                    });
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para la búsqueda por idcodigo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (indiceSeleccionado == 1) {
            try {
                long isbn = Long.parseLong(valorBusqueda);
                List<Ejemplar> ejemplares = ed.buscarEjemplarisbn(isbn);
                if (!ejemplares.isEmpty()) {
                    for (Ejemplar ejemplar : ejemplares) {
                        model.addRow(new Object[]{
                            ejemplar.getIdCodigo(),
                            ejemplar.getLibro().getIsbn(),
                            ejemplar.getLibro().getAutor(),
                            ejemplar.getLibro().getTitulo(),
                            ejemplar.getLibro().getAnio(),
                            ejemplar.getLibro().getTipo(),
                            ejemplar.getLibro().getEditorial(),
                            ejemplar.getEstado()
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron ejemplares con el ISBN proporcionado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para la búsqueda por ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (indiceSeleccionado == 2) {
            String nombreEjemplar = valorBusqueda;
            List<Ejemplar> ejemplares = ed.buscarEjemplarPorNombre(nombreEjemplar);

            if (!ejemplares.isEmpty()) {
                for (Ejemplar ejemplar : ejemplares) {
                    model.addRow(new Object[]{
                        ejemplar.getIdCodigo(),
                        ejemplar.getLibro().getIsbn(),
                        ejemplar.getLibro().getAutor(),
                        ejemplar.getLibro().getTitulo(),
                        ejemplar.getLibro().getAnio(),
                        ejemplar.getLibro().getTipo(),
                        ejemplar.getLibro().getEditorial(),
                        ejemplar.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron ejemplares con el nombre proporcionado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (indiceSeleccionado == 3) {
            String autorEjemplar = valorBusqueda;
            List<Ejemplar> ejemplares = ed.buscarEjemplarPorAutor(autorEjemplar);

            if (!ejemplares.isEmpty()) {
                for (Ejemplar ejemplar : ejemplares) {
                    model.addRow(new Object[]{
                        ejemplar.getIdCodigo(),
                        ejemplar.getLibro().getIsbn(),
                        ejemplar.getLibro().getAutor(),
                        ejemplar.getLibro().getTitulo(),
                        ejemplar.getLibro().getAnio(),
                        ejemplar.getLibro().getTipo(),
                        ejemplar.getLibro().getEditorial(),
                        ejemplar.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron ejemplares con el autor proporcionado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
        limpiarpantalla();
    }//GEN-LAST:event_jBnuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int selectedRow = jtTablaEjemplares.getSelectedRow();
        if (selectedRow != -1) {
            int idCodigo = (int) jtTablaEjemplares.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de Eliminar este ejemplar?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ed.eliminarEjemplar(idCodigo);
                JOptionPane.showMessageDialog(this, "Ejemplar Eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ejemplar a Eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        String isbn = jTFisbn.getText().trim();
        boolean estado = true;
        try {
            Long.parseLong(isbn);
            String idCodigo = ed.guardarEjemplar(isbn, estado);
            jTFidCodigo.setText(idCodigo);
            if (idCodigo != null) {
                JOptionPane.showMessageDialog(this, "Ejemplar guardado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                jTFidCodigo.setText(idCodigo);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el ejemplar. El libro con ISBN " + isbn + " no existe.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El ISBN debe ser un número válido.");
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBsalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBsalirMouseClicked

    private void jTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarActionPerformed

    }//GEN-LAST:event_jTFBuscarActionPerformed

    private void jTFidCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidCodigoActionPerformed

    private void jTFisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFisbnActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        int selectedRow = jtTablaEjemplares.getSelectedRow();
        if (selectedRow != -1) {
            int idCodigo = (int) jtTablaEjemplares.getValueAt(selectedRow, 0);
            Long newIsbn = Long.parseLong(JOptionPane.showInputDialog(this,
                    "Ingrese el nuevo ISBN:", "Modificar ISBN", JOptionPane.QUESTION_MESSAGE));
            if (newIsbn != null) {
                boolean isbnExists = ed.verificarExistenciaISBN(newIsbn);
                if (isbnExists) {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "¿Está seguro de modificar el ISBN?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        ed.actualizarEjemplar(idCodigo, newIsbn);
                        JOptionPane.showMessageDialog(this,
                                "ISBN modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "El nuevo ISBN no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nuevo ISBN ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una fila de la tabla para realizar la modificación.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jCBTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBTipoBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JButton jBsalir;
    private javax.swing.JButton jBuscar;
    private javax.swing.JComboBox<String> jCBTipoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRBestado;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFidCodigo;
    private javax.swing.JTextField jTFisbn;
    private javax.swing.JTable jtTablaEjemplares;
    // End of variables declaration//GEN-END:variables
void limpiarpantalla() {
        jTFisbn.setText("");
        jTFidCodigo.setText("");
        jRBestado.setSelected(false);
    }

}
