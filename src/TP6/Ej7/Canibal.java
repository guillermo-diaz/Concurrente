package TP6.Ej7;

public class Canibal extends Thread{
    private final Olla olla;

    public Canibal(String n, Olla o){
        super(n);
        olla = o;
    }

    @Override
    public void run() {
        olla.comer();
    }
}
