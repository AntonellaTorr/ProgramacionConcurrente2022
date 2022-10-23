package tp4.Ej6;

public class Empleado implements Runnable {
    private Comedor c;
    public Empleado(Comedor c){
        this.c=c;
    }
    public void run (){
        if (c.puedoIngresarAlComedor()){
            System.out.println(" El empleado "+Thread.currentThread().getName() +" se sento en el comedor");
            c.notificarLlegadaAlComedor();
            System.out.println(" El empleado "+Thread.currentThread().getName() +" selecciona su comida");
            c.empezarAComer();
            System.out.println(" El empleado "+Thread.currentThread().getName() +" se va");
            c.irse();
        }
        else{
            System.out.println(" El empleado "+Thread.currentThread().getName() +" no pudo sentarse en el comedor ya que estaba ocupado");

        }

    }
}
