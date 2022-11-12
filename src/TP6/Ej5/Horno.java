package TP6.Ej5;

import java.util.Random;

public class Horno extends Thread{
    private final Mostrador mostrador;
    private int peso_pastel;

    public Horno(Mostrador m, int peso){
        mostrador = m;
        peso_pastel = peso;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            try {
                mostrador.agregar_pastel(new Pastel(peso_pastel));
                sleep(r.nextInt(1000));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
