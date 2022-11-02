package tp6.ej3B;

import java.util.Random;

public class Soldado implements Runnable {
    private Comedor c;
    
    public Soldado (Comedor c){
        this.c=c;
    }
    public void run (){
        Random r= new Random ();
        c.agarrarBandeja();
        c.elegirComidaMostrador();
        System.out.println(Thread.currentThread().getName() + " esta en un mostrador selecciona comida...........");
        this.simular();
        c.irseMostrador();
        if (r.nextInt(2)==0){
            System.out.println(Thread.currentThread().getName() + " eligio botella de gaseosa");
            c.utilizarAbridor();
            System.out.println(Thread.currentThread().getName() + " abriendo botella.....");
            this.simular();
            c.dejarAbridor();

        }
        else{
            System.out.println(Thread.currentThread().getName() + " eligio agua");
        }
        if (r.nextInt(2)==0){
             System.out.println(Thread.currentThread().getName() + " quiere postre, va hacia el mostrador");
             c.elegirPostre();
             System.out.println(Thread.currentThread().getName() + " en el mostrador de postres");
             this.simular();
             c.irseDelMostradorPostre();
        }
        else{
            System.out.println(Thread.currentThread().getName() + " no quiere postre");
        }
        c.dejarBandeja();
        System.out.println(Thread.currentThread().getName() + " se fue");


    }

    public void simular () {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
