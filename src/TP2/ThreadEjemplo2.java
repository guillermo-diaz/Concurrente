package TP2;

public class ThreadEjemplo2 implements Runnable {
    //ejercicio 4
    public void run() {
        for (int i = 0; i < 10 ; i++)
            System.out.println(i + " " + Thread.currentThread().getName());
            System.out.println("Termina thread " + Thread.currentThread().getName());
    }
    
    public static void main (String [] args) {
        ThreadEjemplo2 a = new ThreadEjemplo2();
        ThreadEjemplo2 b = new ThreadEjemplo2();
        Thread h1 = new Thread(a, "Maria Jose");
        Thread h2 = new Thread(b, "Jose Maria");
        h1.start();
        h2.start();
        System.out.println("Termina thread main");
    }
}

