package TP4.ProblemasClasicos.Barbero;

public class Main {
    public static void main(String[] args) {
        Barberia b = new Barberia();
        Barbero barbero = new Barbero(b);
        Cliente[] c = new Cliente[8];
        crearClientes(c, b);
        barbero.start();
        activarHilos(c);
        
        //joinHilos(c);

        
    }

    public static void crearClientes(Cliente[] arr, Barberia br){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Cliente(br);
        }
    }
    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }

    public static void joinHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
