package tp5.ej1;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random r= new Random();
        int cantEmpleados= r.nextInt(10);
        Thread empleados[]= new Thread[cantEmpleados];
        Comedor c= new Comedor(2);
        for(int i=0;i<empleados.length;i++){
            empleados[i]= new Thread( new Empleado(c));
        }
        Thread cocinero= new Thread(new Cocinero(c));
        Thread mozo= new Thread(new Mozo(c));
        for(int i=0;i<empleados.length;i++){
            empleados[i].start();
        }
        cocinero.start();
        mozo.start();



    }
    
}
