package tpOb.HilosDurmientes;

public class ControlReloj implements Runnable {
    private Reloj r;
    public ControlReloj(Reloj r){
        this.r=r;
    }
    @Override

    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.despertarPrimerHilo();
            System.out.println("Desperto al primer hilo");
            r.esperarZZZ();
            System.out.println("Estan todos durmiendo de nuevo ");
        }
        
        
    }

  
    
}
