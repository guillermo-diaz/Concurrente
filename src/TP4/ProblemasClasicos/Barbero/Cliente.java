package TP4.ProblemasClasicos.Barbero;

import java.util.Random;

public class Cliente extends Thread{
    private Barberia b;

    public Cliente(Barberia br){
        this.b = br;
    }

    @Override
    public void run() {
        caminar();
        if (b.estadoSillon()){ //si esta ocupado, intento sentar en las sillas y esperar turno
            boolean turno = b.esperarTurnoEnSilla(); //busco una silla y me siento y espero el turno
            if (turno){ //si ya se corto se va
                b.irse();
            } else {
                System.out.println(getName()+" se quedó sin lugar, se fue de la barberia ||||||");
            }
        } else {
            b.cortarse();
            b.irse();
        }
    }
    
    public void caminar(){
        Random r = new Random();
        try {
            System.out.println(getName()+" caminando----------------");
            sleep(r.nextInt(1000));
            System.out.println(getName()+" llego a la barberia--------------");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
