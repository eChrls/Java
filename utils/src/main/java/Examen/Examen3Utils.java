/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.time.LocalDate;

/**
 * Extensión de utilidades en Java: Operaciones con matrices y streams
 * 
 * ÍNDICE:
 * 1. OPERACIONES CON MATRICES
 *    - sumarMatrices: Suma dos matrices
 *    - sonMatricesIguales: Compara si dos matrices son iguales
 *    - compararPosicion: Compara valores en la misma posición de dos matrices
 *    - copiarMatriz: Crea una copia de una matriz
 * 2. OPERACIONES CON STREAMS
 *    - filtrarNumerosPares: Filtra números pares de una lista
 *    - filtrarCadenasPorLongitud: Filtra cadenas por longitud mínima
 *    - encontrarValorMaximo: Encuentra el valor máximo en una lista
 *    - calcularSuma: Calcula la suma de valores en una lista
 *    - mapearObjetosAStrings: Convierte objetos a cadenas
 *    - agruparPorCategoria: Agrupa objetos por una categoría
 *    - sumarValoresPorGrupo: Suma valores numéricos por grupo
 *    - eliminarDuplicados: Elimina elementos duplicados
 *    - contarElementos: Cuenta elementos que cumplen una condición
 *    - calcularPromedio: Calcula el promedio de valores numéricos
 *    - obtenerValorOPredeterminado: Obtiene valor o usa valor predeterminado
 *    - filtrarPorFechaAnterior: Filtra objetos por fecha anterior
 *    - ordenarPorValorNumerico: Ordena elementos por valor numérico
 *    - agruparOrdenadamente: Agrupa elementos ordenadamente
 *    - calcularPromediosPorGrupo: Calcula promedios por grupo
 *    - encontrarElementoMaximo: Encuentra el elemento con valor máximo
 *    - ordenarMapaPorValor: Ordena mapa por valor
 *    - encontrarValorMinimoEnArray: Encuentra valor mínimo en array
 *    - combinarValores: Combina valores usando reduce
 *    - limitarResultados: Limita cantidad de resultados
 */
public class Examen3Utils {

    // ************************* OPERACIONES CON MATRICES *************************
    
