package EstructurasDeAlmacenamiento;

import java.util.*;

public class EjercicioArrays5B {

    // Método principal 'main', que es el punto de entrada al programa.
    public static void main(String[] args) {
        // Creamos un array de números largos (long) que vamos a comprobar si son primos.
        long[] array = {100, 997, 65, 907, 911, 919, 997, 121071, 526823687};
        
        // Llamamos al método 'esPrimo' pasando el array de números largos.
        // Este método devolverá un array de booleanos que indica si cada número es primo (true) o no (false).
        boolean[] res = esPrimo(array);
        
        // Ahora mostramos el resultado de si cada número es primo o no.
        // Recorremos el array original 'array' y el array de resultados 'res' y los imprimimos.
        for (int i = 0; i < array.length; i++) {
            // Si 'res[i]' es true, el número 'array[i]' es primo.
            if (res[i]) {
                System.out.println("El número " + array[i] + " es primo.");
            } else {
                System.out.println("El número " + array[i] + " no es primo.");
            }
        }
    }

    /**
     * Método que recibe un array de números largos (long) y devuelve un array de booleanos
     * donde cada posición indica si el número correspondiente es primo (true) o no (false).
     * 
     * @param array El array de números largos que vamos a comprobar.
     * @return Un array de booleanos, donde cada posición indica si el número correspondiente
     *         en el array de entrada es primo o no.
     */
    public static boolean[] esPrimo(long[] array) {
        // Creamos un array de booleanos que tendrá el mismo tamaño que el array de entrada.
        // En cada posición guardaremos 'true' si el número correspondiente en el array es primo,
        // o 'false' si no lo es.
        boolean[] res = new boolean[array.length];
        
        // Recorremos cada número en el array de entrada.
        for (int i = 0; i < array.length; i++) {
            // Llamamos al método 'esPrimo' (presumiblemente de otra clase) para comprobar si
            // el número 'array[i]' es primo. Almacenar el resultado en la posición correspondiente
            // del array 'res'. Si es primo, será 'true', de lo contrario será 'false'.
            res[i] = EjercicioArrays4.esPrimo(array[i]);
        }
        
        // Devolvemos el array de resultados (booleanos) indicando la primalidad de cada número.
        return res;
    }
}