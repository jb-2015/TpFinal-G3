/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Miembro;

/**
 *
 * @author Gonza
 */
public class MiembroData {
    public void guardarMiembro(Miembro miembro){
        String sql= "INSERT INTO MIEMBRO(dni,nombre,apellido,estado) VALUES ?,?,?,?";
    }
}
