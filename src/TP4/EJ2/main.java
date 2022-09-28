package TP4.EJ2;

public class main {
    public static void main(String[] args) {
        Recurso r = new Recurso();
        P1 h1 = new P1(r);
        P2 h2 = new P2(r);
        P3 h3 = new P3(r);
        P4 h4 = new P4(r);

        h4.start();
        h2.start();
        h1.start();
        h3.start();
    }
}
