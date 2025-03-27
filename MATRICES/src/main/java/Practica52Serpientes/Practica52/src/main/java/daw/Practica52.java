/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfervic933
 */
public class Practica52 {

    public static void main(String[] args) {
        
        List<Celda> lista = new ArrayList();
        int[][] matriz = Serpiente.generarSerpientePython();
        mostrarMatriz(matriz);
        Celda primeraCelda = buscarPrimeraCelda(matriz);
        // Si hay una celda para empezar
        if (primeraCelda.esValida(matriz)){
            lista = buscarSepiente(primeraCelda, matriz);
        }
        lista.forEach(System.out::println);
        mostrarMatriz(matriz);
    }
    
    // Este método devuelve la lista de casillas con la serpiente, a partir
    // de la casilla inicial
    public static List<Celda> buscarSepiente(Celda inicio, int[][] matriz){
        List<Celda> lista = new ArrayList();
        Celda siguiente = inicio;
        do {
            // Se añade a la lista de casillas de la serpiente
            lista.add(siguiente);
            // Se pone como visitada
            siguiente.visitar(matriz);
            // Se busca la siguiente
            siguiente = buscarSiguiente(siguiente, matriz);
            // Se repite mientras haya casillas válidas
            // En caso de no haber serpiente devuelve casilla -1,-1
        } while (siguiente.esValida(matriz));
        return lista;
    }
    
    // Este método sirve para buscar la siguiente celda por donde seguir
    // Hay que tener en cuenta que, según el ejercicio, sólo puede haber
    // una posibilidad entre los cuatro caminos posibles
    public static Celda buscarSiguiente(Celda celda, int[][] matriz){
        Celda izquierda = new Celda(celda.fila(), celda.columna()-1);
        Celda derecha = new Celda(celda.fila(), celda.columna()+1);
        Celda arriba = new Celda(celda.fila()-1, celda.columna());
        Celda abajo = new Celda(celda.fila()+1, celda.columna());
        Celda siguiente = new Celda(-1,-1);
        if (izquierda.esValida(matriz) && izquierda.contieneUno(matriz)){
            siguiente = izquierda;
        } else if(derecha.esValida(matriz)&&derecha.contieneUno(matriz)){
            siguiente = derecha;
        } else if(arriba.esValida(matriz)&&arriba.contieneUno(matriz)){
            siguiente = arriba;
        } else if (abajo.esValida(matriz)&&abajo.contieneUno(matriz)){
            siguiente = abajo;
        }
        return siguiente;
    }
    
    // Se encarga de buscar la primera casilla que contenga un 1 dentro
    // de la matriz. En caso de no encontrarla devuelve una celda no válida
    public static Celda buscarPrimeraCelda(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j]==1){
                    return new Celda(i,j);
                }
                
            }
            
        }
        return new Celda(-1,-1);
    }
    
    public static void mostrarMatriz(int[][] array){
        for (int[] is : array) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
