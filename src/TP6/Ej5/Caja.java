package TP6.Ej5;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Color.C;

public class Caja {
    private Lock lock = new ReentrantLock();
    private Condition peso_lleno, caja_repuesta; 
    private final int peso_max;
    private int peso_actual;
    private boolean hay_caja;
    

    public Caja(int p){
        hay_caja = true;
        peso_max = p;
        peso_actual = 0;
        peso_lleno = lock.newCondition();
        caja_repuesta = lock.newCondition();
    }

    public void retirar(){
        try {
            lock.lock();
            peso_lleno.await();
            hay_caja = false;
            System.out.println(C.ROJO+"Brazo retiro caja con "+peso_actual+"/"+peso_max+C.RESET);
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            lock.unlock();
        }
        
    }

    public void reponer(){
        lock.lock();
        caja_repuesta.signalAll();
        System.out.println(C.ROJO+"Brazo repuso caja"+C.RESET);
        peso_actual = 0;
        hay_caja = true;
        lock.unlock();
    }

    public void soltar_pastel(int peso_pastel){
        try {
            lock.lock();
            while (peso_actual+peso_pastel > peso_max || !hay_caja){
                peso_lleno.signal();
                caja_repuesta.await();
            }
            peso_actual = peso_actual+peso_pastel;
            System.out.println(C.PURPLE+"Se agregó "+peso_pastel+" kg a la caja. Peso actual: "+peso_actual+"/"+peso_max+C.RESET);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            lock.unlock();
        }

    }
}
