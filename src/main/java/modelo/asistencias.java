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
public class asistencias {
    
    private int id_asistencias, id_asignacion_curso;
    private boolean asistencia;
    private Date fecha;

    public asistencias() {
    }

    public asistencias(int id_asistencias, int id_asignacion_curso, boolean asistencia, Date fecha) {
        this.id_asistencias = id_asistencias;
        this.id_asignacion_curso = id_asignacion_curso;
        this.asistencia = asistencia;
        this.fecha = fecha;
    }

    public int getId_asistencias() {
        return id_asistencias;
    }

    public void setId_asistencias(int id_asistencias) {
        this.id_asistencias = id_asistencias;
    }

    public int getId_asignacion_curso() {
        return id_asignacion_curso;
    }

    public void setId_asignacion_curso(int id_asignacion_curso) {
        this.id_asignacion_curso = id_asignacion_curso;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
