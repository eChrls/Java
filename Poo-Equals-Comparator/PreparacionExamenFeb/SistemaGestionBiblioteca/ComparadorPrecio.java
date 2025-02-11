
import java.util.Comparator;

// Archivo: ComparadorPrecio.java
public class ComparadorPrecio implements Comparator<Libro> {
    @Override
    public int compare(Libro libro1, Libro libro2) {
        // Implementamos la comparación por precio
        return Double.compare(libro1.getPrecio(), libro2.getPrecio());
    }
}
