package tp5.ej7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Puente {
    private char ladoHabilitado;
    private Semaphore semDerecha;
    private Semaphore semIzquierda;
    private Semaphore mutex;
    private int cantBabuinosEsperandoDer, cantBabuinosEsperandoIzq, cantBabuinosPasando, capacidadSoga;

    public Puente (int cantBabuinos){
        Random r= new Random();
        int n =r.nextInt(2);
        if (n==0){
            ladoHabilitado='I';
        }
        else{
            ladoHabilitado='D';
        }
     
    }
    public void pasar(char lado){
        if (lado=='D'){
            if (!semDerecha.tryAcquire()){
                try {
                    mutex.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                cantBabuinosEsperandoDer++;
                mutex.release();
                try {
                    semDerecha.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    mutex.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                cantBabuinosEsperandoDer--;
                mutex.release();

            } else{
                try {
                    mutex.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                cantBabuinosPasando++;
                if (cantBabuinosPasando==capacidadSoga){
                    if (cantBabuinosEsperandoIzq>0){
                        semIzquierda.release(capacidadSoga);
                    }
                    else{
                        // VER SI ESTA BIEN 
                        semDerecha.release();
                    }
                    
                }
                else{
                    semDerecha.release();
                }
                mutex.release();
                
            }
    }
    else{
        if (!semIzquierda.tryAcquire()){
            try { mutex.acquire();} catch (InterruptedException e) { e.printStackTrace();}
            cantBabuinosEsperandoIzq++;
            mutex.release();

            try {
                semIzquierda.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try { mutex.acquire();} catch (InterruptedException e) { e.printStackTrace();}
            cantBabuinosEsperandoIzq--;
            mutex.release();
        } else{
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cantBabuinosPasando++;
            if (cantBabuinosPasando==capacidadSoga){
                if (cantBabuinosEsperandoDer>0){
                    semDerecha.release(capacidadSoga);
                }
                else{
                    // VER SI ESTA BIEN 
                    semIzquierda.release();
                }
                
            }
            else{
                semIzquierda.release();
            }
            mutex.release();
            
        }

    }
    }

    public void irse (){
        try { mutex.acquire();} catch (InterruptedException e) { e.printStackTrace();}
        cantBabuinosPasando--;
        mutex.release();
    }

}
