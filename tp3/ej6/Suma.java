/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej6;

/**
 *
 * @author Antonella
 */
public class Suma {
    private int valor;
    
    public Suma (){
        valor=0;
    }
    public synchronized  void sumar (int cant){
        valor+=cant;
    }
    public  synchronized int getSuma (){
        return valor;
    }
    
}
