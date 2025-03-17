/*Crea una matriz de números aleatorios entre 1 y 9, de tamaño NxM e imprime el resultado por consola. 
Pide al usuario un número entre 1 y 9 y comprueba si está o no en la matriz, indicando su fila y columna. 
Crea un método que devuelva la fila y columna donde está el número o -1 -1 si no está en la matriz.*/
package tarea5D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ejercicio1 {
        
        //metodo para recibir un numero y una matriz y devuelve un array con la posicion fila y columna
         public static int[] comprobarPosicion(int numero, int[][] matriz){
           int[] coordenadas = {-1, 1};
           
           if (numero>0 && numero<10){
               for (int i = 0; i < matriz.length; i++) {
                   for (int j = 0; j < matriz[i].length; j++) {
                       return new int[]{i,j};
                   }
               }
           }
             return coordenadas; 
         }

         //Mismo metodo pero en vez de devolver posicion devuelve lista de posiciones.
         //Requiere una clase posicion
         public static List<Posicion> comprobarPosicionList(int numero, int[][]matriz){
             
             List<Posicion> posiciones = new ArrayList<>();
             
             for (int i = 0; i < matriz.length; i++) {
                 for (int j = 0; j < matriz[i].length; j++) {
                     if(matriz[i][j] ==numero){
                         posiciones.add(new Posicion(i,j));
                     }
                 }
             }
             return posiciones;
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
