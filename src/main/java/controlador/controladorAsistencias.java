/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.toedter.calendar.JDateChooser;
import dao.daoAsignacionCurso;
import dao.daoAsistencias;
import dao.daoBeneficiario;
import dao.daoCurso;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.asistencias;
import modelo.curso;
import vista.vistaRegistroAsistencias;

/**
 *
 * @author Asus
 */
public class controladorAsistencias {
    private final vistaRegistroAsistencias vistaRegistroAsistencias;
    
    daoAsistencias daoAsistencias = new daoAsistencias();
    daoAsignacionCurso daoAsignacionCurso = new daoAsignacionCurso();
    daoBeneficiario daoBeneficiario = new daoBeneficiario();
    daoCurso daoCurso = new daoCurso();
    curso cursos= new curso();

    public controladorAsistencias(vistaRegistroAsistencias vistaRegistroAsistencias) {
        this.vistaRegistroAsistencias = vistaRegistroAsistencias;
    }
    
 //MEDOTO controlador funcion CONSULTAR
    public void consultarBeneficiario(JTable paramTablaBeneficiarioCurso) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
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
            
            Object[] row = {"", "Dar clic al final", ""};
            modelo.addRow(row);
            

            paramTablaBeneficiarioCurso.setModel(modelo);

            for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.setValueAt(false, i, 3);
            }

            // Asignar el editor de celda personalizado a la columna de asistencia (columna 2)
            paramTablaBeneficiarioCurso.getColumnModel().getColumn(3).setCellRenderer(new CheckBoxTableCellRenderer());
            paramTablaBeneficiarioCurso.getColumnModel().getColumn(3).setCellEditor(new CheckBoxTableCellEditor());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaRegistroAsistencias, "ERROR controlador beneficiario: " + e.toString());
        }
    }

    
    public void llenarCbxCursoFecha() {
        ArrayList<Object[]> listaCursos = daoCurso.consultarCursos(); 
        
        JComboBox<curso> comboBoxCursos = vistaRegistroAsistencias.getCbxCursos();
        comboBoxCursos.removeAllItems();

        for (Object[] cursoData : listaCursos) {
            int idCurso = (int) cursoData[0];
            String nombreCurso = (String) cursoData[1];
            curso cu = new curso(idCurso, nombreCurso);
            comboBoxCursos.addItem(cu);
        }
        
        Date fechaActual = new Date();
        
        JDateChooser dateChooser = vistaRegistroAsistencias.getDtcFechaActual();

        dateChooser.setDate(fechaActual);

        dateChooser.setEnabled(false);
    }
    
    public void insertarAsistencias() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas insertar las asistencias?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Date fecha = vistaRegistroAsistencias.getDtcFechaActual().getDate();
            DefaultTableModel modeloTabla = (DefaultTableModel) vistaRegistroAsistencias.getTblBeneficiariosCurso().getModel();

            int rowCount = modeloTabla.getRowCount();
            System.out.println(rowCount);
            int i = 0;
            while (i < rowCount-1) {
                String cedula = (String) modeloTabla.getValueAt(i, 0);
                Boolean asistenciaBoolean = (Boolean) modeloTabla.getValueAt(i, 3);
                boolean asistencia = asistenciaBoolean != null ? asistenciaBoolean : false;

                
                
                System.out.println("Cedula: " + cedula + ", Asistencia: " + asistencia); 

                asistencias asis = new asistencias();
                asis.setFecha(fecha);
                asis.setAsistencia(asistencia);
                asis.setId_asignacion_curso(daoAsignacionCurso.colsultarIdAsignacionCurso(daoBeneficiario.obtenerIdBeneficiario(cedula)));
                daoAsistencias.insertarAsistencia(asis);
                i++;
            }
            vistaRegistroAsistencias.dispose();
        } else {
            // El usuario canceló la acción, no se realiza el método
            System.out.println("Inserción de asistencias cancelada.");
        }
    }     
}
