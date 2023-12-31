/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import javax.swing.JOptionPane;
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

//METODO modificar beneficiario
    public boolean modificarBeneficiario(String cedulaActual) {
        boolean modificado = false;
        try {
            String cedulaBeneficiario = cedulaActual;
            String cedula = vistaModificarBeneficiario.getTxtCedula().getText();
            String nombre = vistaModificarBeneficiario.getTxtNombre().getText();
            String apellido = vistaModificarBeneficiario.getTxtApellido().getText();
            String telefono = vistaModificarBeneficiario.getTxtTelefono().getText();
            String direccion = vistaModificarBeneficiario.getTxtDireccion().getText();
            String email = vistaModificarBeneficiario.getTxtEmail().getText();

            bene.setCedula(cedula);
            bene.setNombre(nombre);
            bene.setApellido(apellido);
            bene.setTelefono(telefono);
            bene.setDireccion(direccion);
            bene.setEmail(email);

            int confirmacion = JOptionPane.showConfirmDialog(vistaModificarBeneficiario,
                    "¿Estás seguro de que deseas modificar al beneficiario?", "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                daoBeneficiario.modificarBeneficiario(bene, cedulaBeneficiario);
                modificado = true;
                JOptionPane.showMessageDialog(vistaModificarBeneficiario,
                        "El beneficiario ha sido modificado correctamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                vistaModificarBeneficiario.notifyObservers();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaModificarBeneficiario,
                    "ERROR controlador modificarbeneficiario: " + e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return modificado;
    }
}
