package TP3.Ej4;

import java.util.Random;

public class Rueda {
    private boolean estado;

    public Rueda(){
        estado = false;
    }

    public synchronized boolean getEstado(){
        return estado;
    }

    public synchronized void dejarRueda(){
        System.out.println(Thread.currentThread().getName()+" dejo rueda");
        estado = false;
    }
    public boolean usarRueda(){
        boolean ret = false; 

        synchronized(this){

            if (!estado){
                ret = true;
                estado = true;
                System.out.println(Thread.currentThread().getName()+" rueda");
            }
        }
        return ret;
        
    }
    

    /*public synchronized void usarRueda(){
      
            this.estado = true;
            System.out.println(Thread.currentThread().getName()+" rueda");
            try{
                Random num = new Random();
                Thread.sleep(num.nextInt(1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            dejarRueda();
  
     }*/
        
    
}
