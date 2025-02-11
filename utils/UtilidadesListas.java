
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Indice:
 * 1. Mas frecuente
 * 2. Eliminar duplicados
 * 3. k Mayores
 * 4. Busqueda binaria
 * 5. Filtrar
 * 6. Unir con comas
 * 7. Mapear
 * 8. Longitud de palabras
 * 9. k Menores
 * 10. Dividir lista
 * 11. Elevar al cuadrado
 * 12. Unir con delimitador
 * 13. Agrupar por longitud
 * * 1. Interseccion de listas (e comunes)
 * 2. Diferencia de listas
 * 3. Aplanar lista
 * 1. Busqueda binaria recursiva
 * 1. Ordenar numéricamente asc lista
 * 2. Vocales en lista de strings
 * 3. Número más alto en lista
 * 4. Número más bajo en lista
 * 1. Ordenar lista descendente
 * 2. Ordenar lista alfabeticamente ascendente
 * 3. Ordenar lista alfabeticamente descendente
 * 4. Contar y añadir vocales
 */
public class UtilidadesListas {

    /**
     * Encuentra el valor más frecuente en una lista de elementos.
     *
     * @param <T>   tipo de los elementos
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
     *
     * @param <T>   tipo de los elementos
     * @param lista lista con posibles duplicados
     * @return lista sin duplicados
     */
    public static <T> List<T> eliminarDuplicados(List<T> lista) {
        return new ArrayList<>(new LinkedHashSet<>(lista));
    }

    /**
     * Encuentra los k valores más grandes de una lista.
     *
     * @param <T>   tipo de los elementos, debe ser Comparable
     * @param lista lista de números
     * @param k     cantidad de valores a obtener
     * @return lista con los k valores más grandes
     */
    public static <T extends Comparable<T>> List<T> kMayores(List<T> lista, int k) {
        return lista.stream()
                .sorted(Collections.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());
    }

