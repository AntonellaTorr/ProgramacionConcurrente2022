package Practica;

import java.util.Random;

public class Encargado implements Runnable {
    private Parque p;

    public Encargado (Parque p){
        this.p=p;
    }

    public void run (){
        boolean tobogan1Ocupado=false,tobogan2Ocupado=false;
        while (true){
            //llegada del visitante
            System.out.println("............................");
            p.esperarVisitante();
            System.out.println("Llego un visitante........");
            if (!p.intentarOcuparTobogan1()){
                System.out.println("Tobogan 1 OCUPADO........");
                if (!p.intentarOcuparTobogan2()){
                    System.out.println("Tobogan 2 OCUPADO........");
                    Random r= new Random();
                    int n=r.nextInt(2);
                    if (n==0){
                        System.out.println("Espera para ocupar tobogan 1........");
                        p.ocuparTobogan1();
                        tobogan1Ocupado=true;
                    }
                    else{
                        System.out.println("Espera para ocupar tobogan 2........");
                        p.ocuparTobogan2();
                        tobogan2Ocupado=true;
                    }
                }
                else{
                    System.out.println("Tobogan 2 libre");
                    tobogan2Ocupado=true;
                }
            }
            else{
                System.out.println("Tobogan 1 libre");
                tobogan1Ocupado=true;
            }
          
            if (tobogan1Ocupado){
                p.permitirTirarse("Tobogan1");

            }
            else{
                p.permitirTirarse("Tobogan2");
            }

            p.esperarFinalizacion();

            if (tobogan1Ocupado){
                p.desocuparTobogan1();
            }
            else{
                p.desocuparTobogan2();
            }
           

           


        }
    }

    
}
