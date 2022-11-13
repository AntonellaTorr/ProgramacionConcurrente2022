package PracticaSegundoP.PerrosAlaska;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Albergue {
    private ReentrantLock mutexPerros= new ReentrantLock();;
    private Condition platosVacios= mutexPerros.newCondition();
    private Condition cocinar=mutexPerros.newCondition();
    private int cantPlatosLlenos, cantTotalPlatos;


    public Albergue(int cantPlatos){
    
        this.cantTotalPlatos=cantPlatos;
        this.cantPlatosLlenos=0;
    }

    public void comer (){
        mutexPerros.lock();
        while (cantPlatosLlenos==0){
            System.out.println(Thread.currentThread().getName() + " NO HABIA PLATOS LLENOS");
            cocinar.signal();
            try {
                platosVacios.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        cantPlatosLlenos--;
        System.out.println(Thread.currentThread().getName()+" ACCEDE AL PLATO");
        mutexPerros.unlock();
        System.out.println(Thread.currentThread().getName()+" SE VA");

    }
    public void empezarCocina (){
        mutexPerros.lock();
        while (cantPlatosLlenos>0){
            System.out.println(Thread.currentThread().getName() + " NO TIENE QUE EMPEZAR A COCINAR");
            try {
                cocinar.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        mutexPerros.unlock();

    }

    public void avisarFinalizacionCocina(){
        mutexPerros.lock();

        cantPlatosLlenos=cantTotalPlatos;
        System.out.println(Thread.currentThread().getName() + "FINALIZO LA COCINA");
        platosVacios.signalAll();
        
        mutexPerros.unlock();

    }


    
}
