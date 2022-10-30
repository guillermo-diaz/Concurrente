package TP5.Ej2;

public class Main {
    public static void activarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
    public static void main(String[] args) {
        int perros, gatos, platos, limite;
        perros = 30;
        gatos = 20;
        platos = 5;
        limite = platos;
        Comedor c = new Comedor(platos, limite);
        Thread[] mascotas = new Thread[perros + gatos];
        crear_mascotas(mascotas, c, perros);
        activarHilos(mascotas);

    }
    public static void crear_mascotas(Thread[] arr, Comedor c, int perros){
        for (int i = 0; i < perros; i++) {
            arr[i] = new Mascota("perro",c);
        }
        for (int i = perros; i < arr.length; i++) {
            arr[i] = new Mascota("gato",c);
        }
    }
}
