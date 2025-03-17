/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea5D;

/**
Ejercicio 4
*  * Clase BuscaUnos que representa una matriz cuadrada de números aleatorios (0 y 1)
 * y proporciona métodos para buscar patrones específicos.
 */
public class BuscaUnos {

    public int[] buscarCeroRodeadoDeUnos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    Posicion pos = new Posicion(i, j); // Crea un objeto Posicion
                    if (comprobarAdyacentes(pos, matriz)) {
                        return new int[]{i, j}; // Devuelve las coordenadas del primer cero encontrado
                    }
                }
            }
        }
        return null; 
    }

    private boolean comprobarAdyacentes(Posicion pos, int[][] matriz) {
        int fila = pos.getFila();
        int columna = pos.getColumna();

        // Creamos un array con los valores de las posiciones adyacentes
        int[] adyacentes = {-1, 0, 1};

        // Recorremos el array y comprobamos si la posición adyacente es un 1
        for (int i = 0; i < adyacentes.length; i++) {
            for (int j = 0; j < adyacentes.length; j++) {
                // Si la posición adyacente es la misma posición, la saltamos
                if (adyacentes[i] == 0 && adyacentes[j] == 0) {
                    continue;
                }

                // Si la posición adyacente no existe en la matriz, la saltamos
                if (!Posicion.existeEnMatriz(matriz, fila + adyacentes[i], columna + adyacentes[j])) {
                    continue;
                }

                // Si la posición adyacente no es un 1, devolvemos false
                if (matriz[fila + adyacentes[i]][columna + adyacentes[j]] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
    
    

}



