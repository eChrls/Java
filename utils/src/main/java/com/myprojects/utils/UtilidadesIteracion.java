package com.myprojects.utils;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Indice:
 * 1. Iteracion por pares
 * 2. Iteracion con indice
 * 3. Iteracion paralela
 * 4. Iteracion condicional
 */
public class UtilidadesIteracion {
   
    /*forEach básico para iterar en una lista*/
    private List libros;
        public void MostrarLibros(){
        System.out.println("Lista de libros: ");
        libros.forEach(libro -> System.out.println(libro));
        }

    /**
     * Ejecuta una acción para cada par de elementos consecutivos en una lista.
     *
     * @param <T>    tipo de los elementos
     * @param lista  lista de elementos
     * @param accion acción a ejecutar con cada par
     */
    public static <T> void forEachPar(List<T> lista, BiConsumer<T, T> accion) {
        for (int i = 0; i < lista.size() - 1; i++) {
            accion.accept(lista.get(i), lista.get(i + 1));
        }
    }

    /**
     * Ejecuta una acción para cada elemento de una lista junto con su índice.
     *
     * @param <T>    tipo de los elementos
     * @param lista  lista de elementos
     * @param accion acción a ejecutar con cada elemento y su índice
     */
    public static <T> void forEachConIndice(List<T> lista, BiConsumer<T, Integer> accion) {
        for (int i = 0; i < lista.size(); i++) {
            accion.accept(lista.get(i), i);
        }
    }

    /**
     * Aplica una operación a cada par de elementos de dos listas en paralelo.
     *
     * @param <T>    tipo de los elementos de la primera lista
     * @param <U>    tipo de los elementos de la segunda lista
     * @param lista1 primera lista
     * @param lista2 segunda lista
     * @param accion acción a ejecutar con cada par de elementos
     */
    public static <T, U> void forEachParalelo(List<T> lista1, List<U> lista2, BiConsumer<T, U> accion) {
        int minSize = Math.min(lista1.size(), lista2.size());
        for (int i = 0; i < minSize; i++) {
            accion.accept(lista1.get(i), lista2.get(i));
        }
    }

    /**
     * Ejecuta una acción para cada elemento de una lista que cumple una condición.
     *
     * @param <T>       tipo de los elementos
     * @param lista     lista de elementos
     * @param condicion condición que debe cumplir el elemento
     * @param accion    acción a ejecutar para cada elemento que cumple la condición
     */
    public static <T> void forEachCondicional(List<T> lista, Predicate<T> condicion, Consumer<T> accion) {
        lista.stream()
                .filter(condicion)
                .forEach(accion);
    }
}