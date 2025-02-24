package com.myprojects.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Indice:
 * ->Try Catchs y bucles
 * -> Excepciones
 * -> Bucles (for each y tradicional y iterator)
 * -> Comparaciones (pattern y matcher)
 * 1. Comparaciones Basicas
 * 2. Utilidades HashCode
 * 3. Comparadores Numericos
 * 4. Clonacion de objetos
 * 5. Inversion de objetos
 * 1. Equals Complejo
 * 2. HashCode Complejo
 */
public class UtilidadesBasicas {

    public static void ejemplosExcepciones() {
        // Try-catch simple
        try {
            int numero = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        // 3. Try-catch con un tipo específico de excepción
        // En operaciones matemáticas incorrectas
        try {
            int resultado = 10 / 0; // División por cero
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero!");
        }

        // 4. Try-catch con múltiples excepciones
        // ejemploMultiplesErrores 
        // Al usar un objeto que es null    
        // Al convertir texto a número con formato incorrecto (por ejemplo, "abc" a int)
        try {
            String texto = null;
            // texto.length(); // Esto dará NullPointerException
            int numero = Integer.parseInt("abc"); // Esto daría NumberFormatException
        } catch (NullPointerException e) {
            System.out.println("El texto es null!");
        } catch (NumberFormatException e) {
            System.out.println("No es un número válido!");
        }
        // 5. Try-catch con finally (para liberar recursos)
        // Al usar un archivo que no existe (por ejemplo, FileReader) 
        //y al cerrar un archivo después de usarlo (por ejemplo, FileWriter) - en este caso, el finally se usa para cerrar el archivo después de usarlo.    
        try {
            int resultado = 10 / 0; // División por cero
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero!");
        } finally {
            System.out.println("Esto siempre se ejecuta");
        }

        // Try-catch múltiple
        try {
            FileReader fr = new FileReader("archivo.txt");
            int numero = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.err.println("Error de formato: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de IO: " + e.getMessage());
        } finally {
            System.out.println("Esto siempre se ejecuta");
        }

        // Try-with-resources (autocierre de recursos)
        //    - En este caso, el archivo se cierra automáticamente después de usarlo.
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Ejemplos de diferentes tipos de bucles
    public static void ejemplosBucles() {
        List<String> lista = new ArrayList<>();
        lista.add("ejemplo");
        lista.add("texto");

        // For-each (solo lectura)
        for (String elemento : lista) {
            System.out.println(elemento);
        }

        // For tradicional (acceso por índice)
        for (int i = 0; i < lista.size(); i++) {
            String elemento = lista.get(i);
            lista.set(i, elemento.toUpperCase());
        }

        // Iterator (para eliminar elementos)
        Iterator<String> iterator = lista.iterator();
        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.equals("a")) {
                iterator.remove(); // Seguro para eliminar durante iteración
            }
        }
    }
    // Ejemplos de uso de expresiones regulares
    // \b: límite de palabra (espacio, inicio o fin de línea)
    // \w: carácter de palabra (letra, dígito, guión bajo)
    // +: uno o más de la expresión anterior
    // .: cualquier carácter excepto nueva línea
    // \.: punto literal
    // \b\w+@\w+\.\w+\b: patrón para validar un correo electrónico
    public static void ejemplosRegex() {
        Pattern pattern = Pattern.compile("\\b\\w+@\\w+\\.\\w+\\b");
        Matcher matcher = pattern.matcher("ejemplo@correo.com");

        if (matcher.matches()) {
            System.out.println("Coincide con el patrón");
        }

        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
        }
    }

    /**
     * Implementación básica de equals para cualquier clase con un ID.
     *
     * @param actual objeto actual
     * @param otro   objeto a comparar
     * @param id     identificador del objeto actual
     * @param idOtro identificador del objeto a comparar
     * @return true si son iguales
     */
    public static boolean equalsBasico(Object actual, Object otro, long id, long idOtro) {
        if (actual == otro)
            return true;
        if (otro == null || actual.getClass() != otro.getClass())
            return false;
        return id == idOtro;
    }

    /**
     * Implementación básica de hashCode para objetos con múltiples campos.
     *
     * @param campos array de objetos que representan los campos
     * @return hashCode calculado
     */
    public static int hashCodeBasico(Object... campos) {
        return Arrays.hashCode(campos);
    }

    /**
     * Comparador básico para ordenar por cualquier campo numérico.
     *
     * @param <T>       tipo del objeto
     * @param extractor función que extrae el valor numérico a comparar
     * @return comparador
     */
    public static <T> Comparator<T> comparadorNumerico(Function<T, Number> extractor) {
        return Comparator.comparing(extractor, Comparator.nullsLast(Comparator.comparingDouble(Number::doubleValue)));
    }

    /**
     * Clona un objeto si implementa la interfaz Cloneable.
     *
     * @param <T>    tipo del objeto
     * @param objeto objeto a clonar
     * @return copia del objeto o null si no es clonable
     */
    public static <T> T clonarObjeto(T objeto) {
        try {
            if (objeto instanceof Cloneable) {
                java.lang.reflect.Method method = objeto.getClass().getMethod("clone");
                return (T) method.invoke(objeto);
            }
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            // Manejar la excepción (log, lanzar una excepción personalizada, etc.)
            System.out.println(e);
        }
        return null;
    }

    /**
     * Invierte el orden de los elementos en un array.
     *
     * @param <T>   tipo de los elementos
     * @param array array a invertir
     */
    public static <T> void invertirArray(T[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            T temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            inicio++;
            fin--;
        }

    }

    /**
     * Implementación más completa de equals para comparar objetos,
     * permitiendo personalización a través de una función lambda.
     *
     * @param <T>        Tipo del objeto a comparar.
     * @param actual     Objeto actual.
     * @param otro       Objeto a comparar.
     * @param comparador Funcion lambda que define la lógica de comparación
     *                   específica para los campos del objeto.
     * @return true si los objetos son iguales según la lógica definida en el
     *         comparador, false en caso contrario.
     */
    public static <T> boolean equalsComplejo(T actual, T otro, java.util.function.BiPredicate<T, T> comparador) {
        if (actual == otro)
            return true;
        if (actual == null || otro == null || actual.getClass() != otro.getClass())
            return false;
        return comparador.test(actual, otro);
    }

    /**
     * Genera un hashCode basado en una lista de campos proporcionados, permitiendo
     * manejar nulls de forma segura.
     * Utiliza Objects.hash para una implementación sencilla y eficiente.
     *
     * @param campos Campos del objeto que se usarán para generar el hashCode.
     * @return Valor hashCode calculado basado en los campos proporcionados.
     */
    public static int hashCodeComplejo(Object... campos) {
        return java.util.Objects.hash(campos);
    }

}
