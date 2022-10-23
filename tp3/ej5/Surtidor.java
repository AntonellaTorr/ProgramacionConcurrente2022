/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej5;

/**
 *
 * @author Antonella
 */
public class Surtidor  {

  
    //recurso compartido
    private double cantLitros;
    
    public Surtidor(double cantLitros) {
        this.cantLitros = cantLitros;
    }
    public synchronized double recargar(double cant){
        double cantRecarga;
        if (cantLitros-cant>0){
               cantRecarga=cant;
               cantLitros= cantLitros-cant; 
               System.out.println("Cantidad de litros del surtidor luego de la recarga "+cantLitros);
        }
        else{
            System.out.println(Thread.currentThread().getName() +" no pudo recargar la cantidad de litros deseada, solo recargo "+
                    cantLitros);
            cantRecarga=cantLitros;
            
            cantLitros=0;
        }
        return cantRecarga;
    }
   
}
