package tp5.ej1;

import java.util.Random;

public class Empleado implements Runnable{
    private Comedor c;

    public Empleado (Comedor c){
        this.c=c;
    }

    public void run (){
        Random r= new Random();
        int n=r.nextInt(3);
        System.out.println(Thread.currentThread().getName()+" nro generado "+ n);
        if (n==0){
            this.pedidosBebida();

        }else{
            if(n==1){
                this.pedidosComida();
            }
            else{
                this.pedidosBebida();
                this.pedidosComida();
            }
        }
        c.irse();

    }
    public void pedidosComida(){
        c.pedirComida();
        c.comer();
        System.out.println(Thread.currentThread().getName()+ "  comiendo........");
        this.simular();        
        System.out.println(Thread.currentThread().getName()+ "  finaliza de comer ........");


    }
    public void pedidosBebida (){
        c.pedirBebida();
        c.tomar();
        System.out.println(Thread.currentThread().getName()+ "  tomando........");
        this.simular();        
        System.out.println(Thread.currentThread().getName()+ "  finaliza de tomar........");
    }
    public void simular(){
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
