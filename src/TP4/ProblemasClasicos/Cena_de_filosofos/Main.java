package TP4.ProblemasClasicos.Cena_de_filosofos;

public class Main {
    public static void main(String[] args) {
        Filosofo[] filosofos = new Filosofo[3];
        crearFilosofos(filosofos);
        mostrarFilosofos(filosofos);
        activarHilos(filosofos);
        joinHilos(filosofos);
        System.out.println("Fin");
    }

    static void mostrarFilosofos(Filosofo[] arr){
        for (Filosofo filosofo : arr) {
            System.out.println(filosofo.toString());
        }
    }

    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
    public static void crearFilosofos(Filosofo[] arr){
        Tenedor izq = new Tenedor("#0");
        Tenedor der = new Tenedor("#1");
        Tenedor primerTenedor = izq;
        int ultimo = arr.length-1;

        for (int i = 0; i < ultimo; i++) {
            arr[i] = new Filosofo(izq, der);
            izq = der;
            der = new Tenedor("#"+(i+2));
        }
        arr[ultimo] = new Filosofo(izq, primerTenedor);
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
