/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controller.ComentarioData;
import controller.ConsultaPorEstados;
import controller.EquipoData;
import controller.MiembroData;
import controller.ProyectoData;
import controller.TareaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Comentario;
import modelo.Equipo;
import modelo.Miembro;
import modelo.Proyecto;
import modelo.Tarea;

/**
 *
 * @author juany
 */
public class ViewGeneral extends javax.swing.JInternalFrame {

    ProyectoData pd = new ProyectoData();
    EquipoData ed = new EquipoData();
    TareaData td = new TareaData();
    MiembroData md = new MiembroData();
    ComentarioData cd = new ComentarioData();

    /**
     * Creates new form ViewGeneral
     */
    public ViewGeneral() {
        initComponents();
        cargarProyectos();
    }

    public void cargarProyectos() {
        String[] cols = {"ID", "Nombre", "Descripcion", "Fecha Inicio"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };
        for (Proyecto p : pd.listarProyectos()) {
            Object[] dato = {p.getIdProyecto(), p.getNombre(), p.getDescripcion(), p.getFecha_inicio()};
            tm.addRow(dato);
        }
        tblProyectos.setModel(tm);
        tblProyectos.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblProyectos.getColumnModel().getColumn(0).setWidth(10);
        tblProyectos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblProyectos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblProyectos.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        tblProyectos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEquipoProject = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMiembroDeEquipo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAComentarios = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnRealizada = new javax.swing.JButton();
        pgrProgresoProyecto = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarProject = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        tblProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProyectosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProyectos);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setText("Equipos asignados");

