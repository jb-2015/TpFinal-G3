/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controller.ConsultaPorEstados;
import controller.EquipoData;
import controller.EquipoMiembroData;
import controller.MiembroData;
import controller.ProyectoData;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Equipo;
import modelo.EquipoMiembro;
import modelo.Miembro;
import modelo.Proyecto;

/**
 *
 * @author juany
 */
public class ViewEquipo extends javax.swing.JInternalFrame {

    EquipoData ed = new EquipoData();
    MiembroData md = new MiembroData();
    ProyectoData pd = new ProyectoData();
    EquipoMiembroData emd = new EquipoMiembroData();
    ArrayList<Miembro> mOutTeam = new ArrayList();
    private Principal gral;
    /**
     * Creates new form ViewEquipo
     */
    public ViewEquipo(Principal parent) {
        this.gral=parent;
        initComponents();
        cargarEquipos();
    }

    private void cargarEquipos() {
        String[] cols = {"Nº", "Nombre", "Proyecto", "Fecha creacion"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return il == 1;
            }
        };

        for (Equipo e : ed.obtenerEquipos(ConsultaPorEstados.ACTIVOS)) {
            Object[] dato = {e.getIdEquipo(), e.getNombre(), e.getProyecto().getNombre(), e.getFecha_creacion()};
            tm.addRow(dato);
        }

