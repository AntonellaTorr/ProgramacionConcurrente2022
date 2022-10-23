/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej4;

/**
 *
 * @author Antonella
 */
public class Hamster implements Runnable {
    private Hamaca hamaca;
    private Plato comida;
    private Rueda rueda;

    public Hamster(Hamaca hamaca, Plato comida, Rueda rueda) {
        this.hamaca = hamaca;
        this.comida = comida;
        this.rueda = rueda;
    }
    
    
    public void run (){
        comida.comer();
        rueda.correr();
        hamaca.descansar();
        
    }
}
