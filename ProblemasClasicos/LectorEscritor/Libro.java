package ProblemasClasicos.LectorEscritor;

import java.util.concurrent.Semaphore;

public class Libro {
    private Semaphore accesoLibro;
    private Semaphore mutexLectoresEscritores;
    private boolean hayEscrito;
    private int cantMaxima;
    private int cantPaginas;


    public void setHayEscrito(boolean hayEscrito){
        try {
            mutexLectoresEscritores.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.hayEscrito=hayEscrito;
        mutexLectoresEscritores.release();


    }
    public boolean  getHayEscrito(){
        return hayEscrito;
    }

    public void  empezarAleer(){
        try {
            accesoLibro.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void finalizarDeLeer(){
        accesoLibro.release();
    }

    public void comenzarAEscribir (){
        try {
            accesoLibro.acquire(cantMaxima);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void finalizarDeEscribir(){
        accesoLibro.release(cantMaxima);
    }
}
