
package tp5.ej2;
public class Gato implements Runnable{
    private Centro c;

    public Gato(Centro c){
        this.c=c;
    }
    public void run (){
        c.ingresarGato();
        c.irseGato();
    }


    
}