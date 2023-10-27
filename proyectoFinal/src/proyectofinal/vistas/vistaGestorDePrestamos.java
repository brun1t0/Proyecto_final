/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyectofinal.vistas;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import proyectofinal.Entidades.Ejemplar;
import proyectofinal.Entidades.Lector;
import proyectofinal.Entidades.Prestamo;
import proyectofinal.accesoDatos.EjemplarData;
import proyectofinal.accesoDatos.LibroData;
import proyectofinal.accesoDatos.PrestamoData;
import proyectofinal.accesoDatos.UsuarioData;

/**
 *
 * @author Lucas
 */
public class vistaGestorDePrestamos extends javax.swing.JInternalFrame {

    private UsuarioData lData = new UsuarioData();
    private EjemplarData eData = new EjemplarData();
    private PrestamoData pData = new PrestamoData();
    private LibroData liData = new LibroData();
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Solo permite la edición de la cuarta columna (índice 3)
            return false;
        }

    };

    public vistaGestorDePrestamos() {
        initComponents();
        initComboBoxes();
        llenarCboLector();
        llenarCboEjemplar();
        armarCabecera();
          jtConsultas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jtConsultas.getSelectedRow();
                jdcNuevaFecha.setEnabled(selectedRow >= 0);

                // Deshabilita todos los botones excepto jbDevolver y jbModificar
                
                jbModificar.setEnabled(selectedRow >= 0); // Habilita jbModificar solo si se selecciona una fila
                jbDevolver.setEnabled(selectedRow >= 0);  // Habilita jbModificar solo si se selecciona una fila
                
            }
        });

        jdcNuevaFecha.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    int selectedRow = jtConsultas.getSelectedRow();
                    if (selectedRow >= 0) {
                        Date nuevaFecha = (Date) evt.getNewValue();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Establece aquí el formato original
                        String nuevaFechaFormateada = dateFormat.format(nuevaFecha);
                        jtConsultas.setValueAt(nuevaFechaFormateada, selectedRow, 3); // Actualizar la fecha de finalización en la tabla
                        jbModificar.setEnabled(true); // Habilitar el botón al editar la fecha
                    }
                }
            }
        });

        
        
        
    }
        

//Metodos 
    public void llenarCboLector() {
        List<Lector> lectores = lData.listarLectores();

        Lector lectorPredeterminado = new Lector();
        lectorPredeterminado.setNroSocio(-1);
        lectorPredeterminado.setNombre("Seleccione el lector");

        jcbLector.addItem(lectorPredeterminado);

        for (Lector lector : lectores) {
            jcbLector.addItem(lector);
        }
    }

    public void llenarCboEjemplar() {
        List<Ejemplar> ejemplares = eData.listarEjemplares();

        Ejemplar ejemplarPredeterminado = new Ejemplar();
        ejemplarPredeterminado.setIdCodigo(-1);
        ejemplarPredeterminado.setNombreLibro("Seleccione un ejemplar");
        jcbEjemplar.addItem(ejemplarPredeterminado);

        for (Ejemplar listarEjemplares : eData.listarEjemplares()) {
            jcbEjemplar.addItem(listarEjemplares);
        }
    }

    public void initComboBoxes() {
        jcbLector.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Lector) {
                    Lector lector = (Lector) value;
                    setText(lector.getComboBoxDisplay());
                }
                return this;
            }
        });

        jcbEjemplar.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Ejemplar) {
                    Ejemplar ejemplar = (Ejemplar) value;
                    setText(ejemplar.getComboBoxDisplay());
                }
                return this;
            }
        });
    }

    public void reiniciarComponentes() {
        jcbLector.setSelectedIndex(0);
        jcbEjemplar.setSelectedIndex(0);
        jdcFechaInicio.setDate(null);
        jdcFechaFin.setDate(null);
    }
