package TP4.ProblemasClasicos.EscritoresYLectores;

import java.util.Random;

public class Lector extends Thread{

    private Documento doc;

    public Lector(Documento d){
        doc = d;
    }
    @Override
    public void run() {
        dormir();
        while (true){
            doc.leer();
            dormir();
        }
    }

    public void dormir(){
        Random r = new Random();
        try {
            sleep(r.nextInt(10)*1000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
