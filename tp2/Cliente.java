/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author Antonella
 */
public class Cliente extends Thread {
  
    public void run(){
    System.out.println("soy"+Thread.currentThread().getName());
    Recurso.uso();
    try {
    Thread.sleep(2000);
    }catch (InterruptedException e) {
    }
    };
    
}
