package Parcial.Semaforos;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import Color.C;

public class BufferO {
    LinkedList<Object> ins = new LinkedList<>();
    LinkedList<Object> ext = new LinkedList<>();
    private Semaphore mutexIns;
    private Semaphore mutexExt;
    private Semaphore hayElem;

    public BufferO(){
        mutexIns = new Semaphore(1);
        mutexExt = new Semaphore(1);
        hayElem = new Semaphore(0);
    }

    private String name(){
        return Thread.currentThread().getName();
    }

    public void insertar(Object elem) throws InterruptedException{
        mutexIns.acquire();
        ins.add(elem);

        System.out.println(C.VERDE+name()+" inserto elem "+elem+C.RESET);
        status(C.AMARILLO);

        mutexIns.release();
        hayElem.release();
    }

    public Object extraer() throws InterruptedException{
        hayElem.acquire();
        mutexExt.acquire();

        System.out.println(C.ROJO+name()+" llegó "+C.RESET);
        mutexIns.acquire();
        if (ext.isEmpty() && !ins.isEmpty()){
            swap();
        }
        mutexIns.release();

        Object ret = ext.poll();
        System.out.println(C.ROJO+name()+" extrajo elem "+ret+C.RESET);
        status(C.PURPLE);
        
        mutexExt.release();
        
        return ret;
    }

    public void swap(){
        //lockIns.lock(); //para que no inserten mientras oscilo
        LinkedList<Object> aux = ins;
        ins = ext;
        ext = aux; //ext = ins
        System.out.println(C.CYAN+"-----------------------------OSCILACION by "+name()+"-----------------------------"+C.RESET);
        status(C.CYAN);
        //lockIns.unlock();
    }

    public void status(String color){
      
        System.out.println(color+" COLA INSERTAR "+ins.toString()+C.RESET);
        System.out.println(color+" COLA EXTRACCION "+ext.toString()+C.RESET);
    }

}
