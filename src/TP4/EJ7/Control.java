package TP4.EJ7;

import java.util.Random;

public class Control extends Thread{
    private GestorCruce gc;

    public Control(GestorCruce g){
        this.gc = g;
    }

    @Override
    public void run() {
        while (true){
            dormir();
        }
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
