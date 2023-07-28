/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IRepresentantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class daoRepresentantes extends conexion implements IRepresentantes {

    @Override
    public int insertarRepresentantes(int pa, int ma) {
        int idRepresentanteGenerado = -1;
        try{
            Connection con = this.iniciarConexion();
            if(pa != -1&& ma != -1){
                String consultaRepresentante = "insert into representantes (id_padre, id_madre) values (?, ?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, pa);
                psr.setInt(2, ma);

                psr.execute();

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
                
            }else if (pa != -1 && ma == -1) {
                String consultaRepresentante = "insert into representantes (id_padre) values (?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, pa);
                psr.execute();

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
                
            }else if(pa == -1 && ma != -1) {
                String consultaRepresentante = "insert into representantes (id_madre) values (?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, ma);
                psr.execute();

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
            }
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());

        }
        return idRepresentanteGenerado;
    }
    
    public boolean veficarRepresentantes(String cedPadre, String cedMadre) {
        boolean padreExiste=false;
        boolean madreExiste=false;
        
        String consultaPadre = "SELECT p.cedula\n"
                + "FROM persona p JOIN padre pa ON p.id_persona = pa.id_persona;";

        String consultaMadre = "SELECT p.cedula\n"
                + "FROM persona p JOIN madre pa ON p.id_persona = pa.id_persona;";

        try {
            Connection con = this.iniciarConexion();

            // validar existencia de la cedula del padre y madre
            if (!"".equals(cedPadre)&&!"".equals(cedMadre)) {
                Statement stp = con.createStatement();
                ResultSet rsp = stp.executeQuery(consultaPadre);

                while (rsp.next()) {
                    String cedulaPadre = rsp.getString("cedula");
                    if (cedulaPadre.equals(cedPadre)) {
                        padreExiste = true;
                    }
                }
                
                Statement stm = con.createStatement();
                ResultSet rsm = stm.executeQuery(consultaMadre);

                while (rsm.next()) {
                    String cedulaMadre = rsm.getString("cedula");
                    if (cedulaMadre.equals(cedMadre)) {
                        madreExiste = true;
                    }
                }
                return madreExiste && padreExiste;
            }
            //validar existencia solo de la cedula de la madre 
            else if (!"".equals(cedMadre)&&"".equals(cedPadre)) {
                Statement stm = con.createStatement();
                ResultSet rsm = stm.executeQuery(consultaMadre);

                while (rsm.next()) {
                    String cedulaMadre = rsm.getString("cedula");
                    if (cedulaMadre.equals(cedMadre)) {
                        madreExiste = true;
                    }
                }
                return madreExiste;
            }
            //validar existencia solo de la cedula del padre
            else if ("".equals(cedMadre)&&"".equals(cedPadre)) {
                Statement stp = con.createStatement();
                ResultSet rsp = stp.executeQuery(consultaPadre);

                while (rsp.next()) {
                    String cedulaPadre = rsp.getString("cedula");
                    if (cedulaPadre.equals(cedPadre)) {
                        padreExiste = true;
                    }
                }
                return padreExiste;
            }
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error dao beneficiario validacion de Representantes:" + e.toString());

        }
        return false;
    }
    
    public int obtenerRepresentante(String cedPadre, String cedMadre){
        int idPadre = -1;
        int idMadre = -1;
        int idRepresentante=-1;
        String consultaIdPadre = "SELECT pa.id_padre FROM persona p "
                + "JOIN padre pa ON p.id_persona = pa.id_persona "
                + "WHERE p.cedula = ?;";
        
        String consultaIdMadre = "SELECT ma.id_madre FROM persona p "
                + "JOIN madre ma ON p.id_persona = ma.id_persona "
                + "WHERE p.cedula = ?;";
        
        String consultaIdRepresentantes  = "SELECT id_representantes "
                + "FROM representantes "
                + "WHERE id_padre = ? OR id_madre = ?;";
        
         try {
             Connection con = this.iniciarConexion();
            //obtener el id padre
            if(!"".equals(cedPadre)){
                PreparedStatement psp = con.prepareStatement(consultaIdPadre);
                psp.setString(1, cedPadre);
                ResultSet rsp = psp.executeQuery();

                if (rsp.next()) {
                    idPadre = rsp.getInt("id_padre");
                }
            }
            
            if(!"".equals(cedMadre)){
                PreparedStatement psm = con.prepareStatement(consultaIdMadre);
                psm.setString(1, cedMadre);
                ResultSet rsm = psm.executeQuery();

                if (rsm.next()) {
                    idMadre = rsm.getInt("id_madre");
                }
            }
            
            if(idMadre>0 && idPadre>0){
               PreparedStatement psr = con.prepareStatement(consultaIdRepresentantes);
                psr.setInt(1, idPadre);
                psr.setInt(2, idMadre);
                ResultSet rsr = psr.executeQuery();

                if(rsr.next()){
                    idRepresentante = rsr.getInt("id_representantes");
                } 
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idRepresentante;
    }
}
