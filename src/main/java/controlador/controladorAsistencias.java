/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoAsistencias;
import dao.daoCurso;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.curso;
import vista.vistaRegistroAsistencias;

/**
 *
 * @author Asus
 */
public class controladorAsistencias {
    private final vistaRegistroAsistencias vistaRegistroAsistencias;
    
    daoAsistencias daoAsistencias = new daoAsistencias();
    daoCurso daoCurso = new daoCurso();
    curso cursos= new curso();

    public controladorAsistencias(vistaRegistroAsistencias vistaRegistroAsistencias) {
        this.vistaRegistroAsistencias = vistaRegistroAsistencias;
    }
    
 //MEDOTO controlador funcion CONSULTAR
    public void consultarBeneficiario(JTable paramTablaBeneficiarioCurso) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Asistencia");

        try {
            int idCursoSeleccionado = vistaRegistroAsistencias.getCbxCursos().getItemAt(vistaRegistroAsistencias.getCbxCursos().getSelectedIndex()).getIdCurso();
            ArrayList<Object[]> listBeneficiario = daoAsistencias.consultarBeneficiarioCurso(idCursoSeleccionado);

            if (listBeneficiario != null && !listBeneficiario.isEmpty()) {
                for (Object[] beneficiario : listBeneficiario) {
                    modelo.addRow(beneficiario);
                }
            }
            paramTablaBeneficiarioCurso.setModel(modelo);

            paramTablaBeneficiarioCurso.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaRegistroAsistencias, "ERROR controlador beneficiario: " + e.toString());
        }
    }

    
    public void llenarCbxCurso() {
        ArrayList<Object[]> listaCursos = daoCurso.consultarCursos(); 
        
        JComboBox<curso> comboBoxCursos = vistaRegistroAsistencias.getCbxCursos();
        comboBoxCursos.removeAllItems();

        for (Object[] cursoData : listaCursos) {
            int idCurso = (int) cursoData[0];
            String nombreCurso = (String) cursoData[1];
            curso cu = new curso(idCurso, nombreCurso);
            comboBoxCursos.addItem(cu);
        }
    }
            
            
}
