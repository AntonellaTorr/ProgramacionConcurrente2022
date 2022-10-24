package tpOb.HilosDurmientes;

public class HiloTrabajador implements Runnable {
    private Reloj r;

    public HiloTrabajador (Reloj r){
        this.r=r;
    }

    public void run (){
        
        while (true){
            r.despertarme();
            System.out.println(Thread.currentThread().getName()+ " se desperto");
            r.despertarPana();
            System.out.println(Thread.currentThread().getName()+ " despierta a su pana");
            if (esHoraTrabajo()){
                System.out.println(Thread.currentThread().getName()+ " es su hora de trabajo");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ " vuelve a dormir");
            r.aMimir();
        }
    }


    public boolean esHoraTrabajo(){
        
        return ((int)(Math.random()*3)+1==2);
    }

    
}
