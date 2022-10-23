/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej3;
import java.util.Random;


/**
 *
 * @author Antonella
 */
public class Main {
    public static void main(String[] args) {
        SalaConcierto s= new SalaConcierto();
        Empleado e= new Empleado(s);
        Random r= new Random ();
        int n=r.nextInt(20)+1;
        System.out.println(n);
        Thread []clientes= new Thread[n];
        for (int i=0;i<n;i++){
             clientes[i]= new Thread (new Cliente(e), "nro" +i);
        }
          for (int i=0;i<n;i++){
             clientes[i].start();
        }
        
        
       
        
        
    }
}
