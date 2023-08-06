/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IAsistencias;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.asistencias;

/**
 *
 * @author Asus
 */
public class daoAsistencias extends conexion implements IAsistencias{

    @Override
    public ArrayList<Object[]> consultarBeneficiarioCurso(int idCurso) {
        ArrayList<Object[]> listBeneficiariosCurso = new ArrayList<>();
        try {
            Connection con = this.iniciarConexion();
            String consulta = "SELECT p. cedula, p.nombre, p.apellido\n" +
                                "FROM persona p\n" +
                                "JOIN beneficiario b ON p.id_persona = b.id_persona\n" +
                                "JOIN asignacion_curso ac ON b.id_beneficiario = ac.id_beneficiario\n" +
                                "WHERE ac.id_curso = ?;";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idCurso); // Coloca el idCurso en el parámetro correspondiente

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre"); 
                String apellido = rs.getString("apellido"); 

                Object[] row = {cedula, nombre, apellido};
                listBeneficiariosCurso.add(row);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return listBeneficiariosCurso;
    }

    @Override
    public boolean insertarAsistencia(asistencias asis) {
        boolean insertar = false;
        
        String consulta = "insert into asistencias (id_asignacion_curso, asistencia, fecha_asistencia)  values(?, ?, ?);";
        try{
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(asis.getFecha());
            java.sql.Date fecha = java.sql.Date.valueOf(formattedDate);
            
            Connection con = this.iniciarConexion();
            CallableStatement cs = con.prepareCall(consulta);
            cs.setInt(1, asis.getId_asignacion_curso());
            cs.setBoolean(2, asis.isAsistencia());
            cs.setDate(3, fecha);
            

            insertar = cs.execute();
            cs.close();
            con.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        return insertar;
    }
}
