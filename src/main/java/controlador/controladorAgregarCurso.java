/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoCurso;
import javax.swing.JOptionPane;
import modelo.curso;
import vista.vistaAgregarCurso;

/**
 *
 * @author Asus
 */
public class controladorAgregarCurso {
    private final vistaAgregarCurso vistaAgregarCurso;
    curso cu = new curso();
    daoCurso daoCurso = new daoCurso();

    public controladorAgregarCurso(vistaAgregarCurso vistaAgregarCurso) {
        this.vistaAgregarCurso = vistaAgregarCurso;
    }
    
    
    public void insertarCurso() {
    String nombreCurso = vistaAgregarCurso.getTxtNombreCurso().getText();
    String tipoBeneficiario = "";

        
        if (vistaAgregarCurso.getCbxTipoBeneficiario() != null && vistaAgregarCurso.getCbxTipoBeneficiario().getSelectedItem() != null) {
            tipoBeneficiario = vistaAgregarCurso.getCbxTipoBeneficiario().getSelectedItem().toString();
        } else {
            JOptionPane.showMessageDialog(vistaAgregarCurso, "Seleccione un tipo de beneficiario válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (nombreCurso.isEmpty()) {
                JOptionPane.showMessageDialog(vistaAgregarCurso, "Por favor llene el campo de nombre del curso", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                cu.setNombreCurso(nombreCurso);
                cu.setTipoBeneficiario(tipoBeneficiario);
                daoCurso.insertarCurso(cu);
                vistaAgregarCurso.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarCurso, "Error al insertar el curso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
