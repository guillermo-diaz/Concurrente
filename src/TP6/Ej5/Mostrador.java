package TP6.Ej5;
import Color.C;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mostrador {
    private Lock mutex = new ReentrantLock();
    private Condition pastel_available;
    private Queue<Pastel> pasteles = new LinkedList<>();

    public Mostrador(){
        pastel_available = mutex.newCondition();
    }

    public void agregar_pastel(Pastel p){
        mutex.lock();
        pasteles.add(p);
        pastel_available.signalAll();
        System.out.println(C.AMARILLO+"Se agregó pastel de "+p.get_peso()+" al mostrador."+C.RESET);
        mutex.unlock();
    }

    public int retirar_pastel(){
        int peso = 0;
        try {
            mutex.lock();
            while (pasteles.isEmpty())
                pastel_available.await();
            
            peso = pasteles.poll().get_peso();
            System.out.println(C.AMARILLO+"Se retiró pastel de "+peso+C.RESET);
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            mutex.unlock();
        }
        return peso;
    }
}
