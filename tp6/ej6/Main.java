package tp6.ej6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Centro c = new Centro();
        Scanner s= new Scanner (System.in);
        System.out.println("Ingrese la cantidad de pacientes");
        int cantP=s.nextInt();
        Thread pacientes[]= new Thread[cantP];
        
        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i]= new Thread(new Paciente(c), "Paciente "+i);
        }
        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i].start();
        }
        
        
    }
}
