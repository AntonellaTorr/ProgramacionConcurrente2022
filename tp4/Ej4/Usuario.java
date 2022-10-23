package tp4.Ej4;

import java.util.Random;

public class Usuario implements Runnable{
    
    private char [] tipoImpresion= {'A','B','X'};
    private Centro c;

    public Usuario( Centro c) {
        this.c=c;
        
    }

    public void run (){
        //realiza pedido
        Random r= new Random();
        int nro=r.nextInt(3);
        char pedidoImpresion=tipoImpresion[nro];
        System.out.println(Thread.currentThread().getName() +" genero pedido de impresion de tipo "+pedidoImpresion);

        int n= c.comenzarAImprimir(pedidoImpresion);
        System.out.println(Thread.currentThread().getName() +" comenzando a imprimir  "+pedidoImpresion + " .........");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
        c.finalizarImprimir(n);
        System.out.println(Thread.currentThread().getName() +" finalizo de imprimir ");


      
              
    }

        


        

    }

