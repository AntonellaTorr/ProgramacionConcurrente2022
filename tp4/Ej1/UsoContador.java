package tp4.Ej1;

public class UsoContador implements Runnable {
    SynchronizedCounter a;

    public UsoContador(SynchronizedCounter a){
        this.a=a;
    }
    public void run() {
        for (int i=0;i<5;i++){
            a.decrement();
            a.increment();
        }
        
      
    }
    
}