    /**
     * Suma dos matrices del mismo tamaño
     * Ejemplo: int[][] a = {{1, 2}, {3, 4}};
     *          int[][] b = {{5, 6}, {7, 8}};
     *          int[][] resultado = sumarMatrices(a, b);
     *          // resultado = {{6, 8}, {10, 12}}
     */
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        // Verificar si las matrices tienen las mismas dimensiones
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
        }
        
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        return resultado;
    }
    
    /**
     * Compara si dos matrices son iguales
     * Ejemplo: int[][] a = {{1, 2}, {3, 4}};
     *          int[][] b = {{1, 2}, {3, 4}};
     *          boolean sonIguales = sonMatricesIguales(a, b); // true
     */
    public static boolean sonMatricesIguales(int[][] matriz1, int[][] matriz2) {
        // Verificar si las matrices tienen las mismas dimensiones
        if (matriz1.length != matriz2.length) {
            return false;
        }
        
        for (int i = 0; i < matriz1.length; i++) {
            if (matriz1[i].length != matriz2[i].length) {
                return false;
            }
            
            for (int j = 0; j < matriz1[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Compara valores en la misma posición de dos matrices
     * Ejemplo: int[][] a = {{1, 2}, {3, 4}};
     *          int[][] b = {{1, 6}, {3, 8}};
     *          boolean mismoValor = compararPosicion(a, b, 0, 0); // true
     *          boolean distintoValor = compararPosicion(a, b, 0, 1); // false
     */
    public static boolean compararPosicion(int[][] matriz1, int[][] matriz2, int fila, int columna) {
        // Verificar que las posiciones existan en ambas matrices
        if (fila < 0 || fila >= matriz1.length || fila >= matriz2.length || 
            columna < 0 || columna >= matriz1[fila].length || columna >= matriz2[fila].length) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites de las matrices");
        }
        
        return matriz1[fila][columna] == matriz2[fila][columna];
    }
    
    /**
     * Crea una copia de una matriz
     * Ejemplo: int[][] original = {{1, 2}, {3, 4}};
     *          int[][] copia = copiarMatriz(original);
     */
    public static int[][] copiarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int[][] copia = new int[filas][];
        
        for (int i = 0; i < filas; i++) {
            int columnas = matriz[i].length;
            copia[i] = new int[columnas];
            System.arraycopy(matriz[i], 0, copia[i], 0, columnas);
        }
        
        return copia;
    }
    
    // ************************* OPERACIONES CON STREAMS *************************
    
    /**
     * Filtra números pares de una lista
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
     *          List<Integer> pares = filtrarNumerosPares(numeros);
     *          // pares = [2, 4, 6]
     */
    public static List<Integer> filtrarNumerosPares(List<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra cadenas por longitud mínima
     * Ejemplo: List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");
     *          List<String> largas = filtrarCadenasPorLongitud(palabras, 3);
     *          // largas = ["abc", "abcd"]
     */
    public static List<String> filtrarCadenasPorLongitud(List<String> cadenas, int longitudMinima) {
        return cadenas.stream()
                .filter(s -> s.length() >= longitudMinima)
                .collect(Collectors.toList());
    }
    
    /**
     * Encuentra el valor máximo en una lista
     * Ejemplo: List<Integer> numeros = Arrays.asList(5, 3, 8, 1, 2);
     *          int maximo = encontrarValorMaximo(numeros);
     *          // maximo = 8
     */
    public static int encontrarValorMaximo(List<Integer> numeros) {
        return numeros.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Lista vacía"));
    }
    
    /**
     * Calcula la suma de valores en una lista
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
     *          int suma = calcularSuma(numeros);
     *          // suma = 15
     */
    public static int calcularSuma(List<Integer> numeros) {
        return numeros.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    
    /**
     * Convierte objetos a cadenas
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", 100),
     *              new Producto("B", 200)
     *          );
     *          List<String> nombres = mapearObjetosAStrings(productos, Producto::getNombre);
     *          // nombres = ["A", "B"]
     */
    public static <T> List<String> mapearObjetosAStrings(List<T> objetos, Function<T, String> mapper) {
        return objetos.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
    
    /**
     * Agrupa objetos por una categoría
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", "Cat1", 100),
     *              new Producto("B", "Cat2", 200),
     *              new Producto("C", "Cat1", 300)
     *          );
     *          Map<String, List<Producto>> porCategoria = agruparPorCategoria(productos, Producto::getCategoria);
     *          // porCategoria = {"Cat1": [A, C], "Cat2": [B]}
     */
    public static <T> Map<String, List<T>> agruparPorCategoria(List<T> objetos, Function<T, String> clasificador) {
        return objetos.stream()
                .collect(Collectors.groupingBy(clasificador));
    }
    
    /**
     * Suma valores numéricos por grupo
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", "Cat1", 100),
     *              new Producto("B", "Cat2", 200),
     *              new Producto("C", "Cat1", 300)
     *          );
     *          Map<String, Double> sumaPorCategoria = sumarValoresPorGrupo(
     *              productos,
     *              Producto::getCategoria,
     *              Producto::getPrecio
     *          );
     *          // sumaPorCategoria = {"Cat1": 400.0, "Cat2": 200.0}
     */
    public static <T> Map<String, Double> sumarValoresPorGrupo(
            List<T> objetos,
            Function<T, String> clasificador,
            Function<T, Number> valorNumerico) {
        
        return objetos.stream()
                .collect(Collectors.groupingBy(
                        clasificador,
                        Collectors.summingDouble(item -> valorNumerico.apply(item).doubleValue())
                ));
    }
    
    /**
     * Elimina elementos duplicados
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
     *          List<Integer> unicos = eliminarDuplicados(numeros);
     *          // unicos = [1, 2, 3, 4]
     */
    public static <T> List<T> eliminarDuplicados(List<T> lista) {
        return lista.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    /**
     * Cuenta elementos que cumplen una condición
     * Ejemplo: List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");
     *          long cantidad = contarElementos(palabras, s -> s.length() > 2);
     *          // cantidad = 2
     */
    public static <T> long contarElementos(List<T> lista, java.util.function.Predicate<T> condicion) {
        return lista.stream()
                .filter(condicion)
                .count();
    }
    
    /**
     * Calcula el promedio de valores numéricos
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", 100),
     *              new Producto("B", 200),
     *              new Producto("C", 300)
     *          );
     *          double promedio = calcularPromedio(productos, Producto::getPrecio);
     *          // promedio = 200.0
     */
    public static <T> double calcularPromedio(List<T> lista, Function<T, Number> extractor) {
        return lista.stream()
                .mapToDouble(item -> extractor.apply(item).doubleValue())
                .average()
                .orElse(0.0);
    }
    
    /**
     * Obtiene valor o usa valor predeterminado
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 3);
     *          int valor = obtenerValorOPredeterminado(numeros.stream().filter(n -> n > 10).findFirst(), 0);
     *          // valor = 0 (porque ningún número es mayor que 10)
     */
    public static <T> T obtenerValorOPredeterminado(Optional<T> opcional, T valorPredeterminado) {
        return opcional.orElse(valorPredeterminado);
    }
    
    /**
     * Filtra objetos por fecha anterior
     * Ejemplo: List<Evento> eventos = Arrays.asList(
     *              new Evento("E1", LocalDate.of(2025, 1, 1)),
     *              new Evento("E2", LocalDate.of(2025, 6, 1))
     *          );
     *          LocalDate limite = LocalDate.of(2025, 3, 1);
     *          List<Evento> anteriores = filtrarPorFechaAnterior(eventos, limite);
     *          // anteriores = [E1]
     */
    public static <T> List<T> filtrarPorFechaAnterior(List<T> objetos, LocalDate fecha, Function<T, LocalDate> extractor) {
        return objetos.stream()
                .filter(o -> extractor.apply(o).isBefore(fecha))
                .collect(Collectors.toList());
    }
    
    /**
     * Ordena elementos por valor numérico
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", 300),
     *              new Producto("B", 100),
     *              new Producto("C", 200)
     *          );
     *          List<Producto> ordenados = ordenarPorValorNumerico(productos, Producto::getPrecio);
     *          // ordenados = [B(100), C(200), A(300)]
     */
    public static <T> List<T> ordenarPorValorNumerico(List<T> lista, Function<T, Number> extractor) {
        return lista.stream()
                .sorted(Comparator.comparingDouble(item -> extractor.apply(item).doubleValue()))
                .collect(Collectors.toList());
    }
    
    /**
     * Agrupa elementos ordenadamente
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", "Cat1", 100),
     *              new Producto("B", "Cat2", 200),
     *              new Producto("C", "Cat1", 300)
     *          );
     *          Map<String, List<Producto>> agrupados = agruparOrdenadamente(productos, Producto::getCategoria);
     *          // agrupados es un TreeMap ordenado por clave donde:
     *          // "Cat1" -> [A, C], "Cat2" -> [B]
     */
    public static <T> Map<String, List<T>> agruparOrdenadamente(List<T> lista, Function<T, String> clasificador) {
        return lista.stream()
                .collect(Collectors.groupingBy(
                        clasificador,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }
    
    /**
     * Calcula promedios por grupo
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", "Cat1", 100),
     *              new Producto("B", "Cat2", 200),
     *              new Producto("C", "Cat1", 300)
     *          );
     *          Map<String, Double> promedios = calcularPromediosPorGrupo(
     *              productos, 
     *              Producto::getCategoria, 
     *              Producto::getPrecio
     *          );
     *          // promedios = {"Cat1": 200.0, "Cat2": 200.0}
     */
    public static <T> Map<String, Double> calcularPromediosPorGrupo(
            List<T> lista,
            Function<T, String> clasificador,
            Function<T, Number> extractor) {
        
        return lista.stream()
                .collect(Collectors.groupingBy(
                        clasificador,
                        Collectors.averagingDouble(item -> extractor.apply(item).doubleValue())
                ));
    }
    
    /**
     * Encuentra el elemento con valor máximo
     * Ejemplo: List<Producto> productos = Arrays.asList(
     *              new Producto("A", 100),
     *              new Producto("B", 300),
     *              new Producto("C", 200)
     *          );
     *          Producto maxProducto = encontrarElementoMaximo(productos, Producto::getPrecio);
     *          // maxProducto = B (con precio 300)
     */
    public static <T> T encontrarElementoMaximo(List<T> lista, Function<T, Number> extractor) {
        return lista.stream()
                .max(Comparator.comparingDouble(item -> extractor.apply(item).doubleValue()))
                .orElseThrow(() -> new NoSuchElementException("Lista vacía"));
    }
    
    /**
     * Ordena mapa por valor
     * Ejemplo: Map<String, Integer> mapa = new HashMap<>();
     *          mapa.put("A", 3);
     *          mapa.put("B", 1);
     *          mapa.put("C", 2);
     *          LinkedHashMap<String, Integer> ordenado = ordenarMapaPorValor(mapa);
     *          // ordenado = {"B": 1, "C": 2, "A": 3}
     */
    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> ordenarMapaPorValor(Map<K, V> mapa) {
        return mapa.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    
    /**
     * Encuentra valor mínimo en array
     * Ejemplo: int[] numeros = {5, 3, 8, 1, 2};
     *          int minimo = encontrarValorMinimoEnArray(numeros);
     *          // minimo = 1
     */
    public static int encontrarValorMinimoEnArray(int[] numeros) {
        return IntStream.of(numeros)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
    
    /**
     * Combina valores usando reduce
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
     *          int producto = combinarValores(numeros, 1, (a, b) -> a * b);
     *          // producto = 120 (1*2*3*4*5)
     */
    public static <T> T combinarValores(List<T> lista, T valorInicial, java.util.function.BinaryOperator<T> operador) {
        return lista.stream()
                .reduce(valorInicial, operador);
    }
    
    /**
     * Limita cantidad de resultados
     * Ejemplo: List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     *          List<Integer> primeros = limitarResultados(numeros, 5);
     *          // primeros = [1, 2, 3, 4, 5]
     */
    public static <T> List<T> limitarResultados(List<T> lista, long cantidad) {
        return lista.stream()
                .limit(cantidad)
                .collect(Collectors.toList());
    }
    
    // Clases de ejemplo para los métodos anteriores
    
    public static class Producto {
        private String nombre;
        private String categoria;
        private double precio;
        
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        
        public Producto(String nombre, String categoria, double precio) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
        }
        
        public String getNombre() { return nombre; }
        public String getCategoria() { return categoria; }
        public double getPrecio() { return precio; }
        
        @Override
        public String toString() {
            return nombre;
        }
    }
    
    public static class Evento {
        private String nombre;
        private LocalDate fecha;
        
        public Evento(String nombre, LocalDate fecha) {
            this.nombre = nombre;
            this.fecha = fecha;
        }
        
        public String getNombre() { return nombre; }
        public LocalDate getFecha() { return fecha; }
        
        @Override
        public String toString() {
            return nombre;
        }
    }
}