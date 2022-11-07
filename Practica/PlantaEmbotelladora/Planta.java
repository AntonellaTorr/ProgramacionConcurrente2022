package Practica.PlantaEmbotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Planta {

    private ReentrantLock mutex= new ReentrantLock();
    private ReentrantLock mutexCamionero= new ReentrantLock();

    private Condition embotelladorAgua= mutex.newCondition();
    private Condition embotelladorVino= mutex.newCondition();
    private Condition esperarBotellas= mutex.newCondition();

    private Condition almacenLleno= mutexCamionero.newCondition();

    private int cantBotellasVino=0, cantBotellasAgua=0, cantCajas=0, cantMaxAlmacen=10;

    private boolean hayCajaPuestaVino=false, hayCajaPuestaAgua=false;



    public void embotellarVino(){
        mutex.lock();
        while (cantBotellasVino>=10 || !hayCajaPuestaVino){
            System.out.println(Thread.currentThread().getName() +" NO HABIA CAJA PUESTA DE VINO");
            hayCajaPuestaVino=false;
            esperarBotellas.signal();
            try {
                embotelladorVino.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
        cantBotellasVino++;
        System.out.println(Thread.currentThread().getName() +" PUSO BOTELLITA DE VINO "+ " CANT BOTELLAS VINO "+ cantBotellasVino);
        mutex.unlock();       


    }
    public void embotellarAgua(){
        mutex.lock();
        while (cantBotellasAgua>=10 || !hayCajaPuestaAgua){
            System.out.println(Thread.currentThread().getName() +" NO HABIA CAJA PUESTA DE AGUA");
            hayCajaPuestaAgua=false;
            esperarBotellas.signal();
            try {
                embotelladorAgua.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        cantBotellasAgua++;
        System.out.println(Thread.currentThread().getName() +" PUSO BOTELLITA DE AGUA"+ " CANT BOTELLAS AGUA "+ cantBotellasAgua);
        mutex.unlock();       


    }

    public void empezarDia(){
        mutex.lock();
        System.out.println(Thread.currentThread().getName() +" EMPAQUETADOR EMPEIZA EL DIA");
        hayCajaPuestaAgua=true;
        hayCajaPuestaVino=true;
        mutex.unlock();
    }

    public void reponer (){
        mutex.lock();
        while (cantBotellasAgua<10 && cantBotellasVino<10){
            System.out.println(Thread.currentThread().getName() +" NO SE LLENO NINGUNA DE LAS CAJAS");
            try {
                esperarBotellas.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (cantBotellasVino>=10){
            System.out.println(Thread.currentThread().getName() +" SE LLENO UNA CAJA DE VINO");
            cantBotellasVino=0;
            hayCajaPuestaVino=true;
            embotelladorVino.signalAll();
        }
        if (cantBotellasAgua>=10){
            System.out.println(Thread.currentThread().getName() +" SE LLENO UNA CAJA DE AGUA");
            cantBotellasAgua=0;
            hayCajaPuestaAgua=true;
            embotelladorAgua.signalAll();
        }

    
        mutex.unlock();

        mutexCamionero.lock();
        if (cantCajas==cantMaxAlmacen-1){
            System.out.println(Thread.currentThread().getName() +" ALMACEN LLENO LE AVISO AL CAMIONERO");
            cantCajas++;
            almacenLleno.signal();
      
        }
        else{
            cantCajas++;
        }
        System.out.println("--------------------------------- CANTIDAD DE CAJAS EN EL ALMACEN-------------------------------- "+cantCajas);
        mutexCamionero.unlock();
       
        
    }
    public void retirarCajas (){
        mutexCamionero.lock();
        while (cantCajas<cantMaxAlmacen){
            try {
                almacenLleno.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +" LLEVANDOME TODAS LAS CAJAS");
        cantCajas=0;
        mutexCamionero.unlock();
    }

    
}
