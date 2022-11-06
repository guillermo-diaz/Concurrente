package TP6.Ej1.Monitores;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int capacidad, max;
        capacidad = 5;
        max = 10;
        Puente p = new Puente(capacidad, max);
        Thread[] autos = new Thread[30];
        generar_autos(autos, p);
        activarHilos(autos);
    }
    public static void generar_autos(Thread[] arr, Puente p){
        Random r = new Random();
        String dir, name;

        for (int i = 0; i < arr.length; i++) {
            if (r.nextBoolean()){
                dir = "Norte";
            } else{
                dir = "Sur";
            }
            name = "#"+i;
            System.out.println(name+" direccion: "+dir);
            arr[i] = new Auto(name, p, dir);
        }
    }
    public static void activarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
