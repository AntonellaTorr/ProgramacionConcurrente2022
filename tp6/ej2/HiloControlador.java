package tp6.ej2;

import java.util.Random;

public class HiloControlador implements Runnable{
    private GestorSala g;
    
    public HiloControlador (GestorSala g){
        this.g=g;
    }



    public void run (){
        Random r= new Random();
        int n;

        while (true){
            n=r.nextInt(50);
            System.out.println( "--------------------NUEVA TEMPERATURA: " +n +" ------------");
            g.notificarTemperatura(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
        }
    }
    
}
