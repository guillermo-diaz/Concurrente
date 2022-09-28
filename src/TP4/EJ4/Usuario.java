package TP4.EJ4;

import java.util.Random;

public class Usuario extends Thread {
    private char tipo;
    private Centro centro;

    public Usuario(char t, Centro c){
        tipo = t;
        centro = c;
    }

    @Override
    public void run() {
        if (tipo == 'A'){
            usarImpresoraA();
        } else if (tipo == 'B'){
            usarImpresoraB();
        } else {
            usarImpresoras();
        }
    }
    private void usarImpresoraA(){
        Impresora[] a = centro.getImpresorasA();
        boolean flag = false;
        int i = 0;
        Random r = new Random();
        int pos = r.nextInt(a.length); // para ir a impresora aleatoriamente 

        while (!flag && i < a.length) {
            if (!a[i].getEstado()){
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        usar(a[pos]);
    }
    private void usarImpresoraB(){
        Impresora[] b = centro.getImpresorasB();
        boolean flag = false;
        int i = 0;
        Random r = new Random();
        int pos = r.nextInt(b.length); // para ir a impresora aleatoriamente 

        while (!flag && i < b.length) {
            if (!b[i].getEstado()){
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        usar(b[pos]);
        
    }

    
    private void usarImpresoras(){
        Impresora[] b = centro.getImpresorasB();
        Impresora[] a = centro.getImpresorasA();
        
        boolean flag = false;
        int i = 0;
        Random r = new Random();
        int pos = r.nextInt(a.length); // para ir a impresora aleatoriamente 
        
        //busco si en las impresoras A hay lugares
        while (!flag && i < b.length) {
            if (!a[i].getEstado()){
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        
        if (flag){
            usar(a[pos]);
        } else { //si no hay lugares busco en B y me quedo esperando
            usarImpresoraB();
        }
        
        
    }
    private void usar(Impresora i){
        Random r = new Random();
        i.usar();
        try {
            sleep(r.nextInt(2000));
            i.dejar();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public char getTipo() {
        return tipo;
    }
    
}
