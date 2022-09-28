package TP4.EJ3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class P3 extends Thread{
    private int iteraciones;
    public Recurso rec;

    public P3(Recurso r){
        iteraciones = 5;
        rec = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < iteraciones; i++) {
            try {
                rec.getSem3().acquire();
                System.out.println(i+" P3 Inicio");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            operaciones_p3(); 
            rec.getSem2().release();
        }
    }

    public void operaciones_p3(){
        Random r = new Random();
        System.out.println("operaciones p3");
        try {
           sleep(r.nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("fin operaciones");
    }
    
}
