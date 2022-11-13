package PracticaSegundoP.MontañaRusa;

public class Pasajero implements Runnable {
    private Parque p;

    public Pasajero (Parque p){
        this.p=p;
    }

    public void run(){
        int cantVueltas= p.getCantRecorridos(),i=0;

        while(i<cantVueltas){
            p.llegaPasajero();
            p.bajarse();
            System.out.println(Thread.currentThread().getName()+" VA A RECORRER EL PARQUE ");
            recorrerParque();
            i++;     

    }
}

    public void recorrerParque() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}