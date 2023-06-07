/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import modelo.Equipo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controller.Estados;




/**
 *
 * @author Usuario
 */
public class EquipoData {
    

    ProyectoData proyectoData = new ProyectoData();
   

    public void guardarEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipo (idProyecto, nombre, fecha_creacion, estado) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //DEVUEL CON SU KEY 
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(equipo.getFecha_creacion()));
            ps.setBoolean(4, equipo.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Equipo guardado.");
            } else {
                JOptionPane.showMessageDialog(null, "El Equipo no pudo ser guardado.");
            }
            ps.close();// se cierra los PS para por que pueden causar perdida de memoria o simplemente cerrar la conexion.

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se encontro un problema al cargar el equipo " + e.getMessage());
        }
    }
    
     public void eliminarEquipo(int id){
        String sql = "UPDATE equipo SET estado=0 WHERE idEquipo = ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            int res = ps.executeUpdate();
            ps.close();
            if(res==1){
                JOptionPane.showMessageDialog(null, "Se 'elimino' el alumno");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno no se encuentra ");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar");
        }
    }

    public List<Equipo> obtenerEquipos(ConsultaPorEstados estado) {
        String sql; 
        if(null == estado){
            sql = "SELECT * FROM equipo";
        } else switch (estado) {
            case INACTIVOS:
                sql = "SELECT * FROM equipo WHERE estado = 0";
                break;
            case ACTIVOS:
                sql = "SELECT * FROM equipo WHERE estado = 1";
                break;
            default:
                sql = "SELECT * FROM equipo";
                break;
        }
        Equipo equipo;
        List<Equipo> equipos = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            while (rs.next()) {
                equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                equipo.setProyecto(proyectoData.buscarProyecto(rs.getInt("idProyecto")));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                equipo.setEstado(rs.getBoolean("estado"));

                equipos.add(equipo);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipo " + e.getMessage());
        }

        return equipos;
    }
    

    public List<Inscripcion> obetenerInscripcionesPorAlumno(int id) {
        String sql = "SELECT * FROM inscripcion WHERE id_alumno = ?";
        Inscripcion insc = new Inscripcion();
        List<Inscripcion> inscripciones = new ArrayList();
        Alumno alumno = alumnoData.buscarAlumno(id);
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            if (rs.next()) {
                insc.setId_inscripcion(rs.getInt("id_inscripcion"));
                insc.setId_alumno(alumno);
                insc.setId_materia(materiaData.buscarMateria(rs.getInt("id_materia")));
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            } else {
                JOptionPane.showMessageDialog(null, "No existen inscripciones para este id_alumno");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion " + e.getMessage());
        }

        return inscripciones;
    }

    public List<Materia> obetenerMateriasCursadas(int id) {
        //String sql = "SELECT * FROM materias where id_materia in (SELECT id_materia FROM inscripcion WHERE id_alumno = ? AND nota IS NOT NULL)";
        String sql = "SELECT * FROM materias where id_materia in (SELECT id_materia FROM inscripcion WHERE id_alumno = ?)";
        Materia materia = new Materia();
        List<Materia> materiasCursadas = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            while (rs.next()) {
                materia = new Materia();
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materiasCursadas.add(materia);
            }
//            else {
//                JOptionPane.showMessageDialog(null, "No existen materias cursadas para este alumno");
//            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materias " + e.getMessage());
        }

        return materiasCursadas;
    }

    public List<Materia> obetenerMateriasNoCursadas(int id) {
        //String sql = "SELECT * FROM materias where id_materia in (SELECT id_materia FROM inscripcion WHERE id_alumno = ? AND nota IS NULL)";
        String sql = "SELECT * FROM materias where id_materia not in (SELECT id_materia FROM inscripcion WHERE id_alumno = ?)";
        Materia materia = new Materia();
        List<Materia> materiasCursadas = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            while (rs.next()) {
                materia = new Materia();
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materiasCursadas.add(materia);
            }
//            else {
//                JOptionPane.showMessageDialog(null, "No existen materias no cursadas para este alumno");
//            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materias " + e.getMessage());
        }

        return materiasCursadas;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        try {
            //buscar el alumno por id, y setearle el estado en 0.
            String sql = "DELETE FROM inscripcion WHERE id_alumno=? AND id_materia=?";
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se a podido acceder a la tabla inscripcion " + e.getMessage());
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            //buscar el alumno por id, y setearle el estado en 0.
            String sql = "UPDATE inscripcion SET nota = ? WHERE id_alumno=? AND id_materia=?";
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            if (!ps.execute()) {
                JOptionPane.showMessageDialog(null, "Error al actualizar nota");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se a podido acceder a la tabla inscripcion " + e.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        String sql = "SELECT * FROM alumnos where id_alumno in (SELECT id_alumno FROM inscripcion WHERE id_materia = ?)";
        Alumno alumno = null;
        List<Alumno> alumnosEnXMateria = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            if (rs.next()) {
                alumno.setAlumno_id(rs.getInt("id_alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getString("dni"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosEnXMateria.add(alumno);
            } else {
                JOptionPane.showMessageDialog(null, "No existen alumnos inscriptos en esta materia");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos " + e.getMessage());
        }

        return alumnosEnXMateria;
    }

}
