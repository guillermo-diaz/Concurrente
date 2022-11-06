package TP6.Ej1.Locks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Implementación sin ceder el paso
public class Puente {
    public static final String VERDE = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    private final Lock mutex = new ReentrantLock();
    private final Condition salir_puente;
    private final Condition entrar_puente;
    private final Queue<String> fila_sur = new LinkedList<>();
    private final Queue<String> fila_norte = new LinkedList<>();

    public Puente() {

        entrar_puente = mutex.newCondition();
        salir_puente = mutex.newCondition();
    }

    public void cruzar_sur() {
        try {
            mutex.lock();
            String name = Thread.currentThread().getName();
            while (!fila_norte.isEmpty()) {
                System.out.println("S: "+name + " ESPERA");
                entrar_puente.await();
            }
            System.out.println(VERDE+"S: " + name + " entro al puente"+RESET);
            fila_sur.add(name);
        } catch (InterruptedException e) {
            // TODO: handle exception
        } finally {
            mutex.unlock();
        }
    }

    public void terminar_cruzar_sur() {
        try {
            mutex.lock();
            String name = Thread.currentThread().getName();
            while (fila_sur.peek() != name){
                salir_puente.await();
            }
            System.out.println(PURPLE+"S: " +name + " salio del puente"+RESET);
            fila_sur.poll();
            salir_puente.signalAll();
            if (fila_sur.isEmpty()) { // si es el ultimo notifica al otro lado que pueden pasar
                entrar_puente.signalAll();
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.unlock();
        }
    }

    public void cruzar_norte() {
        try {
            mutex.lock();
            String name = Thread.currentThread().getName();
            while (!fila_sur.isEmpty()) {
                System.out.println("N: "+name + " ESPERA");
                entrar_puente.await();
            }
            System.out.println(VERDE+"N: "+name + " entro al puente"+RESET);
            fila_norte.add(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // TODO: handle exception
        } finally {
            mutex.unlock();
        }
    }

    public void terminar_cruzar_norte() {
        try {
            mutex.lock();
            String name = Thread.currentThread().getName();
            while (fila_norte.peek() != name){
                salir_puente.await();
            }
            System.out.println(PURPLE+"N: "+name + " salio del puente"+RESET);
            fila_norte.poll();
            salir_puente.signalAll();
            if (fila_norte.isEmpty()) {
                entrar_puente.signalAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.unlock();
        }
    }

}
