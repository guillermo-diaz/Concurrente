package TP3.Ej6;

import java.util.Random;
/* TRABAJO PRACTICO OBLIGATORIO 1

- Cristopher Ovaillos
- Guillermo Diaz
 * 
 */

public class ejercicio6 {
    public static void main(String[] arg) {
        int[] arreglo = new int[50000];
        llenarArreglo(arreglo);
        //mostrarArr(arreglo);
        
        HiloSumar[] arrHilos = new HiloSumar[10000];

        llenarHilo(arrHilos, arreglo);
        
        
        try {
            activarHilos(arrHilos);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sumas = 0;
        for (int j = 0; j<arrHilos.length; j++){
            sumas = sumas + arrHilos[j].getAcum();
        }
       
        mostrarSuma(arreglo);
        System.out.println("Acum: "+sumas);
    }
    

    public static void activarHilos(HiloSumar[] arr) throws InterruptedException{
        int lg = arr.length-1;
        for (int i = 0; i <= lg; i++){
            arr[i].start();
            
        }
        for (int j = 0; j <= lg; j++){
            arr[j].join();
        }
       
    }
    
    public static void llenarHilo(HiloSumar[] arr, int[] arrNum) {
        // precondicion: arrNum.length | arr.length
        int longitud = arr.length;
        int min = 0;
        int max=  (arrNum.length / (longitud));
        int salto = max;

        
        for (int i = 0; i < longitud; i++) {
            
            arr[i] = new HiloSumar(arrNum, min, max);
            
            min = max;
            max = max + salto;
        }

    }

    public static void mostrarSuma(int[] arr){
        //verificador  
        int acum = 0;
        for (int i = 0; i< arr.length; i++){
            acum = acum + arr[i];
        }
        System.out.println("SUMA TOTAL: "+acum);
    }
    public static void llenarArreglo(int[] arr) {
        int longitud = arr.length;
        for (int i = 0; i < longitud; i++) {
            Random x = new Random();
            arr[i] = x.nextInt(10);

        }
    }
    public static void mostrarArr(int[] arr) {
        int longitud = arr.length;
        for (int i = 0; i < longitud; i++) {
            System.out.println("- "+arr[i]);

        }
    }


}
class HiloSumar extends Thread {

    /**
     * @param args the command line arguments
     */
    private int min;
    private int acumActual =0;
    public static int acum = 0;
    private int max;
    private int[] arr;

    public HiloSumar(int[] arr, int min, int max) {
        this.arr = arr;
        this.min = min;
        this.max = max;

    }

    public void run() {
        for (int i = min; i < max; i++) {
            acumActual = acumActual + arr[i];
        }
    
    }
    
    public int getAcum(){
        return acumActual;
    }

}


