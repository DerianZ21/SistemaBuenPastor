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
import java.sql.Statement;
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
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR insertar curso: " + e.toString());

        }
        return insertar;
        
    }
    
    
    
}
