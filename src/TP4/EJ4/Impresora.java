package TP4.EJ4;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String codigo;
    private char tipo;
    private Semaphore usar; 
    private Semaphore estado;
    private boolean status;

    public Impresora(char tipo, String cod){
        this.tipo = tipo;
        usar = new Semaphore(1);
        codigo = cod;
        estado = new Semaphore(1);
        status = false;
    }

    public void usar(){
        try {
            usar.acquire();
            status = true;
            System.out.println(Thread.currentThread().getName()+" esta usando impresora "+codigo);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dejar(){
        status = false;
        System.out.println(Thread.currentThread().getName()+" dejó impresora "+codigo);
        usar.release();
    }

    public boolean getEstado(){
        boolean ret = false;
        try {
            estado.acquire();
            ret = this.status;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        estado.release();
        return ret;
    }

    public char getTipo() {
        return tipo;
    }

    public String getCodigo() {
        return codigo;
    }    


}
