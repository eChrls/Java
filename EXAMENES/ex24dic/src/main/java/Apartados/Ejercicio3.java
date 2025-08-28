/*
La normalización de datos de un rango numérico modifica un dato del conjunto para que se ajuste a un rango específico,
generalmente de 0 a 1. Para ello se usa la siguiente fórmula: 
    valor - min(max-min)

Donde valor es el dato numérico que se quiere normalizar. Max es el valor máximo del rango de datos y min es el valor minimo. 
Después de normalizar los datos el valor máximo del rango será 1 y el mínimo será 0. Por ejemplo para la lista {1.0, 8.5, 7.0, 4.3}
su normalización es {0.0, 1.0, 0.8, 0.44}.

Crea una clase llamada Ejercicio3, con el método main. En esta clase añade una función que reciba una lista de números y devuelva otra
lista con los datos normalizados, usando un foreach. Crea las funciones max y min para calcular el máximo y el minimo 
de un rango de datos. En el main, usa la lista de ejemplo que hay en el ejercicio y comprueba el resultado. 
 */
package Apartados;

import java.util.Arrays;

public class Ejercicio3 {

    public static double[] listaNormalizada(double[] numeros) {
        
        //valor = (valor - min) / (max - min )
        double minimo = minimo(numeros);
        double maximo = maximo(numeros);
        
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (numeros[i] - minimo)/(maximo - minimo);
            
        }
               
        return numeros;
    }
    
    public static double maximo (double[] numeros){
        double maximo = numeros[0]; 
        
        
        for (double num : numeros){
            if (num > maximo){
                maximo = num;
            }
        }
      
        return maximo; 
    }
    
    public static double minimo (double[] numeros){
        double minimo = numeros[0]; 
         for (double num : numeros){
            if (num < minimo ){
                minimo = num;
            }
        }
        return minimo; 
    }
    
    

    public static void main(String[] args) {
    
        double numeros[] = {1.0, 8.5, 7.0, 4.3};
        System.out.println("Lista sin normalizar: " + Arrays.toString(numeros));
        listaNormalizada(numeros);
        System.out.println("Lista normalizada : " + Arrays.toString(numeros));
        
    
    }
}
