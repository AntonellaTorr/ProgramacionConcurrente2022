package tp5.ej5;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore comenzarAterrizaje, comenzarDespegue;
    private Semaphore mutexPista, mutex, cambiarPrioridad;
    private int cantTotalAterrizaje, cantTotalDespegue,maximo, cantEsperandoAterrizaje, cantEsperandoDespegue;
    private char prioridad;

    public Pista (){
        comenzarAterrizaje= new Semaphore(maximo);
        comenzarDespegue= new Semaphore(0);
        prioridad='D';


    }

    public void cambiarPrioridad(char prioridadNueva){
        if (cambiarPrioridad.tryAcquire()){
            if (prioridadNueva=='D'){
                comenzarDespegue.release(maximo);
            }
            else{
                comenzarAterrizaje.release(maximo);
            }

        }

    }


    
    public void puedeDespegar (){
        try {
            comenzarDespegue.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void puedeAterrizar(){
        try {
            comenzarAterrizaje.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void comenzarAterrizar(){
        try {
            mutexPista.acquire();
            cantTotalAterrizaje++;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void finalizarAterrizaje(){
        mutexPista.release();
    }
    public void comenzarDespegue (){
        try {
            mutexPista.acquire();
            cantTotalDespegue++;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void finalizarDespegue(){
        mutexPista.release();
    }

    public void abandonarPistaAterrizaje(){
      
        try {
            mutex.acquire();
            if (cantTotalAterrizaje >= maximo) {
                if (cantEsperandoDespegue > 0) {
                    System.out.println(Thread.currentThread().getName() +"  se llego al limite de aterrizajes y hay despegues esperando");

                    comenzarDespegue.release(maximo);

                } else {
                    // no hay perros
                    if (cantEsperandoAterrizaje > 0) {
                        System.out.println(Thread.currentThread().getName() +"  se llego al aterrizajes NO HABIA DESPEGUES");
                        // pero si gatos
                        comenzarAterrizaje.release();
                    } else {
                        System.out.println(Thread.currentThread().getName() +"  se llego al limite de aterrizajes pero no hay aterrizajes ni despegues");
                        // SETEAR EN 0
                        // no hay niguno de los 2
                        comenzarAterrizaje = new Semaphore(0);
                        cambiarPrioridad.release();
                        //ESTO VA ACA?
                        this.cambiarPrioridad('D');

                    }
                }
            } else {
                // si no llegue al limite
                // si no vienen mas aterrizajess por el momento
                System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes");
                if (cantEsperandoAterrizaje == 0) {
                    if (cantEsperandoDespegue > 0) {
                        System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes PERO SI despegues");
                        comenzarAterrizaje = new Semaphore(0);
                        comenzarDespegue.release(maximo);
                    } else {
                        // si no viene nadi
                        System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes NI despegues");
                        comenzarAterrizaje = new Semaphore(0);
                        cambiarPrioridad.release();
                    }

                }
            }  
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
               
    }
    public void abandonarPistaDespuegue(){
      
        if (cantTotalDespegue >= maximo) {
            if (cantEsperandoAterrizaje > 0) {
                System.out.println(Thread.currentThread().getName() +"  se llego al limite de despegues y hay aterrizajes esperando");

                comenzarAterrizaje.release(maximo);

            } else {
                // no hay perros
                if (cantEsperandoDespegue > 0) {
                    System.out.println(Thread.currentThread().getName() +"  se llego a los despgues pero NO HABIA aterrizajes");
                    // pero si gatos
                    comenzarDespegue.release();
                } else {
                    System.out.println(Thread.currentThread().getName() +"  se llego al limite de despgues pero no hay aterrizajes ni despegues");
                    // SETEAR EN 0
                    // no hay niguno de los 2
                    comenzarDespegue = new Semaphore(0);
                    cambiarPrioridad.release();
                    //ESTO VA ACA?
                    this.cambiarPrioridad('A');

                }
            }
        } else {
            // si no llegue al limite
            // si no vienen mas aterrizajess por el momento
            System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes");
            if (cantEsperandoDespegue == 0) {
                if (cantEsperandoAterrizaje > 0) {
                    System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes PERO SI despegues");
                    comenzarDespegue = new Semaphore(0);
                    comenzarAterrizaje.release(maximo);
                } else {
                    // si no viene nadi
                    System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes NI despegues");
                    comenzarDespegue = new Semaphore(0);
                    cambiarPrioridad.release();
                }

            }
        }  
}

}
