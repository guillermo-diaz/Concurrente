package TP5.Ej1;

import java.util.Random;

public class Empleado extends Thread{
    private final Confiteria c;

    public Empleado(Confiteria cf){
        c = cf;
    }
    @Override
    public void run() {
        Random r = new Random();

        c.entrar();
        switch(r.nextInt(3)){
            case 0: 
                System.out.println(getName()+" solo va a beber");
                bebida();
                break;
            case 1:
                System.out.println(getName()+" solo va a comer");
                comida(); break;
            case 2: 
                System.out.println(getName()+" va a beber y comer");
                bebida();
                comida(); 
                break;
        }
        c.salir();
    }

    public void bebida(){
        c.pedir_bebida();
        c.beber();
        sleep();
        System.out.println(getName()+" termino de beber");
    }

    public void comida(){
        c.pedir_comida();
        c.comer();
        sleep();
        System.out.println(getName()+ " termino de comer");
    }

    public void sleep(){
        Random r = new Random();
        try {
            sleep(r.nextInt(500));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
