/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej4;
import java.util.Random;
/**
 *
 * @author Antonella
 */
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(3) + 1;
        Thread hamsters[] = new Thread[n];
        Hamaca h= new Hamaca();
        Rueda rue= new Rueda ();
        Plato p= new Plato();

        for (int i = 0; i < n; i++) {
            hamsters[i]= new Thread (new Hamster (h,p,rue),"nro "+String.valueOf(i));
        }
        
         for (int i = 0; i < n; i++) {
            hamsters[i].start();
        }
    }
   
        
    
    

    
}
