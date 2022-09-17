package TP3.Ej7;

public class Main {
    public static void main(String[] args) {
        Turno turno = new Turno(3);
        ImprimeLetra h1 , h2, h3;
        h1 = new ImprimeLetra(0, 'A', 3, turno);
        h2 = new ImprimeLetra(1, 'B', 4, turno);
        h3 = new ImprimeLetra(2, 'C', 1, turno);
        System.out.println();
        h1.start();
        h2.start();
        h3.start();

    }
    
}
