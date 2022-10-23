package tp5.ej4;

public class Pasajero  implements Runnable{
    private CentroTuristico c;

    public Pasajero (CentroTuristico c){
        this.c=c;
    }

    public void run (){
        c.ingresarAComprarTicket();
        System.out.println(Thread.currentThread().getName()+" ingresa a comprar un ticket");
        c.iniciarCompra();
        c.comprarTicket();
        System.out.println(Thread.currentThread().getName()+" compra ticket");
        c.salirDeComprar();        
        System.out.println(Thread.currentThread().getName()+" se va del puesto de venta de ticket");
        c.ingresarAlTren();
        c.ocuparAsiento();
        System.out.println(Thread.currentThread().getName()+" ocupa asiento en el tren");
        c.iniciarViaje();
        System.out.println(Thread.currentThread().getName() +" ya inicio el viaje en tren ");
       
        c.finalizarViaje();
        System.out.println(Thread.currentThread().getName() +" ya finalizo el viaje en tren ");
        c.liberarAsiento();
    }
    
    
}
