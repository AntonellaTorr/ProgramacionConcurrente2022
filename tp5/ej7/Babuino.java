package tp5.ej7;

import java.util.Random;
//que pasa si mientras algunos estan esperando para hacer un acquire del semPaso del puente el hilo hace el cambio
public class Babuino  implements Runnable{
    private Puente p;
    public Babuino (Puente p){
        this.p=p;
    }
    public void run (){
        Random r= new Random();
        char lado;

        int n= r.nextInt(2);
        if (n==0){
            lado='I';
        }else{
            lado='D';
        }
        if( p.getLadoHabilitado()!=lado){
            System.out.println(Thread.currentThread().getName() +" debe esperar por que estan pasando los babuinos del lado contrario");
            p.esperarHabilitacionLado();
            System.out.println(Thread.currentThread().getName() +" ya se habilito su lado");
        }
        //se puede hacer un while ?
        p.cruzarPuente();
         System.out.println(Thread.currentThread().getName() + " cruzando...........");
         try {
            Thread.sleep(100);
         } catch (Exception e) {}
        p.liberarEspacioPuente();
         System.out.println(Thread.currentThread().getName() + " termino de pasar");

        
        
    }
}
