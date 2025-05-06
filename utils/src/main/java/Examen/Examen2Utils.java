package Examen;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
/*
# Resumen de métodos por orden de aparición

## Conversiones JSON <-> Map
1. **jsonToMap**: Convierte una cadena JSON a un objeto Map.
2. **mapToJson**: Convierte un objeto Map a una cadena JSON.

## Conversiones JSON <-> CSV
3. **jsonToCsv**: Convierte una cadena JSON a formato CSV.
4. **csvToJson**: Convierte una cadena CSV a formato JSON.

## Operaciones con Matrices
5. **recorrerIzquierdaDerecha**: Recorre una matriz de izquierda a derecha por filas.
6. **recorrerDerechaIzquierda**: Recorre una matriz de derecha a izquierda por filas.
7. **recorrerArribaAbajo**: Recorre una matriz de arriba a abajo por columnas.
8. **recorrerAbajoArriba**: Recorre una matriz de abajo a arriba por columnas.
9. **existeValorEnMatriz**: Verifica si un valor está presente en la matriz.
10. **existeClaveMapEnMatriz**: Verifica si una clave de un Map está presente en una matriz.
11. **existeValorMapEnMatriz**: Verifica si un valor de un Map está presente en una matriz.

## Operaciones con Archivos
12. **copiarCarpeta**: Copia el contenido completo de una carpeta a otra.
13. **crearCsvDesdeListaObjetos**: Crea un archivo CSV a partir de una lista de objetos.
14. **crearCsvPorObjeto**: Crea un archivo CSV por cada objeto de la lista.
15. **crearJsonDesdeListaObjetos**: Crea un archivo JSON a partir de una lista de objetos.
16. **crearJsonPorObjeto**: Crea un archivo JSON por cada objeto de la lista.
17. **copiarArchivo**: Copia un archivo de una carpeta a otra.
18. **crearDirectorioYArchivo**: Crea un directorio y un archivo dentro de él.
19. **buscarArchivosEnDirectorio**: Busca archivos en un directorio por extensión.

## Clases para el Ejercicio JSON Elefantes
20. **TelaElefante**: Clase que representa la estructura del JSON para el ejercicio.
21. **Elefante**: Clase que representa un elefante con nombre y peso.

## Métodos para el Ejercicio JSON Elefantes
22. **leerArchivoElefantes**: Lee un archivo JSON y devuelve un objeto TelaElefante.
23. **elefantesColumpiados**: Obtiene la lista de elefantes que se columpiaron antes de que la tela se rompiera.
24. **encontrarCombinaciones**: Encuentra todas las combinaciones de números que suman un valor objetivo.
25. **encontrarCombinacionesRecursivo**: Método auxiliar recursivo para encontrar combinaciones.

## Métodos Auxiliares
26. **getValorPropiedad**: Método auxiliar para obtener el valor de una propiedad de un objeto.
27. **main**: Método principal que demuestra el ejercicio de los elefantes.
*/
/**
 * Clase de utilidad para operaciones comunes con JSON, CSV, matrices y archivos
 */
public class Examen2Utils {