//Tabla

    private void armarCabecera() {
        // Añade tus columnas a la tabla
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

    public void CargarPrestamos() {
        try {
            Lector lec = (Lector) jcbLector.getSelectedItem();

            for (Prestamo listaP : pData.buscarPrestamosPorLector(lec.getNroSocio())) {

                int id = listaP.getEjemplar().getIdCodigo();
                String tit = listaP.getEjemplar().getLibro().getTitulo();
                Date inicio = listaP.getFechaInicio();
                Date fin = listaP.getFechaFin();
                Boolean estado = listaP.isEstado();
                
                System.out.println("titulo "+listaP.getEjemplar().getLibro().getTitulo());

                modeloTabla.addRow(new Object[]{id, tit, inicio, fin, estado});

            }
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Lector");

        }
    }

    private void borrarTabla() {
        modeloTabla.setRowCount(0);
    }

    private boolean clicFueraDeTabla = true;

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
        jlbEjemplar = new javax.swing.JLabel();
        jlbInicioPrestamo = new javax.swing.JLabel();
        jlbFinPrestamo = new javax.swing.JLabel();
        jcbEjemplar = new javax.swing.JComboBox<>();
        jcbLector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jlbDesc3 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jpFooter = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbPrestar = new javax.swing.JButton();
        jbDevolver = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdcNuevaFecha = new com.toedter.calendar.JDateChooser();

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
                .addGap(16, 16, 16)
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jlbInicioPrestamo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbInicioPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbInicioPrestamo.setText("Inicio");

        jlbFinPrestamo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jlbFinPrestamo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFinPrestamo.setText("Fin");

        jcbEjemplar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcbEjemplar.setToolTipText("");
        jcbEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEjemplarActionPerformed(evt);
            }
        });

        jcbLector.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jcbLector.setToolTipText("");
        jcbLector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbLectorItemStateChanged(evt);
            }
        });
        jcbLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLectorActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jtConsultas);

        jlbDesc3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlbDesc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDesc3.setText("Abajo se muestran los prestamos vigentes del Lector");

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbDesc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpBodyLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jlbInicioPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbFinPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(jpBodyLayout.createSequentialGroup()
                        .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpBodyLayout.createSequentialGroup()
                                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbEjemplar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbLector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlbDesc3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                        .addGap(0, 93, Short.MAX_VALUE))))

        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLector, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlbDesc2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbInicioPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbFinPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)

                .addComponent(jlbDesc3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jdcNuevaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(19, 19, 19))
        );
        jpFooterLayout.setVerticalGroup(
            jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFooterLayout.createSequentialGroup()
                .addContainerGap()

                .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcNuevaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        reiniciarComponentes();

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrestarActionPerformed
        Date fechaInicio = jdcFechaInicio.getDate();
        Date fechaFin = jdcFechaFin.getDate();

        if (fechaInicio != null && fechaFin != null) {
            if (fechaInicio.after(fechaFin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.");
                return; // Salir del método si las fechas son incorrectas
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione fechas válidas.");
            return; // Salir del método si falta una fecha
        }

        Lector lector = (Lector) jcbLector.getSelectedItem();
        Ejemplar ejemplar = (Ejemplar) jcbEjemplar.getSelectedItem();

        Boolean estado = true;

        try {
            Prestamo p = new Prestamo(fechaInicio, fechaFin, ejemplar, lector, estado);
            pData.crearPrestamo(p);

            // Calcula la diferencia en días entre fechaInicio y fechaFin
            long diferenciaEnMillis = fechaFin.getTime() - fechaInicio.getTime();
            int diasDePrestamo = (int) (diferenciaEnMillis / (24 * 60 * 60 * 1000));

            JOptionPane.showMessageDialog(this, "Prestamo realizado correctamente. Duración: " + diasDePrestamo + " días.");

            borrarTabla();
            jcbEjemplar.removeAllItems();
            CargarPrestamos(); // Actualiza la tabla
            llenarCboEjemplar(); // Actualiza ComboBox de Ejemplares
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "No se ha podido crear el préstamo, intente nuevamente.");
        }
    }//GEN-LAST:event_jbPrestarActionPerformed

    private void jbDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDevolverActionPerformed
        int filaSeleccionada = jtConsultas.getSelectedRow();
        Date fechaInicio = null;
        Date fechaFin = null;
        Ejemplar ejemplar = null;
        Lector lector = (Lector) jcbLector.getSelectedItem();
        Boolean estado = false;

        if (filaSeleccionada != -1) {
            fechaInicio = (Date) jtConsultas.getValueAt(filaSeleccionada, 2);
            fechaFin = (Date) jtConsultas.getValueAt(filaSeleccionada, 3);
            int id = Integer.parseInt( jtConsultas.getValueAt(filaSeleccionada, 0).toString());
            ejemplar = eData.buscarEjemplarPorIdCodigo(id, false);
        }

        try {
            Prestamo p = new Prestamo(fechaInicio, fechaFin, ejemplar, lector, estado);
            pData.finalizarPrestamo(p);

            JOptionPane.showMessageDialog(this, "Devolución exitosa.");

            borrarTabla();
            jcbEjemplar.removeAllItems();
            CargarPrestamos(); // Actualiza la tabla
            llenarCboEjemplar(); // Actualiza ComboBox de Ejemplares
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "No se ha podido devolver el ejemplar, intente nuevamente.");
        }
    }//GEN-LAST:event_jbDevolverActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        int selectedRow = jtConsultas.getSelectedRow();

        if (selectedRow >= 0) {
            Date nuevaFecha = jdcNuevaFecha.getDate();
            if (nuevaFecha != null) {
                int filaSeleccionada = jtConsultas.getSelectedRow();
                int id = Integer.parseInt( jtConsultas.getValueAt(filaSeleccionada, 0).toString());
                Ejemplar ejemplar = eData.buscarEjemplarPorIdCodigo(id, false);
                Lector lector = (Lector) jcbLector.getSelectedItem();
                int idSocio = lector.getNroSocio();
                int idCodigo = ejemplar.getIdCodigo();
                Date fechaInicio = (Date) jtConsultas.getValueAt(selectedRow, 2);

                pData.modificarPrestamo(idSocio, idCodigo, fechaInicio, nuevaFecha);
                JOptionPane.showMessageDialog(this, "Prestamo modificado exitosamente.");
                jbModificar.setEnabled(false);
                borrarTabla();
                CargarPrestamos();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
        }

    }//GEN-LAST:event_jbModificarActionPerformed

    private void jcbEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEjemplarActionPerformed

    private void jcbLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLectorActionPerformed

    private void jcbLectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbLectorItemStateChanged
        borrarTabla();
        CargarPrestamos();
        jdcFechaInicio.setDate(null);
        jdcFechaFin.setDate(null);
    }//GEN-LAST:event_jcbLectorItemStateChanged

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDevolver;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbPrestar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Ejemplar> jcbEjemplar;
    private javax.swing.JComboBox<Lector> jcbLector;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private com.toedter.calendar.JDateChooser jdcNuevaFecha;
    private javax.swing.JLabel jlbDesc1;
    private javax.swing.JLabel jlbDesc2;
    private javax.swing.JLabel jlbDesc3;
    private javax.swing.JLabel jlbEjemplar;
    private javax.swing.JLabel jlbFinPrestamo;
    private javax.swing.JLabel jlbInicioPrestamo;
    private javax.swing.JLabel jlbLector;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHead;
    private javax.swing.JTable jtConsultas;
    // End of variables declaration//GEN-END:variables
}
