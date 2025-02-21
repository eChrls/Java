package SistGestBiblioteca.tarea4E;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();

        // Crear libros de ejemplo
        libros.add(new Libro("Introduction to Java Programming", new Autor("Liang", "Y. Daniel"), "9780130319972", 784, 3, Editorial.PRENTICE_HALL, LocalDate.of(2001, 11, 16)));
        libros.add(new Libro("Effective Java", new Autor("Bloch", "Joshua"), "9780134686097", 416, 2, Editorial.MACMILLAN, LocalDate.of(2018, 1, 11)));
        libros.add(new Libro("Java: The Complete Reference", new Autor("Herbert", "Schildt"), "9780071809252", 1248, 11, Editorial.RA_MA, LocalDate.of(2014, 5, 20)));
        libros.add(new Libro("Clean Code", new Autor("Martin", "Robert C."), "9780136083238", 464, 1, Editorial.CIRCULO_ROJO, LocalDate.of(2008, 8, 1)));

        // Mostrar libros iniciales de manera ordenada
        StringBuilder mensaje = new StringBuilder("Lista de libros inicial:\n");
        for (Libro libro : libros) {
            mensaje.append(libro).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());

        // Ordenar por Editorial
        libros.sort(Comparator.comparing(Libro::getEditorial));
        mostrarListaOrdenada("Libros ordenados por Editorial", libros);

        // Ordenar por Título y, en caso de empate, por Número de Páginas
        libros.sort(Comparator.comparing(Libro::getTitulo).thenComparing(Libro::getNumPaginas));
        mostrarListaOrdenada("Libros ordenados por Título y Número de Páginas", libros);

        // Búsqueda binaria por título (la lista ya está ordenada por título)
        String tituloBuscado = JOptionPane.showInputDialog("Ingrese el título a buscar:");
        if (tituloBuscado != null && !tituloBuscado.trim().isEmpty()) {
            int index = Collections.binarySearch(libros, new Libro(tituloBuscado, null, null, 0, 0, null, null),
                    Comparator.comparing(Libro::getTitulo));
            if (index >= 0) {
                ServicioLibro.mostrarLibro(libros.get(index));
            } else {
                JOptionPane.showMessageDialog(null, "Libro no encontrado.");
            }
        }

        // Copiar un libro y mostrarlo
        if (!libros.isEmpty()) {
            Libro libroCopia = ServicioLibro.copiarLibro(libros.get(0));
            JOptionPane.showMessageDialog(null, "Copia del primer libro:\n" + libroCopia);
        }

        // Solicitar datos para un nuevo libro y comprobar si ya existe
        Libro libroSolicitado = ServicioLibro.solicitarDatos();
        if (libroSolicitado != null) {
            if (libros.contains(libroSolicitado)) {
                JOptionPane.showMessageDialog(null, "El libro ya existe en la lista:\n" + libroSolicitado);
            } else {
                libros.add(libroSolicitado);
                JOptionPane.showMessageDialog(null, "Nuevo libro agregado:\n" + libroSolicitado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos no válidos, el libro no se ha agregado.");
        }
    }

    /**
     * Método auxiliar para mostrar la lista de libros ordenada en una sola ventana.
     */
    private static void mostrarListaOrdenada(String titulo, List<Libro> libros) {
        StringBuilder mensaje = new StringBuilder(titulo + ":\n");
        for (Libro libro : libros) {
            mensaje.append(libro).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
