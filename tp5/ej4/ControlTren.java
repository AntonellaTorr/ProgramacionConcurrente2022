package tp5.ej4;

public class ControlTren implements Runnable {
    private CentroTuristico c;

    public ControlTren (CentroTuristico c){
        this.c=c;
    }

    public void run () {

        while (true){
            c.comenzarViaje();
            c.avisarInicioViaje();
            System.out.println("**************************************");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            c.avisarFinViaje();
            System.out.println("-------------------------------------------------------------");
        }
       
    }
    
}
