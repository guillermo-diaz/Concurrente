package TP4.ProblemasClasicos.EscritoresYLectores;

import java.util.concurrent.Semaphore;

public class Documento {
    private Semaphore leer;
    private Semaphore escribir;
    Object datos = new Object();

    public Documento(){
        leer = new Semaphore(1);
        escribir = new Semaphore(1);
    }
    
    public void leer(){

        try {
            escribir.acquire();
            System.out.println(Thread.currentThread().getName()+" está leyendo documento");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        escribir.release();
        /*try {
            leer.acquire();
            System.out.println(Thread.currentThread().getName()+" está leyendo documento");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        leer.release();*/
    }

    public void escribir(){
        try {
            escribir.acquire();
            System.out.println(Thread.currentThread().getName()+" va a escribir");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void dejarDeEscribir(){
        System.out.println(Thread.currentThread().getName()+" Dejo de escribir");
        escribir.release();

        
    }
}
