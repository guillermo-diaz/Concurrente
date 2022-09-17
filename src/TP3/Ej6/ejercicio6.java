package TP3.Ej6;

import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        Random r = new Random();
        SumaTotal suma = new SumaTotal();
        int[] arreglo = new int[50000];
        int k = r.nextInt(arreglo.length);
        System.out.println(k+" hilos:");
        Sumar[] hilos = new Sumar[k];
        llenarArreglo(arreglo);
        llenarHilo(hilos, arreglo, suma);
        activarHilos(hilos);
        int sumaVerif = calcularSuma(arreglo);
        

        for (int j = 0; j < hilos.length; j++){
            try {
                hilos[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println("SUMA TOTAL VERIFCADA: "+sumaVerif);
        System.out.println("SUMA POR HILOS: "+suma.getSuma());

        


    }

    public static void llenarArreglo(int[] arr) {
        int longitud = arr.length;
        for (int i = 0; i < longitud; i++) {
            Random x = new Random();
            arr[i] = x.nextInt(10);

        }
    }

    public static void llenarHilo(Sumar[] arr, int[] arrNum, SumaTotal suma) {
        int longitud = arr.length;
        int min = 0;
        int max=  (arrNum.length / longitud);
        int resto = arrNum.length % (longitud);
        int salto = max;

        if (resto != 0){ //va a ir hasta el anteultimo pos del arreglo
            longitud--;
        }
        
        for (int i = 0; i < longitud; i++) { 
            
            arr[i] = new Sumar(arrNum, min, max, suma);
            
            min = max;
            max = max + salto;
        }

        if (resto != 0){ //si quedó algunas particiones del arreglo de num se los doy al ultimo arreglo para que las sume
            arr[longitud] = new Sumar(arrNum, min, arrNum.length, suma);
        } 

    }
    public static void activarHilos(Sumar[] arr){
        int lg = arr.length;
        for (int i = 0; i < lg; i++){
            arr[i].start();
            
        }
        
       
    }
    public static int calcularSuma(int[] arr){
        //verificador  
        int acum = 0;
        int lg = arr.length;
        for (int i = 0; i< lg; i++){
            acum = acum + arr[i];
        }
        return acum;
    }
}



