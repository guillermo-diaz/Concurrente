package TP5.EJ7;

public class Babuino extends Thread{
    String direccion;
    private Cuerda cuerda;

    public Babuino(String n, Cuerda c, String d){
        super(n);
        direccion = d;
        cuerda = c;

    }
    @Override
    public void run() {
        cuerda.cruzar(direccion);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cuerda.terminar_cruzar(direccion);
    }

    public String toString(){
        return getName()+direccion;
    }
}
