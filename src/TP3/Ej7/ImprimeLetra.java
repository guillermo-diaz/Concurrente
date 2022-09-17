package TP3.Ej7;

import java.util.Random;

public class ImprimeLetra extends Thread{
    private int t, cantidad;
    private char letra;
    private Turno turno;
    public static int iteraciones = 3;
    
    public ImprimeLetra(int turn, char l, int cant, Turno tc){
        t = turn;
        letra = l;
        cantidad = cant;
        turno = tc;
    }
    
    public void run(){
        int cant = 0;
        
        while (cant < iteraciones){ //repeticiones
            if (turno.getTurno() == t){
                for (int i = 1; i <= cantidad; i++) {
                    System.out.print(letra);
                }
                turno.sigTurno();
                cant++;
            } else {
                dormir();
            }
        }
    }
    private void dormir(){
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
