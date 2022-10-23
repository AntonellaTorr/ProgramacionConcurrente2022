/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej2;

/**
 *
 * @author Antonella
 */
public class Main {
    public static void main(String[] args) {
        Vida v= new Vida ();
        Orco o= new Orco(v);
        Curandero c= new Curandero(v);
        Thread orco= new Thread (o);
        Thread curandero= new Thread (c);
        
        orco.start();
        curandero.start();
    }
}
