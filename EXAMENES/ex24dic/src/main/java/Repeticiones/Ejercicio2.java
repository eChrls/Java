/*
Incluye en una clase llamada Ejercicio2 una función (método de clase) que reciba un array de String y devuelve una lista 
con el número mayor de vocales seguidas que tiene cada String del array. Por ejemplo, para el array de String 
["Mesa", "Bueno", "MiauMi", "Rtddr", "Medioeuropeo"] La lista a devolver es {1, 2, 3, 0, 4}

Crea un método para saber si un char es una vocal, y otro que devuelve el máximo número de vocales seguidas de un String. Usa estos
métodos en el ejercicio. 

En una nueva clase Programa, con el main, prueba el método sobre array de ejemplo de este ejercicio. 
 */
package Repeticiones;

import Apartados.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio2 {
    
    private static ArrayList<Integer> listaVocales (String[] array){
        ArrayList<Integer> listaVocales = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++) {
            int num = Ejercicio2.VocalesSeguidas(array[i]);    
            listaVocales.add(num);
        }
        
        return listaVocales;
    }
    
    private static boolean esVocal (char letra){
           
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vocales.length; i++) {
            if (vocales[i] == letra){
                return true;
            }
        }
        return false;
    }
    
    private static int VocalesSeguidas (String palabra){
        
        int vocalesSeguidas = 0;
        int contador = 0;
        
        for(char c : palabra.toLowerCase().toCharArray()){
            if(esVocal(c)){
                contador++;
                vocalesSeguidas = Math.max(contador, vocalesSeguidas);
            }else{
                contador = 0;
            }
        }

        return vocalesSeguidas;
    }
    public static void main(String[] args) {
        
        String array[]= {"Meeeeeeesa", "Bueno", "MiauMi", "Rtddr", "Medioeuropeo"};
        
        
        System.out.println(Ejercicio2.listaVocales(array));
    }
}