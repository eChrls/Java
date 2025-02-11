package utilidades;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UtilidadesCompletas {
    
    // -------------------- ARRAYS Y ARRAYLIST --------------------
    
    /**
     * Busca un elemento en un array usando búsqueda binaria.
     * El array debe estar ordenado previamente.
     * @param <T> tipo del elemento, debe implementar Comparable
     * @param array array ordenado donde buscar
     * @param elemento elemento a buscar
     * @return índice del elemento o -1 si no se encuentra
     */
    public static <T extends Comparable<T>> int busquedaBinaria(T[] array, T elemento) {
        int inicio = 0;
        int fin = array.length - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = array[medio].compareTo(elemento);
            
            if (comparacion == 0) return medio;
            if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }
    
    /**
     * Ordena un ArrayList usando el orden natural de sus elementos
     * y luego realiza una búsqueda binaria.
     * @param <T> tipo del elemento, debe implementar Comparable
     * @param lista lista donde buscar
     * @param elemento elemento a buscar
     * @return el elemento encontrado o null si no existe
     */
    public static <T extends Comparable<T>> T busquedaBinariaEnLista(List<T> lista, T elemento) {
        Collections.sort(lista);  // Ordenamos primero
        int pos = Collections.binarySearch(lista, elemento);
        return pos >= 0 ? lista.get(pos) : null;
    }
    
    /**
     * Combina dos arrays en uno nuevo, manteniendo el orden.
     * @param <T> tipo de los elementos
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
     * @param <T> tipo de los elementos
     * @param lista lista original
     * @return nueva lista sin duplicados
     */
    public static <T> List<T> eliminarDuplicadosOrdenados(List<T> lista) {
        return new LinkedHashSet<>(lista).stream()
                .collect(Collectors.toList());
    }
    
    // -------------------- ORIENTACIÓN A OBJETOS --------------------
    
    /**
     * Interfaz genérica para definir criterios de filtrado
     * @param <T> tipo del objeto a filtrar
     */
    public interface Filtrable<T> {
        boolean cumpleCriterio(T objeto);
    }
    
    /**
     * Filtra una colección según un criterio definido
     * @param <T> tipo de los elementos
     * @param coleccion colección a filtrar
     * @param criterio criterio de filtrado
     * @return lista con los elementos que cumplen el criterio
     */
    public static <T> List<T> filtrar(Collection<T> coleccion, Filtrable<T> criterio) {
        return coleccion.stream()
                .filter(criterio::cumpleCriterio)
                .collect(Collectors.toList());
    }
    
    /**
     * Clase genérica para representar un par de elementos
     * @param <K> tipo del primer elemento
     * @param <V> tipo del segundo elemento
     */
    public static class Par<K, V> {
        private K primero;
        private V segundo;
        
        public Par(K primero, V segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }
        
        public K getPrimero() { return primero; }
        public V getSegundo() { return segundo; }
    }
    
    // -------------------- COLLECTIONS --------------------
    
    /**
     * Divide una colección en grupos según un criterio
     * @param <T> tipo de los elementos
     * @param <K> tipo de la clave de agrupación
     * @param coleccion colección a agrupar
     * @param criterio función que define el criterio de agrupación
     * @return mapa con los elementos agrupados
     */
    public static <T, K> Map<K, List<T>> agrupar(Collection<T> coleccion, 
            Function<T, K> criterio) {
        return coleccion.stream()
                .collect(Collectors.groupingBy(criterio));
    }
    
    /**
     * Encuentra los elementos que aparecen en ambas colecciones
     * @param <T> tipo de los elementos
     * @param coleccion1 primera colección
     * @param coleccion2 segunda colección
     * @return lista con los elementos comunes
     */
    public static <T> List<T> elementosComunes(Collection<T> coleccion1, 
            Collection<T> coleccion2) {
        Set<T> set = new HashSet<>(coleccion1);
        return coleccion2.stream()
                .filter(set::contains)
                .collect(Collectors.toList());
    }
    
    /**
     * Rota los elementos de una lista n posiciones
     * @param <T> tipo de los elementos
     * @param lista lista a rotar
     * @param n número de posiciones (positivo: derecha, negativo: izquierda)
     */
    public static <T> void rotarLista(List<T> lista, int n) {
        if (lista.size() == 0) return;
        n = n % lista.size();
        if (n < 0) n += lista.size();
        
        for (int i = 0; i < n; i++) {
            T ultimo = lista.remove(lista.size() - 1);
            lista.add(0, ultimo);
        }
    }
    
    // -------------------- COMPARACIONES AVANZADAS --------------------
    
    /**
     * Crea un comparador que puede manejar valores null
     * @param <T> tipo de los elementos
     * @param comparador comparador base
     * @return nuevo comparador que maneja null
     */
    public static <T> Comparator<T> comparadorConNull(Comparator<T> comparador) {
        return (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return -1;
            if (b == null) return 1;
            return comparador.compare(a, b);
        };
    }
    
    /**
     * Ordena una lista por múltiples criterios
     * @param <T> tipo de los elementos
     * @param lista lista a ordenar
     * @param comparadores lista de comparadores en orden de prioridad
     */
    public static <T> void ordenarMultiple(List<T> lista, 
            List<Comparator<T>> comparadores) {
        Comparator<T> comparadorCompuesto = (a, b) -> {
            for (Comparator<T> comp : comparadores) {
                int resultado = comp.compare(a, b);
                if (resultado != 0) return resultado;
            }
            return 0;
        };
        Collections.sort(lista, comparadorCompuesto);
    }
    
    /**
     * Encuentra el elemento que más se repite en una colección
     * @param <T> tipo de los elementos
     * @param coleccion colección a analizar
     * @return par con el elemento más frecuente y su frecuencia
     */
    public static <T> Par<T, Long> elementoMasFrecuente(Collection<T> coleccion) {
        return coleccion.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> new Par<>(e.getKey(), e.getValue()))
                .orElse(null);
    }
}