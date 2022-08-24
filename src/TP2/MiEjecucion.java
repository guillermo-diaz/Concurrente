package TP2;

//ejercicio 2
public class MiEjecucion extends Thread{
    public void run(){
    // ir();
        System.out.println("En la pila");
    }
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("En la pila");
    }
}
class TesteoHilos{
    public static void main (String[] args){
        Thread miHilo= new MiEjecucion();
        miHilo.start();

        /*solucion para que imprima primero
        try {
            Thread.currentThread().sleep(1000); //duermo el main
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         */
        
        System.out.println("En el main");
    }
}
    
