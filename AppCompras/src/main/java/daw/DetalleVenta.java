
package daw;

public class DetalleVenta {
    
    //Variables para guardar la información
    private int idDetalleVenta;
    private Producto producto; 
    private int cantidad; 
    private double pvpTotalArticulo; 
    private static int contadorId = 101; //Para crear IDs únicos automáticamente.
    
    //Constructor
    public DetalleVenta(Producto producto, int cantidad){
    
        this.idDetalleVenta = contadorId++; //asigna un ID único a cada detalle venta
        this.producto = producto; 
        this.cantidad = cantidad; 
        this.pvpTotalArticulo = producto.getPVP() * cantidad; //calcula el total
    }
    
    //Metodos para obtener la informacion

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPvpTotalArticulo() {
        return pvpTotalArticulo;
    }

    @Override
    public String toString() {
        return  producto.getIdProducto() + " " + producto.getNombre() + "  x  "+ cantidad;
    } 
    
}
