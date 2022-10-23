package tp2.ej6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antonella
 */
public class Cajero {

  

    public Cajero(String nombre) {
        this.nombre = nombre;
    }
      public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + "->Tiempo: " + (System.currentTimeMillis() - timeStamp)
                    / 1000 + "seg");
        }
        System.out.println("El cajero " + this.nombre +" HA TERMINADO DE  PROCESAR "
                + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    
    public void esperarXsegundos(int cantSegundos){
        try {
            Thread.sleep(cantSegundos*100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo interrumpido.");
        }
    }
  
}
