package TP3.Ej2;

public class Main {
    public static void main(String[] args) {
        int cant = 3;
        Orco[] orcos = new Orco[cant];
        Curandero[] curanderos = new Curandero[cant];
        Vida vid = new Vida(50);

        armarRunnable1(orcos, vid);
        armarRunnable2(curanderos, vid);
        Thread[] hilos = new Thread[orcos.length + curanderos.length];
        llenarThread(hilos, orcos, 0);
        llenarThread(hilos, curanderos, cant);
        activarHilos(hilos);
    }

    public static void llenarThread(Thread[] arr, Runnable[] otroArr, int pos){
        int i = 0;

        while (pos < arr.length && i < otroArr.length){
            arr[pos] = new Thread(otroArr[i], "#"+i);
            pos++;
            i++;
        }
    }
    public static void armarRunnable1(Orco[] arr, Vida vid){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Orco(vid);
        }
    }

    public static void armarRunnable2(Curandero[] arr, Vida vid){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Curandero(vid);
        }
    }
    
    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
