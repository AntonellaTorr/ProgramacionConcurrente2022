package tpOb.HilosDurmientes;

public class HiloTrabajador implements Runnable {
    private Reloj r;
    private int nroTrabajador;

    public HiloTrabajador (Reloj r, int nroTrabajador){
        this.r=r;
        this.nroTrabajador=nroTrabajador;
    }

    public void run (){
        
        while (true){
            r.despertarme(nroTrabajador);
            System.out.println(Thread.currentThread().getName()+ " se desperto");
            r.despertarPana(nroTrabajador);
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
