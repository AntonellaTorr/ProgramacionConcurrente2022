package PracticaSegundoP.FabricaSueters;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica {
    private ReentrantLock mutexCestoMangas;
    private ReentrantLock mutexCestoCuerpo;
    private ReentrantLock mutexCocer;
    private Condition hayEspacioMangas= mutexCestoMangas.newCondition();
    private Condition hayEspacioCuerpo= mutexCestoCuerpo.newCondition();

    private Condition cocer= mutexCocer.newCondition();
    private int numMaxMangas, numMaxCuerpos, cantMangas, cantCuerpos, cantSueters, cantCajas;


    public void cocerMangas(){
        mutexCestoMangas.lock();
        while (cantMangas== numMaxMangas){
            try {
                hayEspacioMangas.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantMangas++;
        mutexCocer.lock();
        if (cantMangas>=2){
            cocer.signal();
        }
        mutexCocer.unlock();
        mutexCestoMangas.unlock();

       
        


    }
    public void cocerCuerpos(){
        mutexCestoCuerpo.lock();
        while (cantCuerpos== numMaxCuerpos){
            try {
                hayEspacioCuerpo.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantCuerpos++;
        mutexCocer.lock();
        if (cantCuerpos>=1){
            cocer.signal();
        }
        mutexCocer.unlock();
        mutexCestoCuerpo.unlock();

    }

    public void cocer(){
        mutexCocer.lock();
        while (cantMangas<2 && cantCuerpos<1){

            System.out.println(Thread.currentThread().getName() + " NO HAY ELEMENTOS PARA ARMAR UN SWETER ESPERA");
            try {
                cocer.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        mutexCestoMangas.lock();
        cantMangas= cantMangas-2;
        mutexCestoMangas.unlock();

        mutexCestoCuerpo.lock();
        cantCuerpos--;
        mutexCestoCuerpo.unlock();

        cantSueters++;
        System.out.println(Thread.currentThread().getName() + " ARMA UN SWETER");
        mutexCocer.unlock();
       

    }
    public void empaquetarSiEsNecesario (){
        mutexCocer.lock();
        if (cantSueters==10){
            cantSueters=0;
            cantCajas++;

            System.out.println(Thread.currentThread().getName()+" LLENO UNA CAJA "+ "Cant cajas "+ cantCajas);
            
        }
        mutexCocer.unlock();
    }

}
