package TP4.EJ5;

public class Taxista extends Thread{
    private Taxi taxi;
    final int it = 3;

    public Taxista(Taxi t){
        taxi = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < it; i++) {
            taxi.esperarCliente();
            recorrido(); 
            taxi.llegada();
            volverParada();; //el recorrido a la parada de taxi
        }
    }

    public void volverParada(){
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void recorrido(){
        try {
            System.out.println("yendo al destino....");
            sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
