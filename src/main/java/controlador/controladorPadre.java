/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoPadre;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.vistaAgregarBeneficiario;

/**
 *
 * @author Asus
 */
public class controladorPadre {
    private final vistaAgregarBeneficiario vistaAgregarBeneficiario;
    daoPadre dao = new daoPadre();

    public controladorPadre(vistaAgregarBeneficiario vistaAgregarBeneficiario) {
        this.vistaAgregarBeneficiario = vistaAgregarBeneficiario;
    }
    
    //MEDOTO controlador funcion CONSULTAR
    public void consultarPadres(JTable paramTabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try {
            ArrayList<Object[]> listPadres = dao.consultarPadres();
            for (Object[] madre : listPadres) {
                modelo.addRow(madre);
            }
        paramTabla.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarBeneficiario, "ERROR en controlador madre: " + e.toString());
        }
    }
}
