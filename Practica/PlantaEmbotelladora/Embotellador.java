package Practica.PlantaEmbotelladora;

import java.util.Random;

public class Embotellador implements Runnable {
    private Planta p;

    public Embotellador(Planta p ){
        this.p=p;
    }


    public void run (){
        Random r= new Random();
        while (true){
            System.out.println("GENERANDOOO EL LIQUIDO ");
            this.simular();
            if (r.nextInt()%2==0){
                System.out.println(Thread.currentThread().getName() + " GENERO AGUA");
                p.embotellarAgua();

            }
            else{
                System.out.println(Thread.currentThread().getName() + " GENERO VINO");
                p.embotellarVino();
            }
        }
       
    }
    public void simular (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
