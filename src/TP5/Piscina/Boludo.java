package TP5.Piscina;

import java.util.Random;

public class Boludo extends Thread{
    
    public Piscina piscina;

    public Boludo(Piscina p){
        piscina = p;   
    }

    public void run(){
        try {
            Random r = new Random();
            
            piscina.entrar();
            sleep(r.nextInt(10000)); //simula el tiempo en la piscina
            piscina.salir();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
