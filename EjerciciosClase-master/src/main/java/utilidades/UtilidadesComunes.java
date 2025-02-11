package utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Clase que proporciona métodos utilitarios comunes para operaciones frecuentes en Java.
 * Incluye comparaciones, fechas, strings y algoritmos básicos.
 */
public class UtilidadesComunes {

    // -------------------- COMPARACIONES BÁSICAS --------------------
    
    /**
     * Implementación básica de equals para cualquier clase con un ID
     * @param actual objeto actual
     * @param otro objeto a comparar
     * @param id identificador del objeto actual
     * @param idOtro identificador del objeto a comparar
     * @return true si son iguales
     */
    public static boolean equalsBasico(Object actual, Object otro, long id, long idOtro) {
        if (actual == otro) return true;
        if (otro == null || actual.getClass() != otro.getClass()) return false;
        return id == idOtro;
    }

    /**
     * Implementación básica de hashCode para objetos con múltiples campos
     * @param campos array de objetos que representan los campos
     * @return hashCode calculado
     */
    public static int hashCodeBasico(Object... campos) {
        return Arrays.hashCode(campos);
    }

    /**
     * Comparador básico para ordenar por cualquier campo numérico
     * @param <T> tipo del objeto
     * @param extractor función que extrae el valor numérico a comparar
     * @return comparador
     */
    public static <T> Comparator<T> comparadorNumerico(Function<T, Number> extractor) {
        return (o1, o2) -> Double.compare(
            extractor.apply(o1).doubleValue(),
            extractor.apply(o2).doubleValue()
        );
    }

    // -------------------- UTILIDADES DE FECHA --------------------
    
    /**
     * Calcula la edad en años a partir de una fecha de nacimiento
     * @param fechaNacimiento fecha de nacimiento
     * @return edad en años
     */
    public static int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Calcula los meses transcurridos entre dos fechas
     * @param inicio fecha inicial
     * @param fin fecha final
     * @return meses transcurridos
     */
    public static long calcularMesesEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.MONTHS.between(inicio, fin);
    }

    /**
     * Convierte días a años, meses y días
     * @param dias número total de días
     * @return array con [años, meses, días]
     */
    public static int[] diasAUnidadesTiempo(int dias) {
        int años = dias / 365;
        int restoDias = dias % 365;
        int meses = restoDias / 30;
        int diasFinales = restoDias % 30;
        return new int[]{años, meses, diasFinales};
    }

    /**
     * Convierte meses a años y meses
     * @param meses número total de meses
     * @return array con [años, meses]
     */
    public static int[] mesesAAños(int meses) {
        int años = meses / 12;
        int mesesRestantes = meses % 12;
        return new int[]{años, mesesRestantes};
    }

    // -------------------- UTILIDADES DE STRING --------------------
    
    /**
     * Comparador para ordenar strings por orden alfabético ignorando mayúsculas/minúsculas
     */
    public static final Comparator<String> COMPARADOR_ALFABETICO = 
        String::compareToIgnoreCase;

    /**
     * Comparador para ordenar strings por longitud
     */
    public static final Comparator<String> COMPARADOR_LONGITUD = 
        Comparator.comparingInt(String::length);

    /**
     * Ordena una lista de strings por el abecedario
     * @param lista lista a ordenar
     */
    public static void ordenarAlfabeticamente(List<String> lista) {
        Collections.sort(lista, COMPARADOR_ALFABETICO);
    }

    /**
     * Ordena una lista de strings por longitud (menor a mayor)
     * @param lista lista a ordenar
     */
    public static void ordenarPorLongitud(List<String> lista) {
        Collections.sort(lista, COMPARADOR_LONGITUD);
    }

    // -------------------- FUNCIONES BOOLEANAS ÚTILES --------------------
    
    /**
     * Verifica si un número es primo
     * @param n número a verificar
     * @return true si es primo
     */
    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Verifica si una cadena es palíndromo
     * @param str cadena a verificar
     * @return true si es palíndromo
     */
    public static boolean esPalindromo(String str) {
        String limpio = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }

    /**
     * Verifica si un número es potencia de 2
     * @param n número a verificar
     * @return true si es potencia de 2
     */
    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * Verifica si una lista está ordenada
     * @param <T> tipo de los elementos
     * @param lista lista a verificar
     * @param comparador comparador a usar
     * @return true si está ordenada
     */
    public static <T> boolean estaOrdenada(List<T> lista, Comparator<T> comparador) {
        if (lista.size() <= 1) return true;
        for (int i = 1; i < lista.size(); i++) {
            if (comparador.compare(lista.get(i-1), lista.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    // -------------------- ITERACIONES ÚTILES --------------------
    
    /**
     * Ejecuta una acción para cada par de elementos consecutivos
     * @param <T> tipo de los elementos
     * @param lista lista de elementos
     * @param accion acción a ejecutar con cada par
     */
    public static <T> void forEachPar(List<T> lista, BiConsumer<T, T> accion) {
        for (int i = 0; i < lista.size() - 1; i++) {
            accion.accept(lista.get(i), lista.get(i + 1));
        }
    }

    /**
     * Ejecuta una acción para cada elemento con su índice
     * @param <T> tipo de los elementos
     * @param lista lista de elementos
     * @param accion acción a ejecutar
     */
    public static <T> void forEachConIndice(List<T> lista, 
            BiConsumer<T, Integer> accion) {
        for (int i = 0; i < lista.size(); i++) {
            accion.accept(lista.get(i), i);
        }
    }

    /**
     * Aplica una operación a cada par de elementos de dos listas
     * @param <T> tipo de los elementos de la primera lista
     * @param <U> tipo de los elementos de la segunda lista
     * @param lista1 primera lista
     * @param lista2 segunda lista
     * @param accion acción a ejecutar con cada par
     */
    public static <T, U> void forEachParalelo(List<T> lista1, List<U> lista2, 
            BiConsumer<T, U> accion) {
        int minSize = Math.min(lista1.size(), lista2.size());
        for (int i = 0; i < minSize; i++) {
            accion.accept(lista1.get(i), lista2.get(i));
        }
    }

    /**
     * Ejecuta una acción para cada elemento que cumple una condición
     * @param <T> tipo de los elementos
     * @param lista lista de elementos
     * @param condicion condición a cumplir
     * @param accion acción a ejecutar
     */
    public static <T> void forEachCondicional(List<T> lista, 
            Predicate<T> condicion, Consumer<T> accion) {
        lista.stream()
            .filter(condicion)
            .forEach(accion);
    }


    
}
