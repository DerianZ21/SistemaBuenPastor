/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.asistencias;

/**
 *
 * @author Asus
 */
public interface IAsistencias {
    
   public ArrayList<Object[]> consultarBeneficiarioCurso(int idCurso);
   public boolean insertarAsistencia(asistencias asis);
    
}
