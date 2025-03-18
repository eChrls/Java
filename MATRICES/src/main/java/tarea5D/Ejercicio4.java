/* Ej4.-
Implementa una aplicación que genere matrices de NxN (cuadrada) con números
aleatorios entre 0 y 1. Se debe poder imprimir la matriz en consola y
debe haber un método que busque dentro de la matriz las coordenadas de
la primera casilla que encuentre cuyo valor sea cero y esté rodeada de
unos en todas las casillas de su alrededor.*/
package tarea5D;

import java.util.Random;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        //inicializamos una matriz de 1s y 0s de tamaño 5
        int dimension = 5; 
        int[][] matriz = generarMatrizAleatoria(dimension);
        
        //La imprimimos
        System.out.println("Matriz generada:");
        imprimirMatriz(matriz);
        
        //Buscamos las coordenadas de los 1s con los metodos de la clase BuscaUnos
        BuscaUnos buscador = new BuscaUnos();
        int[] coordenadas = buscador.buscarCeroRodeadoDeUnos(matriz);
        
        
        if (coordenadas != null) {
            System.out.println("Se encontró un cero rodeado de unos en las coordenadas: (" + coordenadas[0] + ", " + coordenadas[1] + ")");
        } else {
            System.out.println("No se encontró ningún cero rodeado de unos.");
        }
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
    //Recorre la matriz para imprimir los valores formateados
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}