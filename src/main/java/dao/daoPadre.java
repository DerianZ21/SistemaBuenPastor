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
            
            // Obtener la lista de id_persona de la tabla beneficiarios
            String consultaBeneficiarios = "SELECT id_persona FROM beneficiario;";
            Statement stb = con.createStatement();
            ResultSet rsb = stb.executeQuery(consultaBeneficiarios);
            ArrayList<String> idBeneficiarios = new ArrayList<>();
            while (rsb.next()) {
                int idPersona = rsb.getInt("id_persona");
                idBeneficiarios.add(String.valueOf(idPersona)); // Convertir a cadena antes de agregar a la lista
            }
            rsb.close();
            stb.close();

            // Consulta para obtener las madres que no están en la tabla beneficiarios
            String consulta = "SELECT p.cedula, p.nombre, p.apellido FROM persona p " +
                  "INNER JOIN padre m ON p.id_persona = m.id_persona " +
                  "WHERE p.id_persona NOT IN (" + String.join(",", idBeneficiarios) + ");";

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
    public boolean insertarBeneficiarioPadre(padre pa) {
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
            generatedKeys.close();
            ps.close();
            
            //insertar id persona en madre
            if (idPersonaGenerado != -1) {
                String consultaPadre = "INSERT INTO padre (id_persona) VALUES (?)";
                PreparedStatement pspa = con.prepareStatement(consultaPadre);
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

    @Override
    public int insertarPadre(padre pa) {
        Integer idPadreGenerado=-1;
        try{
            Connection con = this.iniciarConexion();
            if(!"".equals(pa.getCedula())){
                String consultaPersonaPadre = "insert into persona (cedula, nombre, apellido)  values(?, ?, ?);";
                PreparedStatement pspp = con.prepareStatement(consultaPersonaPadre, Statement.RETURN_GENERATED_KEYS);
                pspp.setString(1, pa.getCedula());
                pspp.setString(2, pa.getNombre());
                pspp.setString(3, pa.getApellido());

                pspp.execute();
                ResultSet generatedKeysPersonaPa = pspp.getGeneratedKeys();
                int idPersonaPaGenerado = -1;
                if (generatedKeysPersonaPa.next()) {
                    idPersonaPaGenerado = generatedKeysPersonaPa.getInt(1);
                }
                generatedKeysPersonaPa.close();
                pspp.close();

                //insertar id persona en padre
                if (idPersonaPaGenerado != -1) {
                    String consultaPadre = "INSERT INTO padre (id_persona) VALUES (?)";
                    PreparedStatement psp = con.prepareStatement(consultaPadre, Statement.RETURN_GENERATED_KEYS);
                    psp.setInt(1, idPersonaPaGenerado);
                    psp.execute();

                    ResultSet generatedKeysPadre = psp.getGeneratedKeys();
                    if (generatedKeysPadre.next()) {
                        idPadreGenerado = generatedKeysPadre.getInt(1);
                    }
                    generatedKeysPadre.close();
                    psp.close();
                }
            }
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());       
        }
        return idPadreGenerado;
    }
}
