package Examen;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ExamenUtils {

    /*
------------------------------------------
INDICE GENERAL Y TABLA DE UTILIDADES CLAVE
------------------------------------------

1. StreamUtilsBasico       → Filtros, Map, Reduce, Max, Promedios, Contadores
2. JsonUtilsBasico         → Leer/Guardar JSON de objetos y listas ( leerListaDesdeJson)
3. FicheroUtilsBasico      → Guardar CSV, copiar archivos, crear directorios o duplicación de carpetas

| EJERCICIO                                   | UTILIDAD / MÉTODO                                  |
|--------------------------------------------|----------------------------------------------------|
| Crear 25 eventos aleatorios                | new Evento() con lógica propia                    |
| Guardar lista en CSV único                 | FicheroUtilsBasico.guardarCsvLista               |
| Guardar cada evento en CSV individual      | FicheroUtilsBasico.guardarCsvIndividual          |
| Guardar lista en JSON                      | JsonUtilsBasico.guardarListaComoJson             |
| Leer JSON de lista                         | JsonUtilsBasico.leerListaDesdeJson               |
| Obtener evento con mayor valor             | StreamUtilsBasico.maximo                         |
| Filtrar eventos por fecha                  | StreamUtilsBasico.filtrar                        |
| Calcular media                             | StreamUtilsBasico.promedio                       |
| Contar entre fechas                        | StreamUtilsBasico.contar                         |
| Convertir lista a Map                      | StreamUtilsBasico.convertirAMapa                 |
| Agrupar lista                              | StreamUtilsBasico.agruparPor                     |
| Crear backup/copia de carpeta              | FicheroUtilsBasico.copiarArchivosDirectorio      |

     */
    // ------------------------
    // STREAMS
    // ------------------------

    public static <T> List<T> filtrar(List<T> lista, Predicate<T> condicion) {
        return lista.stream().filter(condicion).collect(Collectors.toList());
    }
    // Ejemplo:
    // List<Evento> recientes = filtrar(eventos, e -> e.getFecha().isAfter(LocalDate.of(2024,1,1)));

    public static <T> Optional<T> maximo(List<T> lista, Comparator<T> comparador) {
        return lista.stream().max(comparador);
    }
    // Ejemplo:
    // Optional<Evento> masLluvioso = maximo(eventos, Comparator.comparing(Evento::getPrecipitacion));

    public static <T> double promedio(List<T> lista, ToDoubleFunction<T> extractor) {
        return lista.stream().mapToDouble(extractor).average().orElse(0);
    }
    // Ejemplo:
    // double media = promedio(eventos, e -> e.getPrecipitacion());

    public static <T> long contar(List<T> lista, Predicate<T> condicion) {
        return lista.stream().filter(condicion).count();
    }
    // Ejemplo:
    // long entreFechas = contar(eventos, e -> e.getFecha().isAfter(f1) && e.getFecha().isBefore(f2));

    public static <T, K> Map<K, List<T>> agruparPor(List<T> lista, Function<T, K> agrupador) {
        return lista.stream().collect(Collectors.groupingBy(agrupador));
    }
    // Ejemplo:
    // Map<String, List<Evento>> porLugar = agruparPor(eventos, Evento::getLugar);

    public static <T, K, V> Map<K, V> convertirAMapa(List<T> lista, Function<T, K> clave, Function<T, V> valor) {
        return lista.stream().collect(Collectors.toMap(clave, valor, (v1, v2) -> v2));
    }
    // Ejemplo:
    // Map<String, Double> lugarAPrecipitacion = convertirAMapa(eventos, Evento::getLugar, Evento::getPrecipitacion);


    // ------------------------
    // JSON
    // ------------------------

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(SerializationFeature.INDENT_OUTPUT)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static void guardarListaComoJson(List<?> lista, String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        archivo.getParentFile().mkdirs();
        mapper.writeValue(archivo, lista);
    }
    // Ejemplo:
    // guardarListaComoJson(eventos, "./json/eventos.json");

    public static <T> List<T> leerListaDesdeJson(String rutaArchivo, Class<T> claseElemento) throws IOException {
        CollectionType tipo = mapper.getTypeFactory().constructCollectionType(List.class, claseElemento);
        return mapper.readValue(new File(rutaArchivo), tipo);
    }
    // Ejemplo:
    // List<Evento> eventos = leerListaDesdeJson("./json/eventos.json", Evento.class);

    public static void guardarObjetoComoJson(Object objeto, String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        archivo.getParentFile().mkdirs();
        mapper.writeValue(archivo, objeto);
    }

    public static <T> T leerObjetoDesdeJson(String rutaArchivo, Class<T> clase) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(new File(rutaArchivo), clase);
        //return mapper.readValue(new File(filePath), new TypeReference<List<Evento>>() {});
    }


    // ------------------------
    // CSV Y ARCHIVOS
    // ------------------------

    public static <T> void guardarCsvLista(List<T> lista, String rutaArchivo, Function<T, String> formatter) throws IOException {
        File archivo = new File(rutaArchivo);
        archivo.getParentFile().mkdirs();
        try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
            for (T obj : lista) {
                writer.write(formatter.apply(obj));
                writer.newLine();
            }
        }
    }
    // Ejemplo:
    // guardarCsvLista(eventos, "./csv/eventos.csv", Evento::toString);

    public static <T> void guardarCsvIndividual(List<T> lista, String directorio, Function<T, String> nombreArchivo, Function<T, String> formatter) throws IOException {
        File dir = new File(directorio);
        dir.mkdirs();
        for (T obj : lista) {
            File archivo = new File(dir, nombreArchivo.apply(obj));
            try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
                writer.write(formatter.apply(obj));
            }
        }
    }
    // Ejemplo:
    // guardarCsvIndividual(eventos, "./csv2", e -> e.getId() + ".csv", Evento::toString);

    public static void copiarArchivosDirectorio(String origen, String destino) throws IOException {
        Files.createDirectories(Paths.get(destino));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(origen))) {
            for (Path archivo : stream) {
                if (Files.isRegularFile(archivo)) {
                    Path destinoArchivo = Paths.get(destino, archivo.getFileName().toString());
                    Files.copy(archivo, destinoArchivo, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
    // Ejemplo:
    // copiarArchivosDirectorio("./csv2", "./copias");
}


