package TP2;

//ejercicio 5
public class MiHilo implements Runnable {
    String nombreHilo;
    public MiHilo(String nombre){
        nombreHilo=nombre;
    }
    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    public void run(){
        System.out.println("Comenzando "+nombreHilo);
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(0);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando "+nombreHilo);
    }
}
class UsoHilos{
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto unHilo.
        MiHilo mh=new MiHilo("#1");
        //Luego, construye un hilo de ese objeto.
        Thread nuevoHilo=new Thread(mh);
        //Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        
        for (int i=0; i<50;i++){
            System.out.print(" .");
        } 
        try{
            Thread.sleep(0);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}

//modificado usando ext thread 
class MiHilo2 extends Thread{
    public MiHilo2 (String str) {
        super(str);
    }
    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    public void run(){
        System.out.println("Comenzando "+this.getName());
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(0);
                System.out.println("En "+this.getName()+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(this.getName() + "Interrumpido.");
        }
        System.out.println("Terminando "+this.getName());
    }
    
}

class UsoHilos2{
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto unHilo.
        MiHilo2 nuevoHilo = new MiHilo2("#1");
        /*
        inciso d)
        MiHilo2 nuevoHilo2 = new MiHilo2("#2");
        nuevoHilo2.start(); */
        nuevoHilo.start();
        
        for (int i=0; i<50;i++){
            System.out.print(" .");
        } 
        try{
            Thread.sleep(0);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado."); 
    }
}
