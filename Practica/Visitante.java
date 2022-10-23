package Practica;

public class Visitante implements Runnable{
    private Parque parque;
    public Visitante (Parque p){
        this.parque=p;

    }

    public void run (){ 
        System.out.println(Thread.currentThread().getName() +"llego al parque..........");
        parque.visitanteAvisaLlegada();
        parque.tirarse();
        System.out.println(Thread.currentThread().getName() +"logra tirarse.........");
        parque.irse();
        System.out.println(Thread.currentThread().getName() +"se va del tobogan.........");

    }
    
}
