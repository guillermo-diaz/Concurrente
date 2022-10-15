package TP5.Ej1;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private final Semaphore lugares;
    private final Semaphore ocupado;
    private final Semaphore comida_lista;
    private final Semaphore bebida_lista;
    private final Semaphore pedido_comida;
    private final Semaphore pedido_bebida;

    public Confiteria(){
        lugares = new Semaphore(2);
        ocupado = new Semaphore(0);
        comida_lista = new Semaphore(0);
        bebida_lista = new Semaphore(0);
        pedido_comida = new Semaphore(0);
        pedido_bebida = new Semaphore(0);
    }

    public void entrar(){
        try {
            lugares.acquire();
            System.out.println(Thread.currentThread().getName()+" entro a confiteria");
            ocupado.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void salir(){
        System.out.println(Thread.currentThread().getName()+" salió de la confiteria");
        lugares.release();
        //System.out.println("Mozo descansa");
    }

    public void pedir_comida(){
        pedido_comida.release();
    }

    public void pedir_bebida(){
        pedido_bebida.release();
    }

    public void pedido_bebida(){
        try {
            pedido_bebida.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }

    public void pedido_comida(){
        try {
            pedido_comida.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entregar_comida(){
        comida_lista.release();
    }

    public void entregar_bebida(){
        bebida_lista.release();
    }

    public void comer(){
        try {
            comida_lista.acquire();
            System.out.println(Thread.currentThread().getName()+" esta comiendo");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void beber(){
        try {
            bebida_lista.acquire();
            System.out.println(Thread.currentThread().getName()+" esta bebiendo");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   
}
