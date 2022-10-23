package tp4.Ej5;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore clienteTaxista; //utilizado para que el cliente se comunique con el taxista
    private Semaphore taxistaCliente;//utilizado para que el taxista se comunique con el cliente

    public Taxi(){
        clienteTaxista= new Semaphore(0);
        taxistaCliente= new Semaphore(0);
    }

    public void notificarNecesidadServicioTaxi() {
        clienteTaxista.release();
        
    }
    public void comenzarATrabajar(){
        try {
            clienteTaxista.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void notificarLlegada() {
        taxistaCliente.release();
        
    }
    public void bajarse (){
        try {
            taxistaCliente.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
