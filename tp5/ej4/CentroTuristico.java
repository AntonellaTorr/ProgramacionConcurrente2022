package tp5.ej4;

import java.util.concurrent.Semaphore;

public class CentroTuristico {
    private Semaphore mutexCompraTickets;//controla la exclusion mutua en la venta de pasajes
    private Semaphore asientosTren;//modela la cantidad de asientos del tren
    private Semaphore compraTicket; //rendevous cliente-vendedro
    private Semaphore ticketComprado;//rendevous vendedor-cliente
    private Semaphore comenzarViaje;//el tren comienza el viaje solo cuando todos los asientos estan ocupados
    private Semaphore inicioViaje;// notifica a los pasajeros del inicio del viaje ( verificar si es necesario )
    private Semaphore finViaje;    // notifica a los pasajeros del fin del viaje
    private int cantAsientos;

    public  CentroTuristico (int cantAsientos){
        this.cantAsientos=cantAsientos;
        mutexCompraTickets= new Semaphore(1);
        asientosTren= new Semaphore(cantAsientos);
        compraTicket= new Semaphore(0); 
        ticketComprado= new Semaphore(0);
        comenzarViaje=new Semaphore(0);
        inicioViaje= new Semaphore(0);
        finViaje= new Semaphore(0);

    }
    public void ingresarAComprarTicket(){
        try {
            mutexCompraTickets.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void salirDeComprar(){
        mutexCompraTickets.release();
    }
    public void iniciarCompra(){
        compraTicket.release();
    }
    public void iniciarVenta(){
        try {
            compraTicket.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void comprarTicket(){
        try {
            ticketComprado.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void venderTicket(){
        ticketComprado.release();
    }
    public void ingresarAlTren (){
        try {
            asientosTren.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void liberarAsiento(){
        asientosTren.release();
    }
    public void ocuparAsiento(){
        comenzarViaje.release();
    }
    public void iniciarViaje (){
        try {
            inicioViaje.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void comenzarViaje (){
        try {
            comenzarViaje.acquire(cantAsientos);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void avisarInicioViaje(){
        inicioViaje.release(cantAsientos);

    }
    public void avisarFinViaje(){
        finViaje.release(cantAsientos);
    }
    public void finalizarViaje(){
        try {
            finViaje.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
