package TP4.EJ5;

import java.util.Random;

public class Pasajero extends Thread{
    private Taxi taxi;
    

    public Pasajero(Taxi t){
        taxi = t;
    }

    @Override
    public void run() {
        caminar();
        taxi.subirTaxi();
        taxi.pagar();
        taxi.bajarTaxi();
    }
    public void caminar(){
        Random r = new Random();
        try {
            System.out.println(getName()+" caminando");
            sleep(r.nextInt(1000));
            System.out.println(getName()+" termino de caminar");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
