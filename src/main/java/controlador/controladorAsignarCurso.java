/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoAsignacionCurso;
import javax.swing.JOptionPane;
import modelo.asignacionCurso;
import vista.vistaAsignarCurso;

/**
 *
 * @author Asus
 */
public class controladorAsignarCurso {
    
    private final vistaAsignarCurso vistaAsignarCurso;
    asignacionCurso asigcu = new asignacionCurso();
    daoAsignacionCurso daoAsignacionCurso = new daoAsignacionCurso();

    public controladorAsignarCurso(vistaAsignarCurso vistaAsignarCurso) {
        this.vistaAsignarCurso = vistaAsignarCurso;
    }
    
    //metodo insertar asignacion de curso
    public void insertarAsignacionCurso() {
        int idCurso = vistaAsignarCurso.SeleccionarCurso();
        int idBeneficiario = Integer.parseInt(vistaAsignarCurso.getTxtIdBeneficiario().getText());

        int confirmacion = JOptionPane.showConfirmDialog(
                vistaAsignarCurso,
                "¿Estás seguro de que deseas asignar este curso al beneficiario?",
                "Confirmar Asignación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (daoAsignacionCurso.verificarAsignacionCursoExistente(idBeneficiario, idCurso)) {
                JOptionPane.showMessageDialog(vistaAsignarCurso, "El beneficiario ya está asignado a ese curso");
            } else {
                asigcu.setId_beneficiario(idBeneficiario);
                asigcu.setId_curso(idCurso);
                vistaAsignarCurso.setVisible(false);
                vistaAsignarCurso.notifyObservers();
                daoAsignacionCurso.insertarAsignacionCurso(asigcu);
                JOptionPane.showMessageDialog(vistaAsignarCurso, "Se asignó el nuevo curso");
                    
                
            }
        }
    }
}
