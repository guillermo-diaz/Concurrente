package TP3.Ej4;

public class ejercicio4 {
    public static void main(String[] args)  {

        
        Hamaca h = new Hamaca();
        Plato p = new Plato();
        Rueda r = new Rueda();
        Jaula j1 = new Jaula(h, p, r);

        Hamster[] arreglo = new Hamster[5];
        llenarArreglo(arreglo, j1);
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].start();
        }

        for (int j = 0; j < arreglo.length; j++) {
            try {
                arreglo[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("fin");
       
    }

    public static void llenarArreglo(Hamster[] arreglo, Jaula j1) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Hamster(j1);
        }
    }
}
