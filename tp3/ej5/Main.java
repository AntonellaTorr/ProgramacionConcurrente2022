/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej5;
import java.util.Random;
/**
 *
 * @author Antonella
 */
public class Main {
    
    public static void main(String[] args) {
        Random r= new Random();
        int n=r.nextInt(5)+1;
        Thread autitos[]= new Thread [n];
        Surtidor s= new Surtidor(100);
        for (int i=0;i<n;i++){
            autitos[i]= new Thread (new Auto(r.nextInt(150)+1,r.nextInt(50)+1,s));
        }
        for (int i=0;i<n;i++){
            autitos[i].start();
        }
    }
    
}
