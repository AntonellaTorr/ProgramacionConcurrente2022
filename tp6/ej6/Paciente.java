package tp6.ej6;

public class Paciente implements Runnable{
    private Centro c;
    
    public Paciente (Centro c){
        this.c=c;
    }
    
    public void run(){
        c.entrarSala();
        System.out.println(Thread.currentThread().getName()+": Consegui camilla");
        this.sacarSangre();
        c.salirSala();
    }
    
    private void sacarSangre(){
        try {
            System.out.println(Thread.currentThread().getName()+": Sacandome sangre!!");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
   }
