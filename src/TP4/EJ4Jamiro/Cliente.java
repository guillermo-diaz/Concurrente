package TP4.EJ4Jamiro;

import java.util.Random;

public class Cliente extends Thread {
    Centro centro;

    public Cliente(Centro centro) {
        this.centro = centro;
    }
    
    public void run(){
        System.out.println(Thread.currentThread().getName());
        Impresora[] impresoras = centro.getImpresoras();
        Random r = new Random();
        boolean flag = false;
        int i = 0;

        while(!flag){
            try {
                if (impresoras[r.nextInt(3)].usar()){
                    
                    flag = true;
                    usarImp(); //sleep
                    impresoras[i].dejar();
                } 
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    private void usarImp(){
        Random r = new Random();

        try {
            sleep(r.nextInt(10000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
