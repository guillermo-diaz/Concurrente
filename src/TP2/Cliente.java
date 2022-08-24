package TP2;

//ejercicio 1
public class Cliente extends Thread {
    public void run(){
        System.out.println("soy "+Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);

        }catch (InterruptedException e) {
        }
    }
}
class Recurso {
    static void uso(){
        Thread t=Thread.currentThread();
        System.out.println("en Recurso: Soy " + t.getName());
    }
}
class testeoRecurso {
    public static void main (String[] args){
        Cliente juan=new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines=new Cliente ();
        ines.setName ("Ines Garcia");
        ines.start();
        juan.start();
    }
}

    
