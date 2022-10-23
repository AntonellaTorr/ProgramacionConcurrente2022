package ProblemasClasicos.BarberoDormilon;

public class Barbero implements Runnable{
    private String estado; //durmiendo, atendiendo, libre 
    private Peluqueria p;


    public void run() {
        while (true){
          

            //adquiere sem para comenzar a trabajar
            //trabaja

        }
    }

    public synchronized String getEstado(){
        return estado;
    }
}
