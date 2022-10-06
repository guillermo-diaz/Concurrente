package TP4.EJ6;

public class Main {
    public static void main(String[] args) {
        Confiteria c = new Confiteria();
        Empleado[] e = new Empleado[5];
        crearEmpleados(e, c);
        Mozo mozo = new Mozo(c, e);
        mozo.start();
        activarHilos(e);
    }

    public static void crearEmpleados(Empleado[] e, Confiteria c){
        for (int i = 0; i < e.length; i++) {
            e[i] = new Empleado(c);
        }
    }

    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
