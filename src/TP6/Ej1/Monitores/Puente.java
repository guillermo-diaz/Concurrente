package TP6.Ej1.Monitores;

import java.util.HashMap;
import java.util.Queue;


//monitor

public class Puente {
    public static final String VERDE = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    private final int capacidad;
    private final int max;
    HashMap<String, Contador> map = new HashMap<>();

    public Puente(int c, int m){
        capacidad = c;
        max = m;
        map.put("Norte", new Contador(capacidad, max));
        map.put("Sur", new Contador(capacidad, max));
    }

    public synchronized void cruzar(String dir){
        map.get(dir).increase_espera();

        while (!map.get(opuesto(dir)).getFila().isEmpty() || !map.get(dir).puede_pasar() || debe_ceder_paso(dir))
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        map.get(dir).increase_consecutivo();
        map.get(opuesto(dir)).setConsecutivos(0);
        map.get(dir).decrease_espera();
        map.get(dir).insert_queue(Thread.currentThread().getName()); //lo pongo en la queue
        String d = (dir.equals("Norte")) ? "N: " : "S: ";
        System.out.println(VERDE+d+Thread.currentThread().getName()+" comenzo a cruzar"+RESET);
    }

    public synchronized void terminar_cruzar(String dir){
        Queue<String> q = map.get(dir).getFila();
        String id = Thread.currentThread().getName();
        String d = (dir.equals("Norte")) ? "N: " : "S: ";

        while (q.peek() != id) //si no es su turno, no termina
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        map.get(dir).poll_queue();
        System.out.println(PURPLE+d+Thread.currentThread().getName()+" termino de cruzar"+RESET);
        notifyAll();  
    }
    // 

    private String opuesto(String d1){
        return (d1.equals("Norte")) ? "Sur" : "Norte";
    }

    public synchronized boolean debe_ceder_paso(String dir){
        boolean flag = map.get(dir).getConsecutivos() > max && map.get(opuesto(dir)).getEspera() != 0;
        
        return flag;
    }
}
