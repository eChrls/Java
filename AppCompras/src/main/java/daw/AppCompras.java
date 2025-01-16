package daw;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class AppCompras {
    
    public static void main(String[] args) {
        //Crear la empresa
        Empresa miEmpresa = new Empresa("Alboran-E-learning", "B12345678", "Av. mar de alboran s/n", "952123123");
        
        miEmpresa.carteraPorDefecto();
        miEmpresa.catalogoPorDefecto();

        //Menu
        int opcion;
        try {
            do {
                
                String menu = """
                          APP EMPRESA
                          1. Gestionar clientes
                          2. Gestionar productos
                          3. Gestionar ventas
                          4. Salir
                          Elige una opcion: """;
                
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                
                switch (opcion) {
                    
                    case 1 ->
                        gestionarClientes(miEmpresa);
                    
                    case 2 ->
                        gestionarProductos(miEmpresa);
                    
                    case 3 ->
                        gestionarVentas(miEmpresa);
                    
                    case 4 ->
                        JOptionPane.showMessageDialog(null, "Gracias! Hasta pronto! ");
                    
                    default ->
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
                
            } while (opcion != 4);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Dato introducido no correcto, vuelva a intentarlo.");
        }
        
    } //cerramos main

    //Funcion Gestion de clientes
    private static void gestionarClientes(Empresa empresa) {
        String menuCliente = """
                             GESTION DE CLIENTES
                             1. Añadir cliente
                             2. Borrar cliente
                             3. Consultar cliente
                             4. Consultar todos los clientes
                             5. Modificar cliente
                             6. Volver al menú principal
                             Elige una opcion:                   
                             """;
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuCliente));
        
        switch (opcion) {
            case 1 ->
                añadirCliente(empresa);
            case 2 ->
                borrarCliente(empresa);
            case 3 ->
                consultarCliente(empresa);
            case 4 ->
                consultarTodosClientes(empresa);
            case 5 ->
                modificarCliente(empresa);
            case 6 -> {
            }
            default ->
                JOptionPane.showMessageDialog(null, "Opción elegida incorrecta, vuelva a intentarlo.");
        }
    }

    //Funcion para gestion de productos
    private static void gestionarProductos(Empresa empresa) {
        String menuProductos = """
                             GESTION DE PRODUCTOS
                             1. Añadir producto
                             2. Borrar producto
                             3. Consultar producto
                             4. Consultar todos los productos
                             5. Modificar producto
                             6. Volver al menú principal
                             Elige una opcion:                   
                             """;
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuProductos));
        
        switch (opcion) {
            case 1 ->
                añadirProducto(empresa);
            case 2 ->
                borrarProducto(empresa);
            case 3 ->
                consultarProducto(empresa);
            case 4 ->
                consultarTodosProductos(empresa);
            case 5 ->
                modificarProductos(empresa);
            case 6 -> {
            }
            default ->
                JOptionPane.showMessageDialog(null, "Opción elegida incorrecta, vuelva a intentarlo.");
        }
    }

    //Funcion para gestion de ventas
    private static void gestionarVentas(Empresa empresa) {
        String menuVentas = """
                             GESTION DE VENTAS
                             1. Nueva venta
                             2. Mostrar histórico de ventas
                             3. Volver al menú principal
                             Elige una opcion:                   
                             """;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuVentas));
        
        switch (opcion) {
            case 1 ->
                nuevaVenta(empresa);
            case 2 ->
                mostrarVentas(empresa);
            case 3 -> {
            }
            default ->
                JOptionPane.showMessageDialog(null, "Opción elegida incorrecta, vuelva a intentarlo.");
            
        }
    }
    
    private static void mostrarVentas(Empresa empresa) {
        empresa.mostrarVentas();
        
    }
    
    private static void nuevaVenta(Empresa empresa) {
        try {
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Identificate por tu id (11-12-13 por defecto) : ")); //id 11, 12 y 13
            Cliente cliente = empresa.getCartera().buscarPorId(idCliente);
            
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado con esa id. Prueba de nuevo.");
                return;
            }
            
            Venta venta = new Venta(cliente);
            
            boolean continuarComprando = true;
            
            do {
                //Muestra los artículos por defecto
                System.out.println("Productos: ");
                for (Producto producto : empresa.getCatalogo().getListaCatalogo()) {
                    System.out.println("nº: " + producto.getId() + "\n - Nombre: " + producto.getNombre() + " \n- Stock: " + producto.getStock() + "\n - PVP:  " + producto.getPvpVenta() + " €");
                }
                //Pedir al usuario que elija un producto
                int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nº ID del producto que quieras comprar: "));

                //Buscar el producto por id
                Producto p1 = empresa.getCatalogo().buscarPorId(idProducto);
                
                if (p1 != null) {
                    //Si diferente a null pide la cantidad deseada
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad que quiere comprar: "));
                    
                    //control de stock
                    if (cantidad <= p1.getStock()) {

                        //Creacion de un detalleVenta
                        DetalleVenta dV = new DetalleVenta(p1, cantidad);
                        
                        if (venta.agregarDetalle(dV)) {
                            System.out.println("Producto agregado al carrito");
                        } else {
                            System.out.println("No se pudo agregar el producto al carrito");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay suficiente stock para esa cantidad");
                    }

                    //Pregunútar si quiere añadir algo más a la compra
                    int opcion = JOptionPane.showConfirmDialog(null, "Desea comprar algo más? ", "Continuar comprando", JOptionPane.YES_OPTION);
                    continuarComprando = (opcion == JOptionPane.YES_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado. Por favor, intentelo de nuevo.");
                }
            } while (continuarComprando);

            //muestra ticket 
            JOptionPane.showMessageDialog(null, venta.generarTicket());
            
            //añade venta a la lista de ventas
            empresa.getListaVentas().add(venta);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos, vuelve a intentarlo." + e.getMessage());
        }
        
    }

    //Funciones para gestionar clientes
    private static void añadirCliente(Empresa empresa) {
        try {
            //Datos del cliente
            int id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del cliente: "));
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del cliente: ");
            String apellidos = JOptionPane.showInputDialog("Introduce los apellidos: ");
            String nif = JOptionPane.showInputDialog("Introduce el numero nif: ");
            String telefono = JOptionPane.showInputDialog("Introduce el numero de telefono: ");
            String fechaNac = JOptionPane.showInputDialog("Introduce la fecha de nacimiento (dd/MM/yyyy): ");

            //String a localdate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaNac, formatter);

            //Crear y añadir cliente
            Cliente nuevoCliente = new Cliente(id, nombre, apellidos, nif, telefono, fecha);
            
            empresa.getCartera().añadirCliente(nuevoCliente);
            
            JOptionPane.showMessageDialog(null, "Cliente " + nuevoCliente + " añadido correctamente.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir al cliente, vuelve a empezar" + e.getMessage());
            
        }
    }
    
    private static void borrarCliente(Empresa empresa) {
        try {
            String nif = JOptionPane.showInputDialog("Introduce NIF del cliente a borrar");
            
            if (empresa.getCartera().borrarCliente(nif)) {
                JOptionPane.showMessageDialog(null, "Cliente borrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Este nif no pertenece a ningún cliente. Vuelva a intentarlo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al borrar cliente, vuelve a intentarlo" + e.getMessage());
        }
    }
    
    private static void consultarCliente(Empresa empresa) {
        
        try {
            String nif = JOptionPane.showInputDialog("Introduce NIF del cliente a consultar");
            
            Cliente cliente = empresa.getCartera().buscarCliente(nif);
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, cliente.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró cliente con ese nif, vuelva a intentarlo.");
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar cliente, algún dato introducido incorrecto, vuelva a intentarlo" + e.getMessage());
        }
    }
    
    private static void consultarTodosClientes(Empresa empresa) {
        
        empresa.getCartera().mostrarClientes();
        
    }
    
    private static void modificarCliente(Empresa empresa) {
        try {
            String nif = JOptionPane.showInputDialog("Introduce NIF del cliente a modificar: ");
            
            Cliente cliente = empresa.getCartera().buscarCliente(nif);
            if (cliente != null) {
                //Menu de modificacion
                String menuModificarCliente = """
                                              Que quieres modificar? 
                                              1- Nombre
                                              2- Apellidos
                                              3- Telefono
                                              4- Fecha nacimiento
                                              Elije una opcion: 
                                              """;
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuModificarCliente));
                
                switch (opcion) {
                    case 1 -> {
                        String nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre : ");
                        cliente.setNombre(nuevoNombre);
                        
                    }
                    case 2 -> {
                        String nuevosApellidos = JOptionPane.showInputDialog("Introduce los nuevos apellidos : ");
                        cliente.setApellidos(nuevosApellidos);
                        
                    }
                    case 3 -> {
                        String nuevoTlf = JOptionPane.showInputDialog("Introduce el nuevo numero de telefono : ");
                        cliente.setTelefono(nuevoTlf);
                        
                    }
                    case 4 -> {
                        String nuevaFecNa = JOptionPane.showInputDialog("Introduce la nueva fecha de nacimiento (dd/MM/yyyy) : ");
                        LocalDate nuevaF = LocalDate.parse(nuevaFecNa);
                        cliente.setFecNac(nuevaF);
                        
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "Opción no válida, vuelve a intentarlo.");
                }
                JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al cliente, vuelve a intentarlo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente, algun dato introducido no era correcto, vuelve a intentarlo" + e.getMessage());
        }
    }
    
    private static void añadirProducto(Empresa empresa) {
        try {
            int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de producto : "));
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto :");
            double pCompra = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de compra: "));
            double pvpVenta = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de venta: "));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el stock de producto : "));
            
            if (pCompra > pvpVenta) {
                System.out.println("Precio de venta introducido menor que precio de compra!");
            }
            
            Producto nuevoProducto = new Producto(idProducto, nombre, pCompra, pvpVenta, stock);
            
            empresa.getCatalogo().añadirProducto(nuevoProducto);
            JOptionPane.showMessageDialog(null, "Producto añadido al catálogo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR al introducir el producto, algún dato era incorrecto. Vuelva a intentarlo." + e.getMessage());
        }
    }
    
    private static void borrarProducto(Empresa empresa) {
        try {
            int idABuscar = Integer.parseInt(JOptionPane.showInputDialog("Introduce la id del producto a borrar"));
            Producto productoABorrar = empresa.getCatalogo().buscarPorId(idABuscar);
            if (productoABorrar != null) {
                empresa.getCatalogo().borrarProducto(idABuscar);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado, prueba de nuevo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! Datos introducidos no válidos, vuelva a intentarlo." + e.getMessage());
        }
    }
    
    private static void consultarProducto(Empresa empresa) {
        try {
            int idAConsultar = Integer.parseInt(JOptionPane.showInputDialog("Introduce la id del producto a consultar"));
            Producto productoAConsultar = empresa.getCatalogo().buscarPorId(idAConsultar);
            if (productoAConsultar != null) {
                JOptionPane.showMessageDialog(null, "El producto a consultar es: " + productoAConsultar);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado con esa id");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! Datos introducidos no válidos, vuelva a intentarlo." + e.getMessage());
        }
        
    }
    
    private static void consultarTodosProductos(Empresa empresa) {
        empresa.getCatalogo().mostrarCatalogo();
    }
    
    private static void modificarProductos(Empresa empresa) {
        try {
            int idProdModificar = Integer.parseInt(JOptionPane.showInputDialog("Introduce la id del producto a modificar"));
            Producto productoAModificar = empresa.getCatalogo().buscarPorId(idProdModificar);
            if (productoAModificar != null) {
                String NuevoNom = JOptionPane.showInputDialog("Introduce el nuevo nombre del producto");
                Double nuevoPcom = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio de compra del producto."));
                Double nuevoPvp = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio de venta del producto."));
                
                productoAModificar.setNomProd(NuevoNom);
                productoAModificar.setPCompra(nuevoPcom);
                productoAModificar.setPvpVenta(nuevoPvp);
                
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
                
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado con ese nº id.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! Datos introducidos no válidos, vuelva a intentarlo." + e.getMessage());
        }
    }
    
}

/*resumen: 
POJO

- ATRIBUTOS
	- STATIC
	-NO STATIC

- VISIBILIDAD (puede ir aplicado en atributos y métodos) 
	- PUBLIC
	- PRIVATE
	- PROTECTED
	- DEFAULT (NO SE PONE NADA)

- MÉTODOS
	→ publicos y no static
		- CONSTRUCTORES (necesitamos el new para crearlo, nuevo espacio de memoria)
		- GETTER Y SETTER  
		- HEREDADOS (toString, equals, hashcode)
	- STATIC (prohibido usar this)
 */
//public class AppCompras {
//
//    public static void main(String[] args) {
//Instancia 1
//        Cliente c1 = new Cliente();
//        c1.setFecNac(LocalDate.of(2000, Month.MARCH, 1));
//        System.out.println(c1.toString());
//        System.out.println(c1);
//        
//        //Instancia 2
//        //Para instanciar un objeto necesito el operador
//        //new + constructor
//
//
//        /*EJEMPLO DE CONTROL DE TRY CATCH
//        Cliente c2 = null;
//        
//        try{
//            c2 = new Cliente(1, " Manuel ", " Lopez ", " 7723545G ", " 658203050 ", LocalDate.of(2000, 12, 12)); 
//        }catch (IllegalArgumentException iae){
//            //Mensaje de control
//        }           
//         */
//        Cliente c2 = new Cliente(1, " Manuel ", " Lopez ", " 7723545G ", " 658203050 ", LocalDate.of(2000, 12, 12));
//        System.out.println(c2);
//        c2.setApellidos("Fernandez");
//        System.out.println(c2);
//        Producto p1 = new Producto(1000, "Alicate", 4.99, 0.99);
//        System.out.println(p1);
//
//        //List<Cliente> lista = new ArrayList<>(); //List<Cliente> lista = new LinkedList<>(); te permite otras funciones heredadas
//        ArrayList<Cliente> lista = new ArrayList<>();
//        lista.add(c1);
//        lista.add(c2);
//
//        for (Cliente Cliente : lista){
//            System.out.println("El cliente " + Cliente.getNombreCliente() + " tiene " + Cliente.getEdad() + " años.");
//        }  
//   
//CLASE 16/12 -- SOBRE EQUALS Y HASH
//     
//     Cliente c1 = new Cliente (10, "Juan", "Lopez", "23S", "2233", LocalDate.now().minusDays(15));
////        System.out.println(c1);
////        System.out.println("Hashcode de c1 : " + c1.hashCode());
////        Cliente c2 = Cliente.copiar(c1);
////        System.out.println(c2);
////        System.out.println("Hashcode de c2: " + c2.hashCode());
////        System.out.println(c1.equals(c2));
//        //hacemos pruebas cambiando los equals y comprobando si afecta al hashcode
//        //crea una copia Cliente c2 = new Cliente.copiar (c1); a mi no me funciona
//        //luego hace el equals del id y del nif y cambiar los apellidos
//        //pero sigue dandole true, porque id, nif y hashcode son los mismos
//       Cliente c2 = new Cliente (3, "Pepe", "Lopez", "88854", "54651561", LocalDate.now().minusDays(15)); 
//        
//        CarteraClientes cartera1 = new CarteraClientes();
//        cartera1.añadirCliente(c1);
//        cartera1.añadirCliente(c2);
//        
//        System.out.println("----contenido cartera 1 ----------\n" + cartera1);
//        
//        int idBuscar = 10; 
//        Cliente aux = cartera1.buscarPorId(idBuscar);
//        if (aux!= null){
//            System.out.println("El cliente de id " + idBuscar + " tiene los datos : " );
//            System.out.println(aux);
//        }else{
//            System.out.println("El cliente de id " + idBuscar + " no existe");
//        }
//  
//        // Probamos hacer un catálogo
//        CatalogoProductos catalogo = new CatalogoProductos();
//        
//        // Generar 25 productos aleatorios
//        catalogo.generarProductosAleatorios(25);
//        
//        // Mostrar todos los productos generados
//        catalogo.mostrarCatalogo();
//        
//        // Buscar un producto específico (por ejemplo, con ID 1)
//        Producto encontrado = catalogo.buscarPorId(1);
//        if (encontrado != null) {
//            System.out.println("Producto encontrado: " + encontrado);
//        } else {
//            System.out.println("Producto no encontrado");
//        }

