/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package carlosTorralvo1DAW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author carlos
 */
public class MiTienda {

    public static void main(String[] args) {
        //Crea una lista de productos y añade dos objetos de cada tipo de producto distinto (de los posibles) a la misma.
        List<Producto> listaProductos = new ArrayList<>();
        List<Libro> listaLibros = new ArrayList<>();

        Pantalon pt1 = new Pantalon("M", "PantalonPrueba", "1", 10.00, 0.21, "Pantalon de prueba");
        Pantalon pt2 = new Pantalon("L", "PantalonPrueba2", "2", 13.00, 0.21, "Pantalon de prueba2");
        Libro l1 = new LibroDigital(2, "3", "3", 5.00, 0.10, "Libro Digital");
        Libro l2 = new LibroPapel(3, "4", "4", 15.00, 0.15, "Libro Papel");
        Musica m1 = new Musica("grupo1", 5, 14.50, 8, "descripcionCD");
        Musica m2 = new Musica("grupo2", 6, 16.50, 7, "descripcionCD2");

        listaProductos.add(l1);
        listaProductos.add(pt1);
        listaProductos.add(l2);
        listaProductos.add(pt2);
        listaProductos.add(m1);
        listaProductos.add(m2);

        //Muestra los datos de los productos usando un foreach y el método toString(). 
        //Contesta usando un comentario en el código: ¿es toString() un método polimórfico? Justifica la respuesta.
        //Claro, es un metodo que adopta la forma segun la clase a la que pertenezca. Segun la clase donde este, 
        //dara la respuesta establecida en la clase, y sino esta implementado y se le llama, dara la de la clase padre.
        //Asi continuamente hasta que llegue a su clase originaria Object. Donde devolverá el codigo de referencia del metodo.
        System.out.println("Lista de productos");
        System.out.println("-----------------------------------");
        listaProductos.forEach(System.out::println);

        //Ordena la lista de productos según el precio, haciendo uso de <<Comparator>> y una expresión lambda.
        listaProductos.sort((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
        //Muestra la lista de productos ordenados por precio.
        System.out.println("-----------------------------------");
        System.out.println("Lista ordenada por precio");
        System.out.println("-----------------------------------");
        listaProductos.forEach(System.out::println);
        System.out.println("****************************");
        /*Ordena la lista de productos según el código, haciendo uso de <<Comparator>> y una expresión lambda.*/
        listaProductos.sort((p1, p2) -> Integer.compare(p1.getCodigo(), p2.getCodigo()));
        System.out.println("-----------------------------------");
        System.out.println("Lista ordenada por codigo");
        System.out.println("-----------------------------------");
        //Muestra la lista de productos ordenados por código.
        listaProductos.forEach(System.out::println);
        System.out.println("****************************");
        //Realiza la búsqueda binaria según su código de algún producto que exista dentro de la lista 
        //y otro que no exista, mostrando la posición que ocupa en la lista.
        Producto productoBuscado = new Producto() {
        };

        productoBuscado = productoBuscado.busquedaBinariaPorCodigo((ArrayList<Producto>) listaProductos, 1);
        if (productoBuscado == null) {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("La posicion en la lista es " + listaProductos.get(productoBuscado.getCodigo()));
        productoBuscado = productoBuscado.busquedaBinariaPorCodigo((ArrayList<Producto>) listaProductos, 2);
        if (productoBuscado == null) {
            System.out.println("Producto no encontrado.");
        }

        //Forma que hace Vico en clase
        Comparator<Producto> porCodigo = (p1, p2) -> Integer.compare(p1.getCodigo(), p2.getCodigo());
        Collections.sort(listaProductos, porCodigo);
        Producto aux = new LibroDigital();
        aux.setCodigo(2);
        aux.setCodigo(200);
        int posicion = Collections.binarySearch(listaProductos, aux, porCodigo);
        System.out.println("Posicion = " + posicion);

        //Recorre la lista de productos y guarda todos los libros en una lista de libros.
        //Muestra los datos de la lista de libros usando un foreach y el método toString(). 
        System.out.println("Lista filtrada por libros");
        System.out.println("-----------------------------------");
        for (Producto producto : listaProductos) {
            if (producto instanceof Libro libro) {
                listaLibros.add((Libro) producto);
            }
        }
        /*Ordena los libros según ISBN, haciendo uso de <<Comparable>>.
        Muestra la lista de libros ordenada.*/
        Collections.sort(listaLibros);
        listaLibros.forEach(System.out::println);
        System.out.println("****************************");

        /*Recorre de nuevo la lista de libros y en cada iteración, ejecuta enviar() o descargar() en función del tipo de libro.*/
        for (Libro libro : listaLibros) {
            if (libro instanceof SeEnvia) {
                ((SeEnvia) libro).enviar("direccion");
            }
            if (libro instanceof SeDescarga) {
                ((SeDescarga) libro).descargar();
            }
        }

        /*Indica las líneas de código donde se realizan conversiones implícitas y/o explícitas, 
        así como los métodos polimórficos que hay en la jerarquía.*/
 /*En muchas lineas del ejercicio, desde el primer List - ArrayList, de la 29 a la 34 list.add, hasta en los bloques de instance of donde se añaden interfaces
        y libros dentro de producto. */
 /*Utiliza el método contains(Object) sobre la lista de libros para comprobar si existe un libro o no existe.*/
        if (listaLibros.contains(l1)) {
            System.out.println("La lista contiene el libro " + l1);

        }
        Libro l3 = new LibroDigital(11, "3", "3", 5.00, 0.10, "Libro Digital");
        if (listaLibros.contains(l3)) {
            System.out.println("La lista contiene el libro " + l3);
        } else {
            System.out.println("No esta en la lista");
        }

        /*Usando la lista de productos inicial, crea una nueva lista con todos los objetos del tipo <<SeEnvía>>.*/
        List<SeEnvia> listadoConEnvios = new ArrayList<>();
        for (Producto p : listaProductos) {
            if (p instanceof SeEnvia) {
                listadoConEnvios.add((SeEnvia) p);
            }
        }
        /*Recorre la lista de objetos <<SeEnvía>> y llama al método de la interfaz.*/
        for (SeEnvia s : listadoConEnvios){
           s.enviar("direccion");
        }
    }
}
