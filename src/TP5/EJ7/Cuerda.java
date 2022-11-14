package TP5.EJ7;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

import Color.C;

public class Cuerda {
    public Semaphore mutex;
    public Semaphore agarrar_cuerda;
    private String direccion_actual;
    private int limite_cuerda = 5;
    private HashMap<String, Contador> map = new HashMap<>();

    public Cuerda(){
        direccion_actual ="";
        map.put("izq", new Contador(limite_cuerda));
        map.put("der", new Contador(limite_cuerda));
        agarrar_cuerda = new Semaphore(limite_cuerda);
    }

    public void subir(String dir){
        try {
            mutex.acquire();
            map.get(dir).increase_esperando(); //espera a subir
            if (direccion_actual.isEmpty()){
                set_direccion(); //setea direccion
                mutex.release();
            } else {
                mutex.release();
                if (!direccion_actual.equals(dir) || map.get(dir).getCruzando() >= limite_cuerda){
                    map.get(dir).esperar();
                    System.out.println(C.PURPLE+name()+" espera"+C.RESET);
                } 
            }
            mutex.acquire();
            map.get(dir).decrease_esperando();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String name() {
        return Thread.currentThread().getName();
    }

    public void cruzar(String dir){
        try {
            mutex.acquire();
            map.get(dir).increase_cruzando();
            mutex.release();
            System.out.println(C.ROJO+name()+" cruzando. ("+map.get(dir).getCruzando()+"/"+limite_cuerda+C.RESET);
            agarrar_cuerda.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void terminar_cruzar(String dir){
        try {
            mutex.acquire();
            map.get(dir).decrease_cruzando();
            System.out.println(C.ROJO+name()+" termino de cruzar ("+map.get(dir).getCruzando()+"/"+limite_cuerda+C.RESET);
            agarrar_cuerda.release();

            if (map.get(dir).getCruzando() == 0){ //es el ultimo
                set_direccion();
            }

            mutex.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void set_direccion(){
        String opuesto = (direccion_actual.equals("izq")) ? "der" : "izq";

        if (map.get(opuesto).getEsperando() != 0) { // si la especie opuesta esta esperando, cambio prioridad
            direccion_actual = opuesto;
            System.out.println("TURNO DE LA ESPECIE " + direccion_actual);
            map.get(direccion_actual).liberar();
        } else if (map.get(direccion_actual).getEsperando() != 0) { //si no hay de la esp opuesta pero si de la mia,los dejo pasar
            System.out.println("TURNO DE LA ESPECIE "+direccion_actual);
            map.get(direccion_actual).liberar();                     
        } else {
            direccion_actual = "";
            System.out.println("COMEDOR VACIO");
        }
    }





}
