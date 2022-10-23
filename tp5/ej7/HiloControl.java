package tp5.ej7;

public class HiloControl implements Runnable{
    private Puente p;
    public void run (){
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char lado= p.getLadoHabilitado();
            if (lado=='I'){
                System.out.println("HILO CONTROL CAMBIO LADO DE BABUINOS A DERECHA");
                p.setLadoHabilitado('D');
            }
            else{
                
                System.out.println("HILO CONTROL CAMBIO LADO DE BABUINOS A IZQUIERDA");
                p.setLadoHabilitado('I');
            }
            p.dejarPasarBabuinos();
        }
    }
    
}
