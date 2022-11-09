package TP6.Ej7;

import java.util.Random;

public class Cocinero extends Thread{
    private final Olla olla;
    Random r = new Random();

    public Cocinero(Olla o){
        olla = o;
    }

    @Override
    public void run() {
        while (true){
            olla.llenar_olla();
            cocinar();
            olla.terminar_llenar_olla();
        }
    }

    public void cocinar(){
        try {
            sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
