/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea7a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author carlos
 */
public class Lectura {

    //metodo que lee el CSV y devuelve un List de vehiculos
    public static List<Vehiculo> leerVehiculosCSV(String nombreArchivo) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            //Lee la primera linea
            String linea = br.readLine();

            //Resto de lineas
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); //divide la linea por comas

                Vehiculo vehiculo = new Vehiculo(
                        datos[0],
                        datos[1],
                        Integer.parseInt(datos[2]),
                        datos[3],
                        datos[4],
                        datos[5]
                );

                vehiculos.add(vehiculo);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer archivo" + e.getMessage());
        }

        return vehiculos;
    }
//Crea un set con los nombres de aquellos fabricantes de los coches fabricados en 2007 de color Green. Usa Streams.
    public static Set<String> obtenerFabricantesVehiculosVerdes(List<Vehiculo> vehiculos, int año, String color) {
        return vehiculos.stream()
                .filter(v -> v.año() == año && v.color().equalsIgnoreCase(color)) //filtro por año y color
                .map(Vehiculo::marca) //solo las marcas
                .collect(Collectors.toSet());

    }

     //Implementa un método que reciba la lista de objetos y devuelva un map ordenado, 
    //conteniendo el número de total de coches que hay por cada color. Usa streams dentro del método.
    public static Map<String, Long> contarVehiculosPorColor(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .collect(Collectors.groupingBy(//sirve para agrupar y funciones de conteo
                        Vehiculo::color, //agrupa los colores
                        TreeMap::new, //crea un treemap que ordena por clave (color)
                        Collectors.counting() //cuenta las iteraciones , devuelve un Long
                ));
    }

    //Metodo para guardar el map en un CSV
    public static void guardarMapEnCSV(Map<String, Long> mapa, String nombreArchivo) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(nombreArchivo))) {
        //convierte el nombre del archivo en un objeto Path que representa su ubicacion

            writer.write("Color, Cantidad");
            writer.newLine();
            
            //bucle para recorrer cada par clave valor
            for(Map.Entry<String, Long>entrada : mapa.entrySet()){ //devuelve un conjunto con los pares clave valor del mapa
                writer.write(entrada.getKey() + " , " + entrada.getValue());
                writer.newLine();// salto de linea
            }
            
            System.out.println("Archivo " + nombreArchivo + "creado correctamente. ");
           
            
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }

    }

}
