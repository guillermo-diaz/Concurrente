package TP5.Ej2;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore sem_platos; 
    private Semaphore mutex;
    private String especie_actual;
    private int limite;
    static private HashMap<String, Contador> map = new HashMap<>();

    public Comedor(int platos, int lim) {
        limite = lim;
        sem_platos = new Semaphore(platos);
        mutex = new Semaphore(1);

        especie_actual = "";
        map.put("gato", new Contador(limite));
        map.put("perro", new Contador(limite));
    }

    public void entrar(String tipo) {
        try {
            mutex.acquire();
            if (especie_actual.isEmpty()) { //si esta vacio setea el turno
                System.out.println("COMEDOR VACIO");
                System.out.println("TURNO DE LA ESPECIE "+tipo);
                especie_actual = tipo;
                mutex.release();
            } else {
                //si esta la otra especie comiendo o su especie está comiendo pero esta lleno, espera
                if (!especie_actual.equals(tipo) || map.get(tipo).get_comiendo() == limite) { 
                    System.out.println("\u001B[31m"+Thread.currentThread().getName() + " espera ...\u001B[0m");

                    map.get(tipo).increase_esperando();
                    mutex.release();

                    map.get(tipo).tomar_permiso(); //se bloquea

                    mutex.acquire();
                    map.get(tipo).decrease_esperando();
                    mutex.release();
                } else {
                    mutex.release();
                }
            }
            System.out.println("\u001B[32m"+Thread.currentThread().getName() + " entro al comedor"+"\u001B[0m");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void comer(String tipo) {
        try {
            mutex.acquire();
            map.get(tipo).increase_comiendo();
            mutex.release();
            sem_platos.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void salir(String tipo) {
        try {
            mutex.acquire();
            map.get(tipo).decrease_comiendo();
            sem_platos.release();

            System.out.println(Thread.currentThread().getName() + " salio");
            
            if (map.get(tipo).get_comiendo() == 0) { //si es el ultimo en salir, setea prioridad
                set_prioridad(tipo);
            }
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void set_prioridad(String tipo_actual) {

        String opuesto = (tipo_actual.equals("gato")) ? "perro" : "gato";

        if (map.get(opuesto).get_esperando() != 0) { // si la especie opuesta esta esperando, cambio prioridad
            especie_actual = opuesto;
            System.out.println("TURNO DE LA ESPECIE " + especie_actual);
            map.get(especie_actual).liberar_permisos();
        } else if (map.get(tipo_actual).get_esperando() != 0) { //si no hay de la esp opuesta pero si de la mia,los dejo pasar
            System.out.println("TURNO DE LA ESPECIE "+especie_actual);
            map.get(tipo_actual).liberar_permisos();                     
        } else {
            especie_actual = "";
            System.out.println("COMEDOR VACIO");
        }
    }

}
