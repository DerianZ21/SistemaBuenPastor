/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IAsignacionCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.asignacionCurso;

/**
 *
 * @author Asus
 */
public class daoAsignacionCurso extends conexion implements IAsignacionCurso{

    @Override
    public boolean insertarAsignacionCurso(asignacionCurso asigCur) {
        boolean insertar = false;
        String consulta = "INSERT INTO public.asignacion_curso(\n" +
                        " id_beneficiario, id_curso)\n" +
                        " VALUES (?, ?);";
        try {
            Connection con = this.iniciarConexion();
            PreparedStatement psac = con.prepareStatement(consulta);
            
            psac.setInt(1, asigCur.getId_beneficiario());
            psac.setInt(2, asigCur.getId_curso());
            
            insertar = psac.execute();
            
            
            psac.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR insertar curso: " + e.toString());
        }
        return insertar;
    }
    
}
