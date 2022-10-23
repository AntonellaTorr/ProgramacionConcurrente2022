/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Antonella
 */
public class Main {
    private static int []a=new int[50000];
    private static Suma sumaCompartida= new Suma();
    
    public static void main(String[] args) {
               
       iniciarArreglo();
       Thread hilitos[]= crearHilos();
       sumarArreglo(hilitos, hilitos.length);
       System.out.println("sumita por hilos "+sumaCompartida.getSuma());
       
        
        
    }
    public static void iniciarArreglo(){
 
        
        Random r= new Random ();
        
        for (int i=0; i<50000;i++){
            a[i]= r.nextInt(10)+1;
           
        }
    }
    public static Thread [] crearHilos(){
        System.out.println("Ingrese la cantidad de hilos");
        Scanner s= new Scanner (System.in);
        int k= s.nextInt();
        
        
        Thread []hilitos= new Thread[k];
        int cantPorHilo= Math.floorDiv(50000, k);
        int j=0;
        for (int i=0;i<k-1;i++){
            hilitos[i]= new Thread (new Sumadores(a, j, j+cantPorHilo, sumaCompartida));
            j+=cantPorHilo;
            
        }
        
        //SUMA DEL ULITMO HILO
       hilitos[k-1]= new Thread(new Sumadores(a, j, a.length, sumaCompartida));
       return hilitos;
    }
    public static void sumarArreglo (Thread hilitos[],int k){
        int suma=0;
       for (int i=0;i<k;i++){
            hilitos[i].start();
            
        }
       
       for (int i=0;i<50000;i++){
           suma+=a[i];
       }
        System.out.println( "SUMA SECUENCIAL-->" +suma);
   
        
        
    }
    
}
