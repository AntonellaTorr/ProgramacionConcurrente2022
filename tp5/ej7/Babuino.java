package tp5.ej7;

import java.util.Random;
//que pasa si mientras algunos estan esperando para hacer un acquire del semPaso del puente el hilo hace el cambio
public class Babuino{
    private Puente p;
    public Babuino (Puente p){
        this.p=p;
    }
}
