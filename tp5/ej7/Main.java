package tp5.ej7;

public class Main {
    public static void main(String[] args) {
        Thread babuinos []= new Thread[10];
        Puente p = new Puente(5);
        for (int i=0;i<babuinos.length;i++){
            babuinos[i]= new Thread( new Babuino(p));
        }
        for (int i=0;i<babuinos.length;i++){
            babuinos[i].start();
        }

    }
    
}
