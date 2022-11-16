package TP5.Ej6;

public class Visitante extends Thread{
    private Mirador m;

    public Visitante(String n, Mirador m){
        super(n);
        this.m = m;
    }
    @Override
    public void run() {
        try {
            m.subir_escalera();
            m.usar_tobogan();
            sleep(1000);
            m.salir_tobogan();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    
    

}
