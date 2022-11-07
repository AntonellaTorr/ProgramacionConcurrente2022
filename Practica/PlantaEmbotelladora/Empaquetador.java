package Practica.PlantaEmbotelladora;

public class Empaquetador implements Runnable{
    private Planta p;
    public Empaquetador(Planta p ){
        this.p=p;
    }

    
    public void run (){
        p.empezarDia();
        while (true){
        
            p.reponer();
       

        }
        
    }
    public void simular (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
