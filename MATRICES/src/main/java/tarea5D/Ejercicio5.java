package tarea5D;

import java.util.Random;

public class Ejercicio5 {

    public static void main(String[] args) {
        int dimension = 5;
        int[][] matriz = generarMatrizAleatoria(dimension);

        System.out.println("Matriz generada:");
        imprimirMatriz(matriz);

        System.out.println("\nDiagonal principal:");
        mostrarDiagonalPrincipal(matriz);

        System.out.println("\nDiagonal secundaria:");
        mostrarDiagonalSecundaria(matriz);

        int fila = 2; // Ejemplo de fila
        int columna = 3; // Ejemplo de columna

        System.out.println("\nFila " + fila + " ascendente:");
        mostrarFilaAscendente(matriz, fila);

        System.out.println("\nFila " + fila + " descendente:");
        mostrarFilaDescendente(matriz, fila);

        System.out.println("\nColumna " + columna + " ascendente:");
        mostrarColumnaAscendente(matriz, columna);

        System.out.println("\nColumna " + columna + " descendente:");
        mostrarColumnaDescendente(matriz, columna);
    }

    // Genera una matriz cuadrada de NxN con números aleatorios 0 o 1
    public static int[][] generarMatrizAleatoria(int dimension) {
        int[][] matriz = new int[dimension][dimension];
        Random random = new Random();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matriz[i][j] = random.nextInt(2);
            }
        }
        return matriz;
    }

    // Recorre la matriz para imprimir los valores formateados
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Muestra los elementos de la diagonal principal
    public static void mostrarDiagonalPrincipal(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();
    }

    // Muestra los elementos de la diagonal secundaria
    public static void mostrarDiagonalSecundaria(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - 1 - i] + " ");
        }
        System.out.println();
    }

    // Muestra los elementos de una fila en orden ascendente
    public static void mostrarFilaAscendente(int[][] matriz, int fila) {
        for (int j = 0; j < matriz.length; j++) {
            System.out.print(matriz[fila][j] + " ");
        }
        System.out.println();
    }

    // Muestra los elementos de una fila en orden descendente
    public static void mostrarFilaDescendente(int[][] matriz, int fila) {
        for (int j = matriz.length - 1; j >= 0; j--) {
            System.out.print(matriz[fila][j] + " ");
        }
        System.out.println();
    }

    // Muestra los elementos de una columna en orden ascendente
    public static void mostrarColumnaAscendente(int[][] matriz, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][columna] + " ");
        }
        System.out.println();
    }

    // Muestra los elementos de una columna en orden descendente
    public static void mostrarColumnaDescendente(int[][] matriz, int columna) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            System.out.print(matriz[i][columna] + " ");
        }
        System.out.println();
    }
}