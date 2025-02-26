package com.myprojects.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Indice:
 * 1. Comparador con null
 * 2. Ordenar multiple
 * 1. Comparador encadenado
 * busqueda binaria en listas
 * 
 * @param <T>
 */
public class UtilidadesComparacion<T> {

    // Para hacer una public class Libro extends EntidadComparable, esta debe ser
    // una clase dentro del paquete.
    class EntidadComparable<T> {

    }

    public class Libro extends EntidadComparable<Libro> {

        private int id;
        private double precio;
        private String titulo;

        public String getTitulo() {
            return titulo;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;

            Libro other = (Libro) obj;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        // COMPARABLE Se utiliza para comparar objetos de la misma clase.
        // * La interfaz Comparable tiene un solo método, compareTo, que toma un objeto
        // de la misma clase y devuelve un entero.
        // * Si el objeto actual es menor que el objeto pasado, compareTo debe devolver
        // un número negativo.
        // * Si el objeto actual es mayor que el objeto pasado, compareTo debe devolver
        // un número positivo.
        // * Si los dos objetos son iguales, compareTo debe devolver 0.
        public int compareTo(Libro otro) {
            return Integer.compare(this.id, otro.id);
        }

        // COMPARATOR Se puede utilizar para comparar dos objetos de una clase, incluso
        // si la clase no implementa Comparable.
        public class ComparadorPorPrecio implements Comparator<Libro> {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return Double.compare(libro1.getPrecio(), libro2.getPrecio());
                // return id - otro.id;
            }
        }

        public class ComparadorPorTitulo implements Comparator<Libro> {

            @Override
            public int compare(Libro libro1, Libro libro2) {
                return libro1.getTitulo().compareTo(libro2.getTitulo());
            }
        }
    }

    /**
     * Crea un comparador que puede manejar valores null.
     * 
     * @param <T>        tipo de los elementos
     * @param comparador comparador base
     */

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

/*
 * //COMPARABLE Se puede utilizar para comparar dos objetos de una clase. Es
 * útil cuando se necesita un orden natural para los objetos de una clase.
 * // * La interfaz Comparable tiene un solo método, compareTo, que toma un
 * objeto de la misma clase y devuelve un entero.
 * // * Si el objeto actual es menor que el objeto pasado, devuelve un número
 * negativo.
 * // * Si son iguales, devuelve 0.
 * // * Si el objeto actual es mayor, devuelve un número positivo.
 * // Requiere implementar el método compareTo en la clase. Por ejemplo, para
 * una clase Libro:
 * public class Libro implements Comparable<Libro> {
 * private int id;
 * // otros campos y métodos
 * 
 * @Override
 * public int compareTo(Libro otro) {
 * return Integer.compare(this.id, otro.id);
 * }
 * }
 * 
 * //COMPARATOR Se puede utilizar para comparar dos objetos de una clase,
 * incluso si la clase no implementa Comparable.
 * // * La interfaz Comparator tiene un solo método, compare, que toma dos
 * objetos de la clase y devuelve un entero.
 * // * Si el primer objeto es menor que el segundo, devuelve un número
 * negativo.
 * // * Si son iguales, devuelve 0.
 * // * Si el primer objeto es mayor, devuelve un número positivo.
 * // * Comparator es útil cuando se necesita un orden diferente al orden
 * natural de los objetos de una clase.
 * // * Por ejemplo, si queremos ordenar libros por precio en lugar de por id,
 * podemos usar un Comparator.
 * 
 * public class ComparadorPorPrecio implements Comparator<Libro> {
 * 
 * @Override
 * public int compare(Libro libro1, Libro libro2) {
 * return Double.compare(libro1.getPrecio(), libro2.getPrecio());
 * }
 * }
LA CUESTION ES QUE SI USAS COMPARABLE IMPLEMENTADO EN LA CLASE Y HACES UN COMPARE TO, 
COLLECTIONS.SORT TE LO ORDENA AUTOMATICAMENTE. Y SI QUISIERAS ORDENAR POR ALGO MÁS SERÍA ASÍ: 
    Ordenacion automatica con collections.sort debido a que la clase implementa Comparable y se ha hecho un CompareTo de tiempo
    public void ordenarPorTiempo() {
        Collections.sort(listaParticipantes);
    }
    Ahora queremos ordenar por fecha de nacimiento, dentro del mismo proyecto. Hay que implementar un comparator. 
    public void ordenarPorFechaNacimiento() {
        Collections.sort(listaParticipantes, new Comparator<Participante>() {
            @Override
            public int compare(Participante p1, Participante p2) {
                return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
            }
        });
    }
}

 */