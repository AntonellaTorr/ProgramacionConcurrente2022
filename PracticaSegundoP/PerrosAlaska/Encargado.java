package PracticaSegundoP.PerrosAlaska;

public class Encargado implements Runnable{
    private Albergue a;
    public Encargado (Albergue a){
        this.a=a;
    }

    public void run (){
        while (true){
            a.empezarCocina();
            System.out.println(" Cocinandoooo");
            this.cocinar();
            a.avisarFinalizacionCocina();
           
        }
       
    }
    
    public void cocinar (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
