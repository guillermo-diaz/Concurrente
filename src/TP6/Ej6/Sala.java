package TP6.Ej6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    /*NOTA: Arreglar caso de que haya 0 revistas y las camillas estén ocupadas, hay deadlock 
     * borrar la condicion de revista y moverla al while de entrar_sala
     */
    public static final String VERDE = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    private Queue<String> fila = new LinkedList<>();
    private int cant_revistas, cant_camillas, revistas_ocupadas, camillas_ocupadas;
    private final Lock mutex = new ReentrantLock();
    private Condition camilla_vacia, revista_vacia;

    public Sala(int camillas, int revistas){
        cant_revistas = revistas;
        cant_camillas = camillas;
        camillas_ocupadas = 0;
        revistas_ocupadas = 0;
        camilla_vacia = mutex.newCondition();
        revista_vacia = mutex.newCondition();
    }

    public void entrar_sala(){
        mutex.lock();
        boolean revista = false;
        String name = name();
        fila.add(name);
        try {
            
            while ( camillas_ocupadas >= cant_camillas || fila.peek() != name) {
                revista = true; //si se queda en la sala de espera si o si va a leer una revista cuando este disponible
                this.esperar_turno();
                camilla_vacia.await(); //ya tiene una revista, espera leyendo a que lo llamen
            }
            fila.poll();
            camillas_ocupadas++;
            System.out.println(VERDE+name+" subio a la camilla"+RESET);
        } catch (Exception e) {
                // TODO: handle exception
        }finally{
            if (revista){ //Si tiene revista
                revistas_ocupadas--;
                revista_vacia.signalAll();
            }

            mutex.unlock();
        }
    }

    public void salir(){
        mutex.lock();
        camillas_ocupadas--;
        System.out.println(VERDE+name()+ " salio de la sala"+RESET);
        camilla_vacia.signalAll();
        mutex.unlock();
    }

    private String name(){
        return Thread.currentThread().getName();
    }

    public void esperar_turno(){
        try {
            String name = name();
            while (revistas_ocupadas >= cant_revistas){
                System.out.println(PURPLE+name+" espera mientras ve la televisión"+RESET);
                revista_vacia.await();
            }
            revistas_ocupadas++;
            System.out.println(PURPLE+name+" tomó una revista"+RESET);
        } catch (Exception e) {
            // TODO: handle exception
        }
            
    }


}
