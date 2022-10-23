package tp4.Ej4;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Centro c= new Centro(1,1);
        Random r= new Random();
        int cantHilos= r.nextInt(20)+1;
        Thread hilosUsuarios[]= new Thread[10];

        for(int i=0;i<hilosUsuarios.length;i++){
            hilosUsuarios[i]=new Thread(new Usuario(c), "Hilo "+i);
        }
        for(int i=0;i<hilosUsuarios.length;i++){
            hilosUsuarios[i].start();
        }


    }
}
