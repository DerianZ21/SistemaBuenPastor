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
import modelo.madre;
import modelo.padre;

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
    public boolean insertarBeneficiarioHijo(beneficiario bene, padre pa, madre ma) {
        boolean insertar = false;
        boolean personaBeneficiariaInsertada;
        boolean personaMadreInsertada=false;
        boolean personaPadreInsertada=false;
        boolean MadreInsertada = false;
        boolean PadreInsertado = false;
        boolean RepresentanteGenerado = false;
        boolean beneficiarioInsertado = false;

        int idPersonaPaGenerado = -1;

        try {
            Connection con = this.iniciarConexion();
            //insertar datos en tabla persona de beneficiario
            String consultaPersonaBene = "INSERT INTO public.persona "
                    + "(cedula, nombre, apellido, fecha_nacimiento, telefono, direccion, email, tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pspb = con.prepareStatement(consultaPersonaBene, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(bene.getFecha_nacimiento());
            java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(formattedDate);

            pspb.setString(1, bene.getCedula());
            pspb.setString(2, bene.getNombre());
            pspb.setString(3, bene.getApellido());
            pspb.setDate(4, fecha_nacimiento);
            pspb.setString(5, bene.getTelefono());
            pspb.setString(6, bene.getDireccion());
            pspb.setString(7, bene.getEmail());
            pspb.setString(8, bene.getTipo());

            personaBeneficiariaInsertada = pspb.executeUpdate() > 0;

            ResultSet generatedKeysPersonaBene = pspb.getGeneratedKeys();
            int idPersonaBeneGenerado = -1;
            if (generatedKeysPersonaBene.next()) {
                idPersonaBeneGenerado = generatedKeysPersonaBene.getInt(1);
            }
            pspb.close();

            //insertar datos en tabla persona para madre
            int idMadreGenerado=-1;
            if(!"".equals(ma.getCedula())){
                String consultaPersonaMadre = "insert into persona (cedula, nombre, apellido)  values(?, ?, ?);";
                PreparedStatement pspm = con.prepareStatement(consultaPersonaMadre, Statement.RETURN_GENERATED_KEYS);
                pspm.setString(1, ma.getCedula());
                pspm.setString(2, ma.getNombre());
                pspm.setString(3, ma.getApellido());

                personaMadreInsertada = pspm.executeUpdate() > 0;
                ResultSet generatedKeysPersonaMa = pspm.getGeneratedKeys();
                int idPersonaMaGenerado = -1;
                if (generatedKeysPersonaMa.next()) {
                    idPersonaMaGenerado = generatedKeysPersonaMa.getInt(1);
                }
                pspm.close();

                //insertar id persona en madre
                if (idPersonaMaGenerado != -1) {
                    String consultaMadre = "INSERT INTO madre (id_persona) VALUES (?)";
                    PreparedStatement psm = con.prepareStatement(consultaMadre, Statement.RETURN_GENERATED_KEYS);
                    psm.setInt(1, idPersonaMaGenerado);
                    MadreInsertada = psm.executeUpdate() > 0;

                    ResultSet generatedKeysMadre = psm.getGeneratedKeys();
                    if (generatedKeysMadre.next()) {
                        idMadreGenerado = generatedKeysMadre.getInt(1);
                    }
                    psm.close();
                }
            }
            

            //insertar datos en tabla persona para padre
            Integer idPadreGenerado=-1;
            if(!"".equals(pa.getCedula())){
                String consultaPersonaPadre = "insert into persona (cedula, nombre, apellido)  values(?, ?, ?);";
                PreparedStatement pspp = con.prepareStatement(consultaPersonaPadre, Statement.RETURN_GENERATED_KEYS);
                pspp.setString(1, pa.getCedula());
                pspp.setString(2, pa.getNombre());
                pspp.setString(3, pa.getApellido());

                personaPadreInsertada = pspp.executeUpdate() > 0;
                ResultSet generatedKeysPersonaPa = pspp.getGeneratedKeys();

                if (generatedKeysPersonaPa.next()) {
                    idPersonaPaGenerado = generatedKeysPersonaPa.getInt(1);
                }
                pspp.close();

                //insertar id persona en padre
                if (idPersonaPaGenerado != -1) {
                    String consultaPadre = "INSERT INTO padre (id_persona) VALUES (?)";
                    PreparedStatement psp = con.prepareStatement(consultaPadre, Statement.RETURN_GENERATED_KEYS);
                    psp.setInt(1, idPersonaPaGenerado);
                    PadreInsertado = psp.executeUpdate() > 0;

                    ResultSet generatedKeysPadre = psp.getGeneratedKeys();
                    if (generatedKeysPadre.next()) {
                        idPadreGenerado = generatedKeysPadre.getInt(1);
                    }
                    psp.close();
                }
            }

            //insertar representante
            int idRepresentanteGenerado = -1;
            if(idPadreGenerado != -1&&idMadreGenerado != -1){
                String consultaRepresentante = "insert into representantes (id_padre, id_madre) values (?, ?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, idPadreGenerado);
                psr.setInt(2, idMadreGenerado);

                RepresentanteGenerado = psr.executeUpdate() > 0;

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
                
                if (idPersonaBeneGenerado != -1) {
                    String consultaBeneficiario = "INSERT INTO beneficiario (id_persona, id_representantes) VALUES (?,?)";
                    PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                    psb.setInt(1, idPersonaBeneGenerado);
                    psb.setInt(2, idRepresentanteGenerado);
                    beneficiarioInsertado = psb.executeUpdate() > 0;
                    psb.close();
                }
            }else if (idPadreGenerado != -1 && idMadreGenerado == -1) {
                String consultaRepresentante = "insert into representantes (id_padre) values (?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, idPadreGenerado);
                RepresentanteGenerado = psr.executeUpdate() > 0;

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
                
                if (idPersonaBeneGenerado != -1) {
                    String consultaBeneficiario = "INSERT INTO beneficiario (id_persona, id_representantes) VALUES (?,?)";
                    PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                    psb.setInt(1, idPersonaBeneGenerado);
                    psb.setInt(2, idRepresentanteGenerado);
                    beneficiarioInsertado = psb.executeUpdate() > 0;
                    psb.close();
                }
            }else if(idPadreGenerado == -1 && idMadreGenerado != -1) {
                String consultaRepresentante = "insert into representantes (id_madre) values (?);";
                PreparedStatement psr = con.prepareStatement(consultaRepresentante, Statement.RETURN_GENERATED_KEYS);
                psr.setInt(1, idMadreGenerado);
                RepresentanteGenerado = psr.executeUpdate() > 0;

                ResultSet generatedKeysRepresentante = psr.getGeneratedKeys();
                
                if (generatedKeysRepresentante.next()) {
                    idRepresentanteGenerado = generatedKeysRepresentante.getInt(1);
                }
                psr.close();
                
                if (idPersonaBeneGenerado != -1) {
                    String consultaBeneficiario = "INSERT INTO beneficiario (id_persona, id_representantes) VALUES (?,?)";
                    PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                    psb.setInt(1, idPersonaBeneGenerado);
                    psb.setInt(2, idRepresentanteGenerado);
                    beneficiarioInsertado = psb.executeUpdate() > 0;
                    psb.close();
                }
            }else{
                if (idPersonaBeneGenerado != -1) {
                    String consultaBeneficiario = "INSERT INTO beneficiario (id_persona) VALUES (?)";
                    PreparedStatement psb = con.prepareStatement(consultaBeneficiario);
                    psb.setInt(1, idPersonaBeneGenerado);
                    beneficiarioInsertado = psb.executeUpdate() > 0;
                    psb.close();
                }
            }

            if (personaBeneficiariaInsertada && beneficiarioInsertado || personaPadreInsertada||personaMadreInsertada
                    ||MadreInsertada||PadreInsertado||RepresentanteGenerado) {
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
    
//METODO LOGICA validad Cedula ya existente
    public boolean verificarCedula(String paramCedula) {
        String consulta = "SELECT * FROM persona;";
        try (
            Connection con = this.iniciarConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta)) {

            while (rs.next()) {
                String username = rs.getString("cedula");

                if (username.equals(paramCedula)) {
                    return true;
                }
            }
            st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error dao beneficiario validacion de Cedula:"+e.toString());
        }
        return false;
    }
}
