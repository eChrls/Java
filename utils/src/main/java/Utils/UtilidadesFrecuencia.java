package Utils;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Indice:
 * 1. Elemento mas frecuente
 * 
 * @param <K>
 * @param <V>
 */
public class UtilidadesFrecuencia<K, V> {

    /**
     * Clase genérica para representar un par de elementos.
     *
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

        public K getPrimero() {
            return primero;
        }

        public V getSegundo() {
            return segundo;
        }
    }

    /**
     * Encuentra el elemento que más se repite en una colección.
     *
     * @param <T>       tipo de los elementos
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