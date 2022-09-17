package TP3.Ej4;

public class Jaula {
    private final Hamaca hamaca;
    private final Plato plato;
    private final Rueda rueda;

    public Jaula(Hamaca h, Plato p, Rueda r){
        hamaca = h;
        plato = p;
        rueda = r;
    }
    public Hamaca getHamaca(){
        return hamaca;
    }
    public Plato getPlato(){
        return plato;
    }
    public Rueda getRueda(){
        return rueda;
    }
}
