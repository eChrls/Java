/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen_final;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

// CLASE DE GESTIÓN DE FICHEROS
public class MetodosFicheros {
// ÍNDICE DE MÉTODOS EN MetodosFicheros:
// 1. leerFicheroTextoLineaALista
// 2. escribirFicheroTextoDesdeLista
// 3. leerFicheroTextoLimpiandoSeparadores
// 4. leerCSVQuitandoSeparadores
// 5. leerCSVComoListaFutbolistas
// 6. leerCSVComoFutbolista
// 7. leerCSVFiltradoGolesAListaDouble
// 8. escribirCSVDesdeListaFutbolistas
// 9. escribirJsonDesdeObjeto
// 10. leerJsonAListaFutbolistas y Map Futbolistas
// 11. leerJsonAFutbolista
// 12. leerJsonFiltradoNombresALista
// 13. escribirJsonDesdeLista
// 14. escribirJsonDesdeObjetoCompleto
// 15. crearCarpeta
// 16. copiarContenidoCarpeta
// 17. copiarArchivoEspecifico

    // Lee un fichero de texto línea a línea y lo guarda en una lista de String
    public static List<String> leerFicheroTextoLineaALista(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            return br.lines().collect(Collectors.toList());
        }
    }

    // Escribe una lista de Strings en un fichero de texto, cada elemento en una línea
    public static void escribirFicheroTextoDesdeLista(List<String> contenido, String ruta) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            contenido.forEach(pw::println);
        }
    }

    // Lee un fichero de texto y elimina caracteres separadores como ; o *
    public static List<String> leerFicheroTextoLimpiandoSeparadores(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            return br.lines()
                    .map(l -> l.replaceAll("[;*]", "").trim()) // elimina separadores y espacios
                    .collect(Collectors.toList());
        }
    }

    // Lee un CSV y limpia separadores y espacios, línea a línea
    public static List<String[]> leerCSVQuitandoSeparadores(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            return br.lines()
                    .map(l -> l.replaceAll("[;*]", "").trim())
                    .map(l -> l.split(","))
                    .collect(Collectors.toList());
        }
    }

    // Lee un CSV y crea una lista de objetos Futbolista
    public static List<Futbolista> leerCSVComoListaFutbolistas(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            return br.lines().map(l -> {
                String[] datos = l.split(",");
                return new Futbolista(
                        Integer.parseInt(datos[0].trim()),
                        datos[1].trim(),
                        Double.parseDouble(datos[2].trim()),
                        LocalDate.parse(datos[3].trim()),
                        EstadoJugador.valueOf(datos[4].trim())
                );
            }).collect(Collectors.toList());
        }
    }

    // Lee solo el primer futbolista desde CSV (objeto único)
    public static Futbolista leerCSVComoFutbolista(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            String[] datos = linea.split(",");
            return new Futbolista(
                    Integer.parseInt(datos[0].trim()),
                    datos[1].trim(),
                    Double.parseDouble(datos[2].trim()),
                    LocalDate.parse(datos[3].trim()),
                    EstadoJugador.valueOf(datos[4].trim())
            );
        }
    }

    // Lee un CSV y devuelve una lista de golesPorPartido filtrando por valor mínimo
    public static List<Double> leerCSVFiltradoGolesAListaDouble(String ruta, double umbral) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            return br.lines()
                    .map(l -> l.split(","))
                    .map(d -> Double.parseDouble(d[2].trim()))
                    .filter(g -> g > umbral)
                    .collect(Collectors.toList());
        }
    }

    // Escribe una lista de objetos Futbolista en un fichero CSV
    public static void escribirCSVDesdeListaFutbolistas(List<Futbolista> lista, String ruta) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Futbolista f : lista) {
                bw.write(f.getDorsal() + "," + f.getNombre() + "," + f.getGolesPorPartido() + ","
                        + f.getFechaFichaje() + "," + f.getEstado());
                bw.newLine();
            }
        }
    }

    // Escribe un objeto como JSON a fichero
    public static void escribirJsonDesdeObjeto(Futbolista f, String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(ruta), f);
    }

    // Lee un JSON y convierte a lista de objetos Futbolista
    public static List<Futbolista> leerJsonAListaFutbolistas(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Futbolista>>() {
        });
    }//Usa TypeReference<>() → cuando deserializas listas, mapas u objetos genéricos.

    // Convierte un JSON a un Map<String, Object>
    public static Map<String, Object> leerJsonAHashMap(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<Map<String, Object>>() {
        });
    }

    // Lee un JSON y convierte a un único objeto Futbolista
    public static Futbolista leerJsonAFutbolista(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), Futbolista.class);
    }//Usa .class → cuando deserializas un único objeto.

    // Lee un JSON y filtra nombres como lista de String
    public static List<String> leerJsonFiltradoNombresALista(String ruta, char inicial) throws IOException {
        List<Futbolista> lista = leerJsonAListaFutbolistas(ruta);
        return lista.stream()
                .map(Futbolista::getNombre)
                .filter(n -> n.charAt(0) == inicial)
                .collect(Collectors.toList());
    }

    // Escribe lista completa de objetos en JSON
    public static void escribirJsonDesdeLista(List<Futbolista> lista, String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(ruta), lista);
    }

    // Escribe un objeto como JSON entero (versión separada por lógica)
    public static void escribirJsonDesdeObjetoCompleto(Futbolista f, String ruta) throws IOException {
        escribirJsonDesdeObjeto(f, ruta);
    }

    // Crea una carpeta si no existe
    public static void crearCarpeta(String ruta) throws IOException {
        Files.createDirectories(Paths.get(ruta));
    }

    // Copia todos los archivos de una carpeta a otra
    public static void copiarContenidoCarpeta(String origen, String destino) throws IOException {
        Files.createDirectories(Paths.get(destino));
        try (Stream<Path> paths = Files.walk(Paths.get(origen))) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                Path dest = Paths.get(destino).resolve(path.getFileName());
                try {
                    Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Copia un archivo específico de una carpeta
    public static void copiarArchivoEspecifico(String origen, String destino) throws IOException {
        Files.copy(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
    }
}
