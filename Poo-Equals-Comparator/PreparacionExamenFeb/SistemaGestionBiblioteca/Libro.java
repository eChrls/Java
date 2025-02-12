import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

/**
 * Clase que representa un libro en un sistema de biblioteca o librería.
 * Implementa Comparable para permitir el ordenamiento natural por ID.
 */
public class Libro {

    public class Libro implements Comparable<Libro> {
        // Declaramos los atributos como private para garantizar el encapsulamiento
        // y proteger la integridad de los datos
        private int id; // Identificador único del libro
        private String titulo; // Título del libro
        private String autor; // Autor del libro
        private LocalDate fechaPublicacion; // Fecha de publicación usando LocalDate para mejor manejo de fechas
        private double precio; // Precio del libro
        private int numeroPaginas; // Número de páginas del libro

        public Libro(int id, String titulo, String autor, LocalDate fechaPublicacion,
                double precio, int numeroPaginas) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.fechaPublicacion = fechaPublicacion;
            this.precio = precio;
            this.numeroPaginas = numeroPaginas;
        }

        // Métodos getter para acceder a los atributos privados
        // No incluimos setters para mantener la inmutabilidad de los objetos
        public int getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public LocalDate getFechaPublicacion() {
            return fechaPublicacion;
        }

        } 
            
                ic double ge
            return precio;
                

            ic int getNumeroPaginas() 
            return numeroPaginas;
    
        }
    
    /**
     * Implementación del método equals para comparar libros.
     * Dos libros se consideran iguales si tienen el mismo ID,
     * independientemente de sus otros atributos.
     * 
     * @param obj El objeto a comparar con este libro
     * @return true si los libros son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        // Verificamos si es el mismo objeto en memoria
        if (this == obj)
            return true;
        // Verificamos si el objeto es null o de diferente clase
        if (obj == null || getClass() != obj.getClass())
            return false;
        // Casteamos el objeto a Libro
        Libro other = (Libro) obj;
        // Comparamos por ID ya que es el identificador único
        return this.id == other.id;
    }

    /**
     * Implementación de hashCode.
     * Es necesario implementarlo siempre que se sobrescriba equals()
     * para mantener el contrato equals-hashCode.
     * 
     * @return El código hash del libro basado en su ID
     */
    @Override
    public int hashCode() {
        // Usamos Objects.hash para generar el código hash basado en el ID
        return Objects.hash(id);
    }

    /**
     * Implementación de compareTo para definir el orden natural de los libros.
     * Este método es requerido por la interfaz Comparable.
     * 
     * @param otro El libro a comparar con este
     * @return un número negativo si este libro va antes,
     *         positivo si va después, o cero si son iguales
     */
    @Override
    public int compareTo(Libro otro) {
        // Usamos Integer.compare para evitar problemas de desbordamiento
        // que podrían ocurrir con una simple resta
        return Integer.compare(this.id, otro.id);
    }

    /**
     * Calcula la antigüedad del libro en años desde su fecha de publicación
     * hasta la fecha actual.
     * 
     * @return El número de años desde la publicación del libro
     */
    public long calcularAntiguedad() {
        return ChronoUnit.YEARS.between(fechaPublicacion, LocalDate.now());
    }

    /**
     * Representación en String del libro, útil para debugging y logging.
     * 
     * @return Una cadena con todos los atributos del libro en formato legible
     */

    /**
     * Clase interna estática que implementa un comparador por precio.
     * Al ser estática, no requiere una instancia de Libro para ser utilizada.
     */
    public static class ComparadorPorPrecio implements Comparator<Libro> {
        @Override
        public int compare(Libro libro1, Libro libro2) {
            // Usamos Double.compare para manejar correctamente los valores decimales
            return Double.compare(libro1.getPrecio(), libro2.getPrecio());
        }
    }

    /**
     * Clase interna estática que implementa un comparador por título.
     * Permite ordenar los libros alfabéticamente por título.
     */
    public static class ComparadorPorTitulo implements Comparator<Libro> {
        @Override
        public int compare(Libro libro1, Libro libro2) {
            // Utilizamos el método compareTo de String para comparar títulos
            return libro1.getTitulo().compareTo(libro2.getTitulo());
        }
    }

    }

    
