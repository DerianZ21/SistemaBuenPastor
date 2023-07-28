/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Asus
 */
public class representantes {
    private int id_representantes, id_padre, id_madre;

    public representantes() {
    }

    public representantes(int id_representantes, int id_padre, int id_madre) {
        this.id_representantes = id_representantes;
        this.id_padre = id_padre;
        this.id_madre = id_madre;
    }

    public int getId_representantes() {
        return id_representantes;
    }

    public void setId_representantes(int id_representantes) {
        this.id_representantes = id_representantes;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getId_madre() {
        return id_madre;
    }

    public void setId_madre(int id_madre) {
        this.id_madre = id_madre;
    }
}
