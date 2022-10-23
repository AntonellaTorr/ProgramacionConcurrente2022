package Tp1.Ej9;

import Tp1.Ej9.Barco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Anto
 */
public class Deportivo extends Barco {
    private int potenciaCV;
    
 
public Deportivo (int potenciaCV, String matricula, int eslora, int añoFabricacion){
    super(matricula, eslora, añoFabricacion);
    this.potenciaCV=potenciaCV;
}

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

}
