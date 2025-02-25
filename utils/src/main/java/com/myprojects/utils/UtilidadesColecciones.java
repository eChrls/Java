package com.myprojects.utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Indice:
 * -> Conversiones
 * 1. Agrupar colecciones
 * 2. Elementos comunes
 * 3. Rotar lista
 * 1. Submuestreo aleatorio
 * 2. Particion de listas
 * busqueda binaria en listas
 */
public class UtilidadesColecciones {

    /**
     * Divide una colección en grupos según un criterio.
     *
     * @param <T>       tipo de los elementos
     * @param <K>       tipo de la clave de agrupación
     * @param coleccion colección a agrupar
     * @param criterio  función que define el criterio de agrupación
     * @return mapa con los elementos agrupados
     */
    public static <T, K> Map<K, List<T>> agrupar(Collection<T> coleccion, Function<T, K> criterio) {
        return coleccion.stream()
                .collect(Collectors.groupingBy(criterio));
    }

    /**
     * Encuentra los elementos que aparecen en ambas colecciones.
     *
     * @param <T>        tipo de los elementos
     * @param coleccion1 primera colección
     * @param coleccion2 segunda colección
     * @return lista con los elementos comunes
     */
    public static <T> List<T> elementosComunes(Collection<T> coleccion1, Collection<T> coleccion2) {
        Set<T> set = new HashSet<>(coleccion1);
        return coleccion2.stream()
                .filter(set::contains)
                .collect(Collectors.toList());
    }

    /**
     * Rota los elementos de una lista n posiciones.
     *
     * @param <T>   tipo de los elementos
     * @param lista lista a rotar
     * @param n     número de posiciones (positivo: derecha, negativo: izquierda)
     */
    public static <T> void rotarLista(List<T> lista, int n) {
        if (lista.size() == 0)
            return;
        n = n % lista.size();
        if (n < 0)
            n += lista.size();
        for (int i = 0; i < n; i++) {
            T ultimo = lista.remove(lista.size() - 1);
            lista.add(0, ultimo);
        }
    }

    /**
     * Selecciona un subconjunto aleatorio de elementos de una colección.
     *
     * @param <T>       tipo de los elementos
     * @param coleccion colección original
     * @param tamaño    tamaño del subconjunto
     * @return lista con el subconjunto aleatorio
     */
    public static <T> List<T> submuestreoAleatorio(Collection<T> coleccion, int tamaño) {
        List<T> lista = new ArrayList<>(coleccion);
        java.util.Collections.shuffle(lista);
        return lista.subList(0, Math.min(tamaño, lista.size()));
    }

    /**
     * Divide una lista en particiones de tamaño especificado.
     *
     * @param <T>             tipo de los elementos
     * @param lista           lista original
     * @param tamañoParticion tamaño de cada partición
     * @return lista de listas con las particiones
     */
    public static <T> List<List<T>> particionarLista(List<T> lista, int tamañoParticion) {
        List<List<T>> particiones = new ArrayList<>();
        for (int i = 0; i < lista.size(); i += tamañoParticion) {
            particiones.add(lista.subList(i, Math.min(i + tamañoParticion, lista.size())));
        }
        return particiones;
    }
}