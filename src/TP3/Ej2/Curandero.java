package TP3.Ej2;

import java.util.Random;

public class Curandero implements Runnable{
    private Vida vida;

    public Curandero(Vida salud){
        this.vida = salud;
    }

    public void run() {
        boolean flag = true;

        while (flag){
            if (vida.getSalud() > 0){
                System.out.println("cur "+Thread.currentThread().getName()+" va a curar. Vida actual "+vida.getSalud());
                vida.agregarVida(3);
                try {
                    Random r = new Random();
                    Thread.sleep(r.nextInt(10)*500);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            } else {
                flag = false;
                System.out.println("El objetivo de cur"+Thread.currentThread().getName()+" a curar esta muerto");
            }
        }
        
    }
}
