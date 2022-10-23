package tp5.ej4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CentroTuristico c= new CentroTuristico(5);
        Random r= new Random();
        Thread control= new Thread(new ControlTren(c), "ControlTren");
        Thread vendedor= new Thread(new VendedorTickets(c), "Vendedor");
        int cantPasajeros=10; r.nextInt(10);
        Thread pasajeros[]= new Thread [cantPasajeros];
        for (int i=0;i<pasajeros.length;i++){
            pasajeros[i]= new Thread(new Pasajero(c));
        }
        for (int i=0;i<pasajeros.length;i++){
            pasajeros[i].start();
        }
        control.start();
        vendedor.start();


        

    }
}
