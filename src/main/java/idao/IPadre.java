/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.padre;

/**
 *
 * @author Asus
 */
public interface IPadre {
    public ArrayList<Object[]> consultarPadres();
    
    public boolean insertarPadre(padre pa);
}
