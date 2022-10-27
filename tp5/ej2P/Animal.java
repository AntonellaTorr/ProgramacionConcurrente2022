package tp5.ej2P;

public class Animal implements Runnable{
    private char tipo;
    private Centro c;

    public Animal(char tipo, Centro c){
        this.tipo= tipo;
        this.c=c;
    }

    public void run (){
        c.setearPrioridadAnimal(tipo);
        c.entrar(tipo);
        this.comer();
        c.irse(tipo);




    }
    public void comer (){
        try {
            System.out.println(Thread.currentThread().getName()+" COMIENDOOOO");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
