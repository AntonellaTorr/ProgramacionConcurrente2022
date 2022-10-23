/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1.Ej9;

import Tp1.Ej9.Barco;

/**
 *
 * @author Diana
 */
public class Velero extends Barco {
    private int nroMastil;

public Velero(int nroMastil,String matricula, int eslora, int añoFabricacion){
    super(matricula,eslora,añoFabricacion);
    this.nroMastil=nroMastil;
    
}

    public int getNroMastil() {
        return nroMastil;
    }

    public void setNroMastil(int nroMastil) {
        this.nroMastil = nroMastil;
    }

}
