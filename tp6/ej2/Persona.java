package tp6.ej2;

import java.util.Random;

public class Persona implements Runnable{
    private GestorSala g;

    public Persona (GestorSala g){
        this.g=g;
    }

    public void run (){
        Random r= new Random();
        int n=r.nextInt(2);
        if  (n==0){
            System.out.println( Thread.currentThread().getName() + " ES JUBILADO");
            g.entrarSalaJubilado();
        }
        else{
            System.out.println( Thread.currentThread().getName() + " ES PERSONA NORMAL");
            g.entrarSala();
        }
        this.recorrerMuseo();

        g.salirSala();
    }
    public void recorrerMuseo (){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
