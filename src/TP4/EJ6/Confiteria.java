package TP4.EJ6;

import java.util.concurrent.Semaphore;

public class Confiteria {
    final boolean estado;
    private final Semaphore verEstado;
    private final Semaphore ocupado;
    private final Semaphore comidaLista;

    public Confiteria(){
        verEstado = new Semaphore(1);
        estado = false;
        ocupado = new Semaphore(0);
        comidaLista = new Semaphore(0);
    }

    public void entrar(){
        try {
            verEstado.acquire();
            System.out.println(Thread.currentThread().getName()+" entro a confiteria");
            ocupado.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void salir(){
        System.out.println(Thread.currentThread().getName()+" salió de la confiteria");
        verEstado.release();
        System.out.println("Mozo descansa");
    }

    public void comer(){
        try {
            comidaLista.acquire();
            System.out.println(Thread.currentThread().getName()+" esta comiendo");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entregarComida(){
        System.out.println("comida lista");
        comidaLista.release();
    }

    public void atender(){
        try {
            ocupado.acquire();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
