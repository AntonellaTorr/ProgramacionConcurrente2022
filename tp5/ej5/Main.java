package tp5.ej5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de aviones ");
        int cantAviones= s.nextInt();
        Thread aviones[]= new Thread[cantAviones];
        
        Pista p= new Pista(10);
        
        for (int i=0;i<aviones.length;i++){
            aviones[i]= new Thread(new Avion(p), "Avion "+i);
        }
        for (int i=0;i<aviones.length;i++){
            aviones[i].start();
        }
    }
    
}
