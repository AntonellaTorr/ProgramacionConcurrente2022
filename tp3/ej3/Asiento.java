/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej3;

/**
 *
 * @author Antonella
 */
public class Asiento {
    private boolean ocupado;
    private int nro;
    
    public Asiento (int nro){
        ocupado=false;
        this.nro=nro;
    }
    public synchronized boolean estaOcupado(){
        return ocupado;
    }
    public synchronized void setearEstadoDeOcupacion(boolean estado){
        ocupado=estado;
    }
}
