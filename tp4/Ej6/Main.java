package tp4.Ej6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r= new Random();
        int cantEmpleados=r.nextInt(1000)+1;
        Thread empleados[]= new Thread[cantEmpleados];
        Comedor c= new Comedor();

        for (int i=0;i<empleados.length;i++){
            empleados[i]= new Thread(new Empleado(c));

        }
        Thread mozo= new Thread(new Mozo(c));
        mozo.start();
        for (int i=0;i<empleados.length;i++){
            empleados[i].start();

        }
       
    }
}
