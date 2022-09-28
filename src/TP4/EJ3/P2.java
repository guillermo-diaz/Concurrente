package TP4.EJ3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class P2 extends Thread{
    private int iteraciones;
    public Recurso rec;

    public P2(Recurso r){
        iteraciones = 5;
        rec = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < iteraciones; i++) {
            try {
                rec.getSem2().acquire();
                System.out.println(i+" P2 Inicio");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            operaciones_p2(); 
            rec.getSem1().release(); 
        }
    }

    public void operaciones_p2(){
        Random r = new Random();
        System.out.println("operaciones p2");
        try {
           sleep(r.nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("fin operaciones");
    }
    
}
