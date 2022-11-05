package tp6.ej2;

public class GestorSala {
    private int temperaturaActual, tUmbral;
    private int cantJubiladosEsperando, cantPersonasActual, cantPersonasMaximo;
    

    public GestorSala(){
        temperaturaActual=30;
        tUmbral=35;
        cantJubiladosEsperando=0;
        cantPersonasActual=0;
        cantPersonasMaximo=10;
    }
    public synchronized void entrarSala(){

        System.out.println(Thread.currentThread().getName() + " ESTA EN LA PUERTA DE LA SALA" + "\n");
        while (cantPersonasActual>=cantPersonasMaximo || cantJubiladosEsperando!=0){
            System.out.println(Thread.currentThread().getName() + " no pudo entrar por que la sala estaba llena" + "\n");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantPersonasActual++;
        System.out.println(Thread.currentThread().getName() + "  ENTRO " + "\n");
        System.out.println("-----------------CANTIDAD DE PERSONAS ADENTRO->> "+ cantPersonasActual + "\n");

    }
    public synchronized void entrarSalaJubilado (){
        System.out.println(Thread.currentThread().getName() + " JUBILADO ESTA EN LA PUERTA DE LA SALA" + "\n" );
        cantJubiladosEsperando++;
        while (cantPersonasActual>=cantPersonasMaximo){
            System.out.println(Thread.currentThread().getName() + " Jubilado no pudo entrar por que la sala estaba llena" + "\n");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        cantPersonasActual++;
        
        System.out.println(Thread.currentThread().getName() + " Jubilado ENTRO" + "\n");
        System.out.println("-----------------CANTIDAD DE PERSONAS ADENTRO->> "+ cantPersonasActual + "\n");
        cantJubiladosEsperando--;
        this.notifyAll(); //le notifica a las personas que ya no hay un jubilado esperando

    }
    public synchronized void salirSala(){
        cantPersonasActual--;
        System.out.println(Thread.currentThread().getName() +" se va"+ "\n" );
        this.notifyAll();

    }
    public synchronized void notificarTemperatura(int nuevaTemperatura){
        this.temperaturaActual= nuevaTemperatura;
        if (nuevaTemperatura>tUmbral){
          
            cantPersonasMaximo=5;
        }
        else{
            cantPersonasMaximo=10;
        }
    }
    
    
}
