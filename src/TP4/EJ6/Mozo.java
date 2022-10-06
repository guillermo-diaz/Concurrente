package TP4.EJ6;

import java.util.Random;

public class Mozo extends Thread{
    final Confiteria confi;
    public Empleado[] empleados;

    public Mozo(Confiteria c, Empleado[] e){
        confi = c;
        empleados = e;
    }

    @Override
    public void run() {
        for (Empleado empleado : empleados) {
            confi.atender();
            comida();
            confi.entregarComida();
        }
    }

    public void comida(){
        Random r = new Random();
        try {
            sleep(r.nextInt(500));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


}
