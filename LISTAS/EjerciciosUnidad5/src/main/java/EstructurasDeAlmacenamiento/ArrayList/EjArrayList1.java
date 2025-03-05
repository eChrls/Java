/*1.- Hacer un programa que determine si dos arrays son iguales. Probarlo 
con los arrays [1,2,3] y [1,2,3], [1,2,3,4] y [1,2,3] , [1,2,3] y [1,2,2]. 
Este ejercicio hay que hacerlo de dos formas: la primera, usando la clase 
Arrays (busca una función para ello); la segunda, creando un método que 
vaya comparando los valores de los arrays posición por posición y devuelva 
true si todos los elementos de la misma posición son iguales o false en 
caso contrario. Repite el ejercicio para ArrayList. Para saber si dos 
listas son iguales puedes usar algún método de la clase List. 
También crea un método que reciba dos arraylist y compare sus valores, 
igual que con los arrays.*/
package EstructurasDeAlmacenamiento.ArrayList;

import java.util.*;

public class EjArrayList1 {
    
    public static boolean compararListas (ArrayList<Integer> lista1, ArrayList<Integer> lista2){

        return lista1.equals(lista2);
        //VERSION 2 CON IF, FOR Y EQUALS
        /*
        if(lista1.size() != lista2.size()) {
            return false;
        }
        for(int i = 0; i < lista1.size(); i++){
            if(!Object.equals(lista1.get(i), lista2.get(i))){
                return false;
        }
        }
        return true;
        */
    }
    
    public static boolean compararArrays (int[]array1, int[]array2){
        
        return Arrays.equals(array1, array2);
         //VERSION 2 CON IF y BUCLE FOR
        /*
        if(array1.length != array2.length){
            return false;
        }
        for (int i = 0; i <array1.length; i++){ //Recorre el array
        
            if(array2[i] != array1[i]){
                return false,
        }
        }
        return true;
        }
        }
        */
    }
    
    public static void main(String[] args) {
        //COMPARACIÓN DE LISTAS
        //declaramos listas y añadimos funciones y colecciones
        ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> lista2 = new ArrayList<>(lista1);
        ArrayList<Integer> lista3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> lista4 = new ArrayList<>(lista1);
        ArrayList<Integer> lista5 = new ArrayList<>(lista1);
        ArrayList<Integer> lista6 = new ArrayList<>(Arrays.asList(1, 2, 2));

        System.out.println("La lista 1 y la lista 2 son iguales? :" + compararListas(lista1, lista2));
        System.out.println("La lista 3 y la lista 4 son iguales? :" + compararListas(lista3, lista4));
        System.out.println("La lista 5 y la lista 6 son iguales? :" + compararListas(lista5, lista6));
        
        
        //  COMPARACION DE ARRAYS
        //declaramos arrays y añadimos valores
        int[] array1 = {1, 2, 3};
        int[] array2 = Arrays.copyOf(array1, 3);
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = Arrays.copyOf(array1, 3);
        int[] array5 = Arrays.copyOf(array1, 3);
        int[] array6 = Arrays.copyOf(array1, 3);
        array6[2] = 2;
        
        System.out.println("Array 1 y array 2 son iguales? :" + compararArrays(array1, array2));
        System.out.println("Array 3 y array 4 son iguales? :" + compararArrays(array3, array4));
        System.out.println("Array 5 y array 6 son iguales? :" + compararArrays(array5, array6));
        
        
        
                
    }
}
