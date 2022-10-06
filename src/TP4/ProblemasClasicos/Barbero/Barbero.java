package TP4.ProblemasClasicos.Barbero;

import java.util.Random;

public class Barbero extends Thread{
    private Barberia b;

    public Barbero(Barberia br){
        this.b = br;
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("barbero durmiendo...");
        while (i < 15){
            b.atender();
            cortar();
            b.terminarCorte();
            System.out.println("barbero durmiendo...");
            i++;
        }
    }

    private void cortar(){
        Random r = new Random();
        try {
            sleep(r.nextInt(r.nextInt(1000)));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
