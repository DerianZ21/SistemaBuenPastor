/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IAsistencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.curso;

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
            String consulta = "SELECT p.nombre, p.apellido\n" +
                                "FROM persona p\n" +
                                "JOIN beneficiario b ON p.id_persona = b.id_persona\n" +
                                "JOIN asignacion_curso ac ON b.id_beneficiario = ac.id_beneficiario\n" +
                                "WHERE ac.id_curso = ?;";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idCurso); // Coloca el idCurso en el parámetro correspondiente

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre"); // Cambia "nombres" por "nombre"
                String apellido = rs.getString("apellido"); // Cambia "apellidos" por "apellido"

                Object[] row = {nombre, apellido};
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
}
