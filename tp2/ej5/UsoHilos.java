/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ej5;

/**
 *
 * @author Antonella
 */
public class UsoHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
//Primero, construye un objeto unHilo.
        MiHilo mh = new MiHilo("#1");
        MiHilo mh2 = new MiHilo("#2");
        MiHilo mh3 = new MiHilo("#3");
//Luego, construye un hilo de ese objeto.
        Thread nuevoHilo = new Thread(mh);
        Thread nuevoHilo2 = new Thread(mh2);
        Thread nuevoHilo3 = new Thread(mh3);
//Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        nuevoHilo2.start();
        nuevoHilo3.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
