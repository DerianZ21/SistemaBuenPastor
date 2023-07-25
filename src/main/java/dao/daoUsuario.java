/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.usuario;


/**
 *
 * @author Asus
 */
public class daoUsuario extends conexion implements IUsuario{
    

//METODO LOGICA CONSULTAR
    @Override
    public ArrayList<Object[]> consultarUsuarios() {
        ArrayList<Object[]> listUsuarios = new ArrayList<>();
        try {
            Connection con = this.iniciarConexion();
            String consulta = "SELECT * FROM usuarios";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");

                Object[] row = {id, nombre, apellido};
                listUsuarios.add(row);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return listUsuarios;
    }

//METODO LOGICA INSERTAR
    @Override
    public boolean insertarUsuario(usuario usu) {
        boolean insertar = false;
        
        String consulta = "insert into usuarios (nombres, apellidos, username, contrasena)  values(?, ?, ?, ?);";
        try{
            Connection con = this.iniciarConexion();
            CallableStatement cs = con.prepareCall(consulta);
            cs.setString(1, usu.getNombre());
            cs.setString(2, usu.getApellido());
            cs.setString(3, usu.getUsername());
            cs.setString(4, usu.getContrasena());

            insertar = cs.execute();
            cs.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        return insertar;
    }

//METODO LOGICA MODIFICAR
    @Override
    public boolean modificarUsuario(usuario usu) {
        boolean modificar = false;
        try{
            Connection con = this.iniciarConexion();
            String consulta = "UPDATE usuarios set nombres = ?, apellidos = ? where id = ?;";
            CallableStatement cs = con.prepareCall(consulta);
            cs.setString(1, usu.getNombre());
            cs.setString(2, usu.getApellido());
            cs.setInt(3, usu.getId());

            modificar=cs.execute();
            cs.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        return modificar;
        
    }
    
    
//METODO LOGICA ELIMINAR
    @Override
    public boolean eliminarUsuario(usuario usu) {
        boolean eliminar = false;
        try {
            Connection con = this.iniciarConexion();
            String consulta = "delete from usuarios where usuarios.id=?;";
            CallableStatement cs = con.prepareCall(consulta);
            cs.setInt(1, usu.getId());
            
            eliminar = cs.execute();
            cs.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        return eliminar;
    }
    
//METODO LOGICA validad usuario ya existente
    public boolean verificarUsuario(String paramUsuario) {
        String consulta = "SELECT * FROM usuarios;";
        try (
            Connection con = this.iniciarConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta)) {

            while (rs.next()) {
                String username = rs.getString("username");

                if (username.equals(paramUsuario)) {
                    return true;
                }
            }
            st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "valio verga:"+e.toString());
        }
        return false; // Si no encontramos un nombre de usuario igual, retornamos false
    }

    
//METODO LOGICA validar inicio de sesion
    public boolean verificarInicioSesion(String paramUsuario, String paramContrasena) {
        String consultaUsuarios = "SELECT * FROM usuarios;";
        try (
            Connection con = this.iniciarConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consultaUsuarios)) {

            while (rs.next()) {
                String username = rs.getString("username");
                String contrasena = rs.getString("contrasena");

                if (username.equals(paramUsuario)&&contrasena.equals(paramContrasena)) {
                    return true;
                }
            }
            st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        return false; // Si no encontramos un nombre de usuario igual, retornamos false
    }
}
