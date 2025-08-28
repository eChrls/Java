package daw;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String cif;
    private String direccion;
    private String telefono;
    private CarteraClientes cartera;
    private CatalogoProductos catalogo;
    private ArrayList<Venta> listaVentas;

    //Constructor
    public Empresa(String nombre, String cif, String direccion, String telefono) {

        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cartera = new CarteraClientes();
        this.catalogo = new CatalogoProductos();
        this.listaVentas = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public CarteraClientes getCartera() {
        return cartera;
    }

    public CatalogoProductos getCatalogo() {
        return catalogo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    //Metodo para ver todas las ventas

    public void mostrarVentas() {
        //Controlamos si la lista está vacía
        if (listaVentas.isEmpty()) {
            System.out.println("No existen ventas.");
            return;
        }

        //Para mostrar la lista la recorremos
        System.out.println("======LISTADO DE VENTAS======");

        for (Venta v : listaVentas) {
            System.out.println(v);
        }

        System.out.println("=============================");
    }

    private void cargarDatosPorDefecto() {

        catalogoPorDefecto();
        carteraPorDefecto();

    }

    public void catalogoPorDefecto() {
        getCatalogo().añadirProducto(new Producto(51, "HARINA", 0.51, 0.99, 300));
        getCatalogo().añadirProducto(new Producto(52, "LEVADURA", 0.99, 1.99, 150));
        getCatalogo().añadirProducto(new Producto(53, "SEMILLAS", 0.33, 0.99, 60));
    }

    public void carteraPorDefecto() {
        getCartera().añadirCliente(new Cliente(11, "ABEL", "SANCHEZ", "78945698G", "689775566", LocalDate.of(2000, 1, 1)));
        getCartera().añadirCliente(new Cliente(12, "BETO", "MARQUEZ", "77889955H", "677889944", LocalDate.of(1999, 2, 2)));
        getCartera().añadirCliente(new Cliente(13, "CAROLINA", "GARCIA", "79977855A", "655449988", LocalDate.of(1998, 3, 3)));
    }

    @Override
    public String toString() {
        return "Catalogo=" + catalogo + '}';
    }

}
