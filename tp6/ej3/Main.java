package tp6.ej3;

public class Main {
    public static void main(String[] args) {
        Thread soldados[]= new Thread [10];

        Comedor c= new Comedor(5, 5, 3, 10);

        for (int i=0; i<soldados.length; i++){
            soldados[i]= new Thread(new Soldado(c));
        }
        for (int i=0; i<soldados.length; i++){
            soldados[i].start();
        }
    }
    
}
