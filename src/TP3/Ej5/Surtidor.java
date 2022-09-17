package TP3.Ej5;

public class Surtidor {
    private int maxLit;

    public Surtidor(int lt){
        maxLit = lt;
    }

    public synchronized int getLitros(){
        return maxLit;
    }

    public boolean cargarCombustible(int cant){
        boolean flag = false;

        synchronized (this){
            if (cant < maxLit){
                System.out.println("Estado del surtidor antes de la recarga de "+Thread.currentThread().getName()+": "+maxLit);
                maxLit = maxLit - cant;
                flag = true;
                System.out.println(Thread.currentThread().getName()+" Recargó "+cant+" litros");
                System.out.println("Estado Surtidor luego "+Thread.currentThread().getName()+": "+maxLit+" lts");
            }
            
        }
        return flag;
    }
}
