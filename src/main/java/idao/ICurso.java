/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.curso;

/**
 *
 * @author Asus
 */
public interface ICurso {
    
    public boolean insertarCurso(curso cu);
    public ArrayList<Object[]> consultarCursos(String tipoBene);
}
