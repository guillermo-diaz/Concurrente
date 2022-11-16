package TP5.Ej6;

import java.util.concurrent.Semaphore;

import Color.C;

public class Mirador {
    private Semaphore toboganes;
    private Semaphore escalera;
    private Semaphore espera_encargado;
    private int limite_personas = 4;

    public Mirador() {
        toboganes = new Semaphore(2);
        escalera = new Semaphore(limite_personas);
        espera_encargado = new Semaphore(0);
    }

    public void subir_escalera() throws InterruptedException {
        escalera.acquire();
        System.out.println(C.AMARILLO + name() + " sube la escalera" + C.RESET);
    }

    public void usar_tobogan() throws InterruptedException {
        toboganes.acquire();
        System.out.println(C.VERDE + name() + " baja por el tobogan" + C.RESET);
        escalera.release();
    }

    public void salir_tobogan() {
        System.out.println(C.ROJO + name() + " salio del tobogan" + C.RESET);
        espera_encargado.release();
    }

    public void controlar() throws InterruptedException {
        espera_encargado.acquire();
        toboganes.release();
        System.out.println("Encargado deja pasar a una persona");
    }

    private String name() {
        return Thread.currentThread().getName();
    }
}
