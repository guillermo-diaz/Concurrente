package TP4.EJ7;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    private Semaphore semOeste;
    private Semaphore semNorte;
    private Semaphore sensorNorteEntrada;
    private Semaphore sensorNorteSalida;
    private Semaphore sensorOesteEntrada;
    private Semaphore sensorOesteSalida;

    public GestorCruce(){
        semOeste = new Semaphore(1);
        semNorte = new Semaphore(0);
    }

    public void sale(){

    }

    public void llegaNorte(){
        try {
            System.out.println(Thread.currentThread().getName()+" llego al sem Norte");
            sensorNorteEntrada.acquire();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void llegaOeste(){
        try {
            System.out.println(Thread.currentThread().getName()+" llego al sem Oeste");
            semOeste.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cambiarSemaforos(){

    }



}
