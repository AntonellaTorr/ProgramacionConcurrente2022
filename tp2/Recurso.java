/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author Antonella
 */
public class Recurso {
    static void uso(){
        Thread t=Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
        }
}



