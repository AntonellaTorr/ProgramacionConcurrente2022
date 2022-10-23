package ProblemasClasicos.BarberoDormilon;

public class Cliente {
    private Barbero barbero;
    /*dudas que debe hacer el cliente cuando el barbero esta ocupado y se desocupa
    debe esperar a que el barbero le avise?
    o el debe preguntar
    el recurso compartido es la peluqueria?*/


    public void run() {
       String estadoBarbero= barbero.getEstado();

        if (estadoBarbero.equals("Durmiendo")){
            //libero sem para despertar al barb

        }
        else{
            if (estadoBarbero.equals("Atendiendo")){
                //verifica si se puede sentar
                //el barbero va a tener que liberar sem para avisarle que ya puede atenderlo 


            }
            else{
                //se va 
            }
        }
        
    }
    
}
