package TP5.Piscina;

public class Main {
    public static void main(String[] args) {
        Piscina p = new Piscina(3);
        Boludo[] hilos = new Boludo[7];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Boludo(p);
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
