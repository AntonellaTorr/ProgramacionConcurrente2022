package tp5.ej4;

public class VendedorTickets implements Runnable{

    private CentroTuristico c;

    public VendedorTickets (CentroTuristico c){
        this.c=c;
    }
    public void run (){
        while (true){
            c.iniciarVenta();
            System.out.println(Thread.currentThread().getName() +" inicia venta de tickets..........");
            try {
                //simula venta
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
            c.venderTicket();
            System.out.println(Thread.currentThread().getName() +" vendio ticket.........");
    
        }
       
    }
    
}
