
package tp5.ej2;
public class Perro implements Runnable {
    private Centro c;


    public Perro(Centro c){
        this.c=c;
    }

    public void run (){
        c.ingresarPerro();
        c.irsePerro();
    }


    
}