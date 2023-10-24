/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyectofinal.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import proyectofinal.Entidades.Lector;
import proyectofinal.accesoDatos.EjemplarData;
import proyectofinal.accesoDatos.LibroData;
import proyectofinal.accesoDatos.PrestamoData;
import proyectofinal.accesoDatos.UsuarioData;

/**
 *
 * @author Lucas
 */
public class vistaLectoresConPrestamosVencidos extends javax.swing.JInternalFrame {

    private UsuarioData lData = new UsuarioData();
    private EjemplarData eData = new EjemplarData();
    private PrestamoData pData = new PrestamoData();
    private LibroData liData = new LibroData();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
    
    public vistaLectoresConPrestamosVencidos() {
        initComponents();
        this.setSize(800, 600);
        this.setTitle("Consulta de Lectores con Prestamos Vencidos");
        this.setResizable(false);
        jrbVencidos.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            jrbPorVencer.setSelected(false); 
            cargarLectoresConPrestamosVencidos();
        }
    }
});

jrbPorVencer.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            jrbVencidos.setSelected(false); 
            cargarLectoresConPrestamosPorVencer();
        }
    }
});


    }

    
    
//Metodos 
    

   

    
//Tabla

    private void armarCabecera() {
        
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Titulo");
        modeloTabla.addColumn("Fecha Inicio");
        modeloTabla.addColumn("Fecha Fin");

        jtConsultas.setModel(modeloTabla);
        TableColumnModel columnModel = jtConsultas.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(50);  
        columnModel.getColumn(1).setPreferredWidth(300); 
        columnModel.getColumn(2).setPreferredWidth(100); 
        columnModel.getColumn(3).setPreferredWidth(100); 
    }

    

    private void borrarTabla() {
        modeloTabla.setRowCount(0);
    }
    
    private void cargarLectoresConPrestamosVencidos() {
    List<Lector> lectoresV = pData.obtenerLectoresConPrestamosVencidos();
    borrarTabla();

    for (Lector lector : lectoresV) {
        Object[] fila = {
            lector.getNroSocio(), 
            lector.getNombre(), 
            lector.getDomicilio(), 
            lector.getMail(), 
            lector.isEstado()};
        
        modeloTabla.addRow(fila);
    }
    
    
}
    
    public void cargarLectoresConPrestamosPorVencer() {
    List<Object[]> lectoresPorVencer = pData.obtenerLectoresConPrestamosPorVencer();
    borrarTabla();

    for (Object[] lectorData : lectoresPorVencer) {
        modeloTabla.addRow(lectorData);
    }
}

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHead = new javax.swing.JPanel();
        jlbTitulo = new javax.swing.JLabel();
        jlbDesc1 = new javax.swing.JLabel();
        jpFooter = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbPrestar = new javax.swing.JButton();
        jbDevolver = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdcNuevaFecha = new com.toedter.calendar.JDateChooser();
        jpBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jrbVencidos = new javax.swing.JRadioButton();
        jrbPorVencer = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jlbTitulo.setFont(new java.awt.Font("Candara", 1, 32)); // NOI18N
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Lectores con Prestamos Vencidos");

        jlbDesc1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlbDesc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDesc1.setText("Desde aqui puede consultar los lectores cuyos prestamos se han vencido");

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

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbPrestar.setText("Prestar");
        jbPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrestarActionPerformed(evt);
            }
        });

        jbDevolver.setText("Devolver");
        jbDevolver.setEnabled(false);
        jbDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDevolverActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar Fecha");
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFooterLayout = new javax.swing.GroupLayout(jpFooter);
        jpFooter.setLayout(jpFooterLayout);
        jpFooterLayout.setHorizontalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jbDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcNuevaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcNuevaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtConsultas);

        jrbVencidos.setText("Vencidos");

        jrbPorVencer.setText("Proximos a vencer");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("PRESTAMOS");

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jrbVencidos)
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbPorVencer)
                .addGap(70, 70, 70))
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbVencidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbPorVencer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrestarActionPerformed
     
    }//GEN-LAST:event_jbPrestarActionPerformed

    private void jbDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDevolverActionPerformed
      
    }//GEN-LAST:event_jbDevolverActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDevolver;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbPrestar;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcNuevaFecha;
    private javax.swing.JLabel jlbDesc1;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHead;
    private javax.swing.JRadioButton jrbPorVencer;
    private javax.swing.JRadioButton jrbVencidos;
    private javax.swing.JTable jtConsultas;
    // End of variables declaration//GEN-END:variables
}
