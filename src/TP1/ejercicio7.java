package TP1;

import java.io.IOException;

public class ejercicio7 {
    public static int metodo(){
        int valor = 0;
        try {
            valor++;
            valor = valor + Integer.parseInt("W");
            valor++;
            System.out.println("try "+valor);
        } catch (NumberFormatException e) {
            
            valor = valor + Integer.parseInt("W");
            
            System.out.println("catch "+valor);
        } finally{
            valor++;
            System.out.println("finally "+valor);
        }
        valor++;
        System.out.println(valor);
        return valor;
    }
    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
