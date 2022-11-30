package Parcial.Semaforos;



import java.util.Random;

public class Extractor extends Thread{
    private BufferO buffer;

    public Extractor(BufferO b, String n){
        super(n);
        buffer = b;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            try {
                buffer.extraer();
                sleep(3000);
              //  sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
