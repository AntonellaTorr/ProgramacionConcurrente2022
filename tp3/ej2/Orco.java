/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej2;

/**
 *
 * @author Antonella
 */
public class Orco implements Runnable {

    public Orco(Vida vidaOponente) {
        this.vidaOponente = vidaOponente;
    }
    private Vida vidaOponente;
    
    public void run (){
        this.golpearOponente();
    }
   
    public void golpearOponente (){
         System.out.println("Vida antes de golpear "+vidaOponente.getVida());
            try{
             Thread.sleep(100);
         }catch(InterruptedException ex){
             
         }
         
        vidaOponente.golpear(3);
        System.out.println("Vida despues de golpear "+vidaOponente.getVida());
    }
}
