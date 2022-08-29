package TP2;
//ejercicio 6
public class Cliente {
    private String nombre;
    private int[] carroCompra;
    // Constructor y métodos de acceso
    public Cliente(String nombre, int[] arr){
        this.nombre = nombre;
        carroCompra = arr;
    }
    public String getNombre(){
        return nombre;
    }
    public int[] getCarroCompra(){
        return carroCompra;
    }
    
}
