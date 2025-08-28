package daw;

import java.util.ArrayList;

public class CatalogoProductos {

    //Creamos una lista para guardar los productos
    private ArrayList<Producto> listaCatalogo;

    //Contructor de la clase
    public CatalogoProductos() {
        //Inicializamos la lista vacía
        this.listaCatalogo = new ArrayList<>();
    }

    //Metodo para añadir un producto al catálogo
    public void añadirProducto(Producto producto) {
        listaCatalogo.add(producto);

    }
    
    public void borrarProducto (int idProducto){
        Producto productoABorrar = buscarPorId(idProducto);
        if (productoABorrar != null) {
            listaCatalogo.remove(productoABorrar);
        }
    }

    //Metodo para generar productos aleatorios y añadirlos al catálogo
    public void generarProductosAleatorios(int cantidad) {
        //Bucle for que se repetira = cantidad.
        for (int i = 0; i < cantidad; i++) {
            //creamos un nuevo producto
            Producto productoNuevo = new Producto();

            //Le asignamos valores aleatorios (id, nombre y precio)
            productoNuevo.setIdProd(productoNuevo.generarIdAleatorio());
            double precioAleatorio = productoNuevo.getPVPAleatorio();
            String nombreAleatorio = productoNuevo.generarNombreAleatorio();

            //Construccion del producto con estos datos
            Producto productoCompleto = new Producto(productoNuevo.getId(),
                    nombreAleatorio, precioAleatorio * 0.8, precioAleatorio, 100);

            //Por ultimo lo añadimos a la lista
            listaCatalogo.add(productoCompleto);
        }
    }

    public ArrayList<Producto> getListaCatalogo() {
        return listaCatalogo;
    }

    public void setListaCatalogo(ArrayList<Producto> listaCatalogo) {
        this.listaCatalogo = listaCatalogo;
    }

    //Metodo para ver todos los productos del catálogo
    public void mostrarCatalogo() {
        //Controlamos si la lista está vacía
        if (listaCatalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }

        //Para mostrar la lista la recorremos
        System.out.println("===CATÁLOGO DE PRODUCTOS===");
        for (Producto producto : listaCatalogo) {
            System.out.println(producto.toString());
        }
        System.out.println("============================");
    }

    //Metodo para obtener el numero de productos en el catálogo
    public int numeroProductos() {
        return listaCatalogo.size();
    }

    //Metodo para buscar un producto por su ID
    public Producto buscarPorId(int id) {

        for (Producto producto : listaCatalogo) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
    
    
    

}
