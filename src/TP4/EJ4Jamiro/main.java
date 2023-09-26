package TP4.EJ4Jamiro;


public class main {
    public static void main(String[] args) {
        Impresora[] a = new Impresora[3];

        llenarA(a);
        Centro c = new Centro(a);
        Cliente[] clientes = new Cliente[6];
        llenarClientes(clientes, c);
        activarHilos(clientes);

    }

    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }

    public static void llenarA(Impresora[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = new Impresora('A', "A"+i);
        }
    }

    public static void llenarClientes(Cliente[] u, Centro c){
    
        for (int i = 0; i < u.length; i++) {
            u[i] = new Cliente(c);
        }
        
    }
}
