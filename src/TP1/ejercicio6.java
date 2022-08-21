package TP1;

public class ejercicio6 {
        public static double acceso_por_indice (double [] v, int j) throws RuntimeException{
            try{
                if ((0 <= j) && (j <= v.length)){
                    return v[j];
                }else {
                    throw new RuntimeException ("El indice " + j + " no existe en el vector");
                }
            } catch (RuntimeException exc){
                throw exc;
            }
        }
        public static double acceso_por_indice_2(double[] v, int j) throws RuntimeException{
            //solucion
            try {
                return v[j];
            } catch (RuntimeException e) {
                
                throw new RuntimeException ("El indice " + j + " no existe en el vector");
                //TODO: handle exception
            }
        }
        // Desde el siguiente cliente “main”:
        public static void main(String [] args){
            double [] v = new double [15];
            
            //agrego try para que siga la ejecucion a pesar del error
            try {
                acceso_por_indice_2 (v, 16);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("aaa");
            
        }
}

