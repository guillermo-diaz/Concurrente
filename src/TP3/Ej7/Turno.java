package TP3.Ej7;

public class Turno {
    private int turno;
    private int cantTurnos;

    public Turno(int cantTurnos){
        this.cantTurnos = cantTurnos;
        turno = 0;
    }

    public synchronized int getTurno(){
        return turno;
    }

    public synchronized void sigTurno(){
        turno = (turno+1)%cantTurnos;
    }
}
