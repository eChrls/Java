/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.myprojects.tarea5fmatrices;

import java.util.Scanner;

/**
 *
 * @author Casa
 */
public class Tarea5FMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la altura de la copa del árbol (entre 2 y 10):");
        int alturaCopa = scanner.nextInt();

        if (alturaCopa < 2 || alturaCopa > 10) {
            System.out.println("Altura de copa no válida. Debe estar entre 2 y 10.");
            return;
        }

        char[][] arbol = generarArbol(alturaCopa);

        System.out.println("\nTu árbol:");
        mostrarArbol(arbol);

    }

    public static char[][] generarArbol(int alturaCopa) {
        int alturaTotal = alturaCopa + 2; // Copa + tronco
        int anchoBaseCopa = 2 * alturaCopa - 1;
        char[][] arbol = new char[alturaTotal][anchoBaseCopa];

        // Llenar la matriz con espacios
        for (int i = 0; i < alturaTotal; i++) {
            for (int j = 0; j < anchoBaseCopa; j++) {
                arbol[i][j] = ' ';
            }
        }

        // Generar la copa
        for (int i = 0; i < alturaCopa; i++) {
            int numAsteriscos = 2 * i + 1;
            int espacioIzquierda = (anchoBaseCopa - numAsteriscos) / 2;
            for (int j = 0; j < numAsteriscos; j++) {
                arbol[i][espacioIzquierda + j] = '*';
            }
        }

        // Generar el tronco
        for (int i = alturaCopa; i < alturaTotal; i++) {
            arbol[i][anchoBaseCopa / 2] = '*';
            arbol[i][anchoBaseCopa / 2 + 1] = '*';
        }

        return arbol;
    }

    public static void mostrarArbol(char[][] arbol) {
        for (int i = 0; i < arbol.length; i++) {
            for (int j = 0; j < arbol[i].length; j++) {
                System.out.print(arbol[i][j]);
            }
            System.out.println();
        }
    }
}
