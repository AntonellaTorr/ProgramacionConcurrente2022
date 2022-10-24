package tpOb.HilosDurmientes;

import java.util.concurrent.Semaphore;

public class Reloj {

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
       
      
    }

    public void despertarPrimerHilo(){
        semTrabajadores[0].release();
     
    }
    public void despertarPana(int nroTrabajador){
        if (nroTrabajador< (cantTrabajadores-1)){
            semTrabajadores[nroTrabajador+1].release();
        }
    
      
    }
    public void despertarme(int nroTrabajador){
        try {
            System.out.println(Thread.currentThread().getName() +" INGRESA A DESPERTARSE");
            semTrabajadores[nroTrabajador].acquire();
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
