
import java.util.Comparator;


// Archivo: ComparadorPrecioProducto.java
public class ComparadorPrecioProducto implements Comparator<Producto> {
    @Override
    public int compare(Producto prod1, Producto prod2) {
        return Double.compare(prod1.getPrecio(), prod2.getPrecio());
    }
}