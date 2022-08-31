package TP2;

public class Ejercicio7 {
   public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1});
        CajeroThread cajero1 = new CajeroThread("Cajero 1", cliente1, System.currentTimeMillis());
        CajeroThread cajero2 = new CajeroThread("Cajero 2", cliente2, System.currentTimeMillis());
        Thread h1 = new Thread(cajero1);
        Thread h2 = new Thread(cajero2);
        h1.start();
        h2.start();
   } 
}
