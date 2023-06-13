/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Tarea;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juany
 */
public class TareaData {

    EquipoMiembroData emd = new EquipoMiembroData();

    public void guardarTarea(Tarea t) {
        String sql = "INSERT INTO tarea(nombre,fecha_creacion,fecha_cierre,estado,idMiembroEq) VALUES(?,?,?,?,?)";
        
        try {
            LocalDate FechaCreacion =LocalDate.now();
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFecha_creacion()));
            ps.setDate(3, Date.valueOf(t.getFecha_cierre()));
            ps.setBoolean(4, t.isEstado());
            ps.setInt(5, t.getEquipoMiembro().getIdEquipoMiembro());
            int verificar= FechaCreacion.compareTo(t.getFecha_cierre());
            if(verificar>0){
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha posterior al dia actual");
        }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Tarea Guardada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar Tarea: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> listarTareas() {
        ArrayList<Tarea> arr = new ArrayList();
        Tarea t;
        String sql = "SELECT * FROM tarea WHERE estado = 1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idMiembroEq")));
                arr.add(t);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar tareas: " + e.getMessage());
        }
        return arr;

    }

    public Tarea buscarTarea(int id) {
        Tarea t = null;
        String sql = "SELECT * FROM tarea WHERE idTarea=?";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tarea();
                t.setIdTarea(id);
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idEquipoMiembro")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar tarea: " + e.getMessage());
        }

        return t;
    }

    public void modificarTarea(Tarea t) {
        String sql = "UPDATE tarea SET nombre= ?, fecha_creacion= ?, fecha_cierre=?, estado=?, idMiebroEq=? WHERE idTarea = ?";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFecha_creacion()));
            ps.setDate(3, Date.valueOf(t.getFecha_cierre()));
            ps.setBoolean(4, t.isEstado());
            ps.setInt(5, t.getEquipoMiembro().getIdEquipoMiembro());
            ps.setInt(6, t.getIdTarea());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Tarea modificada");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar tarea: " + e.getMessage());
        }
    }

    public void eliminarTarea(int idTarea) {
        String sql = "UPDATE tarea SET estado= 0 WHERE idTarea= ?";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idTarea);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar materia: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> listarTareaPorMiembro(int idMiembro) {
        ArrayList<Tarea> aux = new ArrayList();
        String sql = "SELECT * FROM tarea WHERE idTarea IN (SELECT idTarea FROM equipomiembros WHERE idEquipo= ?)";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idMiembro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(idMiembro));

                aux.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por equipo " + e.getMessage());
        }
        return aux;

    }

    public ArrayList<Tarea> listarTareaPorEquipo(int idEquipo) {
        ArrayList<Tarea> aux = new ArrayList();
        String sql = "SELECT * FROM tarea WHERE idTarea IN (SELECT idTarea FROM equipomiembros WHERE idEquipo= ?)";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(idEquipo));

                aux.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por equipo " + e.getMessage());
        }
        return aux;
    }
    public ArrayList<Tarea> listarTareaPorProyecto(int idProyecto){
        ArrayList<Tarea> aux = new ArrayList();
        String sql = "SELECT * FROM tarea JOIN equipomiembro ON tarea.idMiembroEq= equipomiembro.idMiembroEq \n"
                + "JOIN equipo ON equipomiembro.idEquipo = equipo.idEquipo\n"
                + "JOIN proyecto ON equipo.idProyecto = proyecto=?";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idMiembroEq")));

                aux.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por equipo " + e.getMessage());
        }
        return aux;
    }

}
