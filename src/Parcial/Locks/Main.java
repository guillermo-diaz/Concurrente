package Parcial.Locks;

public class Main {
    public static void main(String[] args) {
        BufferO b = new BufferO();
        Insertor[] insertores = new Insertor[4];
        Extractor[] extractores = new Extractor[5];

        for (int i = 0; i < insertores.length; i++) {
            insertores[i] = new Insertor(b, "#I"+i);
            insertores[i].start();
        }

        for (int i = 0; i < extractores.length; i++) {
            extractores[i] = new Extractor(b, "#E"+i);
            extractores[i].start();
        }

    }

}
