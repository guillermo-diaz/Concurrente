package TP4.ProblemasClasicos.Barbero;

import java.util.concurrent.Semaphore;

public class Barberia {
    private Semaphore sillon;
    private Semaphore verSillas;
    private Semaphore cortar;
    private Semaphore corteListo;
    private Semaphore verEstadoSillon;
    private boolean[] sillas;
    private boolean estadoSillon; //wrapper

    public Barberia(){
        sillas = new boolean[3];
        sillon = new Semaphore(1);
        verSillas = new Semaphore(1);
        cortar = new Semaphore(0);
        corteListo = new Semaphore(0);
        verEstadoSillon = new Semaphore(1);
        estadoSillon = false;
    }

    public boolean esperarTurnoEnSilla(){
        boolean flag = false;
        int i = 0;

        try {
            verSillas.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (!flag && i < sillas.length){
                if (!sillas[i]){
                    sillas[i] = true; //ocupa el asiento
                    System.out.println(Thread.currentThread().getName()+" se sentó en la silla "+i);
                    flag = true;
                } else {
                    i++;
                }
            
        }
        verSillas.release();
        if (flag){ //si se sento espera su turno
            cortarse();
            dejarSilla(i);
        } 

        return flag;
    }

    private void dejarSilla(int index){
        try {
            verSillas.acquire();
            sillas[index] = false;
            verSillas.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean estadoSillon(){
        try {
            verEstadoSillon.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        boolean estado = this.estadoSillon;
        verEstadoSillon.release();
        return estado; 
    }

    

    

    public boolean[] getSillas() {
        return sillas;
    }

    public void cortarse(){
        try {
            sillon.acquire();
            System.out.println(Thread.currentThread().getName()+" se está cortando");
            verEstadoSillon.acquire();
            estadoSillon = true;
            verEstadoSillon.release();
            cortar.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void atender(){
        try {
            cortar.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void terminarCorte(){
        System.out.println("Barbero termino el corte");
        corteListo.release();
    }

    public void irse(){
        try {
            corteListo.acquire();
            sillon.release();
            System.out.println(Thread.currentThread().getName()+" se fue");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
