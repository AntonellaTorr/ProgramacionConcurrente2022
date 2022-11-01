package tp5.ej5;

import java.util.Random;

public class Avion implements Runnable {
    
    private Pista p; 

    public Avion (Pista p){
        this.p=p;
    }


    public void run (){
        Random r= new Random();
        
        if (r.nextInt(2)==0){
            System.out.println(Thread.currentThread().getName() + " DESEA ATERRIZAR");
            p.puedeAterrizar();
            p.comenzarAterrizar();
            this.usandoPista();
            p.finalizarAterrizaje();
            p.abandonarPistaAterrizaje();
            System.out.println(Thread.currentThread().getName() +" se va");

        }
        else{
            System.out.println(Thread.currentThread().getName() + "DESEA DESPEGAR");
            //p.puedeDes
            //pegar();
            p.comenzarDespegue();
            this.usandoPista();
            p.finalizarDespegue();
            p.abandonarPistaDespuegue();
            System.out.println(Thread.currentThread().getName() +" se va");
        }
    }

    public void usandoPista (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
