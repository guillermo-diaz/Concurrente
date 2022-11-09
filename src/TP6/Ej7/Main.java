package TP6.Ej7;

public class Main {
    public static void main(String[] args) {
        Olla o = new Olla(5);
        Cocinero c = new Cocinero(o);
        Thread[] canibales = new Thread[20];
        crear_canibales(canibales, o);
        c.start();
        activarHilos(canibales);


    }
    public static void crear_canibales(Thread[] c, Olla o){
        for (int i = 0; i < c.length; i++) {
            c[i] = new Canibal("#"+i,o);
        }
    }
    public static void activarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
