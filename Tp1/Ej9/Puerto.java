/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1.Ej9;

import Tp1.Ej9.Alquiler;

/**
 *
 * @author Diana
 */
public class Puerto {
    private Alquiler[] colAlquiler;
    private final int cantDias;


public Puerto (int cantDias){
    colAlquiler= new Alquiler[10];
    this.cantDias=cantDias;
}

    public int getCantDias() {
        return cantDias;
    }
}