/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import modelo.beneficiario;
import vista.vistaModificarBeneficiario;

/**
 *
 * @author Asus
 */
public class controladorModificarBeneficiario {
    
    private final vistaModificarBeneficiario vistaModificarBeneficiario;
    beneficiario bene = new beneficiario();
    daoBeneficiario daoBeneficiario = new daoBeneficiario();

    public controladorModificarBeneficiario(vistaModificarBeneficiario vistaModificarBeneficiario) {
        this.vistaModificarBeneficiario = vistaModificarBeneficiario;
    }
    
    
    
    public void modificarBeneficiario(String cedulaActual){
        String cedulaBeneficiario = cedulaActual;
        String cedula = vistaModificarBeneficiario.getTxtCedula().getText();
        String nombre = vistaModificarBeneficiario.getTxtNombre().getText();
        String apellido = vistaModificarBeneficiario.getTxtApellido().getText();
        String telefono = vistaModificarBeneficiario.getTxtTelefono().getText();
        String direccion = vistaModificarBeneficiario.getTxtDireccion().getText();
        String email = vistaModificarBeneficiario.getTxtEmail().getName();
        
        
        bene.setCedula(cedula);
        bene.setNombre(nombre);
        bene.setApellido(apellido);
        bene.setTelefono(telefono);
        bene.setDireccion(direccion);
        bene.setEmail(email);
        
        daoBeneficiario.modificarBeneficiario(bene, cedulaBeneficiario);
    }
    
}
