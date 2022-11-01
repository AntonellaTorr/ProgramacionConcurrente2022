package tp6.ej2;

public class Main {
    public static void main(String[] args) {
        Thread personas[]= new Thread[10];
        GestorSala g= new GestorSala();

        for (int i=0;i<personas.length;i++){
            personas[i]= new Thread(new Persona(g));

        }
        Thread hiloControlador= new Thread(new HiloControlador(g));
        
        for (int i=0;i<personas.length;i++){
            personas[i].start();

        }
        hiloControlador.start();
    }
    
}
