/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej4;

/**
 *
 * @author Antonella
 */
public class Plato {
    
    public synchronized void comer (){
      try{
             System.out.println(Thread.currentThread().getName() +" por comenzar a comer");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() +" termino de comer");
        }catch(InterruptedException e){
            
        }
    }
}
