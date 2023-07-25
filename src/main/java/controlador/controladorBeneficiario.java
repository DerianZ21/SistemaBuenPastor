/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beneficiario;
import vista.vistaBeneficiarios;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class controladorBeneficiario {
    private final vistaBeneficiarios vistaBeneficiarios;
    
    beneficiario bene = new beneficiario();
    daoBeneficiario dao = new daoBeneficiario();

    public controladorBeneficiario(vistaBeneficiarios vistaBeneficiarios) {
        this.vistaBeneficiarios = vistaBeneficiarios;
    }
    
   
    
//MEDOTO controlador funcion CONSULTAR
    public void consultarBeneficiario(JTable paramTablaBeneficiario) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        try {
            ArrayList<Object[]> listBeneficiario = dao.consultarBeneficiario();
            for (Object[] beneficiario : listBeneficiario) {
                modelo.addRow(beneficiario);
            }
        paramTablaBeneficiario.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaBeneficiarios, "ERROR controlador beneficiario: " + e.toString());
        }
    }
 


    
//MEDOTO controlador funcion ELIMINAR
    public void eliminarBeneficiario() {
        try {
            int filaSeleccionada = vistaBeneficiarios.getTblBeneficiario().getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vistaBeneficiarios, "Por favor, seleccione un usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int indiceCedula = 0; 

                String cedulaTexto = (String) vistaBeneficiarios.getTblBeneficiario().getValueAt(filaSeleccionada, indiceCedula);
           
                    bene.setCedula(cedulaTexto);
                    dao.eliminarBeneficiario(bene);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaBeneficiarios, "ERROR: " + e.toString());
        }
    }
    
}



