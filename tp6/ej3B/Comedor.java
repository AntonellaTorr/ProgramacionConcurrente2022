package tp6.ej3B;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Comedor {

    private ReentrantLock mutexMostradorComida;
    private ReentrantLock mutexMostradorPostre;
    private ReentrantLock mutexAbridores;
    private ReentrantLock mutexBandejas;

    private Condition bandejasLibres= mutexBandejas.newCondition();
    private Condition mostradoresLibres= mutexMostradorComida.newCondition();
    private Condition mostradoresLibresPostre= mutexMostradorPostre.newCondition();
    private Condition abridoresLibres= mutexAbridores.newCondition();
    

    private int cantEnMostradorComida, cantEnMostradorPostre, cantUsandoAbridor, cantBandejasOcupadas;
    private int cantMostradores, cantMostradorPostres, cantAbridores, cantBandejas;



    public Comedor (int cantMostradores,int cantMostradorPostres,int cantAbridores,int cantBandejas){
        mutexAbridores= new ReentrantLock();
        mutexBandejas= new ReentrantLock();
        mutexMostradorComida= new ReentrantLock();
        mutexMostradorPostre= new ReentrantLock();
        this.cantAbridores=cantAbridores;
        this.cantMostradores=cantMostradores;
        this.cantMostradorPostres=cantMostradorPostres;
        this.cantBandejas= cantBandejas;

    }
    public void agarrarBandeja (){
        mutexBandejas.lock();
        while (cantBandejasOcupadas==cantBandejas){
            try {
                bandejasLibres.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantBandejasOcupadas++;
        mutexBandejas.unlock();
    }
    public void dejarBandeja (){
        mutexBandejas.lock();
        cantBandejasOcupadas--;
        bandejasLibres.signal();
        mutexBandejas.unlock();
    }

    public void elegirComidaMostrador (){
        mutexMostradorComida.lock();
        while (cantEnMostradorComida==cantMostradores){
            try {
                mostradoresLibres.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantEnMostradorComida++;
        mutexMostradorComida.unlock();
    }
    public void irseMostrador(){
        mutexMostradorComida.lock();

        cantEnMostradorComida--;
        mostradoresLibres.signal();

        mutexMostradorComida.unlock();
    }

    public void utilizarAbridor (){
        mutexAbridores.lock();
        while (cantUsandoAbridor==cantAbridores){
            try {
                abridoresLibres.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantAbridores++;
        mutexAbridores.unlock();
    }
    public void dejarAbridor(){
        mutexAbridores.lock();
        cantUsandoAbridor--;
        abridoresLibres.signal();
        mutexAbridores.unlock();
    }

    public void elegirPostre(){
        mutexMostradorPostre.lock();
        while (cantEnMostradorPostre== cantMostradorPostres){
            try {
                mostradoresLibresPostre.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantEnMostradorPostre++;
        mutexMostradorPostre.unlock();
        
    }
    public void irseDelMostradorPostre(){
        mutexMostradorPostre.lock();
        cantEnMostradorPostre--;
        mutexMostradorPostre.unlock();
    }

    
}
