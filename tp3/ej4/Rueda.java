/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej4;

/**
 *
 * @author Antonella
 */
public class Rueda {
      public synchronized void correr (){
      try{  
          System.out.println(Thread.currentThread().getName() +" por comenzar a correr");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() +" termino de correr");
        }catch(InterruptedException e){
            
        }
    }
}
