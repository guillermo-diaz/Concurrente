package TP3.Ej2;

public class Vida {
    private int salud;

    public Vida(int vida){
        this.salud = vida;
    }

    public synchronized int getSalud(){
        return this.salud;
    }

    public synchronized void quitarVida(int puntos){
        this.salud = salud - puntos;
        System.out.println(Thread.currentThread().getName()+ " quito "+puntos+" de vida. Vida actual "+salud);
    }

    public synchronized void agregarVida(int puntos){
        this.salud = salud + puntos;
        System.out.println(Thread.currentThread().getName()+ " agrego "+puntos+" de vida. Vida actual "+salud);
    }
    
}
