/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author Antonella
 */

    public class TesteoRecurso {
        public static void main (String[] args){
        Cliente juan=new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines=new Cliente ();
        ines.setName ("Ines Garcia");
        juan.start();
        ines.start();
        Recurso.uso();
        //hola
        }
    }
