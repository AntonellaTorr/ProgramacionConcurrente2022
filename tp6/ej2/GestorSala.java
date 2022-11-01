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

        System.out.println(Thread.currentThread().getName() + " ESTA EN LA PUERTA DE LA SALA");
        while (cantPersonasActual>=cantPersonasMaximo && cantJubiladosEsperando!=0){
            System.out.println(Thread.currentThread().getName() + " no pudo entrar por que la sala estaba llena");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        cantPersonasActual++;
        System.out.println(Thread.currentThread().getName() + "  ENTRO " + " cantidad de jubilado esperando cuando entre "+ cantJubiladosEsperando);

    }
    public synchronized void entrarSalaJubilado (){
        System.out.println(Thread.currentThread().getName() + " JUBILADO ESTA EN LA PUERTA DE LA SALA");
        cantJubiladosEsperando++;
        System.out.println(" Cant jubilados esperando "+cantJubiladosEsperando);
        while (cantPersonasActual>=cantPersonasMaximo){
            System.out.println(Thread.currentThread().getName() + " Jubilado no pudo entrar por que la sala estaba llena");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        cantPersonasActual++;
        System.out.println(Thread.currentThread().getName() + " Jubilado ENTRO");
        cantJubiladosEsperando--;
       System.out.println(cantJubiladosEsperando);
        this.notifyAll(); //le notifica a las personas que ya no hay un jubilado esperando

    }
    public synchronized void salirSala(){
        cantPersonasActual--;
        System.out.println(Thread.currentThread().getName() +" se va");
        this.notifyAll();

    }
    public synchronized void notificarTemperatura(int nuevaTemperatura){
        this.temperaturaActual= nuevaTemperatura;
        if (nuevaTemperatura>tUmbral){
          
            cantPersonasMaximo=5;
        }
    }
    
    
}
