package tp5.ej2P;

import java.util.concurrent.Semaphore;

public class Centro {
    private int cantGatosEsperando, cantPerrosEsperando, cantTotalGatos, cantTotalPerros, limite, cantGatosComiendo,cantPerrosComiendo;
    private Semaphore mutex, entrarPrimerAnimal;
    private Semaphore entrarGatos;
    private Semaphore entrarPerros;
    private Semaphore platos;

    public Centro (int limite, int nroPlatos){
        cantGatosEsperando=0;
        cantPerrosEsperando=0;
        cantGatosComiendo=0;
        cantPerrosComiendo=0;
        cantTotalGatos=0;
        cantTotalPerros=0;
        this.limite=limite;
        mutex= new Semaphore(1);
        entrarPrimerAnimal= new Semaphore(1);
        entrarGatos= new Semaphore(0);
        entrarPerros= new Semaphore(0);
        platos= new Semaphore(nroPlatos);
        


    }


    public void entrar(char tipo) {
        if (tipo=='G'){
            try {
                mutex.acquire();
                cantGatosEsperando++;
                mutex.release();

                entrarGatos.acquire();

                mutex.acquire();
                cantGatosEsperando--;
                mutex.release();

                platos.acquire();

                mutex.acquire();
                cantGatosComiendo++;
                mutex.release();



        
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        }else{
            try {
                mutex.acquire();
                cantPerrosEsperando++;
                mutex.release();

                entrarPerros.acquire();

                mutex.acquire();
                cantPerrosEsperando--;
                mutex.release();

                platos.acquire();

                mutex.acquire();
                cantPerrosComiendo++;
                mutex.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            


        }
        
    }

    public void irse(char tipo){
        platos.release();

        if (tipo=='G'){
            this.irseGato();
        }
        else{
            this.irsePerro();

        }



    }

    private  void irseGato() {
        try {
            mutex.acquire();
            cantGatosComiendo--;
            if (cantGatosComiendo == 0){
                if (cantTotalGatos >= limite) {
                    if (cantPerrosEsperando > 0) {
                        cantGatosComiendo = 0;
                        // hay perros
                        entrarPerros.release(limite);

                    } else {
                        // no hay perros
                        if (cantGatosEsperando > 0) {
                            // pero si gatos
                            entrarGatos.release();
                        } else {
                            // SETEAR EN 0
                            // no hay niguno de los 2
                            entrarGatos = new Semaphore(0);
                            entrarPrimerAnimal.release();

                        }
                    }
                } else {
                    // si no llegue al limite
                    // si no vienen mas gatos por el momento
                    if (cantGatosEsperando == 0) {
                        if (cantPerrosEsperando > 0) {
                            entrarGatos = new Semaphore(0);
                            entrarPerros.release(limite);
                        } else {
                            // si no viene nadie
                            entrarGatos = new Semaphore(0);
                            entrarPrimerAnimal.release();
                        }

                    }
                }  
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
    
    
      
        

    }
    private  void irsePerro() {
        try {
            mutex.acquire();
            cantPerrosComiendo--;
            if (cantPerrosComiendo == 0){
                if (cantTotalPerros >= limite) {
                    if (cantGatosEsperando > 0) {
                        cantPerrosComiendo = 0;
                        // hay gatos
                        entrarGatos.release(limite);

                    } else {
                        // no hay gatos
                        if (cantPerrosEsperando > 0) {
                            // pero si perros
                            entrarPerros.release();
                        } else {
                            // SETEAR EN 0
                            // no hay niguno de los 2
                            entrarPerros = new Semaphore(0);
                            entrarPrimerAnimal.release();

                        }
                    }
                } else {
                    // si no llegue al limite y  no vienen mas perros por el momento
                    if (cantPerrosEsperando == 0) {
                        if (cantGatosEsperando > 0) {
                            entrarPerros = new Semaphore(0);
                            entrarGatos.release(limite);
                        } else {
                            // si no viene nadie
                            entrarPerros = new Semaphore(0);
                            entrarPrimerAnimal.release();
                        }

                    }
                   
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
    
      
        

    }

    public void setearPrioridadAnimal(char tipo) {
        if (entrarPrimerAnimal.tryAcquire()) {
            if (tipo == 'G') {
            
                entrarGatos.release(limite);
            } else {
    
                entrarPerros.release(limite);
            }

        }
    }

}
