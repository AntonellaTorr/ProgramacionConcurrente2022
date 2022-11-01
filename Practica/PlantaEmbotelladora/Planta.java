package Practica.PlantaEmbotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Planta {

    private ReentrantLock mutexVinos= new ReentrantLock();
    private ReentrantLock mutexAgua= new ReentrantLock();

    private Condition hayCajaAgua= mutexAgua.newCondition();
    private Condition hayCajaVino= mutexVinos.newCondition();
    private Condition cajaVinoLlena= mutexVinos.newCondition();
    private Condition cajaAguaLlena= mutexAgua.newCondition();
    
    private int cantVinos;
    private int cantAgua;
    private boolean cajaVinoPuesta;
    private boolean cajaAguaPuesta;




    public void embotellarAgua(){
        mutexAgua.lock();

        while (!cajaAguaPuesta){
            try {
                hayCajaAgua.await();
           

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantAgua++;
        if (cantAgua==10){
           
            
        
        }

    }

    
}
