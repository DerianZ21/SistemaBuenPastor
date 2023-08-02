/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import java.util.List;
import modelo.beneficiario;

/**
 *
 * @author Asus
 */
public interface IBeneficiario {
    public boolean insertarBeneficiarioPadres(beneficiario bene);
    public boolean insertarBeneficiarioHijo(beneficiario bene, int repre);
    public boolean eliminarBeneficiario(String cedula);
    public boolean modificarBeneficiario(beneficiario bene, String ced);
    public ArrayList<Object[]> consultarBeneficiario();
    public List<Object[]> obtenerDatos(String cedulaBuscada);
    public List<Object[]> obtenerNombreApellido(String cedulaBuscada);
}
