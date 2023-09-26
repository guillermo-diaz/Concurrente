package TP4.EJ4Jamiro;

import java.util.concurrent.Semaphore;

public class Centro {
    public static Impresora[] impresoras;


    public Centro(Impresora[] imp){
        impresoras = imp;

    }

    public static Impresora[] getImpresoras() {
        return impresoras;
    }

   

    
}
