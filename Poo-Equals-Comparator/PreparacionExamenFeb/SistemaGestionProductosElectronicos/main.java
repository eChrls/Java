// Archivo: Main.java
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        TiendaElectronica tienda = new TiendaElectronica();

        Producto prod1 = new Producto(1, "Laptop", "Dell", 
            LocalDate.of(2023, 6, 1), 999.99, 24);
        Producto prod2 = new Producto(2, "Smartphone", "Samsung", 
            LocalDate.of(2023, 9, 15), 699.99, 12);
        Producto prod3 = new Producto(3, "Tablet", "Apple", 
            LocalDate.of(2024, 1, 1), 849.99, 12);

        tienda.agregarProducto(prod1);
        tienda.agregarProducto(prod2);
        tienda.agregarProducto(prod3);

        System.out.println("Productos en la tienda:");
        tienda.mostrarProductos();

        System.out.println("\nProductos ordenados por precio:");
        tienda.ordenarPorPrecio();
        tienda.mostrarProductos();

        int idBuscado = 2;
        Producto productoEncontrado = tienda.buscarProductoPorId(idBuscado);
        System.out.println("\nBuscando producto con ID " + idBuscado + ":");
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
            System.out.println("Meses desde fabricación: " + 
                productoEncontrado.calcularTiempoFabricacion());
        } else {
            System.out.println("Producto no encontrado");
        }
    }
}