/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej3;
import java.util.*;


/**
 *
 * @author Antonella
 */
public class SalaConcierto {
    //recurso compartido
    private int cantAsientos;
    private Asiento [] asientos;
    
    public SalaConcierto(){
        Random r= new Random ();
        cantAsientos= r.nextInt(10)+1;
        asientos= new Asiento[cantAsientos];
        System.out.println(cantAsientos);
        for (int i=0;i<cantAsientos;i++){
            asientos[i]= new Asiento(i);
        }
        
    }
    
    public ArrayList obtenerAsientosLibres (){
        ArrayList asientosLibres= new ArrayList();
        for (int i=0;i<cantAsientos;i++){
            if( !asientos[i].estaOcupado()){
              asientosLibres.add(asientos[i]);
            }
        }
        return asientosLibres;
    }
    public boolean reservarAsiento(int nro){
        boolean exito=false;
        if (nro<cantAsientos){
            if(!asientos[nro].estaOcupado()){
            asientos[nro].setearEstadoDeOcupacion(true);
            exito=true;
            System.out.println ("El cliente " +Thread.currentThread().getName() +" ha seleccionado el asiento "+nro+" exitosamente");
            }
        }
        
        return exito;
        
    }

    
    
    
}
