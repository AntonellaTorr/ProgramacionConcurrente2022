package tp4.Ej1;

public class Main {
    public static void main(String[] args) {
        SynchronizedCounter a= new SynchronizedCounter();

        Thread b[]= new Thread[10];
    
        for(int i=0; i<10;i++){
            b[i]= new Thread(new UsoContador(a));
        }
    }
  





}
