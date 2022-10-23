package ProblemasClasicos.ProductorConsumidor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecursoCompartido r= new RecursoCompartido();
        Consumidor c[];
        Productor p[];
        Thread []thc;
        Thread []thp;

        Scanner s= new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de productores");
        int cantP= s.nextInt();
        p= new Productor[cantP];
        thp= new Thread[cantP];
        System.out.println("Ingrese la cantidad de Consumidoress");
        int cantC=  s.nextInt();
        c= new Consumidor[cantC];
        thc= new Thread[cantC];
        
        for (int i = 0; i < p.length; i++) {
            p[i]= new Productor(r);
            thp[i]= new Thread (p[i], "Productor "+i);
        }
        for (int i = 0; i < c.length ; i++) {
            c[i]= new Consumidor (r);
            thc[i]= new Thread(c[i], "Consumidor "+i);
        }
        
        for (int i = 0; i < p.length; i++) {
            thp[i].start();
        }
        for (int i = 0; i < c.length; i++) {
            thc[i].start();
            
        }
        
        
        
        
    }
    
    
}
