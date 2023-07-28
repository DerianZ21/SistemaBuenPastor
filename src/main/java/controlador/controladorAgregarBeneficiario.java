/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoBeneficiario;
import dao.daoMadre;
import dao.daoPadre;
import dao.daoRepresentantes;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.beneficiario;
import modelo.madre;
import modelo.padre;
import vista.vistaAgregarBeneficiario;

/**
 *
 * @author Asus
 */
public class controladorAgregarBeneficiario {

    private final vistaAgregarBeneficiario vistaAgregarModificarBeneficiario;
    beneficiario bene = new beneficiario();
    madre ma = new madre();
    padre pa = new padre();
    daoBeneficiario daoBeneficiario = new daoBeneficiario();
    daoMadre daoMadre = new daoMadre();
    daoPadre daoPadre = new daoPadre();
    daoRepresentantes daoRepresentantes = new daoRepresentantes();

    public controladorAgregarBeneficiario(vistaAgregarBeneficiario vistaAgregarBeneficiario) {
        this.vistaAgregarModificarBeneficiario = vistaAgregarBeneficiario;
    }

//MEDOTO controlador funcion CONSULTAR
    public void consultarMadres(JTable paramTabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try {
            ArrayList<Object[]> listMadres = daoMadre.consultarMadres();
            for (Object[] madre : listMadres) {
                modelo.addRow(madre);
            }
            paramTabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "ERROR en controlador madre: " + e.toString());
        }
    }

//MEDOTO controlador funcion CONSULTAR
    public void consultarPadres(JTable paramTabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try {
            ArrayList<Object[]> listPadres = daoPadre.consultarPadres();
            listPadres.forEach((padres) -> {
                modelo.addRow(padres);
            });
            paramTabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "ERROR en controlador madre: " + e.toString());
        }
    }

//METODO controlador funcion INSERTAR PADRES
    public void insertarBeneficiarioPadres() {
        String cedula = vistaAgregarModificarBeneficiario.getTxtCedula().getText();
        String nombre = vistaAgregarModificarBeneficiario.getTxtNombre().getText();
        String apellido = vistaAgregarModificarBeneficiario.getTxtApellido().getText();
        Date fechaNacimiento = vistaAgregarModificarBeneficiario.getJdcFechaNacimiento().getDate();
        String telefono = vistaAgregarModificarBeneficiario.getTxtTelefono().getText();
        String direccion = vistaAgregarModificarBeneficiario.getTxtDireccion().getText();
        String email = vistaAgregarModificarBeneficiario.getTxtEmail().getText();
        String tipo = vistaAgregarModificarBeneficiario.getTxtTipo().getText();

        try {
            if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento == null
                    || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "Por favor llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(daoBeneficiario.verificarCedula(cedula)){
                JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "La cedula que usted ingresó ya existe, verifique su inforamción", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                bene.setCedula(cedula);
                bene.setNombre(nombre);
                bene.setApellido(apellido);
                bene.setFecha_nacimiento(fechaNacimiento);
                bene.setTelefono(telefono);
                bene.setDireccion(direccion);
                bene.setEmail(email);
                bene.setTipo(tipo);

                daoBeneficiario.insertarBeneficiarioPadres(bene);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "ERROR:" + e.toString());
        }
    }

// METODO controlador funcion INSERTAR hijo
    public void insertarBeneficiariohijo() {
        boolean insertado;
        String cedula = vistaAgregarModificarBeneficiario.getTxtCedula().getText();
        String nombre = vistaAgregarModificarBeneficiario.getTxtNombre().getText();
        String apellido = vistaAgregarModificarBeneficiario.getTxtApellido().getText();
        Date fechaNacimiento = vistaAgregarModificarBeneficiario.getJdcFechaNacimiento().getDate();
        String telefono = vistaAgregarModificarBeneficiario.getTxtTelefono().getText();
        String direccion = vistaAgregarModificarBeneficiario.getTxtDireccion().getText();
        String email = vistaAgregarModificarBeneficiario.getTxtEmail().getText();
        String tipo = vistaAgregarModificarBeneficiario.getTxtTipo().getText();
        String cedulaMadre = vistaAgregarModificarBeneficiario.getTxtCedulaMadre().getText();
        String nombreMadre = vistaAgregarModificarBeneficiario.getTxtNombreMadre().getText();
        String apellidoMadre = vistaAgregarModificarBeneficiario.getTxtApellidoMadre().getText();
        String cedulaPadre = vistaAgregarModificarBeneficiario.getTxtCedulaPadre().getText();
        String nombrePadre = vistaAgregarModificarBeneficiario.getTxtNombrePadre().getText();
        String apellidoPadre = vistaAgregarModificarBeneficiario.getTxtApellidoPadre().getText();

        try {
            if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento == null
                    || telefono.isEmpty() || direccion.isEmpty() || email.isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "Por favor llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(daoBeneficiario.verificarCedula(cedula)){
                JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "La cedula que usted ingresó ya existe, verifique su inforamción", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                bene.setCedula(cedula);
                bene.setNombre(nombre);
                bene.setApellido(apellido);
                bene.setFecha_nacimiento(fechaNacimiento);
                bene.setTelefono(telefono);
                bene.setDireccion(direccion);
                bene.setEmail(email);
                bene.setTipo(tipo);
            
               
                if(!cedulaMadre.isEmpty()&&!nombreMadre.isEmpty()&&!apellidoMadre.isEmpty()){
                    ma.setCedula(cedulaMadre);
                    ma.setNombre(nombreMadre);
                    ma.setApellido(apellidoMadre);
                }else{
                    ma.setCedula("");
                    ma.setNombre("");
                    ma.setApellido("");
                }
                
                if(!cedulaPadre.isEmpty()&&!nombrePadre.isEmpty()&&!apellidoPadre.isEmpty()){
                    pa.setCedula(cedulaPadre);
                    pa.setNombre(nombrePadre);
                    pa.setApellido(apellidoPadre);
                }else{
                    pa.setCedula("");
                    pa.setNombre("");
                    pa.setApellido("");
                }
                
                if(daoRepresentantes.veficarRepresentantes(cedulaPadre, cedulaMadre)){
                    int idRepresentantes = daoRepresentantes.obtenerRepresentante(cedulaPadre,cedulaMadre);
                    insertado = daoBeneficiario.insertarBeneficiarioHijo(bene, idRepresentantes);
                }else{
                    int idPadre = daoPadre.insertarPadre(pa);
                    int idMadre = daoMadre.insertarMadre(ma);
                    int idRepresentates = daoRepresentantes.insertarRepresentantes(idPadre,idMadre);
                    insertado = daoBeneficiario.insertarBeneficiarioHijo(bene, idRepresentates);
                }

                if (insertado) {
                    JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "Se insertó correctamente");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaAgregarModificarBeneficiario, "ERROR:" + e.toString());
        }
    }

//METODO controlador funcion llenar campos al seleccionar tabla
    public void seleccionarPadreMadre(JTable paramTablaUsuarios, JTextField paramCedula, JTextField paramNombre, JTextField paramApellido) {
        try {
            int fila = paramTablaUsuarios.getSelectedRow();
            if (fila >= 0) {
                paramCedula.setText(paramTablaUsuarios.getValueAt(fila, 0).toString());
                paramNombre.setText(paramTablaUsuarios.getValueAt(fila, 1).toString());
                paramApellido.setText(paramTablaUsuarios.getValueAt(fila, 2).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error al seleccionar la fila");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }
    }
}
