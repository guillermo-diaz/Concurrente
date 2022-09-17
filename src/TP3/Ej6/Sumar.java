package TP3.Ej6;

public class Sumar extends Thread{
    private int min;
    private SumaTotal acum;
    private int sumaActual;
    private int max;
    private int[] arr;

    public Sumar(int[] arr, int min, int max, SumaTotal acum) {
        this.arr = arr;
        this.min = min;
        this.max = max;
        this.acum = acum;
        this.sumaActual = 0;
    }

    public void run() {
        for (int i = min; i < max; i++) {
            sumaActual = sumaActual + arr[i];
        }
        //System.out.println(Thread.currentThread().getName()+" termino de sumar");
        acum.sumar(this.sumaActual);
        
    }
}
