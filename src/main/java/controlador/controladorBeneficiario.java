/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.beneficiario;
import vista.vistaBeneficiarios;

/**
 *
 * @author Asus
 */
public class controladorBeneficiario {

    private final vistaBeneficiarios vistaBeneficiarios;
    beneficiario bene = new beneficiario();
    daoBeneficiario daoBeneficiario = new daoBeneficiario();

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
            ArrayList<Object[]> listBeneficiario = daoBeneficiario.consultarBeneficiario();
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
        boolean eliminado= false;
        try {
            String cedulaTexto = vistaBeneficiarios.seleccionarCedula();
            
            if(!"".equals(cedulaTexto)){
                eliminado = daoBeneficiario.eliminarBeneficiario(cedulaTexto);
                
                if(eliminado){
                    JOptionPane.showMessageDialog(vistaBeneficiarios, "Se eliminó correctamente");
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaBeneficiarios, "ERROR: " + e.toString());
        }
    }
 
//metodo para llenar los campos en la vista modificar beneficiario
    public void llenarCamposModificar(JTextField cedula, JTextField nombre, JTextField apellido, JTextField telefono, JTextField direccion, JTextField email) {
        
        String cedulaActual = vistaBeneficiarios.seleccionarCedula();
        if(!"".equals(cedulaActual)){
            List<Object[]> datos = daoBeneficiario.obtenerDatos(cedulaActual);

            Object[] primeraFila = datos.get(0);
            cedula.setText((String) primeraFila[0]);
            nombre.setText((String) primeraFila[1]);
            apellido.setText((String) primeraFila[2]);
            telefono.setText((String) primeraFila[3]);
            direccion.setText((String) primeraFila[4]);
            email.setText((String) primeraFila[5]);
        }
    }
}
