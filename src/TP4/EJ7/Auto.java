package TP4.EJ7;

import java.util.Random;

public class Auto extends Thread{
    private final GestorCruce gc;

    public Auto(GestorCruce g){
        gc = g;
    }

    @Override
    public void run() {
        recorrer();
    }

    public void recorrer(){
        Random r = new Random();
        try {
            sleep(r.nextInt(r.nextInt(1000)));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
