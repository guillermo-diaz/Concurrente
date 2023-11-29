package TPO.EJ1.ej1sem;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import Color.C;

public class Lugar {
    private final int TAM = 10;
    private int espacio_ocupado;
    private Semaphore semSubir, semBajar, iniciarBuque;

    public Lugar() {
        semSubir = new Semaphore(TAM);
        semBajar = new Semaphore(0);
        iniciarBuque = new Semaphore(0);
        espacio_ocupado = 0;
    }

    public void subir() throws InterruptedException {
        semSubir.acquire();
        espacio_ocupado++;
        if (espacio_ocupado == TAM) {
            iniciarBuque.release(1);
        }

        System.out.println(C.VERDE + Thread.currentThread().getName() + " subio al barco" + C.RESET);
    }
    
    public void bajar() throws InterruptedException {
        semBajar.acquire();
        System.out.println(C.ROJO + Thread.currentThread().getName() + " bajó del barco" + C.RESET);
    }
    
    public void arrancar() throws InterruptedException {
        iniciarBuque.acquire();
        System.out.println(C.PURPLE+" Buque arranca viaje"+C.RESET);
    
    }
    public synchronized void descargar() {
        System.out.println(C.PURPLE+" buque descargo"+C.RESET);
        espacio_ocupado = 0;
        semBajar.release(10);
    }
    public void avisar_llegada(){
        System.out.println(C.PURPLE+"Buque llego al puerto origen"+C.RESET);
        semSubir.release(10);
    }


}
