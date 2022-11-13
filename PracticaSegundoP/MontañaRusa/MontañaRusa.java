package PracticaSegundoP.MontañaRusa;

public class MontañaRusa implements Runnable{
    private Parque p;
    public MontañaRusa(Parque p){
        this.p=p;
    }
    public void run (){
        int cantVueltas= p.getCantRecorridos(),i=0;

        while(i<cantVueltas){
            p.iniciarRecorrido();
            System.out.println("-------------------------------------- EMPEZANDO EL RECORRIDO---------------------------------------------");
            this.enRecorrido();
            p.finalizarRecorrido();
            System.out.println("-------------------------------------- FINALIZO EL RECORRIDO---------------------------------------------");
            i++;
        }
    }

    public void enRecorrido(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
