package tp4.Ej5;

public class Taxista implements Runnable {
    private Taxi t;
    public Taxista (Taxi t){
        this.t=t;

    }
    public void run (){

        while (true){
            System.out.println("Taxista durmiendo");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            t.comenzarATrabajar();
            try {
                System.out.println("Taxista manejando ");
                Thread.sleep(100);
            } catch (Exception e) {
            }
            t.notificarLlegada();
        }
     


    }
}
