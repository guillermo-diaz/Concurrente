package TP5.EJ7;

import java.util.concurrent.Semaphore;

public class Contador {
    private int cruzando, esperando, limite_cuerda;
    private Semaphore sem_espera;

    public Contador(int l){
        cruzando = 0;
        esperando = 0;
        limite_cuerda = l;
        sem_espera = new Semaphore(0);
    }

    public void increase_cruzando(){
        cruzando++;
    }

    public void increase_esperando(){
        esperando++;
    }

    public void decrease_cruzando(){
        cruzando--;
    }

    public void decrease_esperando(){
        esperando--;
    }


    public int getCruzando() {
        return cruzando;
    }

    public int getEsperando() {
        return esperando;
    }

    public void liberar(){
        sem_espera.release(esperando); //libero la cantidad que estan esperando
        
    }

    public void esperar(){
        try {
            sem_espera.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
