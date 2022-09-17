package TP3.Ej3;

public class Main {
    public static void main(String[] args) {
        boolean[] asientos = new boolean[5];
        Cliente[] clientes = new Cliente[7];
        Thread[] hilos = new Thread[clientes.length];
        crearCliente(clientes, asientos);
        llenarThread(hilos, clientes, 0);
        activarHilos(hilos);

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        mostrarArreglo(asientos);
        
    }

    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }

    public static void crearCliente(Cliente[] arr, boolean[] asientos){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Cliente(asientos);
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

    public static void mostrarArreglo(boolean[] arr){
        String cad;
        for (int i = 0; i < arr.length; i++) {
            cad = "["+i+"] -> ";
            if (arr[i]){
                cad = cad + "ocupado";
            } else {
                cad = cad+"libre";
            }
            System.out.println(cad);
        }
    }
}
