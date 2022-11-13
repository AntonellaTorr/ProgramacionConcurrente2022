package PracticaSegundoP.PerrosAlaska;

public class Perro implements Runnable{
    private Albergue a;

    public Perro (Albergue a){
        this.a=a;
    }

    public void run (){
        a.comer();
        this.comiendo();

    }
    public void comiendo (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
