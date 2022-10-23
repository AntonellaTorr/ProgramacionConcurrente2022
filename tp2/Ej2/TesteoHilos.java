/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.Ej2;

/**
 *
 * @author Antonella
 */
public class TesteoHilos {
    public static void main (String[] args) throws InterruptedException{
    Thread miHilo= new MiEjecucion();
    miHilo.start();
  
   try{
          Thread.sleep(200);
        }catch (InterruptedException e){
            
        }
    System.out.println("En el main");
   
    }

    
}
