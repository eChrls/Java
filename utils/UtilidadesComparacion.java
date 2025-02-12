
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Indice:
 * 1. Comparador con null
 * 2. Ordenar multiple
 * 1. Comparador encadenado
 * 
 * @param <T>
 */
public class UtilidadesComparacion<T> {

    /**
     * Crea un comparador que puede manejar valores null.
     * 
     * @param <T>        tipo de los elementos
     * @param comparador comparador base
     */
    public interface Comparable<T> {
        int compareTo(T other);
    }

    public interface Comparator<T> {
        int compare(T o1, T o2);
    }

    /**
     * Ordena una lista por múltiples criterios.
     *
     * @param <T>          tipo de los elementos
     * @param lista        lista a ordenar
     * @param comparadores lista de comparadores en orden de prioridad
     */
    public static <T> void ordenarMultiple(List<T> lista, List<Comparator<T>> comparadores) {
        Comparator<T> comparadorCompuesto = (a, b) -> {
            for (Comparator<T> comp : comparadores) {
                int resultado = comp.compare(a, b);
                if (resultado != 0)
                    return resultado;
            }
            return 0;
        };
        Collections.sort(lista, comparadorCompuesto);
    }

    /**
     * Permite encadenar múltiples comparadores para crear una comparación más
     * compleja.
     * Útil cuando se necesita ordenar por varios criterios en orden de prioridad.
     *
     * @param <T>          Tipo de objetos a comparar.
     * @param comparadores Lista de comparadores a encadenar.
     * @return Un comparador que aplica los comparadores en orden hasta encontrar
     *         una diferencia.
     */
    @SafeVarargs
    public static <T> Comparator<T> comparadorEncadenado(Comparator<T>... comparadores) {
        return java.util.Arrays.stream(comparadores)
                .reduce(Comparator::thenComparing)
                .orElse((a, b) -> 0); // Devuelve 0 si no hay comparadores.
    }
}