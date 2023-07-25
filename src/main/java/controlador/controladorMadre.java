/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoMadre;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.vistaAgregarBeneficiario;

/**
 *
 * @author Asus
 */
public class controladorMadre {
    
    private final vistaAgregarBeneficiario vistaAgregarBeneficiario;
    daoMadre dao = new daoMadre();

    public controladorMadre(vistaAgregarBeneficiario vistaAgregarBeneficiario) {
        this.vistaAgregarBeneficiario = vistaAgregarBeneficiario;
    }

    
    
    
//MEDOTO controlador funcion CONSULTAR
    public void consultarMadres(JTable paramTabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try {
            ArrayList<Object[]> listMadres = dao.consultarMadres();
            for (Object[] madre : listMadres) {
                modelo.addRow(madre);
            }
        paramTabla.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarBeneficiario, "ERROR en controlador madre: " + e.toString());
        }
    }
}
