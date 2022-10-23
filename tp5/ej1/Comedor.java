package tp5.ej1;

import java.util.concurrent.Semaphore;


public class Comedor {
    private Semaphore tomar;
    private Semaphore comer;
    private Semaphore prepararBebida;
    private Semaphore prepararComida;
    private Semaphore sillasComedor;

    public Comedor (int cantSillas){
        tomar= new Semaphore(0);
        comer=new Semaphore(0);
        prepararBebida=new Semaphore(0);
        prepararComida=new Semaphore(0);
        sillasComedor= new Semaphore(cantSillas);
    }
    public void pedirComida (){
        prepararComida.release();
    }
    public void prepararComida(){
        try {
            prepararComida.acquire();
        } catch (Exception e) {
        }
    }

    public void pedirBebida (){
        prepararBebida.release();
    }
    public void prepararBebida(){
        try {
            prepararBebida.acquire();
        } catch (Exception e) {
        }
    }
    public void sentarse (){
        try {
            sillasComedor.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void irse(){
        sillasComedor.release();
    }
    public void comer(){
        try {
            comer.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void avisaComidaLista (){
        comer.release();
    }
    public void avisaBebidaLista (){
        tomar.release();
    }
    public void tomar(){
        try {
            tomar.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
