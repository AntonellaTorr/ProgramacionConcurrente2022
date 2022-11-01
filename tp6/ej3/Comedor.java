package tp6.ej3;

import java.util.concurrent.Semaphore;



public class Comedor {
    private Semaphore tomarBandeja;
    private Semaphore tomarComidaMostrador;
    private Semaphore abridor;
    private Semaphore tomarPostreComedor;
    private int capacidadComedor, cantMostradoresComida, cantMostradoresPostre, cantAbridores;



    public Comedor (int capacidadComedor, int cantMostradoresComida, int cantMostradoresPostre, int cantAbridores){
        this.capacidadComedor=capacidadComedor;
        this.cantMostradoresComida=cantMostradoresComida;
        this.cantMostradoresPostre=cantMostradoresPostre;
        this.cantAbridores=cantAbridores;
        tomarBandeja= new Semaphore(capacidadComedor);
        tomarComidaMostrador= new Semaphore(cantMostradoresComida);
        tomarPostreComedor= new Semaphore(cantMostradoresPostre);
        abridor= new Semaphore(cantAbridores);


    }

    public void tomarBandeja(){
        try {
            tomarBandeja.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void tomarComidaMostrador(){
        try {
            tomarComidaMostrador.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void abandonarMostradorComida (){
        tomarComidaMostrador.release();
    }
    public void tomarPostreComedor(){
        try {
            tomarPostreComedor.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void abandonarMostradorPostre(){
        tomarPostreComedor.release();
    }
    public void agarrarAbridor(){
        try {
            abridor.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dejarAbridor (){
        abridor.release();
    }
    public void irse(){
        tomarBandeja.release();
    }
    

    }

