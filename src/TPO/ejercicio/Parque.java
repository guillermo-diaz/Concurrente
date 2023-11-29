package TPO.ejercicio;

import java.util.concurrent.Semaphore;

public class Parque {
    public Semaphore mutex, esperarVecino, esperarRandom;
    public int cant_actual, tam, vecinos_esperando;

    public Parque(){
        mutex = new Semaphore(1);
        esperarRandom = new Semaphore(0);
        esperarVecino = new Semaphore(0);
        tam = 30;
    }

    public void entrarRandom() throws InterruptedException{
        mutex.acquire();
        if(cant_actual >= tam || vecinos_esperando> 0 ){ //si esta lleno  o hay vecinos esperando me bloqueo
            mutex.release(); //libero el mutex antes de bloquearme
            esperarRandom.acquire();

            mutex.acquire(); //lo adquiero otra vez xq tengo que modificar una variable
        } 
        System.out.println("Random ya entro");
        cant_actual++;
        mutex.release();
    }

    public void entrarVecino() throws InterruptedException{
        mutex.acquire();
        if(cant_actual >= tam){ //si esta lleno
            vecinos_esperando++; //aumento la cant esperando
            mutex.release(); //libero el mutex antes de bloquearme
            esperarVecino.acquire();

            mutex.acquire(); //lo adquiero otra vez xq tengo que modificar una variable
        } 
        System.out.println("Vecino ya entro");
        cant_actual++;
        mutex.release();
    }

    public void salir() throws InterruptedException{
        mutex.acquire(); //para ver las variables
        cant_actual--;
        if (vecinos_esperando > 0){ //si hay vecinos esperando solo les aviso a ellos que ya hay lugar
            esperarVecino.release();
        } else {
            esperarRandom.release(); //si no hay vecinos, les aviso a la gente normal
        }
        mutex.release();
    }
}
