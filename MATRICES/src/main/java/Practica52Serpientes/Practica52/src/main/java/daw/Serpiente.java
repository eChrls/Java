/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Arrays;

/**
 *
 * @author jfervic933
 */
public class Serpiente {
    
    public static int[][] generarSerpientePython(){
        int[][] matriz = matrizConCeros(6);
        matriz[1][1] = matriz[2][1] = matriz[2][2] = 
        matriz[2][3] = matriz[2][4] = matriz[3][4] = 
        matriz[4][4] = matriz[4][5] = 1;
        return matriz;
    }
    
    public static int[][] generarSerpienteBoa(){
        int[][] matriz = matrizConCeros(8);
        matriz[1][0] = matriz[1][1] = matriz[1][2] = 
        matriz[1][3] = matriz[1][4] = matriz[1][5] = 
        matriz[2][5] = matriz[3][5] = 1;
        return matriz;
    }
    
    private static int[][] matrizConCeros(int dimension){
        int[][] matriz = new int[dimension][dimension];
        for (int[] fila : matriz) {
            Arrays.fill(fila, 0);
        }
        return matriz;
    }
    
    
}
