package TP6.Ej6;

import java.util.Random;

public class Donante extends Thread{
    public static final String ROJO = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private final Sala sala;

    public Donante(String n, Sala s){
        super(n);
        sala = s;
    }
    @Override
    public void run() {
        sala.entrar_sala();
        blood();
        sala.salir();
    }

    public void blood(){
        
        Random r = new Random();
        try {
            System.out.println(ROJO+getName()+" donando sangre . . ."+RESET);
            sleep(r.nextInt(2000));
            System.out.println(ROJO+getName()+" termino de donar sangre"+RESET);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
