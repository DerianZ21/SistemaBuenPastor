/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.madre;
/**
 *
 * @author Asus
 */
public interface IMadre {
    public ArrayList<Object[]> consultarMadres();
    
    public boolean insertarBenficiarioMadre(madre ma);
    
    public int insertarMadre(madre ma);
    
}
