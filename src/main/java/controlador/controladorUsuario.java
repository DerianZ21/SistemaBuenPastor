/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.usuario;
import vista.vistaUsuarios;

/**
 *
 * @author Asus
 */
public class controladorUsuario {
    private final vistaUsuarios vistaUsuario;
    usuario usu = new usuario();
    daoUsuario dao = new daoUsuario();
    
    public controladorUsuario(vistaUsuarios vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
    }
    
    
//MEDOTO controlador funcion CONSULTAR
    public void consultarUsuarios(JTable paramTablaUsuarios) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try {
            ArrayList<Object[]> listUsuarios = dao.consultarUsuarios();
            for (Object[] usuario : listUsuarios) {
                modelo.addRow(usuario);
            }
        paramTablaUsuarios.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaUsuario, "ERROR: " + e.toString());
        }
    }


//MEDOTO controlador funcion INSERTAR
    public void insertarUsuario() {
        String nombreUsuarioTexto = vistaUsuario.getTxtNombreUsuario().getText();
        String apellidoUsuarioTexto = vistaUsuario.getTxtApellidoUsuario().getText();
        String usernameTexto = vistaUsuario.getTxtUsername().getText();
        String contrasenaUsuarioTexto = vistaUsuario.getPswContrasenaUsuario().getText();
        String confirmarContrasenaTexto = vistaUsuario.getPswConfirmarContrasena().getText();
        
        try {
            if (nombreUsuarioTexto.isEmpty()||apellidoUsuarioTexto.isEmpty()||usernameTexto.isEmpty()||contrasenaUsuarioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Por favor, ingresa el nombre y apellido del alumno.", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(!contrasenaUsuarioTexto.equals(confirmarContrasenaTexto)){
                JOptionPane.showMessageDialog(vistaUsuario, "la contraseña no coincide con su confimación.", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(dao.verificarUsuario(usernameTexto)){
                JOptionPane.showMessageDialog(vistaUsuario, "El usuario que usted ingresó ya existe, coloque uno diferente", "Error", JOptionPane.ERROR_MESSAGE);

            }else {
                
                usu.setNombre(nombreUsuarioTexto);
                usu.setApellido(apellidoUsuarioTexto);
                usu.setUsername(usernameTexto);
                usu.setContrasena(contrasenaUsuarioTexto);
                dao.insertarUsuario(usu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaUsuario, "ERROR:"+e.toString());
        }
    }
    
//MEDOTO controlador funcion MODIFICAR
    public void modificarUsuario() {
        int idUsuario ;
        String nombreUsuarioTexto = vistaUsuario.getTxtNombreUsuario().getText();
        String apellidoUsuarioTexto = vistaUsuario.getTxtApellidoUsuario().getText();
        String idUsuarioTexto = vistaUsuario.getTxtIDUsuarios().getText();
        try {
            if (nombreUsuarioTexto.isEmpty()||apellidoUsuarioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Por favor, ingresa el nombre y apellido del alumno.", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                idUsuario = Integer.parseInt(idUsuarioTexto);
                usu.setNombre(nombreUsuarioTexto);
                usu.setApellido(apellidoUsuarioTexto);
                usu.setId(idUsuario);
                
                dao.modificarUsuario(usu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaUsuario, "ERROR:"+e.toString());
        }
    }
    
    
    
//MEDOTO controlador funcion ELIMINAR
    public void eliminarUsuario() {
        int idUsuario ;
        String idUsuarioTexto = vistaUsuario.getTxtIDUsuarios().getText();
        try {
            if (idUsuarioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "porfavor seleccione un usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                idUsuario = Integer.parseInt(idUsuarioTexto);
                usu.setId(idUsuario);
                dao.eliminarUsuario(usu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaUsuario, "ERROR:"+e.toString());
        }
    }
    

//METODO controlador funcion llenar campos al seleccionar tabla
    public void seleccionarUsuarios(JTable paramTablaUsuarios, JTextField paramCodigo, JTextField paramNombre,  JTextField paramApellido){
        try {
            int fila = paramTablaUsuarios.getSelectedRow();
            if(fila>=0){
                paramCodigo.setText(paramTablaUsuarios.getValueAt(fila, 0).toString());
                paramNombre.setText(paramTablaUsuarios.getValueAt(fila, 1).toString());
                paramApellido.setText(paramTablaUsuarios.getValueAt(fila, 2).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error al seleccionar la fila");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
    }
    
}
