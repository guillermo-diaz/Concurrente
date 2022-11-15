package TP5.EJ7;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

import Color.C;

public class Cuerda {
    public Semaphore mutex;
    public int cruzando;
    private int limite_cuerda = 5;
    private Semaphore cuerda_izq;
    private Semaphore cuerda_der;

    public Cuerda(){
        cruzando = 0;
        cuerda_der = new Semaphore(limite_cuerda);
        cuerda_izq = new Semaphore(limite_cuerda);

        mutex = new Semaphore(1);
    }

    public void cruzar(String dir){
        try {
            if (dir.equals("izq")){
                cuerda_izq.acquire();
                mutex.acquire();
                if (cruzando == 0){
                    System.out.println(C.PURPLE+"TURNO "+dir);
                    cuerda_der.acquire(limite_cuerda);
                }
                cruzando++;
                System.out.println(C.VERDE+name()+" cruzando. ("+cruzando+"/"+limite_cuerda+C.RESET);
                mutex.release();
            } else {
                cuerda_der.acquire();
                mutex.acquire();
                if (cruzando == 0){
                    System.out.println(C.PURPLE+"TURNO "+dir);
                    cuerda_izq.acquire(limite_cuerda);
                }
                cruzando++;
                System.out.println(C.VERDE+name()+" cruzando. ("+cruzando+"/"+limite_cuerda+C.RESET);
                mutex.release();
            }
            /*
            map.get(dir).acquire(1);
            mutex.acquire();
            if (cruzando == 0){
                System.out.println(C.PURPLE+"TURNO "+dir);
                map.get(opuesto(dir)).acquire(limite_cuerda);
                
            }
            cruzando++;
            System.out.println(C.VERDE+name()+" cruzando. ("+cruzando+"/"+limite_cuerda+C.RESET);
            mutex.release();
            */
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String name() {
        return Thread.currentThread().getName();
    }

    public void terminar_cruzar(String dir){
        try {

            if (dir.equals("izq")){
                mutex.acquire();
                cruzando--;
                if (cruzando == 0){
                    cuerda_der.release(limite_cuerda);
                } 
                System.out.println(C.ROJO+name()+" termino de cruzar ("+cruzando+"/"+limite_cuerda+C.RESET);
                cuerda_izq.release();
                mutex.release();
            } else {
                mutex.acquire();
                cruzando--;
                if (cruzando == 0){
                    cuerda_izq.release(limite_cuerda);
                } 
                System.out.println(C.ROJO+name()+" termino de cruzar ("+cruzando+"/"+limite_cuerda+C.RESET);
                cuerda_der.release();
                mutex.release();
            }
           /* 
            mutex.acquire();
            cruzando--;
            if (cruzando == 0){
                map.get(opuesto(dir)).liberar(limite_cuerda);
            }
            
            System.out.println(C.ROJO+name()+" termino de cruzar ("+cruzando+"/"+limite_cuerda+C.RESET);
            map.get(dir).liberar(1);
            mutex.release();
            */

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String opuesto(String dir){
        return dir.equals("izq") ? "der" : "izq";
    }






}
