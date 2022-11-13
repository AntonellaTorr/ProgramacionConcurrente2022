package PracticaSegundoP.MontañaRusa;

import java.util.concurrent.Semaphore;

public class Parque {
    private Semaphore ingresar;
    private Semaphore bajarse;
    private Semaphore comenzarRecorrido;
    private int capacidadMontania, cantRecorridos;


    public Parque (int capacidad, int cantRecorridos){
        this.capacidadMontania=capacidad;
        ingresar= new Semaphore(capacidad);
        bajarse= new Semaphore(0);
        comenzarRecorrido= new Semaphore(0);
        this.cantRecorridos=cantRecorridos;

    }
    public int getCantRecorridos (){
        return cantRecorridos;
    }
    
    public void llegaPasajero (){
        try {
            ingresar.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " LOGRO INGRESAR A LA MONTAÑA RUSA");
        comenzarRecorrido.release();
    }

    public void bajarse(){
        try {
            bajarse.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " SE BAJO");
        ingresar.release();
    }
    public void iniciarRecorrido(){
        try {
            comenzarRecorrido.acquire(capacidadMontania);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void finalizarRecorrido (){
        bajarse.release(capacidadMontania);
    }
    
}
