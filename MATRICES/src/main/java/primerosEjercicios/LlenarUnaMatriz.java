
package primerosEjercicios;

import java.util.Random;


public class LlenarUnaMatriz {
    
    public static void main(String[] args) {
        
        int[][]matriz = crearMatriz(5,5);
        mostrarMatriz(matriz);
    }
    
    public static int[][] crearMatriz(int n, int m){
        Random r = new Random();
        int[][] matriz = new int[n][m];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(1, 10);
            }
        }
        return matriz;
    }
    
    
    public static void mostrarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                
            }
            System.out.println("");
            }
        }

}
