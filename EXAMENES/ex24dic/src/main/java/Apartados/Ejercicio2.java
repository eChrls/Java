/*
Incluye en una clase llamada Ejercicio2 una función (método de clase) que reciba un array de String y devuelve una lista 
con el número mayor de vocales seguidas que tiene cada String del array. Por ejemplo, para el array de String 
["Mesa", "Bueno", "MiauMi", "Rtddr", "Medioeuropeo"] La lista a devolver es {1, 2, 3, 0, 4}

Crea un método para saber si un char es una vocal, y otro que devuelve el máximo número de vocales seguidas de un String. Usa estos
métodos en el ejercicio. 

En una nueva clase Programa, con el main, prueba el método sobre array de ejemplo de este ejercicio. 
 */
package Apartados;

public class Ejercicio2 {
    
      // Método para verificar si un carácter es vocal
    public static boolean esVocal(char c) {
        char letra = Character.toLowerCase(c);
        return letra == 'a' || letra == 'e' || letra == 'i' || 
               letra == 'o' || letra == 'u';
    }
    
    // Método para contar máximo de vocales seguidas en un String
    public static int maxVocalesSeguidas(String palabra) {
        int maxVocales = 0;
        int contadorActual = 0;
        for (int i = 0; i < palabra.length(); i++) {
                char c = palabra.charAt(i);
                if(esVocal(c)){
                contadorActual++;
                maxVocales = Math.max(maxVocales, contadorActual);
            } else {
                contadorActual = 0;
            }
        }
        
       /* 
        for (char c : palabra.toCharArray()) {
            if (esVocal(c)) {
                contadorActual++;
                maxVocales = Math.max(maxVocales, contadorActual);
            } else {
                contadorActual = 0;
            }
        }
     */   
        return maxVocales;
    }
    
    // Método principal que procesa el array de String
    public static int[] contarVocalesSeguidas(String[] palabras) {
        int[] resultado = new int[palabras.length];
        
        for (int i = 0; i < palabras.length; i++) {
            resultado[i] = maxVocalesSeguidas(palabras[i]);
        }
        
        return resultado;
    }
}