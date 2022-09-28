package TP4.EJ4;

public class Centro {
    private Impresora[] impresorasA;
    private Impresora[] impresorasB;

    public Centro(Impresora[] a, Impresora[] b){
        impresorasA = a;
        impresorasB = b;
    }

    public Impresora[] getImpresorasA() {
        return impresorasA;
    }

    public Impresora[] getImpresorasB() {
        return impresorasB;
    }
    
}
