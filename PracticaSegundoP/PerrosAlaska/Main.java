package PracticaSegundoP.PerrosAlaska;

public class Main {
    public static void main(String[] args) {
        Albergue a= new Albergue(5);
        Thread perros[]= new Thread[10];
        Thread encargado= new Thread(new Encargado(a));

        for (int i=0;i<perros.length;i++){
            perros[i]= new Thread(new Perro(a), "Perro "+i);

        }
        for (int i=0;i<perros.length;i++){
            perros[i].start();
            
        }

       encargado.start();

    }
    
}
