package Practica;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Parque p= new Parque();
        Random r= new Random();
        int cantVisitantes= r.nextInt(10);
        Thread [] visitantes= new Thread[32310];

        for (int i=0;i<visitantes.length;i++){
            visitantes[i]= new Thread(new Visitante(p));
        }

        for (int i=0;i<visitantes.length;i++){
            visitantes[i].start();
        }

        Thread encargado= new Thread(new Encargado(p));

        encargado.start();


    }
    
}
