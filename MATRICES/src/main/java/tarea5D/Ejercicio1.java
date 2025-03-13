/*Crea una matriz de números aleatorios entre 1 y 9, de tamaño NxM e imprime el resultado por consola. 
Pide al usuario un número entre 1 y 9 y comprueba si está o no en la matriz, indicando su fila y columna. 
Crea un método que devuelva la fila y columna donde está el número o -1 -1 si no está en la matriz.*/
package tarea5D;

import java.util.Random;


public class Ejercicio1 {
        

         public static int[][] comprobarPosicion(int numero, int[][] matriz){
             
            int[][]matrizPosicion = new int[0][0];
            
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                   if(matriz[i][j] == numero){
                      matrizPosicion = matriz; 
                        System.out.println("El numero esta en la posicion (columna, fila) =  " + i + " , " + j);
                       
                   }
                   if(matriz[i][j] != numero ||  numero<= 0){
                       System.out.println("-1 . - 1");
                   }
                }
            }
            return matrizPosicion;
         }
        
        
    
        public static boolean comprobarNumero(int numero, int[][] matriz){
            
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                   if(matriz[i][j] == numero){
                       return true;
                   }
                }
            }
            return false;
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
    
      
      public static void main(String[] args) {
          //Creamos una matriz del tamaño que queramos y la mostramos
          //Deberia controlarse que no se introdujeran valores negativos
         int[][] nuevaMatriz = crearMatriz(4, 4);
          mostrarMatriz(nuevaMatriz);
          //Comprobamos si esta el numero 4. Devuelve true o false.
          comprobarNumero(4, nuevaMatriz);
           //Indica la fila y columna del numero que queramos, en este caso el 4
          comprobarPosicion(4, nuevaMatriz);

          
          
          
    }
    
}
