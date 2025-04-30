package ficherosUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
Índice de Funcionalidades:

Configuración de ObjectMapper
        createMapper()

Conversiones de Objetos a/desde JSON
        ejemploObjetoAJson()
        objetoAJson(Object objeto)
        ejemploGuardarComoJson()
        guardarComoJson(Object objeto, String rutaArchivo)
        ejemploJsonAObjeto()
        jsonAObjeto
        ejemploJsonAObjetoConTypeReference()
        jsonAObjeto(String json, 
        ejemploLeerObjetoDesdeJson()
        leerObjetoDesdeJson
        ejemploLeerListaDesdeJson()
        leerListaDesdeJson

Operaciones con Streams de JSON Arrays
        ejemploJsonArrayAStream()
        jsonArrayAStream
        ejemploFiltrarJsonArray()
        filtrarJsonArray
        ejemploMapearJsonArray()
        mapearJsonArray
        ejemploAgruparJsonArray()
        agruparJsonArray

* Conversiones a/desde CSV
        ejemploListaACsv()
        listaACsv
        ejemploJsonArrayACsv()
        jsonArrayACsv
        ejemploCsvALista()
        csvALista(String rutaArchivoCsv, Function<Map<String, String>, T> factory)
        ejemploCsvAJson()
        csvAJson(String rutaArchivoCsv, String rutaArchivoJson, Function<Map<String, String>, T> factory)

Conversiones a Texto Plano
        ejemploListaATextoPlano()
        listaATextoPlano
        ejemploJsonArrayATextoPlano()
        jsonArrayATextoPlano
        * 
Operaciones con Directorios y Archivos
        ejemploFusionarJsonArrays()
        fusionarJsonArrays
        ejemploCrearBackupZip()
        crearBackupZip(String directorioOrigen, String rutaArchivoZip)
        ejemploCrearBackupConFecha()

crearBackupConFecha(String rutaArchivo, String directorioBackup)
        ejemploMonitorearDirectorio()
        monitorearDirectorio
        Manipulación Avanzada de JSON con JsonNode
        ejemploManipularJson()
        manipularJson(String rutaArchivo, Function<JsonNode, JsonNode> manipulador)
        ejemploAgregarAJsonArray()
        agregarAJsonArray(String rutaArchivo, T objeto)
        ejemploBuscarEnJson()
        buscarEnJson
        ejemploActualizarEnJson()
        actualizarEnJson
        ejemploEliminarDeJson()
        eliminarDeJson
        ejemploCombinarJsons()
        combinarJsons(String json1, String json2)
        ejemploEsJsonValido()
        esJsonValido(String json)
        ejemploGenerarEstructuraDirectorios()
        generarEstructuraDirectorios
        * 
Métodos Auxiliares
        crearDirectorioSiNoExiste(File directorio)
        formatearValorCsv(Object valor)
        parsearLineaCsv(String linea)
 */
public class JsonStreamUtils {

    private static final String CSV_DELIMITER = ",";
    private static final String CSV_QUOTE = "\"";
    private static final String CSV_ESCAPE = "\\";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    /**
     * Ejemplo de conversión de un objeto Java a JSON.
     */
    public static void ejemploObjetoAJson() {
        try {
            Persona persona = new Persona("Juan", 30);
            String json = objetoAJson(persona);
            System.out.println("Objeto Persona a JSON: " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String objetoAJson(Object objeto) throws IOException {
        return createMapper().writeValueAsString(objeto);
    }

    /**
     * Ejemplo de guardar un objeto Java como un archivo JSON.
     */
    public static void ejemploGuardarComoJson() {
        try {
            Persona persona = new Persona("María", 25);
            String rutaArchivo = "persona.json";
            guardarComoJson(persona, rutaArchivo);
            System.out.println("Objeto Persona guardado en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarComoJson(Object objeto, String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        crearDirectorioSiNoExiste(archivo.getParentFile());
        createMapper().writeValue(archivo, objeto);
    }

    /**
     * Ejemplo de convertir una cadena JSON a un objeto Java.
     */
    public static void ejemploJsonAObjeto() {
        try {
            String json = "{\"nombre\":\"Carlos\",\"edad\":35}";
            Persona persona = jsonAObjeto(json, Persona.class);
            System.out.println("JSON a objeto Persona: " + persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jsonAObjeto(String json, Class<T> clase) throws IOException {
        return createMapper().readValue(json, clase);
    }

    /**
     * Ejemplo de convertir una cadena JSON a un objeto Java con TypeReference
     * para tipos genéricos.
     */
    public static void ejemploJsonAObjetoConTypeReference() {
        try {
            String jsonLista = "[{\"nombre\":\"Ana\",\"edad\":28},{\"nombre\":\"Luis\",\"edad\":40}]";
            List<Persona> personas = jsonAObjeto(jsonLista, new TypeReference<List<Persona>>() {
            });
            System.out.println("JSON a lista de Personas: " + personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jsonAObjeto(String json, TypeReference<T> typeReference) throws IOException {
        return createMapper().readValue(json, typeReference);
    }

    /**
     * Ejemplo de leer un objeto Java desde un archivo JSON.
     */
    public static void ejemploLeerObjetoDesdeJson() {
        try {
            String rutaArchivo = "persona.json";
            Persona persona = leerObjetoDesdeJson(rutaArchivo, Persona.class);
            System.out.println("Objeto Persona leído desde " + rutaArchivo + ": " + persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T leerObjetoDesdeJson(String rutaArchivo, Class<T> clase) throws IOException {
        return createMapper().readValue(new File(rutaArchivo), clase);
    }

    /**
     * Ejemplo de leer una lista de objetos Java desde un archivo JSON array.
     */
    public static void ejemploLeerListaDesdeJson() {
        try {
            String rutaArchivo = "personas.json"; // Archivo con [{"nombre":"...", "edad":...}, ...]
            List<Persona> personas = leerListaDesdeJson(rutaArchivo, Persona.class);
            System.out.println("Lista de Personas leída desde " + rutaArchivo + ": " + personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> leerListaDesdeJson(String rutaArchivo, Class<T> tipoElemento) throws IOException {
        ObjectMapper mapper = createMapper();
        return mapper.readValue(
                new File(rutaArchivo),
                mapper.getTypeFactory().constructCollectionType(List.class, tipoElemento)
        );
    }

    /**
     * Ejemplo de convertir un JSON array a un Stream de objetos Java.
     */
    public static void ejemploJsonArrayAStream() {
        try {
            String rutaArchivo = "personas.json";
            Stream<Persona> personaStream = jsonArrayAStream(rutaArchivo, Persona.class);
            personaStream.forEach(p -> System.out.println("Persona en stream: " + p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> Stream<T> jsonArrayAStream(String rutaArchivo, Class<T> tipoElemento) throws IOException {
        List<T> lista = leerListaDesdeJson(rutaArchivo, tipoElemento);
        return lista.stream();
    }

    /**
     * Ejemplo de filtrar un JSON array de objetos Java.
     */
    public static void ejemploFiltrarJsonArray() {
        try {
            String rutaArchivo = "personas.json";
            List<Persona> mayoresDe25 = filtrarJsonArray(rutaArchivo, Persona.class, p -> p.getEdad() > 25);
            System.out.println("Personas mayores de 25: " + mayoresDe25);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> filtrarJsonArray(String rutaArchivo, Class<T> tipoElemento, Predicate<T> filtro) throws IOException {
        return jsonArrayAStream(rutaArchivo, tipoElemento)
                .filter(filtro)
                .collect(Collectors.toList());
    }

    /**
     * Ejemplo de mapear un JSON array de objetos Java a otro tipo.
     */
    public static void ejemploMapearJsonArray() {
        try {
            String rutaArchivo = "personas.json";
            List<String> nombres = mapearJsonArray(rutaArchivo, Persona.class, Persona::getNombre);
            System.out.println("Nombres de personas: " + nombres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T, R> List<R> mapearJsonArray(String rutaArchivo, Class<T> tipoElemento, Function<T, R> mapper) throws IOException {
        return jsonArrayAStream(rutaArchivo, tipoElemento)
                .map(mapper)
                .collect(Collectors.toList());
    }

    /**
     * Ejemplo de agrupar un JSON array de objetos Java por una propiedad.
     */
    public static void ejemploAgruparJsonArray() {
        try {
            String rutaArchivo = "personas.json";
            Map<Integer, List<Persona>> personasPorEdad = agruparJsonArray(rutaArchivo, Persona.class, Persona::getEdad);
            System.out.println("Personas agrupadas por edad: " + personasPorEdad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T, K> Map<K, List<T>> agruparJsonArray(
            String rutaArchivo, Class<T> tipoElemento, Function<T, K> keyExtractor) throws IOException {
        return jsonArrayAStream(rutaArchivo, tipoElemento)
                .collect(Collectors.groupingBy(keyExtractor));
    }

    /**
     * Ejemplo de convertir una lista de objetos Java a un archivo CSV.
     */
    public static void ejemploListaACsv() {
        try {
            List<Persona> personas = List.of(new Persona("Elena", 32), new Persona("David", 28));
            String rutaArchivoCsv = "personas.csv";
            Map<String, Function<Persona, Object>> extractores = new HashMap<>();
            extractores.put("Nombre", Persona::getNombre);
            extractores.put("Edad", Persona::getEdad);
            listaACsv(personas, rutaArchivoCsv, extractores);
            System.out.println("Lista de Personas guardada en: " + rutaArchivoCsv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void listaACsv(List<T> lista, String rutaArchivo, Map<String, Function<T, Object>> extractores) throws IOException {
        File archivo = new File(rutaArchivo);
        crearDirectorioSiNoExiste(archivo.getParentFile());

        try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
            writer.write(String.join(CSV_DELIMITER, extractores.keySet()));
            writer.write(LINE_SEPARATOR);

            for (T objeto : lista) {
                List<String> valores = extractores.values().stream()
                        .map(extractor -> formatearValorCsv(extractor.apply(objeto)))
                        .collect(Collectors.toList());
                writer.write(String.join(CSV_DELIMITER, valores));
                writer.write(LINE_SEPARATOR);
            }
        }
    }

    /**
     * Ejemplo de convertir un archivo JSON array a un archivo CSV.
     */
    public static void ejemploJsonArrayACsv() {
        try {
            String rutaJson = "personas.json";
            String rutaCsv = "personas_desde_json.csv";
            Map<String, Function<Persona, Object>> extractores = new HashMap<>();
            extractores.put("Nombre", Persona::getNombre);
            extractores.put("Edad", Persona::getEdad);
            jsonArrayACsv(rutaJson, rutaCsv, Persona.class, extractores);
            System.out.println("JSON array guardado como CSV en: " + rutaCsv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void jsonArrayACsv(
            String rutaJsonArray, String rutaArchivoCsv, Class<T> tipoElemento,
            Map<String, Function<T, Object>> extractores) throws IOException {

        List<T> lista = leerListaDesdeJson(rutaJsonArray, tipoElemento);
        listaACsv(lista, rutaArchivoCsv, extractores);
    }

    /**
     * Ejemplo de convertir un archivo CSV a una lista de objetos Java.
     */
    public static void ejemploCsvALista() {
        try {
            String rutaCsv = "personas.csv";
            Function<Map<String, String>, Persona> factory = props -> new Persona(props.get("Nombre"), Integer.parseInt(props.get("Edad")));
            List<Persona> personas = csvALista(rutaCsv, factory);
            System.out.println("CSV leído como lista de Personas: " + personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> csvALista(String rutaArchivoCsv, Function<Map<String, String>, T> factory) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(rutaArchivoCsv), StandardCharsets.UTF_8);
        if (lineas.isEmpty()) {
            return Collections.emptyList();
        }

        String[] cabeceras = parsearLineaCsv(lineas.get(0));

        return lineas.stream()
                .skip(1)
                .map(linea -> {
                    String[] valores = parsearLineaCsv(linea);
                    Map<String, String> propiedades = new HashMap<>();
                    for (int i = 0; i < Math.min(cabeceras.length, valores.length); i++) {
                        propiedades.put(cabeceras[i], valores[i]);
                    }
                    return factory.apply(propiedades);
                })
                .collect(Collectors.toList());
    }

    /**
     * Ejemplo de convertir un archivo CSV a un archivo JSON array.
     */
    public static void ejemploCsvAJson() {
        try {
            String rutaCsv = "personas.csv";
            String rutaJson = "personas_desde_csv.json";
            Function<Map<String, String>, Persona> factory = props -> new Persona(props.get("Nombre"), Integer.parseInt(props.get("Edad")));
            csvAJson(rutaCsv, rutaJson, factory);
            System.out.println("CSV guardado como JSON en: " + rutaJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void csvAJson(
            String rutaArchivoCsv, String rutaArchivoJson, Function<Map<String, String>, T> factory) throws IOException {

        List<T> lista = csvALista(rutaArchivoCsv, factory);
        guardarComoJson(lista, rutaArchivoJson);
    }

    /**
     * Ejemplo de convertir una lista de objetos Java a un archivo de texto
     * plano.
     */
    public static void ejemploListaATextoPlano() {
        try {
            List<Persona> personas = List.of(new Persona("Ricardo", 45), new Persona("Sofía", 38));
            String rutaArchivoTexto = "personas.txt";
            listaATextoPlano(personas, rutaArchivoTexto, p -> p.getNombre() + " - " + p.getEdad());
            System.out.println("Lista de Personas guardada en: " + rutaArchivoTexto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void listaATextoPlano(List<T> lista, String rutaArchivo, Function<T, String> formatter) throws IOException {
        File archivo = new File(rutaArchivo);
        crearDirectorioSiNoExiste(archivo.getParentFile());

        try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
            for (T objeto : lista) {
                writer.write(formatter.apply(objeto));
                writer.write(LINE_SEPARATOR);
            }
        }
    }

    /**
     * Ejemplo de convertir un archivo JSON array a un archivo de texto plano.
     */
    public static void ejemploJsonArrayATextoPlano() {
        try {
            String rutaJson = "personas.json";
            String rutaTexto = "personas_desde_json.txt";

            jsonArrayATextoPlano(rutaJson, rutaTexto, Persona.class,
                    p -> p.getNombre() + " tiene " + p.getEdad() + " años.");

            System.out.println("JSON array guardado como texto en: " + rutaTexto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void jsonArrayATextoPlano(
            String rutaJsonArray, String rutaArchivoTexto, Class<T> tipoElemento,
            Function<T, String> formatter) throws IOException {

        List<T> lista = leerListaDesdeJson(rutaJsonArray, tipoElemento);
        listaATextoPlano(lista, rutaArchivoTexto, formatter);
    }

    /**
     * Ejemplo de fusionar varios archivos JSON array en uno solo.
     */
    public static void ejemploFusionarJsonArrays() {
        try {
            List<String> rutas = List.of("personas1.json", "personas2.json"); // Ambos deben contener arrays de Persona
            String rutaDestino = "personas_fusionadas.json";
            fusionarJsonArrays(rutas, rutaDestino, Persona.class);
            System.out.println("Arrays JSON fusionados en: " + rutaDestino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void fusionarJsonArrays(
            List<String> rutasArchivos, String rutaDestino, Class<T> tipoElemento) throws IOException {

        List<T> listaCompleta = new ArrayList<>();

        for (String ruta : rutasArchivos) {
            List<T> lista = leerListaDesdeJson(ruta, tipoElemento);
            listaCompleta.addAll(lista);
        }

        guardarComoJson(listaCompleta, rutaDestino);
    }

    /**
     * Ejemplo de crear un archivo ZIP de un directorio.
     */
    public static void ejemploCrearBackupZip() {
        try {
            String directorioOrigen = "mi_directorio"; // Reemplazar con la ruta de tu directorio
            String rutaZip = "backup.zip";
            crearBackupZip(directorioOrigen, rutaZip);
            System.out.println("Backup ZIP creado en: " + rutaZip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearBackupZip(String directorioOrigen, String rutaArchivoZip) throws IOException {
        Path pathDirectorio = Paths.get(directorioOrigen);
        File archivoZip = new File(rutaArchivoZip);
        crearDirectorioSiNoExiste(archivoZip.getParentFile());

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(archivoZip))) {
            Files.walk(pathDirectorio)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        String entryName = pathDirectorio.relativize(path).toString();
                        try {
                            ZipEntry zipEntry = new ZipEntry(entryName);
                            zipOut.putNextEntry(zipEntry);
                            Files.copy(path, zipOut);
                            zipOut.closeEntry();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        } catch (UncheckedIOException e) {
            throw e.getCause();
        }
    }

    /**
     * Ejemplo de crear una copia de seguridad de un archivo con la fecha y hora
     * en el nombre.
     */
    public static void ejemploCrearBackupConFecha() {
        try {
            String rutaArchivo = "mi_documento.txt"; // Reemplazar con la ruta de tu archivo
            String directorioBackup = "backups";
            crearBackupConFecha(rutaArchivo, directorioBackup);
            System.out.println("Backup de " + rutaArchivo + " creado en: " + directorioBackup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearBackupConFecha(String rutaArchivo, String directorioBackup) throws IOException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || !archivo.isFile()) {
            throw new FileNotFoundException("El archivo no existe: " + rutaArchivo);
        }

        String nombreArchivo = archivo.getName();
        String nombreBase = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
        String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf('.'));

        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nombreBackup = nombreBase + "_" + fechaHora + extension;

        File dirBackup = new File(directorioBackup);
        crearDirectorioSiNoExiste(dirBackup);

        Path destino = Paths.get(directorioBackup, nombreBackup);
        Files.copy(archivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Ejemplo de monitorear un directorio en busca de nuevos archivos JSON y
     * procesarlos.
     */
    public static void ejemploMonitorearDirectorio() {
        try {
            String directorioMonitor = "entrada_json"; // Crea este directorio
            monitorearDirectorio(directorioMonitor, Dato.class, datos -> {
                System.out.println("Nuevos datos JSON detectados: " + datos);
                // Aquí puedes implementar la lógica para procesar la lista de 'Dato'
                return null;
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> void monitorearDirectorio(
            String directorioMonitor, Class<T> tipoElemento,
            Function<List<T>, Void> procesador) throws IOException, InterruptedException {

        Path directorio = Paths.get(directorioMonitor);
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);
        }

        WatchService watchService = FileSystems.getDefault().newWatchService();
        directorio.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Monitoreando el directorio: " + directorio);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                Path nombreArchivo = (Path) event.context();
                Path archivoCompleto = directorio.resolve(nombreArchivo);

                if (nombreArchivo.toString().endsWith(".json")) {
                    System.out.println("Archivo nuevo detectado: " + nombreArchivo);
                    try {
                        List<T> lista = leerListaDesdeJson(archivoCompleto.toString(), tipoElemento);
                        procesador.apply(lista);
                    } catch (IOException e) {
                        System.err.println("Error al procesar el archivo: " + e.getMessage());
                    }
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

    /**
     * Ejemplo de manipular un archivo JSON utilizando JsonNode.
     */
    public static void ejemploManipularJson() {
        try {
            String rutaArchivo = "data.json"; // Contenido: {"nombre":"viejo", "valor": 10}
            manipularJson(rutaArchivo, rootNode -> {
                ((ObjectNode) rootNode).put("nombre", "nuevo");
                ((ObjectNode) rootNode).put("valor", rootNode.get("valor").asInt() + 5);
                return rootNode;
            });
            System.out.println("Archivo JSON manipulado: data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void manipularJson(String rutaArchivo, Function<JsonNode, JsonNode> manipulador) throws IOException {
        ObjectMapper mapper = createMapper();
        JsonNode rootNode = mapper.readTree(new File(rutaArchivo));

        JsonNode nuevoNode = manipulador.apply(rootNode);

        mapper.writeValue(new File(rutaArchivo), nuevoNode);
    }

    /**
     * Ejemplo de agregar un objeto a un archivo JSON array existente (o crear
     * uno nuevo).
     */
    public static void ejemploAgregarAJsonArray() {
        try {
            String rutaArchivo = "elementos.json"; // Puede no existir inicialmente o contener un array
            Elemento nuevoElemento = new Elemento("item3", 100);
            agregarAJsonArray(rutaArchivo, nuevoElemento);
            System.out.println("Elemento agregado a: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void agregarAJsonArray(String rutaArchivo, T objeto) throws IOException {
        ObjectMapper mapper = createMapper();
        File archivo = new File(rutaArchivo);

        ArrayNode arrayNode;
        if (archivo.exists()) {
            JsonNode rootNode = mapper.readTree(archivo);
            if (rootNode.isArray()) {
                arrayNode = (ArrayNode) rootNode;
            } else {
                arrayNode = mapper.createArrayNode();
                arrayNode.add(rootNode);
            }
        } else {
            crearDirectorioSiNoExiste(archivo.getParentFile());
            arrayNode = mapper.createArrayNode();
        }

        arrayNode.add(mapper.valueToTree(objeto));
        mapper.writeValue(archivo, arrayNode);
    }

    /**
     * Ejemplo de buscar objetos dentro de un archivo JSON (array o único
     * objeto) basado en un predicado.
     */
    public static void ejemploBuscarEnJson() {
        try {
            String rutaArchivo = "productos.json"; // Contenido: [{"nombre":"A", "precio": 20}, {"nombre":"B", "precio": 30}]
            List<Producto> caros = buscarEnJson(rutaArchivo, Producto.class, node -> node.get("precio").asInt() > 25);
            System.out.println("Productos caros: " + caros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> buscarEnJson(String rutaArchivo, Class<T> tipoElemento, Predicate<JsonNode> predicado) throws IOException {
        ObjectMapper mapper = createMapper();
        JsonNode rootNode = mapper.readTree(new File(rutaArchivo));

        List<T> resultados = new ArrayList<>();

        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {
                if (predicado.test(node)) {
                    T objeto = mapper.treeToValue(node, tipoElemento);
                    resultados.add(objeto);
                }
            }
        } else if (predicado.test(rootNode)) {
            T objeto = mapper.treeToValue(rootNode, tipoElemento);
            resultados.add(objeto);
        }

        return resultados;
    }

    /**
     * Ejemplo de actualizar objetos dentro de un archivo JSON array basado en
     * un predicado.
     */
    public static void ejemploActualizarEnJson() {
        try {
            String rutaArchivo = "items.json"; // Contenido: [{"id": 1, "valor": 5}, {"id": 2, "valor": 10}]
            actualizarEnJson(rutaArchivo, node -> node.get("id").asInt() == 1, node -> {
                ((ObjectNode) node).put("valor", node.get("valor").asInt() * 2);
                return node;
            });
            System.out.println("Archivo JSON actualizado: items.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void actualizarEnJson(String rutaArchivo, Predicate<JsonNode> predicado,
            Function<JsonNode, JsonNode> actualizador) throws IOException {

        ObjectMapper mapper = createMapper();
        JsonNode rootNode = mapper.readTree(new File(rutaArchivo));

        if (rootNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) rootNode;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode node = arrayNode.get(i);
                if (predicado.test(node)) {
                    JsonNode nuevoNode = actualizador.apply(node);
                    arrayNode.set(i, nuevoNode);
                }
            }
        }

        mapper.writeValue(new File(rutaArchivo), rootNode);
    }

    /**
     * Ejemplo de eliminar objetos de un archivo JSON array basado en un
     * predicado.
     */
    public static void ejemploEliminarDeJson() {
        try {
            String rutaArchivo = "cosas.json"; // Contenido: ["manzana", "banana", "naranja"]
            eliminarDeJson(rutaArchivo, node -> node.asText().equals("banana"));
            System.out.println("Elemento eliminado de: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarDeJson(String rutaArchivo, Predicate<JsonNode> predicado) throws IOException {
        ObjectMapper mapper = createMapper();
        JsonNode rootNode = mapper.readTree(new File(rutaArchivo));

        if (rootNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) rootNode;
            // Recorrer en reversa para evitar errores al eliminar mientras se itera
            for (int i = arrayNode.size() - 1; i >= 0; i--) {
                JsonNode node = arrayNode.get(i);
                if (predicado.test(node)) {
                    arrayNode.remove(i);
                }
            }
            mapper.writeValue(new File(rutaArchivo), arrayNode);
        }
    }

    /**
     * Ejemplo de combinar dos cadenas JSON de objetos en una sola.
     */
    public static void ejemploCombinarJsons() {
        try {
            String json1 = "{\"a\": 1, \"b\": 2}";
            String json2 = "{\"b\": 3, \"c\": 4}";
            String combinado = combinarJsons(json1, json2);
            System.out.println("JSONs combinados: " + combinado); // Resultado: {"a":1,"b":3,"c":4}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String combinarJsons(String json1, String json2) throws IOException {
        ObjectMapper mapper = createMapper();
        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);

        if (node1.isObject() && node2.isObject()) {
            ObjectNode resultado = mapper.createObjectNode();

            node1.fields().forEachRemaining(entry
                    -> resultado.set(entry.getKey(), entry.getValue()));

            node2.fields().forEachRemaining(entry
                    -> resultado.set(entry.getKey(), entry.getValue()));

            return mapper.writeValueAsString(resultado);
        } else {
            throw new IllegalArgumentException("Ambos JSON deben ser objetos, no arrays");
        }
    }

    /**
     * Ejemplo de verificar si una cadena es un JSON válido.
     */
    public static void ejemploEsJsonValido() {
        String jsonValido = "{\"clave\":\"valor\"}";
        String jsonInvalido = "{\"clave\":\"valor";
        System.out.println(jsonValido + " es válido: " + esJsonValido(jsonValido));
        System.out.println(jsonInvalido + " es válido: " + esJsonValido(jsonInvalido));
    }

    public static boolean esJsonValido(String json) {
        try {
            ObjectMapper mapper = createMapper();
            mapper.readTree(json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Ejemplo de generar una estructura de directorios basada en los datos de
     * un JSON array.
     */
    public static void ejemploGenerarEstructuraDirectorios() {
        try {
            String rutaJson = "usuarios.json"; // [{"id": 1, "rol": "admin", "nombre": "Usuario1"}, {"id": 2, "rol": "user", "nombre": "Usuario2"}]
            String directorioBase = "usuarios_data";
            generarEstructuraDirectorios(rutaJson, directorioBase, Usuario.class, Usuario::getRol, rol -> rol);
            System.out.println("Estructura de directorios generada en: " + directorioBase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T, K> void generarEstructuraDirectorios(
            String rutaJsonArray, String directorioBase, Class<T> tipoElemento,
            Function<T, K> keyExtractor, Function<K, String> nombreArchivo) throws IOException {
        Map<K, List<T>> grupos = agruparJsonArray(rutaJsonArray, tipoElemento, keyExtractor);

        for (Map.Entry<K, List<T>> entrada : grupos.entrySet()) {
            K clave = entrada.getKey();
            List<T> elementos = entrada.getValue();

            String nombreDir = nombreArchivo.apply(clave);
            Path rutaCompleta = Paths.get(directorioBase, nombreDir);

            Files.createDirectories(rutaCompleta);
            guardarComoJson(elementos, rutaCompleta.resolve("datos.json").toString());
        }
    }

    private static void crearDirectorioSiNoExiste(File directorio) throws IOException {
        if (directorio != null && !directorio.exists()) {
            if (!directorio.mkdirs()) {
                throw new IOException("No se pudo crear el directorio: " + directorio);
            }
        }
    }

    private static String formatearValorCsv(Object valor) {
        if (valor == null) {
            return "";
        }

        String str = valor.toString();

        // Verificar si es necesario escapar o encerrar en comillas
        boolean necesitaComillas = str.contains(CSV_DELIMITER)
                || str.contains(CSV_QUOTE)
                || str.contains("\n")
                || str.contains("\r");

        if (necesitaComillas) {
            // Reemplazar comillas por comillas escapadas
            str = str.replace(CSV_QUOTE, CSV_ESCAPE + CSV_QUOTE);
            // Encerrar en comillas
            str = CSV_QUOTE + str + CSV_QUOTE;
        }

        return str;
    }

    private static String[] parsearLineaCsv(String linea) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean enComillas = false;
        char[] chars = linea.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == CSV_QUOTE.charAt(0)) {
                // Comprobar si es una comilla escapada
                if (enComillas && i + 1 < chars.length && chars[i + 1] == CSV_QUOTE.charAt(0)) {
                    sb.append(c);
                    i++; // Saltar la siguiente comilla
                } else {
                    enComillas = !enComillas;
                }
            } else if (c == CSV_DELIMITER.charAt(0) && !enComillas) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString()); // Añadir el último token
        return tokens.toArray(new String[0]);
    }

    // Clases de ejemplo para las demostraciones
    public static class Persona {

        private String nombre;
        private int edad;

        public Persona() {
        }

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        @Override
        public String toString() {
            return "Persona{"
                    + "nombre='" + nombre + '\''
                    + ", edad=" + edad
                    + '}';
        }
    }

    public static class Dato {

        private String valor;

        public Dato() {
        }

        public Dato(String valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Dato{"
                    + "valor='" + valor + '\''
                    + '}';
        }
    }

    public static class Elemento {

        private String nombre;
        private int cantidad;

        public Elemento() {
        }

        public Elemento(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return "Elemento{"
                    + "nombre='" + nombre + '\''
                    + ", cantidad=" + cantidad
                    + '}';
        }
    }

    public static class Producto {

        private String nombre;
        private double precio;

        public Producto() {
        }

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return "Producto{"
                    + "nombre='" + nombre + '\''
                    + ", precio=" + precio
                    + '}';
        }
    }

    public static class Usuario {

        private int id;
        private String rol;
        private String nombre;

        public Usuario() {
        }

        public Usuario(int id, String rol, String nombre) {
            this.id = id;
            this.rol = rol;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getRol() {
            return rol;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return "Usuario{"
                    + "id=" + id
                    + ", rol='" + rol + '\''
                    + ", nombre='" + nombre + '\''
                    + '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Ejemplos de JsonStreamUtils ---");
        ejemploObjetoAJson();
        ejemploGuardarComoJson();
        ejemploJsonAObjeto();
        ejemploJsonAObjetoConTypeReference();
        ejemploLeerObjetoDesdeJson();
        ejemploLeerListaDesdeJson();
        ejemploJsonArrayAStream();
        ejemploFiltrarJsonArray();
        ejemploMapearJsonArray();
        ejemploAgruparJsonArray();
        ejemploListaACsv();
        ejemploJsonArrayACsv();
        ejemploCsvALista();
        ejemploCsvAJson();
        ejemploListaATextoPlano();
        ejemploJsonArrayATextoPlano();
        ejemploFusionarJsonArrays();
        ejemploCrearBackupZip();
        ejemploCrearBackupConFecha();
        // ejemploMonitorearDirectorio(); // Descomentar para probar el monitor de directorio (requiere crear el directorio 'entrada_json' y añadir archivos .json)
        ejemploManipularJson();
        ejemploAgregarAJsonArray();
        ejemploBuscarEnJson();
        ejemploActualizarEnJson();
        ejemploEliminarDeJson();
        ejemploCombinarJsons();
        ejemploEsJsonValido();
        ejemploGenerarEstructuraDirectorios();
    }
}
