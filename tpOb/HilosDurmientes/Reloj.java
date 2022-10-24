package tpOb.HilosDurmientes;

import java.util.concurrent.Semaphore;

public class Reloj {

    private int puntero, puntero2;//puntero indica la pos en la que debe hacer el release y el 2 el acquire
    private Semaphore [] semTrabajadores;
    private int cantTrabajadores;
    private Semaphore semDormir;



    public Reloj (int cantTrabajadores){
        this.cantTrabajadores=cantTrabajadores;
        semTrabajadores= new Semaphore [cantTrabajadores];
        for(int i=0;i<semTrabajadores.length;i++) {
            semTrabajadores[i]= new Semaphore(0);
        }
        semDormir= new Semaphore(0);
        puntero=0;
        puntero2=0;
      
    }

    public void despertarPrimerHilo(){
        semTrabajadores[0].release();
        puntero++;
    }
    public void despertarPana(){
        if (puntero< (cantTrabajadores-1)){
            semTrabajadores[puntero].release();
            puntero++;
        }else{
            //es el ultimo hilito
            puntero2=0;
            puntero=0;
        }
      
    }
    public void despertarme(){
        try {
            System.out.println(Thread.currentThread().getName() +" INGRESA A DESPERTARSE");
            semTrabajadores[puntero2].acquire();
            puntero2++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void esperarZZZ(){
        try {
            semDormir.acquire(cantTrabajadores);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void aMimir(){
        System.out.println(Thread.currentThread().getName() +" HACE RELEASE DE SEM DORMIR");
        semDormir.release();
    }

   

    
}
