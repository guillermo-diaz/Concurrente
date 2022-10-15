package TP5.Ej1;

import java.util.Random;

public class Mozo extends Thread{
    final Confiteria confi;

    public Mozo(Confiteria c){
        confi = c;
    }

    @Override
    public void run() {
        while(true) {
            confi.pedido_bebida();
            preparar_bebida();
            System.out.println("Mozo termino de preparar bebida");
            confi.entregar_bebida();
        }
    }

    public void preparar_bebida(){
        Random r = new Random();
        System.out.println("Mozo prepara bebida");
        try {
            sleep(r.nextInt(500));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
