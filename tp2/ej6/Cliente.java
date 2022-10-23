/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ej6;

/**
 *
 * @author Antonella
 */
public class Cliente {   
    private String nombre;
    private int[] carroCompra;
// Constructor y métodos de acceso

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

 
}
