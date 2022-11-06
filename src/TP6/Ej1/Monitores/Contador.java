package TP6.Ej1.Monitores;


import java.util.LinkedList;
import java.util.Queue;

public class Contador {
    private int consecutivos, capacidad, espera, max;
    private Queue<String> fila;

    public Contador(int c, int m){
        capacidad = c;
        max = m;
        fila = new LinkedList<>();
        espera = 0;
        consecutivos = 0;
    }

    public void poll_queue(){
        fila.poll();
    }

    public void insert_queue(String name){
        fila.add(name);
    }

    public void setConsecutivos(int consecutivos) {
        this.consecutivos = consecutivos;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }

    public void increase_consecutivo(){
        consecutivos++;
    }

    public void increase_espera(){
        espera++;
    }

    public void decrease_consecutivo(){
        consecutivos--;
    }

    public void decrease_espera(){
        espera--;
    }

    public int getConsecutivos() {
        return consecutivos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getEspera() {
        return espera;
    }

    public int getMax() {
        return max;
    }

    public Queue<String> getFila() {
        return fila;
    }

    public boolean puede_pasar(){
        return fila.size() < capacidad;
    }

    
}
