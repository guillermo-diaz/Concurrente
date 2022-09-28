package TP4.EJ4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Impresora[] a = new Impresora[3];
        Impresora[] b = new Impresora[2];
        llenarA(a);
        llenarB(b);
        Centro c = new Centro(a, b);
        Usuario[] users = new Usuario[8];
        llenarUsuarios(a, b, users, c);
        mostrarUsers(users);
        activarHilos(users);

    }
    public static void mostrarUsers(Usuario[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+" "+arr[i].getTipo());
        }
    }
    public static void llenarA(Impresora[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = new Impresora('A', "A"+i);
        }
    }
    public static void activarHilos(Thread[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }

    public static void llenarB(Impresora[] b){
        for (int i = 0; i < b.length; i++) {
            b[i] = new Impresora('B', "B"+i);
        }
    }

    public static void llenarUsuarios(Impresora[] a, Impresora[] b, Usuario[] u, Centro c){
        Random r = new Random();
        int min = 65, max = 67;
        char tipo;
    
        for (int i = 0; i < u.length; i++) {
            tipo = (char) (r.nextInt((max-min)+1)+min);
            u[i] = new Usuario(tipo, c);
        }
        
    }
}
