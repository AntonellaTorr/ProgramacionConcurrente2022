/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.Ej4;

/**
 *
 * @author Antonella
 */
public class test {
       public static void main(String[] args) {
        Thread uno= new Thread(new RunnableEjemplo(), "Jose Maria");
        Thread dos= new Thread(new RunnableEjemplo(), "Maria Jose");
        
        uno.start();
        dos.start();
    }
}
