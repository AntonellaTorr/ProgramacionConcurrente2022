package tp4.Ej4;

import java.util.Random;

public class Centro {
    private Impresora [] impresoras;

    public Centro( int cantImpresorasA, int cantImpresorasB) {
        impresoras= new Impresora[cantImpresorasA+cantImpresorasB];
        for (int i=0;i<cantImpresorasA;i++){
            impresoras[i]= new Impresora('A'); 
        }
        for (int i=cantImpresorasA;i<cantImpresorasA+cantImpresorasB;i++){
            impresoras[i]= new Impresora('B'); 
        }
    }
    
    public int comenzarAImprimir (char tipo){
        Random r= new Random();
        int nro=buscarImpresoraLibreSegunTipo(tipo);
        boolean continuar=true;

        if (nro==-1){
       
                while (continuar){
                    
                    int n=r.nextInt(impresoras.length);

                    if (tipo!='X'){
                        if (impresoras[n].getTipo()==tipo){
                            try {
                                impresoras[n].getSemaforo().acquire();
                                continuar=false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else{
                        try {
                            impresoras[n].getSemaforo().acquire();
                            continuar=false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    nro=n;
                }        
        }
        return nro;
    }
    public void finalizarImprimir (int nro){
        impresoras[nro].getSemaforo().release();
    }
    /*/
    public void imprimir(char tipo){
        Random r= new Random();
        int nro=buscarImpresoraLibreSegunTipo(tipo);
        boolean continuar=true;

        if (nro==-1){
       
                while (continuar){
                    
                    int n=r.nextInt(impresoras.length);

                    if (tipo!='X'){
                        if (impresoras[n].getTipo()==tipo){
                            try {
                                impresoras[n].getSemaforo().acquire();
                                continuar=false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else{
                        try {
                            impresoras[n].getSemaforo().acquire();
                            continuar=false;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    nro=n;
                }        
        }
        System.out.println(Thread.currentThread().getName()+" Impriendo tipo: "+tipo + " en impresora de tipo "+impresoras[nro].getTipo());
        impresoras[nro].getSemaforo().release();
        System.out.println(Thread.currentThread().getName()+" finalizo de imprimir: "+tipo +" en impresora de tipo "  +impresoras[nro].getTipo());

    
        
    }*/
 
    private int buscarImpresoraLibreSegunTipo(char tipo){
        int nroImpresoraLibre=-1,i=0;
        boolean continuar=true;
        

        while (i<impresoras.length && continuar ){
            if (tipo=='A' || tipo=='B'){
                if (impresoras[i].getTipo()==tipo && impresoras[i].getSemaforo().tryAcquire()){
                nroImpresoraLibre=i;
                continuar=false;
                }
            }
            else{
                if (impresoras[i].getSemaforo().tryAcquire()){
                    nroImpresoraLibre=i;
                    continuar=false;
                }
            }
            i++;

        }
      
    return nroImpresoraLibre;
    }
   
}
