package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class UtilidadesListas {
   
      // -------------------- UTILIDADES DE LISTAS --------------------

    /**
     * Encuentra el valor más frecuente en una lista de elementos.
     * @param <T> tipo de los elementos
     * @param lista lista de elementos
     * @return el elemento más frecuente
     */
    public static <T> Optional<T> encontrarMasFrecuente(List<T> lista) {
        return lista.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey);
    }

    /**
     * Elimina los valores duplicados de una lista manteniendo el orden original.
     * @param <T> tipo de los elementos
     * @param lista lista con posibles duplicados
     * @return lista sin duplicados
     */
    public static <T> List<T> eliminarDuplicados(List<T> lista) {
        return new ArrayList<>(new LinkedHashSet<>(lista));
    }

    /**
     * Encuentra los k valores más grandes de una lista.
     * @param lista lista de números
     * @param k cantidad de valores a obtener
     * @return lista con los k valores más grandes
     */
    public static List<Integer> kMayores(List<Integer> lista, int k) {
        return lista.stream()
            .sorted(Collections.reverseOrder())
            .limit(k)
            .collect(Collectors.toList());
    }

    // -------------------- BÚSQUEDAS Y FILTRADOS --------------------

    /**
     * Busca un elemento en una lista de manera binaria (requiere lista ordenada).
     * @param <T> tipo de los elementos (debe ser Comparable)
     * @param lista lista ordenada
     * @param objetivo valor a buscar
     * @return índice del elemento o -1 si no se encuentra
     */
    public static <T extends Comparable<T>> int busquedaBinaria(List<T> lista, T objetivo) {
        int inicio = 0, fin = lista.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = lista.get(medio).compareTo(objetivo);
            if (comparacion == 0) return medio;
            if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

    /**
     * Filtra los elementos de una lista según un criterio dado.
     * @param <T> tipo de los elementos
     * @param lista lista original
     * @param condicion condición para filtrar elementos
     * @return lista filtrada
     */
    public static <T> List<T> filtrar(List<T> lista, Predicate<T> condicion) {
        return lista.stream().filter(condicion).collect(Collectors.toList());
    }

    // -------------------- TRANSFORMACIONES DE DATOS --------------------

    /**
     * Convierte una lista de strings en una sola cadena separada por comas.
     * @param lista lista de cadenas
     * @return string con los valores concatenados
     */
    public static String unirConComas(List<String> lista) {
        return String.join(", ", lista);
    }

    /**
     * Aplica una función a cada elemento de una lista y devuelve una nueva lista con los resultados.
     * @param <T> tipo de entrada
     * @param <R> tipo de salida
     * @param lista lista de entrada
     * @param transformador función de transformación
     * @return lista transformada
     */
    public static <T, R> List<R> mapear(List<T> lista, Function<T, R> transformador) {
        return lista.stream().map(transformador).collect(Collectors.toList());
    }

    /**
     * Convierte una lista de palabras en una lista de sus longitudes.
     * @param palabras lista de palabras
     * @return lista de longitudes de las palabras
     */
    public static List<Integer> longitudesPalabras(List<String> palabras) {
        return mapear(palabras, String::length);
    }

    /**
     * Encuentra los k valores más pequeños de una lista.
     * @param lista lista de números
     * @param k cantidad de valores a obtener
     * @return lista con los k valores más pequeños
     */
    public static List<Integer> kMenores(List<Integer> lista, int k) {
        return lista.stream()
            .sorted()
            .limit(k)
            .collect(Collectors.toList());
    }

    /**
     * Divide una lista en sublistas de tamaño fijo.
     * @param <T> tipo de los elementos
     * @param lista lista de entrada
     * @param tamaño tamaño de cada sublista
     * @return lista de sublistas
     */
    public static <T> List<List<T>> dividirLista(List<T> lista, int tamaño) {
        List<List<T>> resultado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i += tamaño) {
            resultado.add(new ArrayList<>(lista.subList(i, Math.min(lista.size(), i + tamaño))));
        }
        return resultado;
    }

    // -------------------- TRANSFORMACIONES DE DATOS --------------------

    /**
     * Convierte una lista de enteros en una lista de sus valores al cuadrado.
     * @param lista lista de números
     * @return lista con los valores al cuadrado
     */
    public static List<Integer> elevarAlCuadrado(List<Integer> lista) {
        return lista.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de enteros en una cadena con los valores separados por un delimitador.
     * @param lista lista de números
     * @param delimitador símbolo separador
     * @return string con los valores concatenados
     */
    public static String unirConDelimitador(List<Integer> lista, String delimitador) {
        return lista.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(delimitador));
    }

    /**
     * Agrupa una lista de strings por su longitud.
     * @param lista lista de strings
     * @return mapa donde la clave es la longitud y el valor es la lista de palabras con esa longitud
     */
    public static Map<Integer, List<String>> agruparPorLongitud(List<String> lista) {
        return lista.stream()
            .collect(Collectors.groupingBy(String::length));
    }


}





