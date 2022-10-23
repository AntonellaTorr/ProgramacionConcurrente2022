package tp4.Ej4;

import java.util.concurrent.Semaphore;

public class Impresora {
    private Semaphore sem;
    private char tipo;


    public Impresora (char tipo){
        sem= new Semaphore(1);
        this.tipo=tipo;
    }
    public char getTipo(){
        return tipo;
    }
    public Semaphore getSemaforo(){
        return sem;
    }

}