    // ************************* CONVERSIONES JSON <-> MAP *************************
    /**
     * Convierte una cadena JSON a un Map Ejemplo: String json =
     * "{\"nombre\":\"Juan\",\"edad\":30}"; Map<String, Object> mapa =
     * jsonToMap(json);
     */
    public static Map<String, Object> jsonToMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * Convierte un Map a una cadena JSON Ejemplo: Map<String, Object> mapa =
     * new HashMap<>(); mapa.put("nombre", "Juan"); mapa.put("edad", 30); String
     * json = mapToJson(mapa);
     */
    public static String mapToJson(Map<String, Object> map) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(map);
    }

    // ************************* CONVERSIONES JSON <-> CSV *************************
    /**
     * Convierte una cadena JSON a CSV Ejemplo: String json =
     * "[{\"nombre\":\"Juan\",\"edad\":30},{\"nombre\":\"Ana\",\"edad\":25}]";
     * String csv = jsonToCsv(json);
     */
    public static String jsonToCsv(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> data = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
        });

        if (data.isEmpty()) {
            return "";
        }

        StringWriter writer = new StringWriter();
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        // Encabezados
        csvPrinter.printRecord(data.get(0).keySet());

        // Datos
        for (Map<String, Object> row : data) {
            csvPrinter.printRecord(row.values());
        }

        csvPrinter.close();
        return writer.toString();
    }

    /**
     * Convierte una cadena CSV a JSON Ejemplo: String csv =
     * "nombre,edad\nJuan,30\nAna,25"; String json = csvToJson(csv);
     */
    public static String csvToJson(String csv) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Reader reader = new StringReader(csv);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        List<Map<String, String>> data = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            Map<String, String> row = new HashMap<>();
            for (String header : csvParser.getHeaderMap().keySet()) {
                row.put(header, record.get(header));
            }
            data.add(row);
        }

        return mapper.writeValueAsString(data);
    }

    // ************************* OPERACIONES CON MATRICES *************************
    /**
     * Recorre matriz de izquierda a derecha (fila por fila) Ejemplo: int[][]
     * matriz = {{1, 2, 3}, {4, 5, 6}}; List<Integer> resultado =
     * recorrerIzquierdaDerecha(matriz); // resultado = [1, 2, 3, 4, 5, 6]
     */
    public static List<Integer> recorrerIzquierdaDerecha(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        for (int[] fila : matriz) {
            for (int valor : fila) {
                resultado.add(valor);
            }
        }
        return resultado;
    }

    /**
     * Recorre matriz de derecha a izquierda (fila por fila) Ejemplo: int[][]
     * matriz = {{1, 2, 3}, {4, 5, 6}}; List<Integer> resultado =
     * recorrerDerechaIzquierda(matriz); // resultado = [3, 2, 1, 6, 5, 4]
     */
    public static List<Integer> recorrerDerechaIzquierda(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        for (int[] fila : matriz) {
            for (int j = fila.length - 1; j >= 0; j--) {
                resultado.add(fila[j]);
            }
        }
        return resultado;
    }

    /**
     * Recorre matriz de arriba a abajo (columna por columna) Ejemplo: int[][]
     * matriz = {{1, 2, 3}, {4, 5, 6}}; List<Integer> resultado =
     * recorrerArribaAbajo(matriz); // resultado = [1, 4, 2, 5, 3, 6]
     */
    public static List<Integer> recorrerArribaAbajo(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        if (matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                resultado.add(matriz[i][j]);
            }
        }
        return resultado;
    }

    /**
     * Recorre matriz de abajo a arriba (columna por columna) Ejemplo: int[][]
     * matriz = {{1, 2, 3}, {4, 5, 6}}; List<Integer> resultado =
     * recorrerAbajoArriba(matriz); // resultado = [4, 1, 5, 2, 6, 3]
     */
    public static List<Integer> recorrerAbajoArriba(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        if (matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int j = 0; j < columnas; j++) {
            for (int i = filas - 1; i >= 0; i--) {
                resultado.add(matriz[i][j]);
            }
        }
        return resultado;
    }

    /**
     * Verifica si un valor está presente en la matriz Ejemplo: int[][] matriz =
     * {{1, 2, 3}, {4, 5, 6}}; boolean encontrado = existeValorEnMatriz(matriz,
     * 5); // true
     */
    public static boolean existeValorEnMatriz(int[][] matriz, int valor) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                if (elemento == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica si una clave de un Map está presente en una matriz de Strings
     * Ejemplo: String[][] matriz = {{"nombre", "edad"}, {"ciudad", "pais"}};
     * Map<String, Object> mapa = new HashMap<>(); mapa.put("nombre", "Juan");
     * boolean encontrado = existeClaveMapEnMatriz(matriz, mapa); // true
     */
    public static boolean existeClaveMapEnMatriz(String[][] matriz, Map<String, Object> mapa) {
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            String clave = entry.getKey();
            boolean encontrado = false;

            for (String[] fila : matriz) {
                for (String elemento : fila) {
                    if (elemento.equals(clave)) {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    break;
                }
            }

            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un valor de un Map está presente en una matriz Ejemplo:
     * Object[][] matriz = {{"Juan", 30}, {"Ana", 25}}; Map<String, Object> mapa
     * = new HashMap<>(); mapa.put("nombre", "Juan"); boolean encontrado =
     * existeValorMapEnMatriz(matriz, mapa); // true
     */
    public static boolean existeValorMapEnMatriz(Object[][] matriz, Map<String, Object> mapa) {
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            Object valor = entry.getValue();
            boolean encontrado = false;

            for (Object[] fila : matriz) {
                for (Object elemento : fila) {
                    if (valor.equals(elemento)) {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    break;
                }
            }

            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    // ************************* OPERACIONES CON ARCHIVOS *************************
    /**
     * Copia el contenido completo de una carpeta a otra Ejemplo:
     * copiarCarpeta("C:/carpeta1", "C:/carpeta2")
     */
    public static void copiarCarpeta(String origen, String destino) throws IOException {
        Path origenPath = Paths.get(origen);
        Path destinoPath = Paths.get(destino);

        Files.walk(origenPath)
                .forEach(source -> {
                    try {
                        Path target = destinoPath.resolve(origenPath.relativize(source));
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Error al copiar: " + e.getMessage());
                    }
                });
    }

    /**
     * Crea un archivo CSV a partir de una lista de objetos Ejemplo:
     * List<Persona> personas = Arrays.asList( new Persona("Juan", 30), new
     * Persona("Ana", 25) ); crearCsvDesdeListaObjetos(personas,
     * "C:/datos/personas.csv", new String[]{"nombre", "edad"});
     */
    public static <T> void crearCsvDesdeListaObjetos(List<T> objetos, String rutaArchivo,
            String[] encabezados) throws IOException {

        File file = new File(rutaArchivo);
        file.getParentFile().mkdirs(); // Crea directorios si no existen

        try (FileWriter fileWriter = new FileWriter(file); CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(encabezados))) {

            for (T objeto : objetos) {
                List<Object> valores = new ArrayList<>();
                for (String encabezado : encabezados) {
                    // Esta es una forma simplificada. En realidad, necesitarías reflection
                    // o un mapeo personalizado para obtener los valores
                    Object valor = getValorPropiedad(objeto, encabezado);
                    valores.add(valor);
                }
                csvPrinter.printRecord(valores);
            }
        }
    }

    /**
     * Crea un archivo CSV por cada objeto de la lista Ejemplo: List<Persona>
     * personas = Arrays.asList( new Persona("Juan", 30), new Persona("Ana", 25)
     * ); crearCsvPorObjeto(personas, "C:/datos/persona_", new
     * String[]{"nombre", "edad"});
     */
    public static <T> void crearCsvPorObjeto(List<T> objetos, String prefijoCarpeta,
            String[] encabezados) throws IOException {

        Files.createDirectories(Paths.get(new File(prefijoCarpeta).getParent()));

        for (int i = 0; i < objetos.size(); i++) {
            T objeto = objetos.get(i);
            String rutaArchivo = prefijoCarpeta + i + ".csv";

            try (FileWriter fileWriter = new FileWriter(rutaArchivo); CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(encabezados))) {

                List<Object> valores = new ArrayList<>();
                for (String encabezado : encabezados) {
                    // Método simplificado para obtener el valor
                    Object valor = getValorPropiedad(objeto, encabezado);
                    valores.add(valor);
                }
                csvPrinter.printRecord(valores);
            }
        }
    }

    /**
     * Crea un archivo JSON a partir de una lista de objetos Ejemplo:
     * List<Persona> personas = Arrays.asList( new Persona("Juan", 30), new
     * Persona("Ana", 25) ); crearJsonDesdeListaObjetos(personas,
     * "C:/datos/personas.json");
     */
    public static <T> void crearJsonDesdeListaObjetos(List<T> objetos, String rutaArchivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(rutaArchivo);
        file.getParentFile().mkdirs(); // Crea directorios si no existen

        mapper.writeValue(file, objetos);
    }

    /**
     * Crea un archivo JSON por cada objeto de la lista Ejemplo: List<Persona>
     * personas = Arrays.asList( new Persona("Juan", 30), new Persona("Ana", 25)
     * ); crearJsonPorObjeto(personas, "C:/datos/persona_");
     */
    public static <T> void crearJsonPorObjeto(List<T> objetos, String prefijoCarpeta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Files.createDirectories(Paths.get(new File(prefijoCarpeta).getParent()));

        for (int i = 0; i < objetos.size(); i++) {
            T objeto = objetos.get(i);
            String rutaArchivo = prefijoCarpeta + i + ".json";
            mapper.writeValue(new File(rutaArchivo), objeto);
        }
    }

    /**
     * Copia un archivo de una carpeta a otra Ejemplo:
     * copiarArchivo("C:/carpeta1/archivo.txt", "C:/carpeta2/archivo.txt")
     */
    public static void copiarArchivo(String origen, String destino) throws IOException {
        Path origenPath = Paths.get(origen);
        Path destinoPath = Paths.get(destino);

        Files.createDirectories(destinoPath.getParent());
        Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Crea un directorio y un archivo dentro de él Ejemplo:
     * crearDirectorioYArchivo("C:/datos/", "archivo.json",
     * "{\"nombre\":\"Juan\"}")
     */
    public static void crearDirectorioYArchivo(String directorio, String nombreArchivo, String contenido) throws IOException {
        Path dirPath = Paths.get(directorio);
        Files.createDirectories(dirPath);

        Path filePath = dirPath.resolve(nombreArchivo);
        Files.write(filePath, contenido.getBytes());
    }

    /**
     * Busca archivos en un directorio por extensión Ejemplo: List<Path>
     * archivosJson = buscarArchivosEnDirectorio("C:/datos", ".json");
     */
    public static List<Path> buscarArchivosEnDirectorio(String directorio, String extension) throws IOException {
        List<Path> archivos = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directorio))) {
            for (Path file : stream) {
                if (file.toString().endsWith(extension)) {
                    archivos.add(file);
                }
            }
        }

        return archivos;
    }

    // ************************* EJERCICIO JSON ELEFANTES *************************
    // Definimos la clase para representar nuestros datos
    public static class TelaElefante {

        private double resistenciaTela;
        private List<Elefante> elefantes;

        // Getters y setters
        public double getResistenciaTela() {
            return resistenciaTela;
        }

        public void setResistenciaTela(double resistenciaTela) {
            this.resistenciaTela = resistenciaTela;
        }

        public List<Elefante> getElefantes() {
            return elefantes;
        }

        public void setElefantes(List<Elefante> elefantes) {
            this.elefantes = elefantes;
        }
    }

    public static class Elefante {

        private String nombre;
        private double peso;

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        // Para manejar pesos negativos
        public double getPesoPositivo() {
            return Math.abs(this.peso);
        }

        @Override
        public String toString() {
            return nombre + " (" + getPesoPositivo() + " kg)";
        }
    }

    /**
     * Lee un archivo JSON y devuelve un objeto TelaElefante Ejemplo:
     * TelaElefante datos = leerArchivoElefantes("elefantes.json");
     */
    public static TelaElefante leerArchivoElefantes(String rutaArchivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(new File(rutaArchivo), TelaElefante.class);
    }

    /**
     * Obtiene la lista de elefantes que se columpiaron antes de que la tela se
     * rompiera Ejemplo: List<String> columpiados = elefantesColumpiados(datos);
     */
    public static List<String> elefantesColumpiados(TelaElefante datos) {
        List<String> nombres = new ArrayList<>();
        double pesoAcumulado = 0;

        for (Elefante elefante : datos.getElefantes()) {
            double pesoPositivo = elefante.getPesoPositivo();
            pesoAcumulado += pesoPositivo;

            if (pesoAcumulado <= datos.getResistenciaTela()) {
                nombres.add(elefante.getNombre());
            } else {
                break;
            }
        }

        return nombres;
    }

    /**
     * Encuentra todas las combinaciones de números que suman un valor objetivo
     * Ejemplo: List<List<Integer>> combinaciones = encontrarCombinaciones(new
     * int[]{1, 2, 3, 4}, 5);
     */
    public static List<List<Integer>> encontrarCombinaciones(int[] numeros, int objetivo) {
        List<List<Integer>> resultado = new ArrayList<>();
        encontrarCombinacionesRecursivo(numeros, objetivo, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void encontrarCombinacionesRecursivo(int[] numeros, int objetivo, int inicio,
            List<Integer> actual, List<List<Integer>> resultado) {
        if (objetivo == 0) {
            resultado.add(new ArrayList<>(actual));
            return;
        }

        for (int i = inicio; i < numeros.length; i++) {
            if (numeros[i] <= objetivo) {
                actual.add(numeros[i]);
                encontrarCombinacionesRecursivo(numeros, objetivo - numeros[i], i, actual, resultado);
                actual.remove(actual.size() - 1);
            }
        }
    }

    // Método auxiliar para obtener el valor de una propiedad de un objeto (simplificado)
    private static Object getValorPropiedad(Object objeto, String nombrePropiedad) {
        // Este es un método simplificado - normalmente usarías reflection
        // Por ejemplo, para una clase Persona con getters:
        if (objeto instanceof Map) {
            return ((Map<?, ?>) objeto).get(nombrePropiedad);
        }

        // Este es solo un ejemplo básico - en la práctica necesitarías
        // usar reflection para acceder a las propiedades del objeto
        return "Valor de ejemplo";
    }

    /**
     * Ejemplo de programa principal para el ejercicio de los elefantes
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Listar archivos JSON disponibles
            List<Path> archivosJson = buscarArchivosEnDirectorio(".", ".json");
            if (archivosJson.isEmpty()) {
                System.out.println("No se encontraron archivos JSON en el directorio.");
                return;
            }

            System.out.println("Archivos JSON disponibles:");
            for (int i = 0; i < archivosJson.size(); i++) {
                System.out.println((i + 1) + ". " + archivosJson.get(i).getFileName());
            }

            System.out.print("Seleccione un archivo (1-" + archivosJson.size() + "): ");
            int seleccion = scanner.nextInt();

            if (seleccion < 1 || seleccion > archivosJson.size()) {
                System.out.println("Selección inválida.");
                return;
            }

            String rutaArchivo = archivosJson.get(seleccion - 1).toString();
            TelaElefante datos = leerArchivoElefantes(rutaArchivo);

            // Mostrar peso que soporta la tela
            System.out.println("Peso que soporta la tela: " + datos.getResistenciaTela() + " kg");

            // Mostrar lista de elefantes
            System.out.println("Lista de elefantes:");
            for (Elefante elefante : datos.getElefantes()) {
                System.out.println("- " + elefante);
            }

            // Mostrar elefantes que se columpiaron
            List<String> columpiados = elefantesColumpiados(datos);
            System.out.println("Elefantes que se columpiaron antes de que se rompiera la tela:");
            if (columpiados.isEmpty()) {
                System.out.println("Ninguno");
            } else {
                for (String nombre : columpiados) {
                    System.out.println("- " + nombre);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
