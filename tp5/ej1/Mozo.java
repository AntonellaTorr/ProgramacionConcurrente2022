package tp5.ej1;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo (Comedor c){
        this.c=c;
    }
    public void run (){
        while (true){
            c.prepararBebida();
            System.out.println("Mozo comienza a preparar la bebida........");
            this.prepararBebida();
            System.out.println("Mozo finaliza de preparar la bebida.........");
            c.avisaBebidaLista();

        }
    }
    public void prepararBebida (){
        try {
            Thread.currentThread().sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
