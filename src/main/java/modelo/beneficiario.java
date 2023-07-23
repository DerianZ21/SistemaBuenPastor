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
public class beneficiario extends persona{
    private int id_beneficiario;

    public beneficiario() {
    }

    public beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }

    public beneficiario(int id_beneficiario, int id, String nombre, String apellido, String telefono, String cedula, String direccion, String email, String tipo, Date fecha_nacimiento) {
        super(id, nombre, apellido, telefono, cedula, direccion, email, tipo, fecha_nacimiento);
        this.id_beneficiario = id_beneficiario;
    }

    public int getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }
    
    
}
