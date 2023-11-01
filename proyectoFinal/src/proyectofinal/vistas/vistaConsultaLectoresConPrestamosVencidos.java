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
import java.util.Map;
import javax.swing.JDesktopPane;
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
public class vistaConsultaLectoresConPrestamosVencidos extends javax.swing.JInternalFrame {

    private UsuarioData lData = new UsuarioData();
    private EjemplarData eData = new EjemplarData();
    private PrestamoData pData = new PrestamoData();
    private LibroData liData = new LibroData();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
    
    public vistaConsultaLectoresConPrestamosVencidos() {
        initComponents();
        armarCabecera();
        this.setSize(800, 600);
        this.setTitle("Consulta de Lectores con Prestamos Vencidos");
        this.setResizable(false);
        
        

        jrbVencidos.addItemListener(new ItemListener() {
            @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            jrbPorVencer.setSelected(false); 
            borrarTabla();
            cargarLectoresConPrestamosVencidos();
        }
    }
});

jrbPorVencer.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            jrbVencidos.setSelected(false); 
            borrarTabla();
            cargarLectoresConPrestamosPorVencer();
        }
    }
});


    }

    
    
//Metodos 
    

   

    
//Tabla

    private void armarCabecera() {
        borrarTabla();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Domicilio");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Vencimiento");
        

        jtConsultas.setModel(modeloTabla);
        TableColumnModel columnModel = jtConsultas.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(15);  
        columnModel.getColumn(1).setPreferredWidth(60); 
        columnModel.getColumn(2).setPreferredWidth(60); 
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(70); 
    }

    

    private void borrarTabla() {
        modeloTabla.setRowCount(0);
    }
    
    public void cargarLectoresConPrestamosVencidos() {
    List<Map<String, Object>> lectoresVencidos = pData.obtenerLectoresConPrestamosVencidos();
    borrarTabla();

    for (Map<String, Object> data : lectoresVencidos) {
        Object[] fila = {
            data.get("idSocio"),
            data.get("nombre"),
            data.get("domicilio"),
            data.get("mail"),
            data.get("fechaFin")
        };
          System.out.println("Lectores con prestamos vencidos: "+lectoresVencidos);
        modeloTabla.addRow(fila);
    }
}

      
    

    
    public void cargarLectoresConPrestamosPorVencer() {
    List<Map<String, Object>> lectoresProximosAVencer = pData.obtenerLectoresConPrestamosProximosAVencer();
    borrarTabla();

    for (Map<String, Object> data : lectoresProximosAVencer) {
        Object[] fila = {
            data.get("idSocio"),
            data.get("nombre"),
            data.get("domicilio"),
            data.get("mail"),
            data.get("fechaFin")
        };
        System.out.println("Lectores con prestamos proximos a vencer: "+lectoresProximosAVencer);
        modeloTabla.addRow(fila);
    }
}


    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHead = new javax.swing.JPanel();
        jlbTitulo = new javax.swing.JLabel();
        jlbDesc1 = new javax.swing.JLabel();
        jpFooter = new javax.swing.JPanel();
        jbSalir = new javax.swing.JButton();
        jpBody = new javax.swing.JPanel();
        jrbVencidos = new javax.swing.JRadioButton();
        jrbPorVencer = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();

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
                    .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(586, 586, 586)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jrbVencidos.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jrbVencidos.setText("Vencidos");

        jrbPorVencer.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jrbPorVencer.setText("Proximos a vencer");

        jLabel1.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESTAMOS");

        jtConsultas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(jtConsultas);

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBodyLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jrbVencidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPorVencer)
                .addGap(70, 70, 70))
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbVencidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbPorVencer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
    JDesktopPane desktopPane = getDesktopPane();
    if (desktopPane != null) {
        desktopPane.getDesktopManager().closeFrame(this);
    }
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbSalir;
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
