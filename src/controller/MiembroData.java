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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Miembro;

/**
 *
 * @author Gonza
 */
public class MiembroData {
    public void guardarMiembro(Miembro miembro){
        String sql= "INSERT INTO MIEMBRO(dni,nombre,apellido,estado) VALUES ?,?,?,?";
       try{
           PreparedStatement ps= Conexion.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, miembro.getNombre());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getDni());
            ps.setBoolean(4, miembro.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            miembro.setIdMiembro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Miembro añadido. ");
            }else{
            JOptionPane.showMessageDialog(null, "El miembro no pudo ser guardado");
            }
            ps.close();
       }catch(SQLException e){
       JOptionPane.showMessageDialog(null, "Error al guardar miembro" + e.getMessage());
       }
    }
       public void buscarMiembro(int id){
           String sql= "SELECT * FROM miembro WHERE idMiembro=?";
           Miembro m= new Miembro();
           
           try {
               PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
               ResultSet rs;
               rs = ps.executeQuery();
               ps.setInt(1, id);
               if (rs.next()){
                   m.setIdMiembro(id);
                   m.setDni(rs.getString("dni"));
                   m.setApellido(rs.getString("apellido"));
                   m.setNombre(rs.getString("nombre"));
                   m.setEstado(rs.getBoolean("estado"));
               }else{
               JOptionPane.showMessageDialog(null, "No se encontro el miembro");
               }
           }
           catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Error al buscar miembro " + e.getMessage());
           }
       }
       public void modificarMiembro(Miembro miembro){
       String sql= "UPDATE miembro SET dni=?, apellido=?, nombre=?,estado=?";
           try {
               PreparedStatement ps=Conexion.conectar().prepareStatement(sql);
               ps.setString(1, miembro.getDni());
               ps.setString(2, miembro.getApellido());
               ps.setString(3, miembro.getNombre());
               ps.setBoolean(4, miembro.isEstado());
               int res= ps.executeUpdate();
               if(res==1){
               JOptionPane.showMessageDialog(null, "Miembro modificado ");
               }
               else{
               JOptionPane.showMessageDialog(null, "No se pudo modificar el miembro");
               }
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Problemas al modificar el miembro "+ e.getMessage());
           }
       }
       public void eliminarMiembro(int id){
       String sql = "UPDATE miembro SET estado=0 WHERE idMiembro=?";
           try {
               PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
               ps.setInt(1, id);
               int res= ps.executeUpdate();
               if(res==1){
               JOptionPane.showMessageDialog(null, "Miembro eliminado");
               }else{
               JOptionPane.showMessageDialog(null, "No se pudo eliminar al miembro");
               }
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Problemas al eliminar el miembro "+e.getMessage());
           }
       }
       public List<Miembro> listarMiembros(){
           List<Miembro> listaMiembros= new ArrayList();
       String sql ="SELECT* FROM miembro WHERE estado=1";
           try {
               PreparedStatement ps= Conexion.conectar().prepareStatement(sql);
               ResultSet rs= ps.executeQuery();
               while(rs.next()){
               Miembro miembro= new Miembro();
               miembro.setIdMiembro(rs.getInt("id_alumno"));
               miembro.setDni(rs.getString("dni"));
               miembro.setApellido(rs.getString("apellido"));
               miembro.setNombre(rs.getString("nombre"));
               miembro.setEstado(rs.getBoolean("estado"));
               listaMiembros.add(miembro);
               }
               ps.close();
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LA LISTA DE MIEMBROS"+ e.getMessage());
           }
       return listaMiembros;
       }
       public void darAlta(int id){
           try {
               String sql= "UPDATE miembro SET estado=1 WHERE idMiembro=?";
               PreparedStatement ps= Conexion.conectar().prepareStatement(sql);
               ps.setInt(1, id);
               int res = ps.executeUpdate();
               if(res==1){
               JOptionPane.showMessageDialog(null, "Miembro activado! ");
               }else{
                   JOptionPane.showMessageDialog(null, "El miembro no pudo activarse");
               }
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "ERROR AL DAR DE ALTA ALUMNO"+ e.getMessage());
           }
       }
}
