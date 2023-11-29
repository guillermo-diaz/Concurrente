package TP4.EJ6.v2;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private final Semaphore tomarAsiento;
    private final Semaphore avisarMozo;
    private final Semaphore comidaLista;

    public Confiteria(){
        tomarAsiento = new Semaphore(1);
        avisarMozo = new Semaphore(0);
        comidaLista = new Semaphore(0);
    }

    public void ocupar() throws InterruptedException{
        tomarAsiento.acquire();
        System.out.println("Empleado tomó asiento: ");
        avisarMozo.release(); // le avisa al mozo
        comidaLista.acquire();   //espera que le sirvan la comida
    }

    public void desocupar() throws InterruptedException{
        tomarAsiento.release(); //deja el asiento para que entre otro empleado
        System.out.println("Empleado dejo de comer y se fue");
    }

    public void atender() throws InterruptedException{
        avisarMozo.acquire();  //intenta agarrar el semaforo que le avisa si hay gente
        System.out.println("Mozo atiende a cliente");
    }

    public void servirComida() throws InterruptedException {
        comidaLista.release(); //libera el semaforo de la comida para avisarle al empleado que ya puede comer
        System.out.println("Mozo sirve la comida");
    }
}
