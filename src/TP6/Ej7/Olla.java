package TP6.Ej7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {
    public static final String VERDE = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";


    private int limite_raciones, raciones_comida;
    private final Lock mutex = new ReentrantLock();
    private Condition olla_llena, olla_vacia;

    public Olla(int n){
        limite_raciones = n;
        raciones_comida = n;
        olla_llena = mutex.newCondition();
        olla_vacia = mutex.newCondition();
    }

    
    public void comer(){
        try {
            mutex.lock();
            
            while (raciones_comida == 0){ //si no hay raciones, avisa y espera
                olla_vacia.signal();
                System.out.println(PURPLE+name()+" espera que se llene la olla"+RESET);
                olla_llena.await();
            }
             
            raciones_comida--;
            System.out.println(VERDE+name()+" tomó una porción"+RESET);
            
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            mutex.unlock();
        }
    }

    public void llenar_olla(){
        try {
            mutex.lock();
            while (raciones_comida != 0){
                olla_vacia.await();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            mutex.unlock();
        }
    }

    public void terminar_llenar_olla(){
        mutex.lock();
        olla_llena.signalAll();
        raciones_comida = limite_raciones;
        System.out.println("Cocinero lleno la olla con "+raciones_comida);
        mutex.unlock();
    }

    private String name(){
        return Thread.currentThread().getName();
    }

}
