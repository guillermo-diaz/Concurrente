package TP4.ProblemasClasicos.Cena_de_filosofos;

import java.util.Random;

public class Filosofo extends Thread{
    private Tenedor izq;
    private Tenedor der;

    public Filosofo(Tenedor i, Tenedor d){
        izq = i;
        der = d;
    }

    @Override
    public void run() {
        Random r = new Random();

        if (r.nextBoolean()){
            izq.tomar();
            der.tomar();
        } else {
            der.tomar();
            izq.tomar();
        }
        comer();
        System.out.println(getName()+" dejo de comer");
        izq.dejar();
        der.dejar();
    }

    public void comer(){
        Random r = new Random();
        System.out.println(getName()+" está comiendo...");
        dormir();

    }

    public String toString(){
        return getName()+" TI: "+izq.getNombre()+" | TD: "+der.getNombre();
    }

    public void dormir(){
        Random r = new Random();
        try {
            sleep(r.nextInt(1000));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    

    
}
