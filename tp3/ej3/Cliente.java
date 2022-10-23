/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej3;

import java.util.*;

/**
 *
 * @author Antonella
 */
public class Cliente implements Runnable {
   private Empleado e;
   
   public Cliente (Empleado e){
       this.e=e;
   }
   
   public void run (){
       boolean exito=false, continuar=true;
       ArrayList asientosLibres=e.solicitarAsientosLibres();
       
      
            do {
            Random r= new Random();
            int nroA= r.nextInt(asientosLibres.size());
            System.out.println(Thread.currentThread().getName() +" asiento seleccionado nro "+nroA);
            exito= e. reservarAsiento(nroA);

            if (!exito){
                continuar=(e.solicitarAsientosLibres().size()!=0);
                System.out.println (Thread.currentThread().getName() +" El nro asiento fue ocupado recientemente");
            }
           }while (!exito && continuar);
       }
   
    
      
   }
    