    /**
     * Busca un elemento en una lista de manera binaria (requiere lista ordenada).
     *
     * @param <T>      tipo de los elementos (debe ser Comparable)
     * @param lista    lista ordenada
     * @param objetivo valor a buscar
     * @return índice del elemento o -1 si no se encuentra
     */
    public static <T extends Comparable<T>> int busquedaBinaria(List<T> lista, T objetivo) {
        int inicio = 0, fin = lista.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = lista.get(medio).compareTo(objetivo);
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
     * Filtra los elementos de una lista según un criterio dado.
     *
     * @param <T>       tipo de los elementos
     * @param lista     lista original
     * @param condicion condición para filtrar elementos
     * @return lista filtrada
     */
    public static <T> List<T> filtrar(List<T> lista, Predicate<T> condicion) {
        return lista.stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     * Convierte una lista de strings en una sola cadena separada por comas.
     *
     * @param lista lista de cadenas
     * @return string con los valores concatenados
     */
    public static String unirConComas(List<String> lista) {
        return String.join(", ", lista);
    }

    /**
     * Aplica una función a cada elemento de una lista y devuelve una nueva lista
     * con los resultados.
     *
     * @param <T>           tipo de entrada
     * @param <U>           tipo de salida
     * @param lista         lista de entrada
     * @param transformador función de transformación
     * @return lista transformada
     */
    public static <T, U> List<U> mapear(List<T> lista, Function<T, U> transformador) {
        return lista.stream().map(transformador).collect(Collectors.toList());
    }

    /**
     * Convierte una lista de palabras en una lista de sus longitudes.
     *
     * @param palabras lista de palabras
     * @return lista de longitudes de las palabras
     */
    public static List<Integer> longitudesPalabras(List<String> palabras) {
        return mapear(palabras, String::length);
    }

    /**
     * Encuentra los k valores más pequeños de una lista.
     *
     * @param <T>   tipo de los elementos, debe ser Comparable
     * @param lista lista de números
     * @param k     cantidad de valores a obtener
     * @return lista con los k valores más pequeños
     */
    public static <T extends Comparable<T>> List<T> kMenores(List<T> lista, int k) {
        return lista.stream()
                .sorted()
                .limit(k)
                .collect(Collectors.toList());
    }

    /**
     * Divide una lista en sublistas de tamaño fijo.
     *
     * @param <T>    tipo de los elementos
     * @param lista  lista de entrada
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

    /**
     * Convierte una lista de enteros en una lista de sus valores al cuadrado.
     *
     * @param lista lista de números
     * @return lista con los valores al cuadrado
     */
    public static List<Integer> elevarAlCuadrado(List<Integer> lista) {
        return lista.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de enteros en una cadena con los valores separados por un
     * delimitador.
     *
     * @param lista       lista de números
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
     *
     * @param lista lista de strings
     * @return mapa donde la clave es la longitud y el valor es la lista de palabras
     *         con esa longitud
     */
    public static Map<Integer, List<String>> agruparPorLongitud(List<String> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    /**
     * Calcula la intersección de dos listas.
     *
     * @param <T>    tipo de los elementos
     * @param lista1 primera lista
     * @param lista2 segunda lista
     * @return lista con los elementos comunes
     */
    public static <T> List<T> interseccion(List<T> lista1, List<T> lista2) {
        return lista1.stream()
                .filter(lista2::contains)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Calcula la diferencia entre dos listas (elementos en lista1 pero no en
     * lista2).
     *
     * @param <T>    tipo de los elementos
     * @param lista1 lista base
     * @param lista2 lista a restar
     * @return lista con los elementos de diferencia
     */
    public static <T> List<T> diferencia(List<T> lista1, List<T> lista2) {
        return lista1.stream()
                .filter(elemento -> !lista2.contains(elemento))
                .collect(Collectors.toList());
    }

    /**
     * Aplana una lista de listas en una sola lista.
     *
     * @param <T>           tipo de los elementos
     * @param listaDeListas lista de listas
     * @return lista aplanada
     */
    public static <T> List<T> aplanarLista(List<List<T>> listaDeListas) {
        return listaDeListas.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * Implementación recursiva de la búsqueda binaria para encontrar un elemento en
     * una lista ordenada.
     *
     * @param <T>      Tipo de los elementos en la lista, debe ser Comparable.
     * @param lista    Lista ordenada en la que buscar.
     * @param objetivo Elemento que se busca.
     * @param inicio   Índice inicial de la sublista actual.
     * @param fin      Índice final de la sublista actual.
     * @return El índice del elemento si se encuentra, o -1 si no se encuentra.
     */
    public static <T extends Comparable<T>> int busquedaBinariaRecursiva(List<T> lista, T objetivo, int inicio,
            int fin) {
        if (inicio > fin) {
            return -1; // El elemento no está en la lista.
        }

        int medio = inicio + (fin - inicio) / 2; // Evita el overflow para listas grandes.
        int comparacion = lista.get(medio).compareTo(objetivo);

        if (comparacion == 0) {
            return medio; // Elemento encontrado.
        } else if (comparacion < 0) {
            return busquedaBinariaRecursiva(lista, objetivo, medio + 1, fin); // Buscar en la mitad derecha.
        } else {
            return busquedaBinariaRecursiva(lista, objetivo, inicio, medio - 1); // Buscar en la mitad izquierda.
        }
    }

    /**
     * Wrapper para la búsqueda binaria recursiva que permite no tener que
     * especificar los índices inicial y final.
     *
     * @param <T>      Tipo de los elementos en la lista, debe ser Comparable.
     * @param lista    Lista ordenada en la que buscar.
     * @param objetivo Elemento que se busca.
     * @return El índice del elemento si se encuentra, o -1 si no se encuentra.
     */
    public static <T extends Comparable<T>> int busquedaBinariaRecursiva(List<T> lista, T objetivo) {
        return busquedaBinariaRecursiva(lista, objetivo, 0, lista.size() - 1);
    }

    /**
     * Ordena una lista de números de forma ascendente.
     *
     * @param <T>   Tipo de los números en la lista, debe extender Number y ser
     *              Comparable.
     * @param lista Lista de números a ordenar.
     */
    public static <T extends Number & Comparable<T>> void ordenarListaNumericamente(List<T> lista) {
        Collections.sort(lista, Comparator.comparing(Number::doubleValue));
    }

    /**
     * Cuenta el número total de vocales en una lista de strings.
     *
     * @param lista Lista de strings a analizar.
     * @return Número total de vocales encontradas en todos los strings.
     */
    public static int contarVocalesEnLista(List<String> lista) {
        int totalVocales = 0;
        for (String str : lista) {
            totalVocales += contarVocales(str);
        }
        return totalVocales;
    }

    /**
     * Método auxiliar para contar el número de vocales en un string.
     *
     * @param str String a analizar.
     * @return Número de vocales encontradas en el string.
     */
    private static int contarVocales(String str) {
        int count = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vocales.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Encuentra el número más alto en una lista de números.
     *
     * @param <T>   Tipo de los números en la lista, debe extender Number y ser
     *              Comparable.
     * @param lista Lista de números.
     * @return El número más alto en la lista, o null si la lista está vacía.
     */
    public static <T extends Number & Comparable<T>> T encontrarNumeroMasAlto(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return Collections.max(lista);
    }

    /**
     * Encuentra el número más bajo en una lista de números.
     *
     * @param <T>   Tipo de los números en la lista, debe extender Number y ser
     *              Comparable.
     * @param lista Lista de números.
     * @return El número más bajo en la lista, o null si la lista está vacía.
     */
    public static <T extends Number & Comparable<T>> T encontrarNumeroMasBajo(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return Collections.min(lista);
    }

    /**
     * Ordena una lista de elementos de manera descendente utilizando el orden
     * natural de los elementos.
     *
     * @param <T>   Tipo de los elementos de la lista, debe ser Comparable.
     * @param lista Lista a ordenar.
     */
    public static <T extends Comparable<T>> void ordenarListaDescendente(List<T> lista) {
        Collections.sort(lista, Collections.reverseOrder());
    }

    /**
     * Ordena una lista de strings alfabéticamente de manera ascendente, ignorando
     * mayúsculas y minúsculas.
     *
     * @param lista Lista de strings a ordenar.
     */
    public static void ordenarListaAlfabeticamenteAscendente(List<String> lista) {
        lista.sort(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Ordena una lista de strings alfabéticamente de manera descendente, ignorando
     * mayúsculas y minúsculas.
     *
     * @param lista Lista de strings a ordenar.
     */
    public static void ordenarListaAlfabeticamenteDescendente(List<String> lista) {
        lista.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    /**
     * Cuenta la frecuencia de cada vocal en una lista de strings, ignorando
     * mayúsculas y minúsculas, y añade las vocales a una lista.
     *
     * @param lista Lista de strings a analizar.
     * @return Un array de enteros donde cada posición representa la frecuencia de
     *         la vocal correspondiente (a=0, e=1, i=2, o=3, u=4).
     */
    public static int[] contarYAnadirVocales(List<String> lista, List<Character> listaVocales) {
        int[] frecuencias = new int[5]; // a, e, i, o, u
        String vocales = "aeiou";
        for (String str : lista) {
            String strLower = str.toLowerCase();
            for (int i = 0; i < strLower.length(); i++) {
                char c = strLower.charAt(i);
                int index = vocales.indexOf(c);
                if (index != -1) {
                    frecuencias[index]++;
                    listaVocales.add(c); // Añade la vocal a la lista
                }
            }
        }
        return frecuencias;
    }
}