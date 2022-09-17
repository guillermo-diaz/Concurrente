package TP3.Ej2;

import java.util.Random;

public class Orco implements Runnable{
    private Vida vida;

    public Orco(Vida vid){
        vida = vid;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        boolean flag = true;

        while (flag){
            if (vida.getSalud() > 0){
                System.out.println("Orc "+Thread.currentThread().getName()+" va a atacar. Vida actual "+vida.getSalud());
                vida.quitarVida(3);
                try {
                    Random r = new Random();
                    Thread.sleep(r.nextInt(9)*500);
                    
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } else {
                flag = false;
                System.out.println("El objetivo de Orc"+Thread.currentThread().getName()+" fue derrotado");
            }
        }
    }
    
}
