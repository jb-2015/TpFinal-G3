/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controller.ConsultaPorEstados;
import controller.EquipoData;
import controller.EquipoMiembroData;
import controller.ProyectoData;
import controller.TareaData;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Equipo;
import modelo.EquipoMiembro;
import modelo.Proyecto;
import modelo.Tarea;

/**
 *
 * @author juany
 */
public class ViewTarea extends javax.swing.JInternalFrame {

    TareaData td = new TareaData();
    EquipoMiembroData emd = new EquipoMiembroData();
    ProyectoData pd = new ProyectoData();
    EquipoData ed = new EquipoData();
    LocalDate FechaCreacion = LocalDate.now();  
    /**
     * Creates new form viewTarea
     */
    public ViewTarea() {
        initComponents();
        listarTareas();
        //cargarEquipoMiembros();
        cargarProyectos();
    }

    private void listarTareas() {
        String[] cols = {"Identificador", "Nombre", "Fecha Creacion", "Fecha Cierre"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                if (i1 == 0) {
                    return false;
                }
                if (i1 == 2) {
                    return false;
                }
                return true;
            }
        };
        for (Tarea t : td.listarTareas()) {
            Object[] dato = {t.getIdTarea(), t.getNombre(), t.getFecha_creacion(), t.getFecha_cierre()};
            tm.addRow(dato);
        }

