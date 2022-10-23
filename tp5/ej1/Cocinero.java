package tp5.ej1;

public class Cocinero implements Runnable  {
    private Comedor c;
    public Cocinero (Comedor c){
        this.c=c;
    }
    public void run (){
        while (true){
            c.prepararComida();
            System.out.println("Cocinero comienza a preparar la comida.........");
            this.prepararComida();
            System.out.println("Cocinero finaliza de preparar.........");
            c.avisaComidaLista();

        }
    }
    public void prepararComida (){
        try {
            Thread.currentThread().sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


}
