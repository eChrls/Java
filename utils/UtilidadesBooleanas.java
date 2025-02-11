import java.util.Comparator;
import java.util.List;

/**
 * Indice:
 * 1. Numero primo
 * 2. Palindromo
 * 3. Potencia de dos
 * 4. Lista ordenada
 * 1. Validacion de si es un numero par
 * 2. Validacion de si es un año bisiesto
 */
public class UtilidadesBooleanas {

    /**
     * Verifica si un número es primo.
     *
     * @param n número a verificar
     * @return true si es primo
     */
    public static boolean esPrimo(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Verifica si una cadena es palíndromo.
     *
     * @param str cadena a verificar
     * @return true si es palíndromo
     */
    public static boolean esPalindromo(String str) {
        String limpio = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }

    /**
     * Verifica si un número es potencia de 2.
     *
     * @param n número a verificar
     * @return true si es potencia de 2
     */
    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Verifica si una lista está ordenada.
     *
     * @param <T>        tipo de los elementos
     * @param lista      lista a verificar
     * @param comparador comparador a usar
     * @return true si está ordenada
     */
    public static <T> boolean estaOrdenada(List<T> lista, Comparator<T> comparador) {
        if (lista.size() <= 1)
            return true;
        for (int i = 1; i < lista.size(); i++) {
            if (comparador.compare(lista.get(i - 1), lista.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un número es par.
     *
     * @param n número a verificar
     * @return true si es par
     */
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    /**
     * Verifica si un año es bisiesto.
     *
     * @param año año a verificar
     * @return true si es bisiesto
     */
    public static boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}