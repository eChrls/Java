
package ficheros;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Nombre del archivo CSV a leer
        String archivoEntrada = "vehiculos.csv";
        
        // 1. Leer el archivo y crear lista de vehículos
        List<Vehiculo> vehiculos = Lectura.leerVehiculosCSV(archivoEntrada);
        
        // 2. Mostrar la lista de vehículos (limitamos a 5 para no saturar la consola)
        System.out.println("Primeros 5 vehículos leídos:");
        vehiculos.stream().limit(5).forEach(System.out::println);
        System.out.println("Total de vehículos: " + vehiculos.size());
        System.out.println();
        
        // 3. Obtener fabricantes de coches verdes del 2007
        Set<String> fabricantesVerdes2007 = Lectura.obtenerFabricantesVehiculosVerdes(
            vehiculos, 2007, "Green");
        
        // 4. Mostrar los fabricantes de coches verdes del 2007
        System.out.println("Fabricantes de coches verdes del 2007:");
        fabricantesVerdes2007.forEach(System.out::println);
        System.out.println();
        
        // 5. Contar vehículos por color
        Map<String, Long> conteoColores = Lectura.contarVehiculosPorColor(vehiculos);
        
        // 6. Mostrar el conteo de vehículos por color
        System.out.println("Conteo de vehículos por color:");
        conteoColores.forEach((color, cantidad) -> 
            System.out.println(color + ": " + cantidad));
        System.out.println();
        
        // 7. Guardar el conteo en un archivo CSV
        String archivoSalida = "conteo_colores.csv";
        Lectura.guardarMapEnCSV(conteoColores, archivoSalida);
    }
}

