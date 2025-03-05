// Archivo: TiendaElectronica.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiendaElectronica {
    private List<Producto> productos;

    public TiendaElectronica() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        productos.forEach(System.out::println);
    }

    public void ordenarPorPrecio() {
        Collections.sort(productos, new ComparadorPrecioProducto());
    }

    public Producto buscarProductoPorId(int id) {
        Collections.sort(productos);
        int inicio = 0;
        int fin = productos.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Producto productoMedio = productos.get(medio);

            if (productoMedio.getId() == id) {
                return productoMedio;
            }
            if (productoMedio.getId() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }
}