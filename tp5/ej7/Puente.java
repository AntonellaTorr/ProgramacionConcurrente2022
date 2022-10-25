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
        this.cantBabuinosPermitidos=cantBabuinos;
     
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
            } else{
                try {
                    mutex.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                cantBabuinosPasando++;
                if (cantBabuinosPasando==capacidadSoga){
                    semIzquierda.release(capacidadSoga);
                }
                else{
                    semDerecha.release();
                }
                mutex.release();
                
            }
        }
    }



    
}
