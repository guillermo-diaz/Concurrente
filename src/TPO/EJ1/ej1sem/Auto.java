package TPO.EJ1.ej1sem;

public class Auto extends Thread {
    Lugar lugares;

    public Auto(Lugar l, String n){
        super(n);
        lugares = l;

    }

    @Override
    public void run() {
        try {
            lugares.subir();
            lugares.bajar();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
