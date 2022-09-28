package TP4.EJ5;

public class Main {
    public static void main(String[] args) {
        Taxi t = new Taxi();

        Pasajero p1 = new Pasajero(t);
        Pasajero p2 = new Pasajero(t);
        Pasajero p3 = new Pasajero(t);
        Taxista t1 = new Taxista(t);

        t1.start();
        p1.start();
        p2.start();
        p3.start();


    }
}
