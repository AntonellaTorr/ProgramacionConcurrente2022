package Practica.PlantaEmbotelladora;

public class Main {
    public static void main(String[] args) {
        Planta p= new Planta();
        Thread embotelladores[]= new Thread [30];

        Thread camionerito= new Thread(new Camionerito(p), "Camionerito");

        Thread empaquetador= new Thread(new Empaquetador(p), "Empaquetador");

        for (int i=0;i<embotelladores.length;i++){
            embotelladores[i]= new Thread(new Embotellador(p), "Embotellador "+i);
        }
        for (int i=0;i<embotelladores.length;i++){
            embotelladores[i].start();
        }
        camionerito.start();
        empaquetador.start();
    }
    
}
