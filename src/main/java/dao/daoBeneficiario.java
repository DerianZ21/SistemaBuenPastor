/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import idao.IBeneficiario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.beneficiario;

/**
 *
 * @author Asus
 */
public class daoBeneficiario extends conexion implements IBeneficiario {
    
//METODO LOGICA CONSULTAR
    @Override
    public ArrayList<Object[]> consultarBeneficiario() {
        ArrayList<Object[]> listBeneficiarios = new ArrayList<>();
        try {
            Connection con = this.iniciarConexion();
            String consulta = "SELECT p.cedula, p.nombre, p.apellido, p.tipo, p.direccion, p.email FROM persona p " +
                  "INNER JOIN beneficiario b ON p.id_persona = b.id_persona;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String tipo = rs.getString("tipo");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");

                Object[] row = {cedula, nombre, apellido, tipo, direccion, email};
                listBeneficiarios.add(row);
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR dao beneficiario: " + e.toString());
        }
        return listBeneficiarios;
    }

//METODO LOGICA INSERTAR PADRES
    @Override
    public boolean insertarBeneficiarioPadres(beneficiario bene) {
        boolean personaActualizada = false;
        boolean beneficiarioInsertado = false;
        boolean insertar = false;
        try {
            Connection con = this.iniciarConexion();
            String consultaPersona = "UPDATE public.persona "
                    + "SET nombre = ?, apellido = ?, fecha_nacimiento = ?, telefono = ?, direccion = ?, email = ?, tipo = ? "
                    + "WHERE cedula = ?;";
            PreparedStatement psp = con.prepareStatement(consultaPersona);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(bene.getFecha_nacimiento());
            java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(formattedDate);

            
            psp.setString(1, bene.getNombre());
            psp.setString(2, bene.getApellido());
            psp.setDate(3, fecha_nacimiento);
            psp.setString(4, bene.getTelefono());
            psp.setString(5, bene.getDireccion());
            psp.setString(6, bene.getEmail());
            psp.setString(7, bene.getTipo());
            psp.setString(8, bene.getCedula());

            personaActualizada = psp.executeUpdate() > 0;
            
            psp.close();
            
            int idPersona=-1;
            String consulta = "SELECT id_persona FROM public.persona WHERE cedula = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, bene.getCedula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idPersona = rs.getInt("id_persona");
            }
            ps.close();
            
            if (idPersona != -1) {
                String consultaBeneficiario = "INSERT INTO beneficiario (id_persona) VALUES (?)";
                PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                psb.setInt(1, idPersona);
                beneficiarioInsertado = psb.executeUpdate() > 0;
                psb.close(); 
            }
            
            if (personaActualizada && beneficiarioInsertado) {
                insertar = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertar;
    }
    
    
//METODO LOGICA INSERTAR HIJO
    @Override
    public boolean insertarBeneficiarioHijo(beneficiario bene) {
        boolean insertar = false;
        boolean personaInsertada = false;
        boolean beneficiarioInsertado = false;

        try {
            Connection con = this.iniciarConexion();
            
            //insertar datos en tabla persona
            String consultaPersona = "INSERT INTO public.persona "
                            + "(cedula, nombre, apellido, fecha_nacimiento, telefono, direccion, email, tipo) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement psp = con.prepareStatement(consultaPersona, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(bene.getFecha_nacimiento());
            java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(formattedDate);

            psp.setString(1, bene.getCedula());
            psp.setString(2, bene.getNombre());
            psp.setString(3, bene.getApellido());
            psp.setDate(4, fecha_nacimiento);
            psp.setString(5, bene.getTelefono());
            psp.setString(6, bene.getDireccion());
            psp.setString(7, bene.getEmail());
            psp.setString(8, bene.getTipo());

            personaInsertada = psp.executeUpdate() > 0;

            ResultSet generatedKeys = psp.getGeneratedKeys();
            int idPersonaGenerado = -1;
            if (generatedKeys.next()) {
                idPersonaGenerado = generatedKeys.getInt(1);
            }
            psp.close();
            
            //insertar datos en tabla beneficiario
            if (idPersonaGenerado != -1) {
                String consultaBeneficiario = "INSERT INTO beneficiario (id_persona) VALUES (?)";
                PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                psb.setInt(1, idPersonaGenerado);
                beneficiarioInsertado = psb.executeUpdate() > 0;
                psb.close(); 
            }

            if (personaInsertada && beneficiarioInsertado) {
                insertar = true;
            }

            con.close();
            return insertar;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertar;
    }

    
//METODO LOGICA ELIMINAR
    @Override
    public boolean eliminarBeneficiario(beneficiario bene) {
        boolean eliminar = false;
        try {
            Connection con = this.iniciarConexion();
            String consulta = "DELETE FROM persona where persona.cedula=?;";
            CallableStatement cs = con.prepareCall(consulta);
            cs.setString(1, bene.getCedula());
            
            eliminar = cs.execute();
            cs.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        
        return eliminar;
    }

    
//METODO LOGICA MODIFICAR
    @Override
    public boolean modificarBeneficiario(beneficiario bene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
