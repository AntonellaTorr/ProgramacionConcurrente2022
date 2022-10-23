package tp4.Ej5;

public class Main {
    public static void main(String[] args) {
        Taxi t= new Taxi();
        Thread cliente= new Thread (new Cliente(t));
        Thread taxista= new Thread(new Taxista(t));

        cliente.start();
        taxista.start();
    }
    
}
