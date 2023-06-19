/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import modelo.Miembro;
import controller.MiembroData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juany
 */
public class ViewMiembro extends javax.swing.JInternalFrame {
        MiembroData md = new MiembroData();
        ArrayList<Miembro> listaMiembros= new ArrayList();
    /**
     * Creates new form ViewMiembro
     */
    public ViewMiembro() {
        initComponents();
        listarMiembros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMiembros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfBuscarMiembro = new javax.swing.JTextField();
        jbModificarMiembro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbAgregarMiembro = new javax.swing.JButton();
        jtfAgregarNombre = new javax.swing.JTextField();
        jtfAgregarApellido = new javax.swing.JTextField();
        jtfAgregarDni = new javax.swing.JTextField();
        jbSalir = new javax.swing.JButton();
        jbEliminarMiembro = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/115-users.png"))); // NOI18N
        jLabel1.setText("MIEMBROS");

        tblMiembros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMiembros);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/135-search.png"))); // NOI18N

        jtfBuscarMiembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBuscarMiembroKeyReleased(evt);
            }
        });

        jbModificarMiembro.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jbModificarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/007-pencil2.png"))); // NOI18N
        jbModificarMiembro.setText("Modificar");
        jbModificarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarMiembroActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/116-user-plus.png"))); // NOI18N
        jLabel3.setText("Agregar Miembro");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("DNI");

        jbAgregarMiembro.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jbAgregarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/116-user-plus.png"))); // NOI18N
        jbAgregarMiembro.setText("Crear");
        jbAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarMiembroActionPerformed(evt);
            }
        });

        jtfAgregarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAgregarNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfAgregarNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAgregarApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(jtfAgregarDni)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAgregarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfAgregarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfAgregarDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jbAgregarMiembro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbSalir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbEliminarMiembro.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jbEliminarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/117-user-minus.png"))); // NOI18N
        jbEliminarMiembro.setText("Eliminar");
        jbEliminarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarMiembroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jbEliminarMiembro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificarMiembro)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfBuscarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbModificarMiembro)
                        .addComponent(jbEliminarMiembro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbModificarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarMiembroActionPerformed

        // TODO add your handling code here:
        int index= tblMiembros.getSelectedRow();
        int idMiembro=(int)tblMiembros.getValueAt(index,0);
        
        Miembro m = md.buscarMiembro(idMiembro);
        
        m.setNombre(tblMiembros.getValueAt(index, 1).toString());
        m.setApellido(tblMiembros.getValueAt(index, 2).toString());
        
        md.modificarMiembro(m);
        
        
        
        

    }//GEN-LAST:event_jbModificarMiembroActionPerformed

    private void jtfAgregarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAgregarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAgregarNombreActionPerformed

    private void jbAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarMiembroActionPerformed
        // TODO add your handling code here:
        String dni = jtfAgregarDni.getText();
        String nombre = jtfAgregarNombre.getText();
        String apellido = jtfAgregarApellido.getText();
        Miembro nuevo = new Miembro(dni,nombre,apellido,true);
        md.guardarMiembro(nuevo);
        limpiar1();
        listarMiembros();
    }//GEN-LAST:event_jbAgregarMiembroActionPerformed

    private void jbEliminarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarMiembroActionPerformed
        // TODO add your handling code here:
        
        int index = tblMiembros.getSelectedRow();
        int idMiembro = (int)tblMiembros.getValueAt(index,0);
        
        md.eliminarMiembro(idMiembro);
    }//GEN-LAST:event_jbEliminarMiembroActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfBuscarMiembroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarMiembroKeyReleased
        // TODO add your handling code here:
        if(listaMiembros.isEmpty()){
            listaMiembros=(ArrayList<Miembro>)md.listarMiembros();
        }
        String busqueda= jtfBuscarMiembro.getText();
        String[] cols = {"ID", "Nombre", "Apellido", "DNI"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0){
            @Override
            public boolean isCellEditable(int i,int il){
               return il==1 || il==2;
            }
        };
        for(Miembro m: listaMiembros){
            if(m.getNombre().contains(busqueda) || m.getApellido().contains(busqueda)){
                Object[] dato ={m.getIdMiembro(),m.getNombre(),m.getApellido(),m.getDni()};
                tm.addRow(dato);
            }
        }
        tblMiembros.setModel(tm);
    }//GEN-LAST:event_jtfBuscarMiembroKeyReleased
    private void limpiar1(){
        jtfAgregarApellido.setText("");
        jtfAgregarDni.setText("");
        jtfAgregarNombre.setText("");
    }
   
        private void listarMiembros(){
        String[] cols = {"ID", "Nombre", "Apellido", "DNI"};
        DefaultTableModel tm = new DefaultTableModel(cols, 0){
            @Override
            public boolean isCellEditable(int i,int il){
               return il==1 || il==2;
            }
        };

        for (Miembro m : md.listarMiembros()) {
            Object[] dato = {m.getIdMiembro(), m.getNombre(), m.getApellido(), m.getDni()};
            tm.addRow(dato);
        }

        tblMiembros.setModel(tm);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarMiembro;
    private javax.swing.JButton jbEliminarMiembro;
    private javax.swing.JButton jbModificarMiembro;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtfAgregarApellido;
    private javax.swing.JTextField jtfAgregarDni;
    private javax.swing.JTextField jtfAgregarNombre;
    private javax.swing.JTextField jtfBuscarMiembro;
    private javax.swing.JTable tblMiembros;
    // End of variables declaration//GEN-END:variables

}
