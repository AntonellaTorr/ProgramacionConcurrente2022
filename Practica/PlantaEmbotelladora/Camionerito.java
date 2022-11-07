package Practica.PlantaEmbotelladora;

public class Camionerito implements Runnable{
    private Planta p;

    public Camionerito(Planta p ){
        this.p=p;
    }



    public void run (){
        while (true){
            p.retirarCajas();
        }
    }
}
