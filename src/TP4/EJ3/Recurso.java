package TP4.EJ3;

import java.util.concurrent.Semaphore;

public class Recurso {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    
    public Recurso(){
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }

    public Semaphore getSem1() {
        return sem1;
    }
    
    public Semaphore getSem2() {
        return sem2;
    }
    
    public Semaphore getSem3() {
        return sem3;
    }


    
    
}
