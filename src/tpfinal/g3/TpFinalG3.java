/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.g3;

import controller.EquipoMiembroData;
import controller.MiembroData;
import controller.ProyectoData;
import java.time.LocalDate;
import java.util.Date;
import modelo.Equipo;
import modelo.EquipoMiembro;
import modelo.Miembro;
import modelo.Proyecto;

/**
 *
 * @author juany
 */
public class TpFinalG3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EquipoMiembroData emd= new EquipoMiembroData();
        MiembroData md = new  MiembroData();
        ProyectoData pd = new ProyectoData();
        
       Miembro m1 = new Miembro("38338967", "Carolina", "Pereyra", true);
       Miembro m2 = new Miembro("35765492", "Alejandro", "Alaniz", true);
       Miembro m3 = new Miembro("45658987", "Josefa", "Chavez", true);
       
       Proyecto p1 = new Proyecto("Pagina web", "E-Comerce Pasteleria", LocalDate.now(), true);
       Proyecto p2 = new Proyecto("Sistema de ventas", "Control de inventario y ventas", LocalDate.now(), true);
       
       Equipo e1= new Equipo(p2, "Bigote", LocalDate.now(), true);
       
       EquipoMiembro em1 = new EquipoMiembro(LocalDate.now(), e1, m3, true);
       EquipoMiembro em2 = new EquipoMiembro(LocalDate.now(), e1, m1, true);
       
       
    }
    
}
