/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class padre extends persona{
    private int id_padre;

    public padre() {
    }

    public padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public padre(int id_padre, int id, String nombre, String apellido, String telefono, String cedula, String direccion, String email, String tipo, Date fecha_nacimiento) {
        super(id, nombre, apellido, telefono, cedula, direccion, email, tipo, fecha_nacimiento);
        this.id_padre = id_padre;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }
    
}
