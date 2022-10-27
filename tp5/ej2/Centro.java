package tp5.ej2;

import java.util.concurrent.Semaphore;

public class Centro {
    private int cantPerrosComiendo, cantPerrosEsperando, cantGatosComiendo, cantGatosEsperando, cantTotalPerros,cantTotalGatos, limite;
    private int cantPlatos;
    //VERIFICAR 
    private Semaphore mutex; //para exclusion mutua en el acceso a variables 
    private Semaphore platosPerro;// simboliza los platos a los que van a acceder los perros
    private Semaphore platosGato;// simboliza los platos a los que van a acceder los gatos
    private Semaphore rendevousGatos;//semaforos de espera cuando viene un gato pero estan comiendo los perros
    private Semaphore rendevousPerros;//semaforos de espera cuando viene un perro pero estan comiendo los gatos
    private Semaphore esperarPerros;/* semaforo de espera para cuando estan comiendo los perros pero se llenaron los platos
    deben esperar ya que una vez que se llenan todos se debe averiguar si ya se llego al limite y deben entrar los gatos*/
    private Semaphore esperarGatos;/* semaforo de espera para cuando estan comiendo los gatos pero se llenaron los platos
    deben esperar ya que una vez que se llenan todos se debe averiguar si ya se llego al limite y deben entrar los perros*/
    private char comiendo;

    public Centro (int limite, int cantPlatos){
        cantPerrosComiendo=0;
        cantPerrosEsperando=0;
        cantGatosComiendo=0;
        cantGatosEsperando=0;
        cantTotalPerros=0;
        cantTotalGatos=0;
        this.limite=limite;
        this.cantPlatos=cantPlatos;
        mutex= new Semaphore(1);
        platosPerro=new Semaphore(cantPlatos);
        platosGato=new Semaphore(cantPlatos);
        rendevousGatos=new Semaphore(0);
        rendevousPerros=new Semaphore(0);
        esperarGatos=new Semaphore(0);
        esperarPerros=new Semaphore(0);
        comiendo='-';

    }


