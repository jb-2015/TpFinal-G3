/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EquipoMiembro;

/**
 *
 * @author juany
 */
public class EquipoMiembroData {
    private MiembroData md= new MiembroData();
    private EquipoData ed = new EquipoData();
    //private EquipoData ed= new EquipoData();
    //EquipoData ed= new EquipoData();
    
    public EquipoMiembro buscarEquipoMiembro(int id){
        String sql = "SELECT * FROM equipomiembros WHERE idMiembroEq=?";
         EquipoMiembro em = null;
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();//devolviendo todos los equipos.
            if(rs.next()){
            em =new EquipoMiembro();
            em.setIdEquipoMiembro(rs.getInt("idMiembroEq"));
            em.setFecha_incorporacion(rs.getDate("fecha_incorporacion").toLocalDate());
            em.setMiembro(md.buscarMiembro(rs.getInt("idMiembro")));
            //em.setEquipo(ed.buscarEquipo(rs.getInt(idEquipo)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR EQUIPO MIEMBRO"+ e.getMessage());
        }
        return null;
    }
    public ArrayList<EquipoMiembro> listarEquipoMiembro(){
        ArrayList<EquipoMiembro> arrEM = new ArrayList();
        String sql = "SELECT * FROM equipomiembros WHERE estado = 1";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                EquipoMiembro em = new EquipoMiembro();
                em.setIdEquipoMiembro(rs.getInt("idMiembroEq"));
                em.setFecha_incorporacion(rs.getDate("fecha_incorporacion").toLocalDate());
                em.setEquipo(ed.obtenerEquipo(rs.getInt("idEquipo")));
                em.setMiembro(md.buscarMiembro(rs.getInt("idMiembro")));
                em.setEstado(rs.getBoolean("estado"));
                arrEM.add(em);
            }
                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al listar Equipo/miembro");
        }
        
        return arrEM;
    }
    
}
