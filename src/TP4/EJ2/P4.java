package TP4.EJ2;

import java.util.Random;

public class P4 extends Thread{
    private int iteraciones;
    public Recurso rec;

    public P4(Recurso r){
        iteraciones = 5;
        rec = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < iteraciones; i++) {
            try {
                rec.getSem4().acquire();
                System.out.println(i+" P4 Inicio");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            operaciones_p4(); 
        }
    }

    public void operaciones_p4(){
        Random r = new Random();
        System.out.println("operaciones p4");
        try {
            //sleep(r.nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("fin operaciones");
    }
}
