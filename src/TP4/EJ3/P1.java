package TP4.EJ3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class P1 extends Thread{
    private int iteraciones;
    public Recurso rec;

    public P1(Recurso r){
        iteraciones = 5;
        rec = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < iteraciones; i++) {
            try {
                rec.getSem1().acquire();
                System.out.println(i+" P1 Inicio");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            operaciones_p1(); 
            rec.getSem3().release();
        }
    }

    public void operaciones_p1(){
        Random r = new Random();
        System.out.println("operaciones p1");
        try {
            sleep(r.nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("fin operaciones");
    }
    
}
