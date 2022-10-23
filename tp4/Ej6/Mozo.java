package tp4.Ej6;

public class Mozo implements Runnable {
    private Comedor c;
    public Mozo(Comedor c){
        this.c=c;
    }
    public void run (){

        while (true){

            System.out.println( "--------------------Inventando recetas-----------------");
            c.empezarAAtender();
            System.out.println( "Prepara comida............");
            
            c.notificarComidaLista();
        }
      


    }
}
