package daw;

import java.util.Random;

public class Producto {

    Random r = new Random();
//ATRIBUTOS DE INSTANCIA
    private int idProducto;
    private String nombre;
    private double pCompra;
    private double pvpVenta;
    private int stock; 

//CONSTRUCTOR
//CREA LOS PARAMETROS
    public Producto(int idProducto, String nombre, double pCompra, double pvpVenta, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.pCompra = pCompra;
        this.pvpVenta = pvpVenta;
        this.stock = stock; 

    }

    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Metodo para reducir el stock
    public boolean reducirStock (int cantidad){
        if (cantidad <= stock){
            stock -= cantidad;
            return true; 
        }
        return false; 
    }
    
    public void setpCompra(double pCompra) {
        this.pCompra = pCompra;
    }
    

//CONSTRUCTOR POR DEFECTO SIN PARAMETROS
    public Producto() {
    }

    public void setIdProd(int nuevoid) {
        if (nuevoid > 0) {
            idProducto = nuevoid;
        }

    }

    public Random getR() {
        return r;
    }

    public double getpCompra() {
        return pCompra;
    }

    public void setNomProd(String nuevoNom) {

        this.nombre = nuevoNom;

    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPvpVenta(double pvpVenta) {
        this.pvpVenta = pvpVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPCompra() {
        return pCompra;
    }

    public double getPvpVenta() {
        return pvpVenta;
    }

    public int getId() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPVP() {
        return pvpVenta;
    }

//Con insert code setter
    public void setPCompra(double pCompra) {
        this.pCompra = pCompra;
    }

    //con alt insert, insert code, toString
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", pCompra=" + String.format("%.2f", pCompra) + ", pvpVenta=" + String.format("%.2f", pvpVenta) + '}';
    }

    public int generarIdAleatorio() {

        idProducto = r.nextInt(100000, 999999);

        return idProducto;
    }

    public String generarNombreAleatorio() {

        String nombresProductos[] = {"Cafetera", "Tostadora", "AirFrier", "Microondas", "Horno", "CalientaToallas", "Ventilador", "Calefactor", "Hornillo", "Estufa", "Aire Acondicionado", "Cargador de movil"};

        int posicion = r.nextInt(nombresProductos.length);

        nombre = nombresProductos[posicion];

        return nombre;
    }

    public double getPVPAleatorio() {
        double pvpVenta = 0.0;

        pvpVenta = r.nextDouble(0.99, 99.99);

        return pvpVenta;
    }

}
