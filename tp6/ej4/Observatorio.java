package tp6.ej4;

public class Observatorio {

    private int capacidadSala, cantActualVisitantes, cantInvestigadores, cantMantenimiento, cantEnSilla;


    public Observatorio (){
        
    }

    public synchronized void ingresarVisitante(boolean silla){

        while (cantActualVisitantes>=capacidadSala || cantMantenimiento>0 || cantInvestigadores>0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (silla ){
            cantEnSilla++;
            if (cantEnSilla==0){
                this.modificarCapacidad(35);
            }
            
        }

    
        cantActualVisitantes++;
        

    }

    public synchronized void modificarCapacidad(int capacidad){
        this.capacidadSala=capacidad;
    }

   
    public synchronized void ingresarMantenimiento (){
        while (cantActualVisitantes>0 || cantInvestigadores>0 || cantMantenimiento>=capacidadSala){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        cantMantenimiento++;
    }

    public synchronized void ingresarInvestigador (){
        while (cantActualVisitantes>0 || cantInvestigadores>0 || cantMantenimiento>0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        cantInvestigadores++;

    }

    public synchronized void irseVisitante(boolean silla){
        cantActualVisitantes--;
        if (silla){
            cantEnSilla--;
            //si es el ultimo en salir modifica la capacidad a 50 de nuevo
            if (cantEnSilla==0){
                this.modificarCapacidad(50);
            }
        }
        this.notifyAll();
    }

    public synchronized void irseInvestigador(){
        cantInvestigadores--;
        this.notifyAll();

    }
    public synchronized void irseMantenimiento(){
        cantMantenimiento--;
        this.notifyAll();
    }

    
}