        jtblTareas.setModel(tm);
        jtblTareas.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtblTareas.getColumnModel().getColumn(1).setPreferredWidth(70);
    }

    private void borrar() {
        tbxNombreNewTarea.setText("");
        jcFinalizacion.setDate(null);
        cbxMiembroEquipo.setSelectedIndex(-1);
        cbxProyecto.setSelectedIndex(-1);
        cbxEquipo.setSelectedIndex(-1);
    }

    private void cargarProyectos() {
        cbxProyecto.removeAllItems();
        for (Proyecto p : pd.listarProyectos()) {
            cbxProyecto.addItem(p.getIdProyecto() + "-" + p.getNombre());
        }
    }

    private void cargarEquipos() {
        cbxEquipo.removeAllItems();
        for (Equipo e : ed.obtenerEquipos(ConsultaPorEstados.ACTIVOS)) {
            String[] part = cbxProyecto.getSelectedItem().toString().split("-");
            int idProyecto = Integer.parseInt(part[0]);
            if (e.getProyecto().getIdProyecto() == idProyecto) {
                cbxEquipo.addItem(e.getIdEquipo() + "-" + e.getNombre());
            }
        }
    }

    private void cargarEquipoMiembros() {
        cbxMiembroEquipo.removeAllItems();
        for (EquipoMiembro em : emd.listarEquipoMiembro()) {
            int idEquipo = Integer.parseInt(cbxEquipo.getSelectedItem().toString().split("-")[0]);
            if (em.getEquipo().getIdEquipo() == idEquipo) {
                cbxMiembroEquipo.addItem(em.getIdEquipoMiembro() + "-" + em.getMiembro().getNombre() + em.getMiembro().getApellido());
            }

        }
        cbxMiembroEquipo.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTareas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tbxNombreNewTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcFinalizacion = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbxMiembroEquipo = new javax.swing.JComboBox<>();
        jbGuardar = new javax.swing.JButton();
        cbxProyecto = new javax.swing.JComboBox<>();
        cbxEquipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tbxFiltroViewTarea = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblInfoTarea = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(410, 550));

        jtblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblTareasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblTareas);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/186-list-numbered.png"))); // NOI18N
        jLabel1.setText("   TAREAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nueva Tarea");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel4.setText("Finaliza");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel5.setText("Miembro/Equipo");

        cbxMiembroEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxMiembroEquipoMousePressed(evt);
            }
        });
        cbxMiembroEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMiembroEquipoActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/007-pencil2.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        cbxProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProyectoActionPerformed(evt);
            }
        });

        cbxEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxEquipoMousePressed(evt);
            }
        });
        cbxEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEquipoActionPerformed(evt);
            }
        });

        jLabel8.setText("Proyecto");

        jLabel9.setText("Equipo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbGuardar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxMiembroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbxEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tbxNombreNewTarea, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcFinalizacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tbxNombreNewTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jcFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxMiembroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbGuardar)
                .addContainerGap())
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/007-pencil2.png"))); // NOI18N
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/135-search.png"))); // NOI18N

        tbxFiltroViewTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxFiltroViewTareaActionPerformed(evt);
            }
        });
        tbxFiltroViewTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbxFiltroViewTareaKeyReleased(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/272-cross.png"))); // NOI18N
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("Info:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 34, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblInfoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addComponent(jButton3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbxFiltroViewTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInfoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxFiltroViewTarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbModificar)
                        .addComponent(jbEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        boolean validando = false;
        LocalDate fecha_creacion = null;
        LocalDate fecha_cierre = null;
        int idEquipoMiembro = 0;
        String nombre = tbxNombreNewTarea.getText();
        if (nombre.equals("")) {
            validando = true;
        }
        
        int verificar = FechaCreacion.compareTo(jcFinalizacion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (verificar > 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha posterior al dia actual");
            return;
        }
        //Calendar c = Calendar.getInstance();
        //c.setTime(jcFinalizacion.getDate());
        if (jcFinalizacion.getDate() == null) {
            validando = true;
        } else {
            fecha_creacion = LocalDate.now();
            fecha_cierre = jcFinalizacion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if (cbxMiembroEquipo.getSelectedIndex() == -1) {
            validando = true;
        } else {
            String idEM = cbxMiembroEquipo.getSelectedItem().toString();

            String[] part = idEM.split("-");
            idEquipoMiembro = Integer.parseInt(part[0]);
        }

        if (validando) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.");
        } else {
            Tarea t = new Tarea(nombre, fecha_creacion, fecha_cierre, true, emd.buscarEquipoMiembro(idEquipoMiembro));
            td.guardarTarea(t);
            listarTareas();
            borrar();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        int indice = jtblTareas.getSelectedRow();
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea a editar");
        } else {
            int id = (int) jtblTareas.getValueAt(indice, 0);
            String nombre = jtblTareas.getValueAt(indice, 1).toString();
            LocalDate fechaCrea = (LocalDate) jtblTareas.getValueAt(indice, 2);
            LocalDate fechaModi = (LocalDate) jtblTareas.getValueAt(indice, 3);
            Tarea TareaModi = new Tarea(id, nombre, fechaCrea, fechaModi, true, null);
            td.modificarTarea(TareaModi);
            listarTareas();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void tbxFiltroViewTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxFiltroViewTareaActionPerformed

    }//GEN-LAST:event_tbxFiltroViewTareaActionPerformed

    private void tbxFiltroViewTareaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbxFiltroViewTareaKeyReleased
        String field = tbxFiltroViewTarea.getText().toString();
        String[] cols = {"Identificador", "Nombre", "Fecha Creacion", "Fecha Cierre"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                if (i1 == 0) {
                    return false;
                }
                if (i1 == 2) {
                    return false;
                }
                return true;
            }
        };
        for (Tarea t : td.filtroTarea(field)) {
            Object[] objetos = {t.getIdTarea(), t.getNombre(), t.getFecha_creacion(), t.getFecha_cierre(), t.isEstado()};
            tm.addRow(objetos);
        }
        jtblTareas.setModel(tm);
    }//GEN-LAST:event_tbxFiltroViewTareaKeyReleased

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int indice = jtblTareas.getSelectedRow();
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea a eliminar");
        } else {
            int id = (int) jtblTareas.getValueAt(indice, 0);
            td.eliminarTarea(id);
            listarTareas();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtblTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblTareasMousePressed
        // TODO add your handling code here:
        int indice = jtblTareas.getSelectedRow();
        int id = (int) jtblTareas.getValueAt(indice, 0);

        Tarea t = td.buscarTarea(id);

        lblInfoTarea.setText(t.getEquipoMiembro().getEquipo().getProyecto().getNombre() + " / " + t.getEquipoMiembro().getEquipo().getNombre() + " / " + t.getEquipoMiembro().getMiembro().getNombre());
    }//GEN-LAST:event_jtblTareasMousePressed

    private void cbxProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProyectoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxProyectoActionPerformed

    private void cbxEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEquipoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxEquipoActionPerformed

    private void cbxMiembroEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMiembroEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMiembroEquipoActionPerformed

    private void cbxEquipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEquipoMousePressed
        // TODO add your handling code here:
        if (cbxProyecto.getSelectedIndex() > -1) {
            cargarEquipos();
        }
    }//GEN-LAST:event_cbxEquipoMousePressed

    private void cbxMiembroEquipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMiembroEquipoMousePressed
        // TODO add your handling code here:
        if (cbxEquipo.getSelectedIndex() > -1) {
            cargarEquipoMiembros();
        }
    }//GEN-LAST:event_cbxMiembroEquipoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxEquipo;
    private javax.swing.JComboBox<String> cbxMiembroEquipo;
    private javax.swing.JComboBox<String> cbxProyecto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private com.toedter.calendar.JDateChooser jcFinalizacion;
    private javax.swing.JTable jtblTareas;
    private javax.swing.JLabel lblInfoTarea;
    private javax.swing.JTextField tbxFiltroViewTarea;
    private javax.swing.JTextField tbxNombreNewTarea;
    // End of variables declaration//GEN-END:variables
}
