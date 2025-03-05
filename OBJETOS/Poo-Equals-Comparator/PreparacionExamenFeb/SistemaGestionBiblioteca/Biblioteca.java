// Archivo: Biblioteca.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    // Lista que almacenará los libros
    private List<Libro> libros;

    public Biblioteca() {
        // Inicializamos la lista en el constructor
        this.libros = new ArrayList<>();
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para mostrar todos los libros usando forEach
    public void mostrarLibros() {
        // Utilizamos la sintaxis de referencia a método
        libros.forEach(System.out::println);
    }

    // Método para ordenar libros por precio
    public void ordenarPorPrecio() {
        Collections.sort(libros, new ComparadorPrecio());
    }

    // Método para buscar un libro por ID usando búsqueda binaria
    public Libro buscarLibroPorId(int id) {
        // Primero ordenamos por ID (orden natural)
        Collections.sort(libros);
        
        // Implementamos búsqueda binaria
        int inicio = 0;
        int fin = libros.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Libro libroMedio = libros.get(medio);

            if (libroMedio.getId() == id) {
                return libroMedio;
            }
            if (libroMedio.getId() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null; // Retornamos null si no encontramos el libro
    }
}
