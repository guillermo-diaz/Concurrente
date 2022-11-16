package TP5.Ej6;

public class Encargado extends Thread{
    private Mirador m;

    public Encargado(Mirador m){
        this.m = m;
    }

    @Override
    public void run() {
        while(true){
            try {
                m.controlar();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
