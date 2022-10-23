package tp4.Ej5;

public class Cliente implements Runnable {
    private Taxi t;
    public Cliente(Taxi t) {
        this.t=t;
        
    }
    public void run (){
        System.out.println(" Buscando taxi......................");
        t.notificarNecesidadServicioTaxi();
        System.out.println( "Cliente sube al taxi");
        t.bajarse();
        System.out.println( "Cliente se va del taxi");

        
    }
    
}
