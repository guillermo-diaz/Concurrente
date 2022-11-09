package TP6.Ej6;

public class Main {
    public static void main(String[] args) {
        Sala s = new Sala(2, 5);
        Thread[] donantes = new Thread[14];
        crear_donantes(donantes, s);
        activarHilos(donantes);
    }
    public static void crear_donantes(Thread[] d, Sala s){
        for (int i = 0; i < d.length; i++) {
            d[i] = new Donante("#"+i, s);
        }
    }

    public static void activarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
