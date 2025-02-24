package com.myprojects.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Indice:
 * -> Conversiones
 * 1. Busqueda binaria
 * 2. Busqueda binaria en lista
 * 3. Combinar arrays
 * 4. Eliminar duplicados ordenados
 * 1. Llenar array con valores random
 * 2. Imprimir array
 * 1. Ordenar array
 * 1. Ordenar array con comparador
 * 2. Ordenar array strings alfabeticamente
*/

/*INICIALIZACION EN OBJETOS*
private int[] numero = {1,2,3,4,5,6,7,10,11,12};
private ArrayList<Integer> numero = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,10,11,12));
*/

public class UtilidadesArrays {

    public void ejemplosConversion() {
        // Array a ArrayList (Método 1 - Arrays.asList)
        String[] array = { "a", "b", "c" };
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(array));

        // Array a ArrayList (Método 2 - Collections.addAll)
        ArrayList<String> arrayList2 = new ArrayList<>();
        Collections.addAll(arrayList2, array);

        // ArrayList a Array (Método 1 - toArray)
        String[] arrayFromList1 = arrayList1.toArray(new String[0]);

        // ArrayList a Array (Método 2 - manual)
        String[] arrayFromList2 = new String[arrayList1.size()];
        for (int i = 0; i < arrayList1.size(); i++) {
            arrayFromList2[i] = arrayList1.get(i);
        }
    }

    // Método genérico para convertir Array a ArrayList
    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Método genérico para convertir ArrayList a Array
    public static <T> T[] arrayListToArray(ArrayList<T> lista, T[] array) {
        return lista.toArray(array);
    }

    /**
     * Busca un elemento en un array usando búsqueda binaria.
     * El array debe estar ordenado previamente.
     *
     * @param <T>      tipo del elemento, debe implementar Comparable
     * @param array    array ordenado donde buscar
     * @param elemento elemento a buscar
     * @return índice del elemento o -1 si no se encuentra
     */
    public static <T extends Comparable<T>> int busquedaBinaria(T[] array, T elemento) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = array[medio].compareTo(elemento);
            if (comparacion == 0)
                return medio;
            if (comparacion < 0)
                inicio = medio + 1;
            else
                fin = medio - 1;
        }
        return -1;
    }

    /**
     * Ordena un ArrayList usando el orden natural de sus elementos
     * y luego realiza una búsqueda binaria.
     *
     * @param <T>      tipo del elemento, debe implementar Comparable
     * @param lista    lista donde buscar
     * @param elemento elemento a buscar
     * @return el elemento encontrado o null si no existe
     */
    public static <T extends Comparable<T>> T busquedaBinariaEnLista(List<T> lista, T elemento) {
        Collections.sort(lista); // Ordenamos primero
        int pos = Collections.binarySearch(lista, elemento);
        return pos >= 0 ? lista.get(pos) : null;
    }

    /**
     * Combina dos arrays en uno nuevo, manteniendo el orden.
     *
     * @param <T>    tipo de los elementos
     * @param array1 primer array
     * @param array2 segundo array
     * @return nuevo array con todos los elementos
     */
    public static <T> T[] combinarArrays(T[] array1, T[] array2) {
        T[] resultado = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, resultado, array1.length, array2.length);
        return resultado;
    }

    /**
     * Elimina elementos duplicados de un ArrayList preservando el orden.
     *
     * @param <T>   tipo de los elementos
     * @param lista lista original
     * @return nueva lista sin duplicados
     */
    public static <T> List<T> eliminarDuplicadosOrdenados(List<T> lista) {
        return new LinkedHashSet<>(lista).stream()
                .collect(Collectors.toList());
    }

    /**
     * Llena un array con valores aleatorios dentro de un rango específico.
     *
     * @param array array a llenar
     * @param min   valor mínimo
     * @param max   valor máximo
     */
    public static void llenarArrayAleatorio(int[] array, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
    }

    /**
     * Imprime un array en la consola.
     *
     * @param array array a imprimir
     */
    public static void imprimirArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Ordena un array utilizando el algoritmo de ordenación natural de Java
     * (Timsort).
     *
     * @param <T>   Tipo de los elementos del array, debe ser Comparable.
     * @param array Array a ordenar.
     */
    public static <T extends Comparable<T>> void ordenarArray(T[] array) {
        Arrays.sort(array);
    }

    /**
     * Ordena una sección específica de un array utilizando el algoritmo de
     * ordenación natural de Java (Timsort).
     *
     * @param <T>    Tipo de los elementos del array, debe ser Comparable.
     * @param array  Array a ordenar.
     * @param inicio Indice inicial (inclusivo) de la sección a ordenar.
     * @param fin    Indice final (exclusivo) de la sección a ordenar.
     */
    public static <T extends Comparable<T>> void ordenarArray(T[] array, int inicio, int fin) {
        Arrays.sort(array, inicio, fin);
    }

    /**
     * Ordena un array utilizando un comparador personalizado.
     *
     * @param <T>        Tipo de los elementos del array.
     * @param array      Array a ordenar.
     * @param comparador Comparador a utilizar.
     */
    public static <T> void ordenarArray(T[] array, Comparator<T> comparador) {
        Arrays.sort(array, comparador);
    }

    /**
     * Ordena un array de strings alfabéticamente, ignorando mayúsculas y
     * minúsculas.
     *
     * @param array Array de strings a ordenar.
     */
    public static void ordenarArrayAlfabeticamente(String[] array) {
        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
    }
}