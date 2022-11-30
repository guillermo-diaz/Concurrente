package Parcial.Semaforos;



import java.util.Random;

public class Insertor extends Thread{
    private BufferO buffer;

    public Insertor(BufferO b, String n){
        super(n);
        buffer = b;
    }

    @Override
    public void run() {
        Random r = new Random();
        int i = 1;
        
        while (true){
            try {
                buffer.insertar(r.nextInt(10));
                sleep(r.nextInt(2000));
                //sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