    public void ingresarGato (){
        try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"AGARRO MUTEX ");
        //si es el primer animal
        if (cantTotalGatos==0 && cantTotalPerros==0){
            //ocupa un plato
            System.out.println(Thread.currentThread().getName() +" ingreso primero como gato");
            try { platosPerro.acquire(cantPlatos);}catch (InterruptedException e){e.printStackTrace(); }
            try { platosGato.acquire();}catch (InterruptedException e){e.printStackTrace(); }
            cantGatosComiendo++;
            cantTotalGatos++;
            comiendo='G';  
            System.out.println(Thread.currentThread().getName() +" INICIAN COMIENDO LOS GATOS");
            System.out.println(Thread.currentThread().getName() +" COMIENDO");
            mutex.release();          
        }else{
            //si no es el primero pero hay perros comiendo
            if (comiendo=='G'){
                if(cantGatosComiendo==cantPlatos){
                    System.out.println(Thread.currentThread().getName() +" estan comiendo los gatos pero estan llenos los platos debe esperar");
                    cantGatosEsperando++;
                    mutex.release();
                    //debe esperar
                    try {esperarGatos.acquire();} catch (InterruptedException e1) {e1.printStackTrace();}
                    System.out.println(Thread.currentThread().getName() +" finalizo la espera");
                }
                else{
                    mutex.release();

                }
                //hace el acquire del plato
                try { platosGato.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() +" pudo acceder al plato");
                 //una vez q logro hacer el acquire del plato
                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                cantGatosComiendo++;
                cantTotalGatos++;
                System.out.println(Thread.currentThread().getName() +" COMIENDO");
                mutex.release();
            }
            else{
                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() +" estan comiendo los perros debe esperar");
                cantGatosEsperando++;
                mutex.release();
                
                try {rendevousGatos.acquire();} catch (InterruptedException e) {e.printStackTrace();}


                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                //soy el primer perro en empezar a comer luego de que se cambio
                if (cantGatosComiendo==0){
                    /*para lograr hacer el acquire todos los perros deben irse por lo cual no se cambiara quien 
                    esta comiendo hasta que no se vayan todos*/
                    try { platosPerro.acquire(cantPlatos);} catch (InterruptedException e) {e.printStackTrace();}
                    comiendo = 'G';
                    System.out.println("--------------------------SE DEJA ENTRAR A LOS GATOS------------------------");
                    platosGato.release(cantPlatos);

                }
                mutex.release();

                try { platosGato.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                
                System.out.println(Thread.currentThread().getName() +" logra acceder a un plato luego del cambio de lado");
                //una vez q logro hacer el acquire del plato
                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                cantGatosEsperando--;
                cantGatosComiendo++;
                System.out.println(Thread.currentThread().getName() +" COMIENDO");
                cantTotalGatos++;
                mutex.release();
            }
    
        }   
    }

    public void ingresarPerro (){
        try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"AGARRO MUTEX ");
        //si es el primer animal
        if (cantTotalGatos==0 && cantTotalPerros==0){
            
            System.out.println(Thread.currentThread().getName() +" ingreso primero como perro");
            try { platosGato.acquire(cantPlatos);}catch (InterruptedException e){e.printStackTrace(); }
            try { platosPerro.acquire();}catch (InterruptedException e){e.printStackTrace(); }
            cantPerrosComiendo++;
            cantTotalPerros++;
            System.out.println(" INICIAN COMIENDO LOS PERROS");
            comiendo='P';  
            System.out.println(Thread.currentThread().getName() +" COMIENDO");
            mutex.release();          
        }else{
            //si no es el primero pero hay perros comiendo
            if (comiendo=='P'){
                if(cantPerrosComiendo==cantPlatos){
                    System.out.println(Thread.currentThread().getName() +" estan comiendo los perrros pero estan llenos los platos debe esperar");
                    cantPerrosEsperando++;
                    mutex.release();
                    try { esperarPerros.acquire();}catch (InterruptedException e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() +" finalizo la espera");
                }
                else{
                    mutex.release();
                }
                //hace el acquire del plato
                try { platosPerro.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() +" pudo acceder al plato");
                 //una vez q logro hacer el acquire del plato

                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                cantPerrosComiendo++;
                System.out.println(Thread.currentThread().getName() +" COMIENDO");
                cantTotalPerros++;
                mutex.release();
            }
            else{
                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                cantPerrosEsperando++;
        
                System.out.println(Thread.currentThread().getName() +" estan comiendo los gatos debe esperar");
                mutex.release();

                //en este semaforo se va a trabar hasta q le avisen q ya estan comiendo los perros
                try {rendevousPerros.acquire();} catch (InterruptedException e) {e.printStackTrace();}

                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                //soy el primer perro en empezar a comer 
                if (cantPerrosComiendo==0){
                    try { platosGato.acquire(cantPlatos);} catch (InterruptedException e) {e.printStackTrace();}
                    comiendo = 'P';
                    System.out.println(Thread.currentThread().getName() +" -------------------SE DEJA A ENTRAR A LOS PERROS----------------");
                    platosPerro.release(cantPlatos);
                }
                mutex.release();//esta bien hacerlo aca

                try { platosPerro.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                //una vez q logro hacer el acquire del plato
                System.out.println(Thread.currentThread().getName() +" logra acceder a un plato luego del cambio de lado");
                try {mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
                cantPerrosEsperando--;
                cantPerrosComiendo++;
                System.out.println(Thread.currentThread().getName() +" COMIENDO");
                cantTotalPerros++;
                mutex.release();
            }
    
        }   
    }

    public void irsePerro() {
        try { mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
        if (cantPerrosComiendo == cantPlatos) {
            System.out.println(Thread.currentThread().getName() +" es el primer perro en irse de los platos");
            if (cantTotalPerros == limite) {     
                System.out.println(Thread.currentThread().getName() +" se llego al limite de perros que pueden entrar a comer");
                //reinicia el limite
                cantTotalPerros=0;         
                rendevousGatos.release(cantPlatos);
            } else {
                //si no llegaste al limite le das paso a los perros que quieran comer
                System.out.println(Thread.currentThread().getName() +" no se llego al limite siguen entrando perros ");
                esperarPerros.release();

            }
        } else { // si la cantidad de perros que hay comiendo no es igual a la cantidd de platos
                 // es xq no hay esperando para entrar entonces 
            if (cantGatosEsperando > 0) {
                System.out.println(Thread.currentThread().getName() +" No se llenan los platos de los perros y hay gatos esperando entonces deja entrar a los gatos ");
                rendevousGatos.release(cantPlatos);
            }
        }
        platosPerro.release();
        cantPerrosComiendo--;
        System.out.println(Thread.currentThread().getName() +" Deja el plato");
        mutex.release();
    }
    public void irseGato() {
        try { mutex.acquire();} catch (InterruptedException e) {e.printStackTrace();}
        if (cantGatosComiendo == cantPlatos) {
            System.out.println(Thread.currentThread().getName() +" soy el primer gato en irse");
            if (cantTotalGatos == limite) { 
                System.out.println(Thread.currentThread().getName() +" se llego al limite de gatos que pueden entrar a comer");
                //reinicia el limite
                cantTotalGatos=0;             
                rendevousPerros.release(cantPlatos);
            } else {
                //si no llegaste al limite le das paso a los gatos que quieran comer
                System.out.println(" no se llego al limite siguen entrando gatos ");
                esperarGatos.release();
            }
        } else { // si la cantidad de gatos que hay comiendo no es igual a la cantidd de platos
                 // es xq no hay esperando para entrar entonces si hay perros esperand
            if (cantPerrosEsperando > 0) {
                System.out.println(" No se llenan los platos de los gatos y hay perros esperando entonces deja entrar a los perro ");
                rendevousPerros.release(cantPlatos);
            }
        }
        platosGato.release();
        cantGatosComiendo--;
        System.out.println(Thread.currentThread().getName() +" Deja el plato");
        mutex.release();
    }
   

    
}
