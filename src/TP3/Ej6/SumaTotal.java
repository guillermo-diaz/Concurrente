package TP3.Ej6;

public class SumaTotal {
    private int suma;

    public SumaTotal(){
        suma = 0;
    }

    public synchronized void sumar(int cant){
        suma = suma + cant;
    }
    public synchronized int getSuma(){
        return suma;
    }
}
