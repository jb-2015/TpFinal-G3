/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controller.ComentarioData;
import controller.EstadoTareaData;
import controller.MiembroData;
import controller.TareaData;
import java.time.LocalDate;
import javax.swing.JInternalFrame;
import modelo.Comentario;
import modelo.EstadoTarea;
import modelo.Miembro;
import modelo.Tarea;

/**
 *
 * @author juany
 */
public class ViewComentar extends javax.swing.JFrame {
    private int idTarea;
    private int idMiembro;
    private TareaData td = new TareaData();
    private ComentarioData cd = new ComentarioData();
    private MiembroData md = new MiembroData();

    /**
     * Creates new form ViewComentar
     */
    public ViewComentar() {

        initComponents();

    }

    public void cargarInfo(int idTarea, int idMiembro) {
        this.idTarea=idTarea;
        this.idMiembro=idMiembro;
        Miembro m = md.buscarMiembro(idMiembro);
        lblMiembroCom.setText(m.getNombre() + " " + m.getApellido());
        lblTareaComent.setText(td.buscarTarea(idTarea).getNombre());
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
        lblMiembroCom = new javax.swing.JLabel();
        lblTareaComent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAComentario = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jchbxRealizada = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/111-bubble2.png"))); // NOI18N
        jLabel1.setText("COMENTAR");

        lblMiembroCom.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMiembroCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/114-user.png"))); // NOI18N
        lblMiembroCom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 1, 11))); // NOI18N

        lblTareaComent.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTareaComent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/186-list-numbered.png"))); // NOI18N
        lblTareaComent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarea", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 1, 11))); // NOI18N

        txtAComentario.setColumns(20);
        txtAComentario.setRows(5);
        jScrollPane1.setViewportView(txtAComentario);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/074-compass.png"))); // NOI18N
        jButton1.setText("Comentar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconS/272-cross.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jchbxRealizada.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jchbxRealizada.setText("Realizada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(lblMiembroCom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTareaComent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jchbxRealizada)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblMiembroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTareaComent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jchbxRealizada))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TareaData td = new TareaData();
        EstadoTareaData etd= new EstadoTareaData();
        String msg= "";
        if(jchbxRealizada.isSelected()){
            Tarea t= td.buscarTarea(idTarea);
            EstadoTarea et= new EstadoTarea(t, LocalDate.now());     
            
            etd.finalizarTarea(idTarea);
            msg="#FINALIZADA#";
        }
        String texto = msg+txtAComentario.getText();
        Comentario com = new Comentario(texto, LocalDate.now(), td.buscarTarea(idTarea));
        cd.guardarComentario(com);
        txtAComentario.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jchbxRealizada;
    private javax.swing.JLabel lblMiembroCom;
    private javax.swing.JLabel lblTareaComent;
    private javax.swing.JTextArea txtAComentario;
    // End of variables declaration//GEN-END:variables
}
