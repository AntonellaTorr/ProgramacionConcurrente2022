package tp6.ej4;

import java.util.Random;

public class Persona {
    private Observatorio o;
    private char tipo;
    


    public void run (){
        Random r= new Random();
        switch (tipo){
            case 'V':
                if (r.nextInt(2)==0){
                    o.ingresarVisitante(true);
                    this.simular();
                    o.irseVisitante(true);
                }
                else{
                    o.ingresarVisitante(false);
                    this.simular();
                    o.irseVisitante(false);
                }
               
            break;
            case 'M':
                o.ingresarMantenimiento();
                this.simular();
                o.irseMantenimiento();
            break;
            case 'I':
                o.ingresarInvestigador();
                this.simular();
                o.irseInvestigador();
            break;
        }

    }
    public void simular (){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
