/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.ICurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.curso;

/**
 *
 * @author Asus
 */
public class daoCurso extends conexion implements ICurso{

    @Override
    public boolean insertarCurso(curso cu) {
        boolean insertar = false;
        String consulta = "INSERT INTO curso(\n" +
                        " nombre_curso, tipo_beneficiario)\n" +
                        " VALUES (?, ?);";
        try {
            Connection con = this.iniciarConexion();
            PreparedStatement psc = con.prepareStatement(consulta);
            
            psc.setString(1, cu.getNombreCurso());
            psc.setString(2, cu.getTipoBeneficiario());
            
            insertar = psc.execute();
            
            
            psc.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR insertar curso: " + e.toString());
        }
        return insertar;
    }

    @Override
    public ArrayList<Object[]> consultarCursos(String tipoBeneficiario) {
        ArrayList<Object[]> listCursos = new ArrayList<>();
        
        String consultaTipoHijo = "SELECT id_curso, nombre_curso FROM curso where tipo_beneficiario = 'Hijo';";
        String consultaTipoRepresentante = "SELECT id_curso, nombre_curso FROM curso where tipo_beneficiario = 'Representante';";
        try {
            Connection con = this.iniciarConexion();
            
            if("Hijo".equals(tipoBeneficiario)){
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(consultaTipoHijo);

                while (rs.next()) {
                    int idCurso = rs.getInt("id_curso");
                    String nombreCurso = rs.getString("nombre_curso");

                    Object[] row = {idCurso,nombreCurso};
                    listCursos.add(row);
                }
                rs.close();
                st.close();
            }else{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(consultaTipoRepresentante);

                while (rs.next()) {
                    int idCurso = rs.getInt("id_curso");
                    String nombreCurso = rs.getString("nombre_curso");

                    Object[] row = {idCurso,nombreCurso};
                    listCursos.add(row);
                }
                rs.close();
                st.close();
            }
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return listCursos;
    }

    @Override
    public ArrayList<Object[]> consultarCursos() {
        ArrayList<Object[]> listCurso = new ArrayList<>();
        try {
            Connection con = this.iniciarConexion();
            String consulta = "SELECT * FROM curso";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                String nombreCurso = rs.getString("nombre_curso");
                int idCurso = rs.getInt("id_curso");

                Object[] row = {idCurso, nombreCurso};
                listCurso.add(row);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return listCurso;
    }
    
    
    
}
