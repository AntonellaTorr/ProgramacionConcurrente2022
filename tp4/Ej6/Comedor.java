package tp4.Ej6;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore mutex;
    private Semaphore clienteMozo;
    private Semaphore mozoCliente;


    public Comedor (){
        mutex= new Semaphore(1);
        clienteMozo= new Semaphore(0);
        mozoCliente= new Semaphore(0);
    }

    public void notificarLlegadaAlComedor() {
        clienteMozo.release();
    }
    public boolean puedoIngresarAlComedor(){
        return mutex.tryAcquire();
    }
    public void irse(){
        mutex.release();
    }

    public void notificarComidaLista(){
        mozoCliente.release();
        System.out.println("La comida esta lista");
    }

    public void empezarAAtender(){
        try {
            clienteMozo.acquire();
            System.out.println("El mozo empieza a atender");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void empezarAComer (){
        try {
            mozoCliente.acquire();
            System.out.println( Thread.currentThread().getName()+ " empieza a comer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}
