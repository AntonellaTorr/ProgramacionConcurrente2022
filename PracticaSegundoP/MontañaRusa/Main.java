package PracticaSegundoP.MontañaRusa;

public class Main {
    public static void main(String[] args) {
        Thread pasajeros[]= new Thread[5];
        Parque p= new Parque(5, 2);
        Thread montañaRusa= new Thread(new MontañaRusa(p), "MONTAÑA");
        for (int i=0; i<pasajeros.length;i++){
            pasajeros[i]= new Thread(new Pasajero(p), "Pasajero "+i);
        }
        for (int i=0; i<pasajeros.length;i++){
            pasajeros[i].start();
        }
        montañaRusa.start();
    }
}
