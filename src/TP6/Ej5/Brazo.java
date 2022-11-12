package TP6.Ej5;

public class Brazo extends Thread{
    private final Caja caja;

    public Brazo(Caja c){
        caja = c;
    }

    @Override
    public void run() {
        while (true){
            caja.retirar();
            caja.reponer();
        }
    }
}
