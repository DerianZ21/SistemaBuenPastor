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
import java.sql.ResultSet;
import java.sql.Statement;
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
    
//METODO LOGICA validar si existe ya esa asignación
    public boolean verificarAsignacionCursoExistente(int paraIdBeneficiario, int paramIdCurso) {
        String consultaAsignacionCurso = "SELECT * FROM asignacion_curso;";
        try (
            Connection con = this.iniciarConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consultaAsignacionCurso)) {

            while (rs.next()) {
                int idBeneficiario = rs.getInt("id_beneficiario");
                int idCurso = rs.getInt("id_curso");

                if (idBeneficiario == paraIdBeneficiario && idCurso == paramIdCurso) {
                    return true;
                }
            }
            st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }
        return false; // Si no encontramos una asignación de curso igual, retornamos false
    }
    
}
