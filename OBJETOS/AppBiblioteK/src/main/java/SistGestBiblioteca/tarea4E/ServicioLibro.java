/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca.tarea4E;

import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class ServicioLibro {

    //copiar(Libro libro1), recibe un libro y devuelve una copia del mismo
    public static Libro copiarLibro(Libro libro) {
        //Control+espacio y elegimos el constructor copia
        return new Libro(libro);
    }

    //mostrarLibro(Libro libro1), mostrará la información del libro con este formato, en un JOption, usando textblock
    public static void mostrarLibro(Libro libro) {

        if (libro != null) {
            JOptionPane.showMessageDialog(null, "El libro no existe");

            JOptionPane.showMessageDialog(null, libro.toString());

            String mensaje = """
                         Título : %s
                         %da edición
                         Autor: %s %s
                         ISBN : %s
                         Fecha edicion: %s
                         %d paginas
                         """.formatted(libro.getTitulo(), libro.getNumEdicion(), libro.getAutor(), libro.getIsbn(), libro.getEditorial(),
                    libro.getFechaEdicion().format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy")), libro.getNumPaginas()
            );

            JOptionPane.showMessageDialog(null, mensaje);

        } else {
            System.out.println("El libro no existe");
        }
    }

    /*solicitarDatos(), se encarga de solicitar datos por teclado y devolver un libro con esos datos o un null si algún parámetro no es válido.*/
    public static Libro solicitarDatos() {
        try {
            String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
            if (titulo == null || titulo.trim().isEmpty()) {
                return null; // Título no válido
            }

            String nombreAutor = JOptionPane.showInputDialog("Ingrese el nombre del autor:");
            if (nombreAutor == null || nombreAutor.trim().isEmpty()) {
                return null; // Nombre del autor no válido
            }

            String apellidosAutor = JOptionPane.showInputDialog("Ingrese los apellidos del autor:");
            if (apellidosAutor == null || apellidosAutor.trim().isEmpty()) {
                return null; // Apellidos del autor no válidos
            }

            String isbn = JOptionPane.showInputDialog("Ingrese el ISBN (13 dígitos):");
            if (isbn == null || !isbn.matches("\\d{13}")) {
                return null; // ISBN no válido
            }

            String numPaginasStr = JOptionPane.showInputDialog("Ingrese el número de páginas:");
            int numPaginas = Integer.parseInt(numPaginasStr);

            String numEdicionStr = JOptionPane.showInputDialog("Ingrese el número de edición:");
            int numEdicion = Integer.parseInt(numEdicionStr);

            String[] editoriales = {"Prentice-Hall", "Ra-ma", "Macmillan", "Círculo Rojo"};
            String editorialStr = (String) JOptionPane.showInputDialog(null, "Seleccione la editorial:",
                    "Editorial", JOptionPane.QUESTION_MESSAGE, null, editoriales, editoriales[0]);
            if (editorialStr == null) {
                return null; // Selección de editorial no válida
            }

            Editorial editorial = Editorial.valueOf(editorialStr.toUpperCase().replace("-", "_").replace(" ", "_"));

            String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de edición (yyyy-MM-dd):");
            LocalDate fechaEdicion = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);

            return new Libro(titulo, new Autor(nombreAutor, apellidosAutor), isbn, numPaginas, numEdicion, editorial, fechaEdicion);
        } catch (NumberFormatException | DateTimeParseException e) {
            return null; // Manejo de excepciones para entradas no válidas
        } catch (IllegalArgumentException e) {
            return null; // Manejo de excepciones para valores de enum no válidos
        }
    }
}
