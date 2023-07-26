/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.daoUsuario;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.usuario;
import vista.vistaLogin;
import vista.vistaUsuarios;

/**
 *
 * @author Asus
 */
public class controladorLogin {
    private final vistaLogin vistaLogin;
    vistaUsuarios vistUsuarios = new vistaUsuarios();
    
    usuario usu = new usuario();
    daoUsuario dao = new daoUsuario();

    public controladorLogin(vistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }


//MEDOTO controlador funcion iniciar sesion
    public boolean iniciarSesion(JTextField paramUsuario,  JTextField paramContrasena){
        String usuarioTexto = vistaLogin.getTxtUsuario().getText();
        String contrasenaTexto = vistaLogin.getPswContrasena().getText();
        try{
            if(usuarioTexto.isEmpty()||contrasenaTexto.isEmpty()){
                JOptionPane.showMessageDialog(vistaLogin, "Por favor, ingresa usurio y contrasena", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }else if(dao.verificarInicioSesion(usuarioTexto, contrasenaTexto)){
                return true;
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:"+e.toString());
        }
        JOptionPane.showMessageDialog(vistaLogin, "Usuario y contraseña incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}