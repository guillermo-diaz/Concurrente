package TP6.Ej5;

public class Main {
    public static void main(String[] args) {
        Caja caja = new Caja(60);
        Mostrador m = new Mostrador();
        Horno a, b, c;
        a = new Horno(m, 5);
        b = new Horno(m, 10);
        c = new Horno(m, 20);
        Brazo brazo = new Brazo(caja);
        int cant_robots = 2;
        Thread[] robots = new Thread[cant_robots];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot(m, caja);
        }

        a.start();
        b.start();
        c.start();
        brazo.start();
        for (int i = 0; i < robots.length; i++) {
            robots[i].start();
        }



    }
}
