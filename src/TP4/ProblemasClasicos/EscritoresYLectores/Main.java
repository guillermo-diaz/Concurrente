package TP4.ProblemasClasicos.EscritoresYLectores;



public class Main {
   public static void main(String[] args) {
      Lector[] lectores = new Lector[4];
      Escritor e1, e2;
      Documento doc = new Documento();
      e1 = new Escritor(doc, "#1");
      e2 = new Escritor(doc, "#2");
      crearLectores(lectores,doc);
      e1.start();
      e2.start();
      activarHilos(lectores);


   } 
   public static void crearLectores(Lector[] arr, Documento dc){
      for (int i = 0; i < arr.length; i++) {
         arr[i] = new Lector(dc);
      }
   }
   public static void activarHilos(Thread[] arr){
      for (int i = 0; i < arr.length; i++) {
          arr[i].start();
      }
  }
}
