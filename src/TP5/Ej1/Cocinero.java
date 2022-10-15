package TP5.Ej1;

import java.util.Random;

public class Cocinero extends Thread{
    final Confiteria c;

    public Cocinero(Confiteria c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.pedido_comida();
            preparar_comida();
            c.entregar_comida();
        }
    }   
    public void preparar_comida(){
        Random r = new Random();
        System.out.println("Cocinero prepara comida");
        try {
            sleep(r.nextInt(500));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Cocinero termino la comida");

    } 
}
