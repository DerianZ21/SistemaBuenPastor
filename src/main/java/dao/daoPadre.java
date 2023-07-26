/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IPadre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.padre;

/**
 *
 * @author Asus
 */
public class daoPadre extends conexion implements IPadre{

    
    @Override
    public ArrayList<Object[]> consultarPadres() {
        ArrayList<Object[]> listPadres = new ArrayList<>();
        try {
            
            Connection con = this.iniciarConexion();
            String consulta = "SELECT p.cedula, p.nombre, p.apellido FROM persona p " +
                  "INNER JOIN padre pa ON p.id_persona = pa.id_persona;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                Object[] row = {cedula, nombre, apellido};
                listPadres.add(row);
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR dao beneficiario: " + e.toString());
        }
        return listPadres;
    }

    @Override
    public boolean insertarPadre(padre pa) {
        boolean insertar = false;
        boolean personaInsertada = false;
        boolean padreInsertado = false;
        
        try{
            //insertar persona
            String consulta = "insert into persona (cedula, nombre, apellido)  values(?, ?, ?);";
            Connection con = this.iniciarConexion();
            PreparedStatement ps = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pa.getCedula());
            ps.setString(2, pa.getNombre());
            ps.setString(3, pa.getApellido());
            
            personaInsertada = ps.executeUpdate() > 0;
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idPersonaGenerado = -1;
            if (generatedKeys.next()) {
                idPersonaGenerado = generatedKeys.getInt(1);
            }
            ps.close();
            
            //insertar id persona en madre
            if (idPersonaGenerado != -1) {
                String consultaMadre = "INSERT INTO padre (id_persona) VALUES (?)";
                PreparedStatement pspa = con.prepareStatement(consultaMadre);
                pspa.setInt(1, idPersonaGenerado);
                padreInsertado = pspa.executeUpdate() > 0;
                pspa.close(); 
            }

            if (personaInsertada &&  padreInsertado) {
                insertar = true;
            }
            
            con.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR error dao madre inserta madre:"+e.toString());
        }
        return insertar;
    }
}
