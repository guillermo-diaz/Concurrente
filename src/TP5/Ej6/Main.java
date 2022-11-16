package TP5.Ej6;

public class Main {
    public static void main(String[] args) {
        Mirador m = new Mirador();
        Encargado e = new Encargado(m);
        e.start();
        Thread[] visitantes = new Thread[10];
        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Visitante("#"+i, m);
        }
        for (Thread v : visitantes) {
            v.start();
        }
    }
}
