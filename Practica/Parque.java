package Practica;

import java.util.concurrent.Semaphore;

public class Parque {
    private Semaphore tobogan1;
    private Semaphore tobogan2;
    //semaforos para comunicacion entre los visitantes y el encargado
    private Semaphore llegadaTobogan;
    private Semaphore tirarseTobogan;
    private Semaphore irseParque;
    

    public Parque (){
        tobogan1= new Semaphore(1);
        tobogan2= new Semaphore(1);
        llegadaTobogan= new Semaphore(0);
        tirarseTobogan= new Semaphore(0);
        irseParque=new Semaphore(0);


    }

    public boolean intentarOcuparTobogan1(){
        return tobogan1.tryAcquire();
    }
    public boolean  intentarOcuparTobogan2(){
        return tobogan2.tryAcquire();
    }
    public void ocuparTobogan1(){
        try{ tobogan1.acquire();} catch(InterruptedException e){}
    }
    public void ocuparTobogan2(){
        try{ tobogan2.acquire();} catch(InterruptedException e){}
    }

    public void desocuparTobogan1(){
        tobogan1.release();
    }
    public void desocuparTobogan2(){
        tobogan2.release();
    }
    public void visitanteAvisaLlegada (){
        llegadaTobogan.release();
    }
    public void permitirTirarse(String lado){
        tirarseTobogan.release();
        System.out.println("VISITANTE SE TIRA POR LADO: "  +lado);
    }
   
    public void tirarse() {
        try {
            tirarseTobogan.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void irse(){
        irseParque.release();

    }
    public void esperarFinalizacion(){
        try {
            irseParque.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperarVisitante(){
        try {
            llegadaTobogan.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    



}
