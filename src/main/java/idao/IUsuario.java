/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;
import java.util.ArrayList;
import modelo.usuario;
/**
 *
 * @author Asus
 */
public interface IUsuario{
    
    public boolean insertarUsuario(usuario usu);
    public boolean eliminarUsuario(usuario usu);
    public boolean modificarUsuario(usuario usu);
    public ArrayList<Object[]> consultarUsuarios();
    
    
}
