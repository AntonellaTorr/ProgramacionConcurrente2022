/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej2;

/**
 *
 * @author Antonella
 */
public class Vida {
    private int nivel=10; 
    
  
    public synchronized int getVida() {
        return nivel;
    }
    public synchronized void golpear (int cant){
        nivel=nivel-cant;
    }
    public synchronized void curar (int cant){
        nivel=nivel+cant;
    }
    
}
