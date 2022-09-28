package TP4.EJ5;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore disponible;
    private Semaphore subir;
    private Semaphore llegada;

    public Taxi(){
        disponible = new Semaphore(1);
        subir = new Semaphore(0);
        llegada = new Semaphore(0);
    }

    public void esperarCliente(){
        try {
            subir.acquire();
            System.out.println("Taxista recogio cliente");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void subirTaxi(){
        try {
            disponible.acquire();
            System.out.println(Thread.currentThread().getName()+ " subio al taxi");
            subir.release(); 
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void llegada(){
        llegada.release();
    }

    public void pagar(){
        try {
            llegada.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void bajarTaxi(){
        System.out.println(Thread.currentThread().getName()+" llego al destino");
        disponible.release();
    }

}
