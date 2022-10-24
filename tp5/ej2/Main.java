package tp5.ej2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r= new Random();
        int n=r.nextInt(10);
        Centro c= new Centro(5, 5);
        Thread perros[]=new Thread[5];
        Thread gatos[]=new Thread[5];

        for (int i=0;i<perros.length;i++){
            perros[i]= new Thread(new Perro(c), "Perro "+(i));
        }
        for (int i=0;i<gatos.length;i++){
            gatos[i]= new Thread(new Gato(c), "Gato "+(i));
        }
        for (int i=0;i<perros.length;i++){
            perros[i].start();
        }
        for (int i=0;i<gatos.length;i++){
            gatos[i].start();
        }


    }
    
}
