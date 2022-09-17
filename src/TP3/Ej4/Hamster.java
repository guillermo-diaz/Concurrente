package TP3.Ej4;

import java.util.Random;

public class Hamster extends Thread {

    static Jaula jaula;


    public Hamster(Jaula j1){
        jaula = j1;
    }

    public void run(){
        boolean flag1 = false, flag2 = false, flag3 = false;
        int actividades = 0;

        while (actividades < 3){
            if (!flag1 && jaula.getPlato().usarPlato()){
                usar();
                jaula.getPlato().dejarPlato();
                flag1 = true;
                actividades++;
            }

            if (!flag2 && jaula.getHamaca().usarHamaca()){
                usar();
                jaula.getHamaca().dejarHamaca();
                flag2 = true;
                actividades++;
            }

            if (!flag3 && jaula.getRueda().usarRueda()){
                usar();
                jaula.getRueda().dejarRueda();
                flag3 = true;
                actividades++;
            }

        } 
        System.out.println(Thread.currentThread().getName()+ " termino todas sus actividades");

    }
    public void usar(){
        Random r = new Random();
        try {
           Thread.sleep(r.nextInt(10)*500);
           //Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
