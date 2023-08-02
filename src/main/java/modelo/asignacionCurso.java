/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Asus
 */
public class asignacionCurso {
    
    private int id_curso, id_beneficiario;

    public asignacionCurso() {
    }

    public asignacionCurso(int id_curso, int id_beneficiario) {
        this.id_curso = id_curso;
        this.id_beneficiario = id_beneficiario;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }
    
}
