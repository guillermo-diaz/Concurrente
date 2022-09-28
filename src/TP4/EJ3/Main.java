package TP4.EJ3;

public class Main {
    public static void main(String[] args) {
        Recurso r = new Recurso();
        P1 h1 = new P1(r);
        P2 h2 = new P2(r);
        P3 h3 = new P3(r);
    

        h3.start();
        h2.start();
        h1.start();
    }
}
