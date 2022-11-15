package PracticaSegundoP.FabricaSueters;


    public class Ensamblador implements Runnable {
        private Fabrica f;
    
        public void run (){
            while (true){
                f.cocerCuerpos();
                this.simularTiempo();
                f.empaquetarSiEsNecesario();
               
            }
            
        }
        private void simularTiempo(){
            try {
                System.out.println(Thread.currentThread().getName()+": poniendo sweters en caja........");
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
  }

