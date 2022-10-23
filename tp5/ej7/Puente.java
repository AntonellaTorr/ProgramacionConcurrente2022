package tp5.ej7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Puente {
    private char ladoHabilitado;
    private Semaphore espacioPuente;
    private Semaphore semEspera;
    private int cantBabuinosPermitidos;

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
        espacioPuente= new Semaphore(cantBabuinosPermitidos);
        semEspera=new Semaphore(0);
    }

    public char getLadoHabilitado (){
        return ladoHabilitado;
    }
    public void setLadoHabilitado (char lado){
        this.ladoHabilitado=lado;
    }
    public void dejarPasarBabuinos(){
        semEspera.release(cantBabuinosPermitidos);
    }

    public void esperarHabilitacionLado(){
        try {
            semEspera.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void cruzarPuente(){
        try {
            espacioPuente.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void liberarEspacioPuente(){
        espacioPuente.release();
    }
    
}
