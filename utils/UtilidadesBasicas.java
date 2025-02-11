
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * Indice:
 * 1. Comparaciones Basicas
 * 2. Utilidades HashCode
 * 3. Comparadores Numericos
 * 4. Clonacion de objetos
 * 5. Inversion de objetos
 * 1. Equals Complejo
 * 2. HashCode Complejo
 */
public class UtilidadesBasicas {

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
        } catch (Exception e) {
            // Manejar la excepción (log, lanzar una excepción personalizada, etc.)
            e.printStackTrace();
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
