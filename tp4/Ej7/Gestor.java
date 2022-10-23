package tp4.Ej7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gestor {
    private Semaphore mutexAutosGestor;
    private boolean semNorteVerde;
    private boolean semOesteVerde;


    public void Gestor(){
        Random r= new Random();
        int n= r.nextInt(2);
        if (n==0){
            semNorteVerde=true;
            semOesteVerde=false;

        }else{
            semNorteVerde=false;
            semOesteVerde=true;
        }

    }
    public void cambiarSemaforo(){
        try {
            mutexAutosGestor.acquire();
            if (semNorteVerde=true){
                semNorteVerde=false;
                semOesteVerde=true;
            }else{
                //si no esta en verde significa que el oeste lo esta
                semOesteVerde=false;
                semNorteVerde=true;
            }
            mutexAutosGestor.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void ingresarOeste (){
      try {
        mutexAutosGestor.acquire();
        if (semOesteVerde){
            
        }

    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
