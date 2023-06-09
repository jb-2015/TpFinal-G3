/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Comentario;

/**
 *
 * @author juany
 */
public class ComentarioData {

    TareaData td = new TareaData();

    public ArrayList<Comentario> listarComentarios() {
        ArrayList<Comentario> com = new ArrayList();

        String sql = "SELECT * FROM comentarios";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comentario c = new Comentario();
                c.setIdComentario(rs.getInt("idComentario"));
                c.setComentario(rs.getString("comentario"));
                c.setFecha_avance(rs.getDate("fecha_avance").toLocalDate());
                c.setTarea(td.buscarTarea(rs.getInt("idTarea")));

                com.add(c);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar comentarios");
        }

        return com;
    }
    
    public void guardarComentario(Comentario c){
        String sql = "INSERT INTO comentarios (comentario,fecha_avance,idTarea) VALUES (?,?,?)";
        try{
            PreparedStatement ps  = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, c.getComentario());
            ps.setDate(2, Date.valueOf(c.getFecha_avance()));
            ps.setInt(3, c.getTarea().getIdTarea());
            ps.execute();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al guardar comentario: "+e.getMessage());
        
        }
    }
    
    
}
