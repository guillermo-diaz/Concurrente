package TP3.Ej3;

public class Cliente implements Runnable{
    private boolean[] asientos;

    public Cliente(boolean[] arr){
        asientos = arr;
    }

    @Override
    public void run() {
        int pos, cantAsientos;
        pos = 0;
        cantAsientos = asientos.length;
        boolean flag = false;

        while (!flag && pos < cantAsientos){
            System.out.println(Thread.currentThread().getName()+" intenta conseguir el asiento "+pos);
            synchronized(this.asientos){ //protejo el rec compartido
                if (!asientos[pos]){ //si no esta ocupado
                    asientos[pos] = true;
                    flag = true;
                    System.out.println(Thread.currentThread().getName()+" ocupo el asiento "+pos);
                } 
            }
            pos++;
        }

        if (!flag){
            System.out.println(Thread.currentThread().getName()+" se quedó sin asientos");
        }

    }
    
}
