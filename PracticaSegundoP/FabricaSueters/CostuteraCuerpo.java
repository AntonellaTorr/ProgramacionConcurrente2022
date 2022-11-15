package PracticaSegundoP.FabricaSueters;

public class CostuteraCuerpo implements Runnable {
    private Fabrica f;

    public void run (){
        while (true){
            this.simularTiempo();
            f.cocerCuerpos();
        }
        
    }
    private void simularTiempo(){
        try {
            System.out.println(Thread.currentThread().getName()+": generando cuerpo...........");
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
