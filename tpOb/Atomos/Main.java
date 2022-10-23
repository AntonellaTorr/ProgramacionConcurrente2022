package tpOb.Atomos;

import java.util.Random;



public class Main {
    public static void main(String[] args) {
        int i=0;
        Random r= new Random();
        int cantAtomos= r.nextInt(20);
        Thread atomos[]= new Thread[cantAtomos];
        char tipo;

        Espacio e= new Espacio(r.nextInt(10));

        for (int j=0;j<atomos.length;j++){
           
            if (r.nextInt(2)==0){
                tipo='H';
            }else{
                tipo='O';
            }

            if (j%2==0){
                atomos[j]= new Thread(new Atomo (e,tipo,true));
            }
            else{
                atomos[j]= new Thread(new Atomo (e,tipo,false));
            }

           
        }
        Thread recipiente = new Thread(new Recipiente(e));
        recipiente.start();
        
        for (int j=0;j<atomos.length;j++){
            atomos[j].start();
        }

    }
    
}