        tblEquipos.setModel(tm);

    }

    private boolean yaExiste(String dni, JTable tab) {
        for (int i = 0; i < tab.getRowCount(); i++) {
            if (dni.equals(tab.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
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
        tblEquipos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFuturos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTodos = new javax.swing.JTable();
        tbxNombreNuevoEquipo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxProyecto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMiembros = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbxMiembros = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        txtFiltroMiembro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("EQUIPO");

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEquiposMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipos);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblFuturos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre y Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblFuturos);
        if (tblFuturos.getColumnModel().getColumnCount() > 0) {
            tblFuturos.getColumnModel().getColumn(0).setResizable(false);
            tblFuturos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblFuturos.getColumnModel().getColumn(1).setResizable(false);
            tblFuturos.getColumnModel().getColumn(1).setPreferredWidth(70);
        }

        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Futuros miembros");

        jLabel4.setText("Nombre de Equipo nuevo: ");

        jLabel5.setText("Escoge los miembros");

        tblTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblTodos);

        tbxNombreNuevoEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbxNombreNuevoEquipoMousePressed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("NUEVO EQUIPO");

        jLabel7.setText("Proyecto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tbxNombreNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbxNombreNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblMiembros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblMiembros);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxMiembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxMiembrosMousePressed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/116-user-plus.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtFiltroMiembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroMiembroKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/135-search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltroMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFiltroMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/007-pencil2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/272-cross.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/115-users.png"))); // NOI18N
        jLabel1.setText("Equipos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEquiposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMousePressed
        // TODO add your handling code here:
        int index = tblEquipos.getSelectedRow();
        int idEquipo = Integer.parseInt(tblEquipos.getValueAt(index, 0).toString());

        cbxMiembros.removeAllItems();
        for (Miembro m : md.listarNoEnEquipo(idEquipo)) {
            cbxMiembros.addItem(m.getIdMiembro() + "-" + m.getNombre() + " " + m.getApellido());
        }

        String[] cols = {"Nº", "Nombre", "Incorporacion"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };

        for (EquipoMiembro em : emd.listarEquipoMiembro()) {
            if (idEquipo == em.getEquipo().getIdEquipo()) {
                Object[] dato = {em.getMiembro().getIdMiembro(), em.getMiembro().getNombre() + " " + em.getMiembro().getApellido(), em.getFecha_incorporacion()};
                tm.addRow(dato);
            }
        }

        tblMiembros.setModel(tm);

        tblMiembros.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblMiembros.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblMiembros.getColumnModel().getColumn(2).setPreferredWidth(25);

    }//GEN-LAST:event_tblEquiposMousePressed

    private void tbxNombreNuevoEquipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbxNombreNuevoEquipoMousePressed
        // TODO add your handling code here:
        String[] cols = {"DNI", "Nombre y apellido"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0);

        for (Miembro m : md.listarMiembros()) {
            Object[] dato = {m.getDni(), m.getNombre() + " " + m.getApellido()};
            tm.addRow(dato);
        }
        tblTodos.setModel(tm);
        tblTodos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblTodos.getColumnModel().getColumn(1).setPreferredWidth(70);
        cbxProyecto.removeAllItems();
        for (Proyecto p : pd.listarProyectos()) {
            cbxProyecto.addItem(p.getIdProyecto() + "-" + p.getNombre());
        }
        cbxProyecto.setSelectedIndex(-1);

    }//GEN-LAST:event_tbxNombreNuevoEquipoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int[] index = tblTodos.getSelectedRows();
        int colCant = tblTodos.getColumnCount();
        Object[] rowData = new Object[colCant];

        for (int j = 0; j < index.length; j++) {
            if (!yaExiste(tblTodos.getValueAt(index[j], 0).toString(), tblFuturos)) {
                for (int i = 0; i < colCant; i++) {
                    rowData[i] = tblTodos.getValueAt(index[j], i);
                }

                DefaultTableModel mod = (DefaultTableModel) tblFuturos.getModel();
                mod.addRow(rowData);
            } else {
                JOptionPane.showMessageDialog(null, "Se encontraron datos que ya existen");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int indice = tblFuturos.getSelectedRow();
        DefaultTableModel mod = (DefaultTableModel) tblFuturos.getModel();

        mod.removeRow(indice);
        tblFuturos.revalidate();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int index = tblEquipos.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo a modificar.");
        } else {
            int idEquipo = Integer.parseInt(tblEquipos.getValueAt(index, 0).toString());
            String nombre = tblEquipos.getValueAt(index, 1).toString();
            Equipo aux = new Equipo(idEquipo, null, nombre, null, true);

            ed.modificarEquipo(aux);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbxMiembrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMiembrosMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxMiembrosMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int index = tblEquipos.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo a eliminar");
        } else {
            int idEquipo = Integer.parseInt(tblEquipos.getValueAt(index, 0).toString());

            ed.eliminarEquipo(idEquipo);
            gral.toggleButtons();
            cargarEquipos();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nombreEquipo = tbxNombreNuevoEquipo.getText();
        int indexProyecto = cbxProyecto.getSelectedIndex();

        if (!nombreEquipo.equals("") && indexProyecto > -1) {
            String[] part = cbxProyecto.getItemAt(indexProyecto).split("-");
            int idProyecto = Integer.parseInt(part[0]);
            Equipo e = new Equipo(pd.buscarProyecto(idProyecto), nombreEquipo, LocalDate.now(), true);

            ed.guardarEquipo(e);
            gral.toggleButtons();
            if (tblFuturos.getRowCount() > 0) {
                int cant = tblFuturos.getRowCount();
                for (int i = 0; i < cant; i++) {
                    String[] p = tblFuturos.getValueAt(i, 0).toString().split("-");
                    String dni = p[0];
                    EquipoMiembro nem = new EquipoMiembro(LocalDate.now(), e, md.buscarPorDni(dni), true);
                    emd.guardarEquipoMiembro(nem);
                    cargarEquipos();
                    gral.toggleButtons();
                }
                tblTodos.removeAll();
                tblFuturos.removeRowSelectionInterval(0, cant - 1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Revise si ha puesto un nombre, o si ha seleccionado un proyecto");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtFiltroMiembroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroMiembroKeyReleased
        // TODO add your handling code here:
        String f = txtFiltroMiembro.getText();
        int index = tblEquipos.getSelectedRow();
        int idEquipo = Integer.parseInt(tblEquipos.getValueAt(index, 0).toString());
        if (mOutTeam.isEmpty()) {
            mOutTeam = md.listarNoEnEquipo(idEquipo);
        }
        cbxMiembros.removeAllItems();
        for (Miembro m : mOutTeam) {
            if (m.getNombre().contains(f) || m.getApellido().contains(f)) {
                cbxMiembros.addItem(m.getIdMiembro() + "-" + m.getNombre() + " " + m.getApellido());
            }
        }
    }//GEN-LAST:event_txtFiltroMiembroKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (cbxMiembros.getSelectedIndex() != -1) {
            String select = cbxMiembros.getSelectedItem().toString();
            String[] part = select.split("-");
            int idMiembro = Integer.parseInt(part[0]);

            int index = tblEquipos.getSelectedRow();
            int idEquipo = (int) tblEquipos.getValueAt(index, 0);

            EquipoMiembro em = new EquipoMiembro(LocalDate.now(), ed.obtenerEquipo(idEquipo), md.buscarMiembro(idMiembro), true);
            emd.guardarEquipoMiembro(em);
            gral.toggleButtons();
            cargarEquipos();
            cbxMiembros.setSelectedIndex(-1);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un miembro, puede ayudarse con el buscador");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxMiembros;
    private javax.swing.JComboBox<String> cbxProyecto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblEquipos;
    private javax.swing.JTable tblFuturos;
    private javax.swing.JTable tblMiembros;
    private javax.swing.JTable tblTodos;
    private javax.swing.JTextField tbxNombreNuevoEquipo;
    private javax.swing.JTextField txtFiltroMiembro;
    // End of variables declaration//GEN-END:variables
}
