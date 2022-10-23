/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ej6;

/**
 *
 * @author Antonella
 */
public class MainThread {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
            2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});
        long initialTime = System.currentTimeMillis();
        CajeroThread cajero1 = new CajeroThread("Cajero 1", cliente1,initialTime );
        CajeroThread cajero2 = new CajeroThread("Cajero 2", cliente2,initialTime );
        cajero1.start();
        cajero2.start();

    }
}
