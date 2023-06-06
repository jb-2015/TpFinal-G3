/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Tarea;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author juany
 */
public class TareaData {
    
    public void guardarTarea(Tarea t){
        String sql= "INSERT INTO tarea(nombre,fecha_creacion,fecha_cierre,estado) VALUES(?,?,?,?)";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setDate(2,Date.valueOf(t.getFecha_creacion()));
            ps.setDate(3,Date.valueOf(t.getFecha_cierre()));
            ps.setBoolean(4, t.isEstado());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Tarea Guardada");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar Tarea: "+e.getMessage());
        }
    }
    public ArrayList<Tarea> listarTareas(){
        ArrayList<Tarea> arr= new ArrayList();
        Tarea t;
        String sql= "SELECT * FROM tarea WHERE estado = 1";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                t=new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                
                arr.add(t);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al listar tareas: "+e.getMessage());
        }
        return arr;
        
    }
    public Tarea buscarTarea(int id){
        Tarea t = null;
        String sql ="SELECT * FROM tarea WHERE idTarea=?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                t=new Tarea();
                t.setIdTarea(id);
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al buscar tarea: "+e.getMessage());
        }
        
        return t;
    }
    public void modificarTarea(Tarea t){
        
    }
    
    
}
