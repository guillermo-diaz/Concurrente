package TP5.EJ7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cuerda c = new Cuerda();
        Thread[] babuinos = new Thread[9];
        Random r = new Random();

        for (int i = 0; i < babuinos.length; i++) {
            if (r.nextInt(2) == 0){
                babuinos[i] = new Babuino("#"+i, c, "izq");
            } else{
                babuinos[i] = new Babuino("#"+i, c, "der");
            }
        }
        for (Thread b : babuinos) {
            b.start();
        }
    }
}
