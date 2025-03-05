// Archivo: Producto.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Producto implements Comparable<Producto>, Comparator<Producto> {
    private int id;
    private String nombre;
    private String marca;
    private LocalDate fechaFabricacion;
    private double precio;
    private int garantiaMeses;

    public Producto(int id, String nombre, String marca, LocalDate fechaFabricacion, 
                   double precio, int garantiaMeses) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.garantiaMeses = garantiaMeses;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public LocalDate getFechaFabricacion() { return fechaFabricacion; }
    public double getPrecio() { return precio; }
    public int getGarantiaMeses() { return garantiaMeses; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto other = (Producto) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Producto otro) {
        return this.id - otro.id;
    }

    @Override
    public int compare(Producto prod1, Producto prod2) {
        return Double.compare(prod1.getPrecio(), prod2.getPrecio());
    }

    public long calcularTiempoFabricacion() {
        return ChronoUnit.MONTHS.between(fechaFabricacion, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Producto[ID=%d, Nombre='%s', Marca='%s', Fecha=%s, Precio=%.2f, Garantía=%d meses]",
                id, nombre, marca, fechaFabricacion, precio, garantiaMeses);
    }
}