        tblEquipoProject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipo"
            }
        ));
        tblEquipoProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEquipoProjectMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblEquipoProject);
        if (tblEquipoProject.getColumnModel().getColumnCount() > 0) {
            tblEquipoProject.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tblMiembroDeEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido"
            }
        ));
        tblMiembroDeEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMiembroDeEquipoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblMiembroDeEquipo);
        if (tblMiembroDeEquipo.getColumnModel().getColumnCount() > 0) {
            tblMiembroDeEquipo.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jLabel1.setText("Miembros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 192, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTareasMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblTareas);

        txtAComentarios.setEditable(false);
        txtAComentarios.setColumns(20);
        txtAComentarios.setRows(5);
        jScrollPane5.setViewportView(txtAComentarios);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Comentarios:");

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/111-bubble2.png"))); // NOI18N
        jButton2.setText("Comentar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRealizada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/273-checkmark.png"))); // NOI18N
        btnRealizada.setToolTipText("marcar como realizada");

        pgrProgresoProyecto.setToolTipText("");
        pgrProgresoProyecto.setValue(75);
        pgrProgresoProyecto.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(pgrProgresoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnRealizada)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgrProgresoProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btnRealizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/157-stats-bars.png"))); // NOI18N
        jLabel3.setText("General");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/135-search.png"))); // NOI18N
        jLabel4.setText("Buscar");

        txtBuscarProject.setToolTipText("ingrese para buscar");
        txtBuscarProject.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProjectKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        jButton1.setToolTipText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscarProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProyectosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProyectosMousePressed
        // TODO add your handling code here:
        
        int index = tblProyectos.getSelectedRow();
        int idProyecto = Integer.parseInt(tblProyectos.getValueAt(index, 0).toString());
        String[] cols = {"ID", "Nombre Equipo", "Creacion"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };

        for (Equipo e : ed.obtenerEquipos(ConsultaPorEstados.ACTIVOS)) {
            if (e.getProyecto().getIdProyecto() == idProyecto) {
                Object[] dato = {e.getIdEquipo(), e.getNombre(), e.getFecha_creacion()};
                tm.addRow(dato);
            }
        }
        tblEquipoProject.setModel(tm);

        //LISTAMOS TAREAS POR PROYECTO
        String[] colsT = {"ID", "Nombre Tarea", "Fecha Fin"};
        DefaultTableModel tmt = new DefaultTableModel(colsT, 0);

        for (Tarea t : td.listarTareaPorProyecto(idProyecto)) {
            Object[] dato = {t.getIdTarea(), t.getNombre(), t.getFecha_cierre()};
            tmt.addRow(dato);
        }
        tblTareas.setModel(tmt);
        tblMiembroDeEquipo.setModel(new DefaultTableModel(0, 0));
        
    }//GEN-LAST:event_tblProyectosMousePressed

    private void tblEquipoProjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipoProjectMousePressed
        // TODO add your handling code here:
        int index = tblEquipoProject.getSelectedRow();
        int idEquipo = Integer.parseInt(tblEquipoProject.getValueAt(index, 0).toString());
        String[] colsT = {"ID", "Nombre Tarea", "Fecha Fin"};
        DefaultTableModel tmt = new DefaultTableModel(colsT, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };
        for (Tarea t : td.listarTareaPorEquipo(idEquipo)) {
            Object[] dato = {t.getIdTarea(), t.getNombre(), t.getFecha_cierre()};
            tmt.addRow(dato);
        }
        tblTareas.setModel(tmt);
        String[] colsM = {"ID", "NOMBRE MIEMBRO", "DNI"};
        DefaultTableModel tmm = new DefaultTableModel(colsM, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };
        for (Miembro m : md.lisarPorEquipo(idEquipo)) {
            Object[] dato = {m.getIdMiembro(), m.getNombre() + " " + m.getApellido(), m.getDni()};
            tmm.addRow(dato);
        }
        tblMiembroDeEquipo.setModel(tmm);


    }//GEN-LAST:event_tblEquipoProjectMousePressed

    private void tblMiembroDeEquipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMiembroDeEquipoMousePressed
        // TODO add your handling code here:
        int index = tblMiembroDeEquipo.getSelectedRow();
        int idMiembro = Integer.parseInt(tblMiembroDeEquipo.getValueAt(index, 0).toString());

        String[] colsT = {"ID", "Nombre Tarea", "Fecha Fin"};
        DefaultTableModel tmt = new DefaultTableModel(colsT, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };

        index = tblEquipoProject.getSelectedRow();
        int idEquipo = Integer.parseInt(tblEquipoProject.getValueAt(index, 0).toString());

        for (Tarea t : td.listarTareaPorMiembro(idMiembro, idEquipo)) {
            Object[] dato = {t.getIdTarea(), t.getNombre(), t.getFecha_cierre()};
            tmt.addRow(dato);

        }

        tblTareas.setModel(tmt);

    }//GEN-LAST:event_tblMiembroDeEquipoMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
        if (tblTareas.getSelectedRowCount() > 0) {
            int index = tblMiembroDeEquipo.getSelectedRow();
            int idMiembro = Integer.parseInt(tblMiembroDeEquipo.getValueAt(index, 0).toString());
            index = tblTareas.getSelectedRow();
            int idTarea = (int) tblTareas.getValueAt(index, 0);
            ViewComentar cv = new ViewComentar();
            cv.cargarInfo(idTarea, idMiembro);
            cv.setVisible(true);
              
        }else{
            JOptionPane.showMessageDialog(this, "No hay tareas Seleccionadas para realizar comentario");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTareasMousePressed

        int index = tblTareas.getSelectedRow();
        int idTarea = (int) tblTareas.getValueAt(index, 0);
        //VAMOS A MOSTRAR QUE EQUIPO HACE LA TAREA Y QUE MIEMBRO
        Tarea t = td.buscarTarea(idTarea);

        String idEquipo = t.getEquipoMiembro().getEquipo().getIdEquipo() + "";
        String idMiembro = t.getEquipoMiembro().getMiembro().getIdMiembro() + "";

        for (int i = 0; i < tblEquipoProject.getRowCount(); i++) {
            if (idEquipo.equals(tblEquipoProject.getValueAt(i, 0).toString())) {
                tblEquipoProject.setRowSelectionInterval(i, i);
            }
        }

        String[] colsM = {"ID", "NOMBRE MIEMBRO", "DNI"};
        DefaultTableModel tmm = new DefaultTableModel(colsM, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };
        for (Miembro m : md.lisarPorEquipo((t.getEquipoMiembro().getEquipo().getIdEquipo()))) {
            Object[] dato = {m.getIdMiembro(), m.getNombre() + " " + m.getApellido(), m.getDni()};
            tmm.addRow(dato);
        }
        tblMiembroDeEquipo.setModel(tmm);

        for (int i = 0; i < tblMiembroDeEquipo.getRowCount(); i++) {
            if (idMiembro.equals(tblMiembroDeEquipo.getValueAt(i, 0).toString())) {
                tblMiembroDeEquipo.setRowSelectionInterval(i, i);
            }
        }

        //-------------------------------------------------------
        String contenido = "";
        for (Comentario c : cd.listarPorTarea(idTarea)) {

            String nombre = c.getTarea().getEquipoMiembro().getMiembro().getNombre() + " " + c.getTarea().getEquipoMiembro().getMiembro().getApellido();
            String fecha = c.getFecha_avance().toString();
            String coment = c.getComentario();

            contenido += nombre + ": (" + fecha + ") \n >> " + coment + "\n ------------------------- \n ";

        }
        txtAComentarios.setText(contenido);


    }//GEN-LAST:event_tblTareasMousePressed

    private void txtBuscarProjectKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProjectKeyReleased
        // TODO add your handling code here:
        String texto = txtBuscarProject.getText();
        String[] cols = {"ID", "Nombre", "Descripcion", "Fecha Inicio"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return false;
            }
        };
        for (Proyecto p : pd.filtrar(texto)) {
            Object[] dato = {p.getIdProyecto(), p.getNombre(), p.getDescripcion(), p.getFecha_inicio()};
            tm.addRow(dato);
        }
        tblProyectos.setModel(tm);
        tblProyectos.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblProyectos.getColumnModel().getColumn(0).setWidth(10);
        tblProyectos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblProyectos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblProyectos.getColumnModel().getColumn(3).setPreferredWidth(100);
    }//GEN-LAST:event_txtBuscarProjectKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JProgressBar pgrProgresoProyecto;
    private javax.swing.JTable tblEquipoProject;
    private javax.swing.JTable tblMiembroDeEquipo;
    private javax.swing.JTable tblProyectos;
    private javax.swing.JTable tblTareas;
    private javax.swing.JTextArea txtAComentarios;
    private javax.swing.JTextField txtBuscarProject;
    // End of variables declaration//GEN-END:variables
}
