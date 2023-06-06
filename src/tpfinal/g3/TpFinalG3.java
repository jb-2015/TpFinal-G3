/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.g3;

import controller.ProyectoData;
import java.time.LocalDate;
import java.util.Date;
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
        ProyectoData pd = new ProyectoData();
        for (Proyecto p : pd.listarProyectos()){
            System.out.println("Id: "+p.getIdProyecto()+"\n Nombre: "+p.getNombre()+"\n Descripcion: "+p.getDescripcion());
        }
        
        
    }
    
}
