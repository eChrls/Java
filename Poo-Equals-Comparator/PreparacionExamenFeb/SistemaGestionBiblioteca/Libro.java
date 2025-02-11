// Archivo: Libro.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Libro implements Comparable<Libro>, Comparator<Libro> {
    // Declaramos los atributos como private para encapsulamiento
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private double precio;
    private int numeroPaginas;

    // Constructor
    public Libro(int id, String titulo, String autor, LocalDate fechaPublicacion, 
                double precio, int numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
    }

    // Getters y setters necesarios
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public double getPrecio() { return precio; }
    public int getNumeroPaginas() { return numeroPaginas; }

    // Implementación de equals para comparar libros
    // Este método es crucial para la correcta comparación de objetos
    @Override
    public boolean equals(Object obj) {
        // Verificamos si es el mismo objeto en memoria
        if (this == obj) return true;
        // Verificamos si el objeto es null o de diferente clase
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Casteamos el objeto a Libro
        Libro other = (Libro) obj;
        // Comparamos por ID ya que es el identificador único
        return this.id == other.id;
    }

    // Implementación de hashCode
    // Necesario implementarlo siempre que se implemente equals
    @Override
    public int hashCode() {
        // Utilizamos Objects.hash para generar un hash code basado en el ID
        return Objects.hash(id);
    }

    // Implementación de compareTo para ordenamiento natural por ID
    @Override
    public int compareTo(Libro otro) {
        // Forma simplificada de comparar IDs
        return this.id - otro.id;
    }

    // Implementación de compare para la interfaz Comparator
    // En este caso, comparamos por precio
    @Override
    public int compare(Libro libro1, Libro libro2) {
        // Usamos Double.compare para evitar problemas con números decimales
        return Double.compare(libro1.getPrecio(), libro2.getPrecio());
    }

    // Método para calcular la antigüedad del libro
    public long calcularAntiguedad() {
        // Utilizamos ChronoUnit.YEARS para calcular años entre fechas
        return ChronoUnit.YEARS.between(fechaPublicacion, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Libro[ID=%d, Título='%s', Autor='%s', Fecha=%s, Precio=%.2f, Páginas=%d]",
                id, titulo, autor, fechaPublicacion, precio, numeroPaginas);
    }
}



