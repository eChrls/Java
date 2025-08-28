    
// Archivo: Main.java
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // Creamos una biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Creamos algunos libros de ejemplo
        Libro libro1 = new Libro(1, "Don Quijote", "Cervantes", 
            LocalDate.of(1605, 1, 1), 29.99, 863);
        Libro libro2 = new Libro(2, "1984", "Orwell", 
            LocalDate.of(1949, 6, 8), 19.99, 328);
        Libro libro3 = new Libro(3, "Cien años de soledad", "García Márquez", 
            LocalDate.of(1967, 5, 30), 24.99, 417);

        // Agregamos los libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Mostramos los libros inicialmente
        System.out.println("Libros en la biblioteca:");
        biblioteca.mostrarLibros();

        // Ordenamos por precio y mostramos
        System.out.println("\nLibros ordenados por precio:");
        biblioteca.ordenarPorPrecio();
        biblioteca.mostrarLibros();

        // Buscamos un libro por ID
        int idBuscado = 2;
        Libro libroEncontrado = biblioteca.buscarLibroPorId(idBuscado);
        System.out.println("\nBuscando libro con ID " + idBuscado + ":");
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: " + libroEncontrado);
            System.out.println("Antigüedad: " + libroEncontrado.calcularAntiguedad() + " años");
        } else {
            System.out.println("Libro no encontrado");
        }
    }
}