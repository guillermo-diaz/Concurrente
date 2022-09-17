package TP3.Ej4;

import java.util.Random;

public class Plato {
    private boolean estado;

    public Plato(){
        estado = false;
    }
    
    public synchronized boolean getEstado(){
        return estado;
    }
    public boolean usarPlato(){
        boolean ret = false; 

        synchronized(this){
        if (!estado){
            ret = true;
            estado = true;
            System.out.println(Thread.currentThread().getName()+" plato");
        }
        return ret;}
        
    }

    public synchronized void dejarPlato(){
        estado = false;
        System.out.println(Thread.currentThread().getName()+" dejo plato");
    }
    
    /*public synchronized void usarPlato(){
      
            this.estado = true;
            System.out.println(Thread.currentThread().getName()+" plato");
    
            try{
                Random num = new Random();
                Thread.sleep(num.nextInt(1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            dejarPlato();
 
        
    
        
    }*/
    

}
