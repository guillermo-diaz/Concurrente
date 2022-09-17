package TP3.Ej5;

import java.util.Random;

public class Auto extends Vehiculo implements Runnable{
    private int combustible;
    private Surtidor surtidor;

    public Auto(String pat, String mod, int k, Surtidor surt) {
        super(pat, mod, k);
        this.combustible = 50;
        surtidor = surt;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag && combustible > 0){

            recorrer();
            Random r = new Random();
            System.out.println(Thread.currentThread().getName()+" llego al nivel de reserva");
            
            flag = surtidor.cargarCombustible(r.nextInt(100)); //si recarga puede seguir recorriendo
        }
        System.out.println(Thread.currentThread().getName()+" se quedó sin combustible");

    }

    public void recorrer(){
        Random r = new Random();
        System.out.println(Thread.currentThread().getName()+ " empezó a recorrer");

        while (combustible > 10){ //10 de reserva
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            combustible = combustible - r.nextInt(10);
        }
    }
    
}
