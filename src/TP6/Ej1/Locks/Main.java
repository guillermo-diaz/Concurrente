package TP6.Ej1.Locks;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int capacidad, max;
        capacidad = 5;
        max = 10;
        Puente p = new Puente();
        generar_autos(p);
        //activarHilos(autos);
    }
    public static void generar_autos(Puente p){
        Random r = new Random();
        String dir, name;
        int i = 1;

        while(true) {
            if (r.nextBoolean()){
                dir = "Norte";
            } else{
                dir = "Sur";
            }
            name = "#"+i;
            if (i % 5 == 0)
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
            //System.out.println(name+" direccion: "+dir);
            Auto a = new Auto(name, p, dir);
            a.start();
            i++;
        }
    }
    public static void activarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
