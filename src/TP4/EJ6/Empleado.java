package TP4.EJ6;

import java.util.Random;

public class Empleado extends Thread{
    private final Confiteria c;

    public Empleado(Confiteria cf){
        c = cf;
    }
    @Override
    public void run() {
        
        c.entrar();
        c.comer();
        comer();
        c.salir();
    }

    public void comer(){
        Random r = new Random();
        try {
            sleep(r.nextInt(500));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
