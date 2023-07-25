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
public class madre extends persona{
    private int id_madre;

    public madre() {
    }

    public madre(int id_madre) {
        this.id_madre = id_madre;
    }

    public madre(int id_madre, int id, String nombre, String apellido, String telefono, String cedula, String direccion, String email, String tipo, Date fecha_nacimiento) {
        super(id, nombre, apellido, telefono, cedula, direccion, email, tipo, fecha_nacimiento);
        this.id_madre = id_madre;
    }

    public int getId_madre() {
        return id_madre;
    }

    public void setId_madre(int id_madre) {
        this.id_madre = id_madre;
    }
    
}
