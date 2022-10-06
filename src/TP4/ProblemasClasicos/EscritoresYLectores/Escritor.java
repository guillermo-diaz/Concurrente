package TP4.ProblemasClasicos.EscritoresYLectores;

import java.util.Random;

public class Escritor extends Thread{
    private Documento doc;

    public Escritor(Documento d, String n){
        super(n);
        doc = d;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            if (r.nextBoolean()){
                doc.escribir();
                dormir();
                doc.dejarDeEscribir();
            } 
            dormir();
        }
    }

    public void dormir(){
        Random r = new Random();
        try {
            sleep(r.nextInt(10)*2000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
