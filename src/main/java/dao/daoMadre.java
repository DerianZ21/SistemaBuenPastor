/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IMadre;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.madre;

/**
 *
 * @author Asus
 */
public class daoMadre extends conexion implements IMadre{

    
    @Override
    public ArrayList<Object[]> consultarMadres() {
        ArrayList<Object[]> listMadres = new ArrayList<>();
        try {
            Connection con = this.iniciarConexion();
            String consulta = "SELECT p.cedula, p.nombre, p.apellido FROM persona p " +
                  "INNER JOIN madre m ON p.id_persona = m.id_persona;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                Object[] row = {cedula, nombre, apellido};
                listMadres.add(row);
                
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR dao madre: " + e.toString());
        }
        return listMadres;
    }

    @Override
    public boolean insertarMadre(madre ma) {
        boolean insertar = false;
        boolean personaInsertada = false;
        boolean madreInsertada = false;

        
        try{
            //insertar persona
            String consulta = "insert into persona (cedula, nombre, apellido)  values(?, ?, ?);";
            Connection con = this.iniciarConexion();
            PreparedStatement ps = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ma.getCedula());
            ps.setString(2, ma.getNombre());
            ps.setString(3, ma.getApellido());
            
            personaInsertada = ps.executeUpdate() > 0;
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idPersonaGenerado = -1;
            if (generatedKeys.next()) {
                idPersonaGenerado = generatedKeys.getInt(1);
            }
            ps.close();
            
            //insertar id persona en madre
            if (idPersonaGenerado != -1) {
                String consultaMadre = "INSERT INTO madre (id_persona) VALUES (?)";
                PreparedStatement psm = con.prepareStatement(consultaMadre);
                psm.setInt(1, idPersonaGenerado);
                madreInsertada = psm.executeUpdate() > 0;
                psm.close(); 
            }

            if (personaInsertada &&  madreInsertada) {
                insertar = true;
            }
            
            con.close();
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR error dao madre inserta madre:"+e.toString());
        }
        return insertar;
    }
    
}
