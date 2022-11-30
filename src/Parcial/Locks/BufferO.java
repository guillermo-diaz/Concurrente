package Parcial.Locks;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Color.C;

public class BufferO {
    LinkedList<Object> ins = new LinkedList<>();
    LinkedList<Object> ext = new LinkedList<>();
    Lock lockIns = new ReentrantLock();
    Lock lockExt = new ReentrantLock();
    Lock lockVerEstado = new ReentrantLock();
    Condition hayElem =lockExt.newCondition();


    private String name(){
        return Thread.currentThread().getName();
    }

    public void insertar(Object elem){
        lockIns.lock();
        ins.add(elem);
        System.out.println(C.VERDE+name()+" inserto elem "+elem+C.RESET);
        status(C.AMARILLO);
        
        lockExt.lock();
        if (ext.isEmpty()){
            swap();
        }
        hayElem.signalAll();
        lockExt.unlock();

        lockIns.unlock();
    }

    public Object extraer() throws InterruptedException{
        lockExt.lock();
        while (ext.isEmpty()){
            System.out.println(name()+ " espera");
            hayElem.await();
        }
        Object ret = ext.poll();
        System.out.println(C.ROJO+name()+" extrajo elem "+ret+C.RESET);
        lockExt.unlock();

        /*solucion a caso especial donde cuando un insertor inserta un elemento(ob1), hace swap y queda "qIns = [] | qExt = [ob1]". 
        luego otro insertor llega y pone otro elem(ob2) "qIns = [ob2] | qExt = [ob1]", luego un extractor saca ob1 "qIns = [ob2], qExt = []", 
        y llega otro extractor distinto intenta extraer pero no puede ya q tiene q esperar a un insertor para poder extraer 
        
        Lo hago afuera del lock de ext para evitar deadlock
        */
        lockIns.lock();
        if (ext.isEmpty() && !ins.isEmpty()){
            swap();
        }
        lockIns.unlock();
        status(C.PURPLE);
        return ret;
    }

    public void swap(){
        //lockIns.lock(); //para que no inserten mientras oscilo
        LinkedList<Object> aux = ins;
        ins = ext;
        ext = aux;
        System.out.println(C.CYAN+"-----------------------------OSCILACION by "+name()+"-----------------------------"+C.RESET);
        status(C.CYAN);
        //lockIns.unlock();
    }

    public void status(String color){
      
        System.out.println(color+" COLA INSERTAR "+ins.toString()+C.RESET);
        System.out.println(color+" COLA EXTRACCION "+ext.toString()+C.RESET);
    }

}
