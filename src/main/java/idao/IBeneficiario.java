/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.beneficiario;

/**
 *
 * @author Asus
 */
public interface IBeneficiario {
    public boolean insertarBeneficiario(beneficiario bene);
    public boolean eliminarBeneficiario(beneficiario bene);
    public boolean modificarBeneficiario(beneficiario bene);
    public ArrayList<Object[]> consultarBeneficiario();
}
