package TP6.Ej1.Locks;

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
        if (direccion.equals("Norte")){
            puente.cruzar_norte();
            sleep();
            puente.terminar_cruzar_norte();
        } else {
            puente.cruzar_sur();
            sleep();
            puente.terminar_cruzar_sur();
        }
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
