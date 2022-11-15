package PracticaSegundoP.FabricaSueters;

public class CostureraManga implements Runnable {
    private Fabrica f;


    public void run (){
        while (true){
            this.simularTiempo();
            f.cocerMangas();

        }
    }

    private void simularTiempo(){
        try {
            System.out.println(Thread.currentThread().getName()+": generando manga...........");
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
