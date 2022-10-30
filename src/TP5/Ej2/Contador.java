package TP5.Ej2;

import java.util.concurrent.Semaphore;

public class Contador {
    private Integer esperando, comiendo; 
    private Semaphore sem_espera; //para que los hilos se queden bloqueados mientras esperan
    private int limite;

	public Contador(int limite) {
		esperando = 0;
		comiendo = 0;
        sem_espera = new Semaphore(0);
        this.limite = limite;
	}
	

	public int get_esperando() {
		return (int) esperando;
    }
	
	public void increase_esperando() {
        

            this.esperando++;
        
	}
	
	public void decrease_esperando() {
        
		this.esperando--;
	}
	

	public int get_comiendo() {
		return (int) comiendo;
	}
	
	public void increase_comiendo() {
		this.comiendo++;
	}
	
	public void decrease_comiendo() {
		this.comiendo--;
	}

    public void liberar_permisos(){
        if (esperando > limite){ //si hay mas del limite, libero los 10 de una
            sem_espera.release(limite);
        } else {
            sem_espera.release(esperando); //libero la cantidad que estan esperando
        }
    }

    public void tomar_permiso(){
        try {
            sem_espera.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
