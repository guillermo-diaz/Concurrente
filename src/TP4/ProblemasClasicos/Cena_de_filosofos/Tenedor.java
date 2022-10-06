package TP4.ProblemasClasicos.Cena_de_filosofos;

import java.util.concurrent.Semaphore;

public class Tenedor {
    private Semaphore tomar;
    private String nombre;

    public Tenedor(String nombre){
        tomar = new Semaphore(1);
        this.nombre = nombre;
    }

    public void tomar(){
        try {
            tomar.acquire();
            System.out.println(Thread.currentThread().getName()+" tomo el tenedor "+nombre);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dejar(){
        System.out.println(Thread.currentThread().getName()+" dejo el tenedor "+nombre);
        tomar.release();
    }

    public String getNombre() {
        return nombre;
    }
    
}
