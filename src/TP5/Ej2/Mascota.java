package TP5.Ej2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Mascota extends Thread{
    private Comedor com;
    private String tipo;
    static int num = 0;
    Random r = new Random();

    public Mascota(String t, Comedor c){
        super(t+" #"+num);
        tipo = t;
        com = c;
        num++;
    }
    @Override
    public void run() {
        try {
            sleep(r.nextInt(1000)); //para que no inicien todos juntos
        } catch (Exception e) {
            // TODO: handle exception
        }
        com.entrar(tipo);
        com.comer(tipo);
        morfar();
        com.salir(tipo);
    }

    public void morfar(){
        System.out.println(getName()+" comiendo....");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
