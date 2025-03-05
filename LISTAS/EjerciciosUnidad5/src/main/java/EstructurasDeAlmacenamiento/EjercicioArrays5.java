/*
5.- Usando de base el ejercicio anterior, crea una función que reciba un array de long y 
devuelva un array de boolean indicando si el número que ocupa la posición i del array es primo 
o no. Esto es, si el número de la posición cero del array de long es primo se debe guardar 
true en la posición cero del array de booleanos y así sucesivamente. 
Muestra el resultado en el main.
 */
package EstructurasDeAlmacenamiento;
import java.util.*;
public class EjercicioArrays5 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
    
    long[] array = {100, 997, 65, 907, 911, 919, 997, 121071, 526823687};
    boolean [] arrayB = new boolean [9];
    
        for (int i = 0; i < array.length; i++) {
            boolean esPrimo = esPrimo(array[i]);
            
            arrayB[i] = esPrimo(array[i]);
            
            System.out.println(arrayB[i]);
                   
        } 
    }
    public static boolean esPrimo(long numero){
        
        if(numero%2==0)
            return false;
        for (int i = 3; i*i<=numero; i+=2) {
            if(numero % i == 0)
                return false;
            }
        return true;
         
    }  
}