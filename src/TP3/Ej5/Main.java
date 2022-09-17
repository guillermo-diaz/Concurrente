package TP3.Ej5;

public class Main {
    public static void main(String[] args) {
        Surtidor surtidor = new Surtidor(100);
        Auto[] autos = new Auto[10];
        llenarAutos(autos, surtidor);
        Thread[] hilos = new Thread[autos.length];
        llenarThread(hilos, autos, 0);
        activarHilos(hilos);

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("FIN: ESTADO SURTIDOR "+surtidor.getLitros());
    }
    public static void llenarAutos(Auto[] arr, Surtidor surtidor){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Auto("#"+i, "mod", 100, surtidor);
        }
    }
    public static void llenarThread(Thread[] arr, Runnable[] otroArr, int pos){
        int i = 0;

        while (pos < arr.length && i < otroArr.length){
            arr[pos] = new Thread(otroArr[i], "#"+i);
            pos++;
            i++;
        }
    }
    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
