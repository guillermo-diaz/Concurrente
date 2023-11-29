package TP5.Piscina;

import java.util.concurrent.Semaphore;

import Color.C;

public class Piscina {
    public int capacidad;
    public Semaphore entrar;


    public Piscina(int k){
        capacidad = k;
        entrar = new Semaphore(k);
    }

    public void entrar(){
        try {
            entrar.acquire(1);
            System.out.println(C.AMARILLO+Thread.currentThread().getName()+" entro a la piscina"+C.RESET);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public void salir(){
        System.out.println(C.ROJO+Thread.currentThread().getName()+" salio de la piscina"+C.RESET);
        entrar.release(1);
    }
}
