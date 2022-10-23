/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej5;
import java.util.Random;

/**
 *
 * @author Antonella
 */
public class Auto extends Vehiculo implements Runnable {
    private double km;
    private double cantCombustible;
    private  static double reserva=2;
    private Surtidor s;
    
    public Auto(double km, double cantCombustible, Surtidor s) {
        this.km = km;
        this.cantCombustible = cantCombustible;
        this.s = s;
    }

    
    public void run (){
       Random r= new Random();
       
       recorrer();
       System.out.println(Thread.currentThread().getName()+ " finalizo de recorrer la ciudad y necesita recargar"
               + " combustible..." );
       recargarCombustible(r.nextInt(50)+1);
       
       
       
    }
    public void recorrer (){
        Random r= new Random();
        System.out.println(Thread.currentThread().getName()+ " recorriendo la ciudad..." );
        while (cantCombustible>reserva){
            try{
                Thread.sleep(r.nextInt(300)+1);
           
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            cantCombustible-=r.nextInt(10)+1;
        }
       
    }
    public void recargarCombustible(double cant){
        s.recargar(cant);
    }
    
    
}
