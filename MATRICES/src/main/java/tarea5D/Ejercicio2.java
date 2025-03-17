/*Crea dos matrices de NxM con números aleatorios entre 1 y 9.
En un método que recibe las dos matrices, suma los elementos que 
ocupan las mismas posiciones en ambas matrices y guarda el resultado en una nueva matriz, 
en la misma posición y devuelve el resultado. Imprime el resultado.*/
package tarea5D;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio2 {
    // suma los valores de espacios comunes, si una matriz es mas grande
    // que otra, se creara una tercera con el tamaño de la matriz mas chica.
    public static int[][] sumaDeMatrices(int[][] matriz1, int[][] matriz2) {

        int longitud = Math.max(matriz1.length, matriz2.length);
        int[][] matriz3 = new int[longitud][longitud];

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                matriz3[i][j] = matriz1[i][j] + matriz2[i][j];

            }
        }
        return matriz3;
    }

    // suma los valores de M1(0,0) de manera creciendo con M2(Ultimo,Ultimo) de manera decreciente, 
    //y lo devuelve en M3(0,0) de manera creciente
   public static int[][] sumaDeMatricesInversa(int[][] matriz1, int[][] matriz2) {
    // Obtener las dimensiones de las matrices
    int filas1 = matriz1.length;
    int columnas1 = matriz1[0].length;
    int filas2 = matriz2.length;
    int columnas2 = matriz2[0].length;

    // Verificar que las matrices tengan las mismas dimensiones
    if (filas1 != filas2 || columnas1 != columnas2) {
        throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones.");
    }

    int[][] matriz3 = new int[filas1][columnas1];

    for (int i = 0; i < filas1; i++) {
        for (int j = 0; j < columnas1; j++) {
            // Sumar el elemento de matriz1 en orden creciente
            // con el elemento de matriz2 en orden decreciente
            matriz3[i][j] = matriz1[i][j] + matriz2[filas2 - 1 - i][columnas2 - 1 - j];
        }
    }

    return matriz3;
}

    public static int[][] creaMatriz(int n, int m) {
        Random r = new Random();
        int[][] matriz = new int[n][m];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(1, 10);
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int[][] matriz1 = creaMatriz(4, 4);
        int[][] matriz2 = creaMatriz(4, 4);
        System.out.println("Matrices creadas");
        mostrarMatriz(matriz1);
        System.out.println("-----------");
        mostrarMatriz(matriz2);
        System.out.println("-----------");
        System.out.println("Matriz resultado: ");
        int[][] matriz3 = sumaDeMatrices(matriz1, matriz2);
        mostrarMatriz(matriz3);
        System.out.println("-----------");
        System.out.println("Matriz resultado inversa: ");
        int[][] matriz4 = sumaDeMatricesInversa(matriz1, matriz2);
        mostrarMatriz(matriz4);
        
    }

}
