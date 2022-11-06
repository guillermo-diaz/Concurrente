package TP6.Ej1.Monitores;

import java.util.Random;

public class Auto extends Thread{
    static int n = 1;
    private Puente puente;
    private String direccion;

    public Auto(String name, Puente p, String d){
        super(name);
        puente = p;
        direccion = d;
        n++;
    }

    public void run() {
        puente.cruzar(direccion);
        sleep();
        puente.terminar_cruzar(direccion);
    }

    public void sleep(){
        Random r = new Random();
        try {
            sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
