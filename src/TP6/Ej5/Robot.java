package TP6.Ej5;

public class Robot extends Thread{
    private Mostrador mostrador;
    private Caja caja;

    public Robot(Mostrador m, Caja c){
        mostrador = m;
        caja = c;

    }

    @Override
    public void run() {
        while (true){
            int peso = mostrador.retirar_pastel();
            caja.soltar_pastel(peso);
        }
    }
}
