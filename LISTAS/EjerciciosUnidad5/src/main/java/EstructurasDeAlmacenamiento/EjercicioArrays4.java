/*
4.- Vamos a programar un algoritmo que permita saber si un número es primo. Un número es primo 
cuando solo es divisible por la unidad y por sí mismo. Realiza una función que tenga como 
parámetro un long y devuelva si es primo o no. Usa un algoritmo de fuerza bruta. En el método 
main prueba los siguientes números, iterando sobre un array: 
100, 997, 65, 907, 911, 919, 997, 121071, 526823687.
*/
package EstructurasDeAlmacenamiento;

public class EjercicioArrays4 {
   
    public static void main(String[] args) {
        
    
    long[] array = {100, 997, 65, 907, 911, 919, 997, 121071, 526823687};
    
        for (int i = 0; i < array.length; i++) {
            boolean esPrimo = esPrimo(array[i]);
            System.out.println("Es " + array[i] + "primo? : " + esPrimo);
                   
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
