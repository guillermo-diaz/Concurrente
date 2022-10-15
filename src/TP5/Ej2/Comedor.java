package TP5.Ej2;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore comedores;
    private Semaphore mutex_especie;
    private int cantidad;
    private Integer especie;
    private boolean control;


    public Comedor(int cant){
        especie = 0;
        comedores = new Semaphore(cant);
        cantidad = cant*2;
        mutex_especie = new Semaphore(1);
        especie = -1;
    }

    public boolean entrar(int esp){
    }

    public void comer(int esp){
        synchronized(especie){
            if (especie == -1){
                especie = esp;
                try {
                    mutex_especie.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                if (especie == esp){
                    if (control){
                        try {
                            comedores.acquire();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    } else {
                        
                    }
                } else {
                    try {
                        mutex_especie.acquire();
                        especie = esp;
                        comedores.acquire();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
