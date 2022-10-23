/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ej6;

/**
 *
 * @author Antonella
 */
public class Sumadores implements Runnable {
    private int []a;
    private int inicioSuma,finSuma;
    private Suma sumaCompartida;
    
    public void run (){
        int sumaParcial=0;
        for (int i=inicioSuma;i<finSuma;i++){
            sumaParcial+=a[i];
        }
        
        sumaCompartida.sumar(sumaParcial);
        
        
        
    }

    public Sumadores(int[] a, int inicioSuma, int finSuma, Suma sumaCompartida) {
        this.a = a;
        this.inicioSuma = inicioSuma;
        this.finSuma = finSuma;
        this.sumaCompartida = sumaCompartida;
    }
            
    
}
