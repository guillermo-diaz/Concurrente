package TP2;

//ejercicio 1
public class ClienteEj1 extends Thread {
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
        ClienteEj1 juan=new ClienteEj1();
        juan.setName("Juan Lopez");
        ClienteEj1 ines=new ClienteEj1 ();
        ines.setName ("Ines Garcia");
        ines.start();
        juan.start();
    }
}

    
