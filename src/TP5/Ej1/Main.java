package TP5.Ej1;

public class Main {
    public static void main(String[] args) {
        Confiteria c = new Confiteria();
        Cocinero cocinero = new Cocinero(c);
        Mozo mozo = new Mozo(c);
        Empleado[] e = new Empleado[3];
        crearEmpleados(e, c);
        activarHilos(e);
        mozo.start();
        cocinero.start();

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
