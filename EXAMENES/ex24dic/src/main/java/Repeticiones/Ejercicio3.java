/*
La normalización de datos de un rango numérico modifica un dato del conjunto para que se ajuste a un rango específico,
generalmente de 0 a 1. Para ello se usa la siguiente fórmula: 
    valor - min(max-min)
    no me funciona con esta formula. Uso (valor - min) / (max - min)

Donde valor es el dato numérico que se quiere normalizar. Max es el valor máximo del rango de datos y min es el valor minimo. 
Después de normalizar los datos el valor máximo del rango será 1 y el mínimo será 0. Por ejemplo para la lista {1.0, 8.5, 7.0, 4.3}
su normalización es {0.0, 1.0, 0.8, 0.44}.

Crea una clase llamada Ejercicio3, con el método main. En esta clase añade una función que reciba una lista de números y devuelva otra
lista con los datos normalizados, usando un foreach. Crea las funciones max y min para calcular el máximo y el minimo 
de un rango de datos. En el main, usa la lista de ejemplo que hay en el ejercicio y comprueba el resultado. 
 */
package Repeticiones;

import Apartados.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 {
    
    private static ArrayList<Double> normalizacion (ArrayList<Double> lista){
        
        double max = 0.0;
        double min = 10.0;
        double numNormalizado = 0.0;
        ArrayList<Double> listaNormalizada = new ArrayList<>();
        
        for (double num : lista){
            max = Math.max(max, num);
        }
        
        for (double num : lista){
            min = Math.min(min, num);
        }
        
        for (double num : lista){
            numNormalizado =(num - min) / (max - min);
            listaNormalizada.add(numNormalizado);
        }
        
        return listaNormalizada; 
    }

    public static void main(String[] args) {
    
        ArrayList<Double> lista = new ArrayList<>();
        
        lista.add(1.0);
        lista.add(8.5);
        lista.add(7.0);
        lista.add(4.3);
        
        System.out.print("Lista sin normalizar : " + lista );
        
        lista = Ejercicio3.normalizacion(lista);
        
        System.out.println("Lista normalizada : " + lista);
        
        
        
    }
}
