/*Crea dos matrices de NxM con números aleatorios entre 1 y 9.
En un método que recibe las dos matrices, suma los elementos que 
ocupan las mismas posiciones en ambas matrices y guarda el resultado en una nueva matriz, 
en la misma posición y devuelve el resultado. Imprime el resultado.*/
package tarea5D;

import java.util.Arrays;
import java.util.Random;


public class Ejercicio2 {
        //suma los valores de espacios comunes, si una matriz es mas grande
        //que otra, se creara una tercera con el tamaño de la matriz mas chica.
        public static int[][]sumaDeMatrices(int[][]matriz1, int[][]matriz2){
            
            int longitud = Math.max(matriz1.length, matriz2.length);
            int[][] matriz3 = new int[longitud][longitud];
            
            
            for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz1.length; j++) {
                    matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
                    
                }
         }
            return matriz3;
        }
        
    
    
       public static int[][] creaMatriz(int n, int m){
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
      
      public static void main(String[] args) {
        
            int[][]matriz = crearMatriz(4, 4);
            int[][]matriz = crearMatriz(4, 4);
           
          
      
          
    }
      
}
