/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NotasExamen;

import java.util.ArrayList;
import java.util.Arrays;


public class Imprimir {
    
    public static void main(String[] args) {
        
   
    //LISTAS
     ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
        System.out.println("Contenido de la lista: " + lista);
    
    
    } 
    
    //ARRAYS
    public static void imprimirArray (int[] array){
    
            int[] pin = {1, 2, 3, 4};  // Ejemplo de un arreglo de enteros
        
        System.out.println("Contenido del arreglo: " + Arrays.toString(pin));
    
    }
    
      // Método para mostrar los pines de una lista
    public static void mostrarPines(ArrayList<int[]> listaPines) {
        for (int[] pin : listaPines) {
            for (int digito : pin) {
                System.out.print(digito);
            }
            System.out.println();
        }
    }
    
}
