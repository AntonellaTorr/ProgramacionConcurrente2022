/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1.Ej9;

/**
 *
 * @author Diana
 */
public class Cliente {
    private String nombreYApe;
    private int dni;
    private int nroMovil;
    private String dirElectronica;
    
    
 public Cliente (String nombreYApe, int dni, int nroMovil, String dirElectronica){
     this.nombreYApe=nombreYApe;
     this.dni=dni;
     this.nroMovil=nroMovil;
     this.dirElectronica=dirElectronica;
 }

    public String getNombreYApe() {
        return nombreYApe;
    }

    public void setNombreYApe(String nombreYApe) {
        this.nombreYApe = nombreYApe;
    }

    public int getDni() {
        return dni;
    }


    public int getNroMovil() {
        return nroMovil;
    }

    public void setNroMovil(int nroMovil) {
        this.nroMovil = nroMovil;
    }

    public String getDirElectronica() {
        return dirElectronica;
    }

    public void setDirElectronica(String dirElectronica) {
        this.dirElectronica = dirElectronica;
    }
 
}

