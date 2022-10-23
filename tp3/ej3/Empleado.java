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
public class Empleado  {
    private SalaConcierto c;
    
    public Empleado (SalaConcierto c){
        this.c=c;
    }
    
    public ArrayList solicitarAsientosLibres(){
        return c.obtenerAsientosLibres();
    }
    public boolean reservarAsiento (int nro){
        return c.reservarAsiento(nro);
    }
    
    
    
}
