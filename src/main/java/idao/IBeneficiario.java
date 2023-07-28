/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.beneficiario;
import modelo.madre;
import modelo.padre;

/**
 *
 * @author Asus
 */
public interface IBeneficiario {
    public boolean insertarBeneficiarioPadres(beneficiario bene);
    public boolean insertarBeneficiarioHijo(beneficiario bene, int repre);
    public boolean eliminarBeneficiario(beneficiario bene);
    public boolean modificarBeneficiario(beneficiario bene);
    public ArrayList<Object[]> consultarBeneficiario();
}
