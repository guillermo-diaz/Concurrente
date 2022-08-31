package TP2;
//ejercicio 6b
public class CajeroThread extends Thread{
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    // Constructor, y métodos de acceso
    public CajeroThread(String nombre, Cliente cliente, long time){
        this.nombre = nombre;
        this.cliente = cliente;
        initialTime = time;
    }
    public void esperarXsegundos(int seg){
        try {
            Thread.sleep(seg*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void run() {
        System.out.println("El cajero "+this.nombre+" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "+
        this.cliente.getNombre()+" EN EL TIEMPO: "+(System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + " ->Tiempo: " +
            (System.currentTimeMillis() - this.initialTime) / 1000+ "seg");
        }
        System.out.println("El cajero '" + this.nombre + "' HA TERMINADO DE PROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " +
        (System.currentTimeMillis() - this.initialTime) / 1000 +
        " seg");
    }

}
