package TP1;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        edadPersona(12);
    }

    public static void edadPersona(int edad) throws RuntimeException{
        if (edad < 18){
            throw new menor_de_edad("es menor de edad");
        } else {
            System.out.println("es mayor");
        }
        
        

    }

}
class menor_de_edad extends RuntimeException{
    public menor_de_edad(){
    }
    public menor_de_edad(String st){
        super(st);
    }
}
