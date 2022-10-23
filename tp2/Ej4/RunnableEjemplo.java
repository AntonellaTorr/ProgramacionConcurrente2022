/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.Ej4;

/**
 *
 * @author Antonella
 */
public class RunnableEjemplo implements Runnable {
   
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
 
}

