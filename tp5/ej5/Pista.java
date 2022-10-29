package tp5.ej5;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore comenzarAterrizaje, comenzarDespegue;
    private Semaphore mutexPista, mutex, cambiarPrioridad;
    private int cantTotalAterrizaje, cantTotalDespegue, maximo, cantEsperandoAterrizaje, cantEsperandoDespegue;
  
    

    public Pista(int maximo) {
        this.maximo=maximo;
        comenzarAterrizaje = new Semaphore(maximo);
        comenzarDespegue = new Semaphore(0);
        mutexPista= new Semaphore(1);
        mutex= new Semaphore(1);
        cambiarPrioridad= new Semaphore(1);
        cantEsperandoAterrizaje=0;
        cantEsperandoDespegue=0;
        cantTotalAterrizaje=0;
        cantTotalDespegue=0;

    }

    public void cambiarPrioridad(char prioridadNueva) {
        if (cambiarPrioridad.tryAcquire()) {
            if (prioridadNueva == 'D') {
                comenzarDespegue.release(maximo);
            } else {
                comenzarAterrizaje.release(maximo);
            }

        }

    }

    public void puedeDespegar() {
        try {
            mutex.acquire();
            cantEsperandoDespegue++;
            mutex.release();
            comenzarDespegue.acquire();
           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void puedeAterrizar() {
        try {
            mutex.acquire();
            cantEsperandoAterrizaje++;
            mutex.release();
            comenzarAterrizaje.acquire();
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void comenzarAterrizar() {
        try {
            mutexPista.acquire();


            mutex.acquire();
            cantEsperandoAterrizaje--;
            cantTotalAterrizaje++;
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finalizarAterrizaje() {
        mutexPista.release();
    }

    public void comenzarDespegue() {
        try {
            mutexPista.acquire();

            mutex.acquire();
            cantEsperandoDespegue--;
            cantTotalDespegue++;
            mutex.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void finalizarDespegue() {
        mutexPista.release();
    }

    public void abandonarPistaAterrizaje() {

        try {
            mutexPista.acquire();
            mutex.acquire();
            if (cantTotalAterrizaje >= maximo) {
                if (cantEsperandoDespegue > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + "  se llego al limite de aterrizajes y hay despegues esperando");

                    comenzarDespegue.release(maximo);

                } else {
                    // no hay perros
                    if (cantEsperandoAterrizaje > 0) {
                        System.out.println(
                                Thread.currentThread().getName() + "  se llego al aterrizajes NO HABIA DESPEGUES");
                        // pero si gatos
                        comenzarAterrizaje.release();
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "  se llego al limite de aterrizajes pero no hay aterrizajes ni despegues");
                        // SETEAR EN 0
                        // no hay niguno de los 2
                        comenzarAterrizaje = new Semaphore(0);
                        cambiarPrioridad.release();
                        // ESTO VA ACA?
                        this.cambiarPrioridad('D');

                    }
                }
            } else {
                // si no llegue al limite
                // si no vienen mas aterrizajess por el momento
                System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de aterrizajes");
                if (cantEsperandoAterrizaje == 0) {
                    if (cantEsperandoDespegue > 0) {
                        System.out.println(Thread.currentThread().getName()
                                + "  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes PERO SI despegues");
                        comenzarAterrizaje = new Semaphore(0);
                        comenzarDespegue.release(maximo);
                    } else {
                        // si no viene nadi
                        System.out.println(Thread.currentThread().getName()
                                + "  NO se llego al limite de aterrizajes Y NO HABIA MAS aterrizajes NI despegues");
                        comenzarAterrizaje = new Semaphore(0);
                        
                    }

                }
            }
            mutex.release();
            mutexPista.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void abandonarPistaDespuegue() {
        try{

            mutexPista.acquire();
            mutex.acquire();
            if (cantTotalDespegue >= maximo) {
                if (cantEsperandoAterrizaje > 0) {
                    System.out.println(Thread.currentThread().getName()
                            + "  se llego al limite de despegues y hay aterrizajes esperando");

                    comenzarAterrizaje.release(maximo);

                } else {
                    // no hay perros
                    if (cantEsperandoDespegue > 0) {
                        System.out.println(
                                Thread.currentThread().getName() + "  se llego a los despegues pero NO HABIA aterrizajes");
                        // pero si gatos
                        comenzarDespegue.release();
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "  se llego al limite de despegues pero no hay aterrizajes ni despegues");
                        // SETEAR EN 0
                        // no hay niguno de los 2
                        comenzarDespegue = new Semaphore(0);
                        cambiarPrioridad.release();
                        // ESTO VA ACA?
                        this.cambiarPrioridad('A');

                    }
                }
            } else {
                // si no llegue al limite
                // si no vienen mas aterrizajess por el momento
                System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de despgues");
                if (cantEsperandoDespegue == 0) {
                    if (cantEsperandoAterrizaje > 0) {
                        System.out.println(Thread.currentThread().getName()
                                + "  NO se llego al limite de despegues Y NO HABIA MAS despgues PERO SI aterrizajes");
                        comenzarDespegue = new Semaphore(0);
                        comenzarAterrizaje.release(maximo);
                    } else {
                        // si no viene nadi
                        System.out.println(Thread.currentThread().getName()
                                + "  NO se llego al limite de despegues Y NO HABIA MAS aterrizajes NI despegues");
                        comenzarDespegue = new Semaphore(0);
                       
                    }

                }
            }

        } catch (InterruptedException e){};
        mutex.release();
        mutexPista.release();
    }

}
