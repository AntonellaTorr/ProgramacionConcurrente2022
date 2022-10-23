/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej2;

/**
 *
 * @author Antonella
 */
public class Curandero implements Runnable{
    private Vida vidaParaCurar;
    
    public void run (){
        this.curar();
    }
    
    public void curar (){
        
         System.out.println("Vida antes de curar "+vidaParaCurar.getVida());
         try{
             Thread.sleep(100);
         }catch(InterruptedException ex){
             
         }
        vidaParaCurar.curar(3);
         System.out.println("Vida despues de curar "+vidaParaCurar.getVida());
    }

    public Curandero(Vida vidaParaCurar) {
        this.vidaParaCurar = vidaParaCurar;
    }
}
