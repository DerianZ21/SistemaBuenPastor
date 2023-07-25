/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.beneficiario;
import vista.vistaAgregarBeneficiario;

/**
 *
 * @author Asus
 */
public class controladorAgregarBeneficiario {
    private final vistaAgregarBeneficiario vistaAgregarBeneficiario;
    beneficiario bene = new beneficiario();
    daoBeneficiario dao = new daoBeneficiario();
    
    public controladorAgregarBeneficiario(vistaAgregarBeneficiario vistaAgregarBeneficiario) {
        this.vistaAgregarBeneficiario = vistaAgregarBeneficiario;
    }
    

//METODO controlador funcion INSERTAR
    public void insertarBeneficiario(String tipoElegido){
        
        vistaAgregarBeneficiario.setTxtTipo(tipoElegido);
        String cedula = vistaAgregarBeneficiario.getTxtCedula().getText();
        String nombre = vistaAgregarBeneficiario.getTxtNombre().getText();
        String apellido = vistaAgregarBeneficiario.getTxtApellido().getText();
        Date fechaNacimiento = vistaAgregarBeneficiario.getJdcFechaNacimiento().getDate();
        String telefono = vistaAgregarBeneficiario.getTxtTelefono().getText();
        String direccion = vistaAgregarBeneficiario.getTxtDireccion().getText();
        String email = vistaAgregarBeneficiario.getTxtEmail().getText();
        String tipo = vistaAgregarBeneficiario.getTxtTipo().getText();
        
        try {
            if (cedula.isEmpty()||nombre.isEmpty()||apellido.isEmpty()||fechaNacimiento== null
                ||telefono.isEmpty()||direccion.isEmpty()||email.isEmpty()||tipo.isEmpty()) {
                JOptionPane.showMessageDialog(vistaAgregarBeneficiario, "Por favor llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                
                bene.setCedula(cedula);
                bene.setNombre(nombre);
                bene.setApellido(apellido);
                bene.setFecha_nacimiento(fechaNacimiento);
                bene.setTelefono(telefono);
                bene.setDireccion(direccion);
                bene.setEmail(email);
                bene.setTipo(tipo);
                dao.insertarBeneficiario(bene);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarBeneficiario, "ERROR:"+e.toString());
        }
    }
}
