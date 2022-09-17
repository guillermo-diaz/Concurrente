package TP3.Ej4;
import java.util.Random;

public class Hamaca {
    private boolean estado;
    
    public Hamaca(){
        estado = false;
    }

    public boolean usarHamaca(){
        boolean ret = false; 

        synchronized(this){
        if (!estado){
            ret = true;
            estado = true;
            System.out.println(Thread.currentThread().getName()+" hamaca");
        }}
        return ret;
    }
    
    public synchronized void dejarHamaca(){
        estado = false;
        System.out.println(Thread.currentThread().getName()+" dejo hamaca");
    }
    public synchronized boolean getEstado(){
        return estado;
    }

    /*public synchronized void usarHamaca(){
    
            this.estado = true;
            System.out.println(Thread.currentThread().getName()+" hamaca");
    
            try{
                Random num = new Random();
                Thread.sleep(num.nextInt(1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            dejarHamaca();
    }*/

    
}
