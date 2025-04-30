package ficherosUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * **Índice de Funcionalidades:**
 *
 * 1.  **Configuración de ObjectMapper**
 * 2.  **Conversión de Objeto a JSON**
 * 3.  **Guardar Objeto como JSON**
 * 4.  **Conversión de JSON a Objeto**
 * 5.  **Leer Objeto desde JSON**
 * 6.  **Leer Lista desde JSON**
 * 7.  **Conversión de JSON a Map**
 * 8.  **Crear ObjectMapper Tolerante a Errores**
 * 9.  **Ejemplo de Uso**
 */
public class JsonUtils {

    public static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static String objetoAJson(Object objeto) throws IOException {
        ObjectMapper mapper = createMapper();
        return mapper.writeValueAsString(objeto);
    }

    public static void guardarComoJson(Object objeto, String rutaArchivo) throws IOException {
        ObjectMapper mapper = createMapper();
        File archivo = new File(rutaArchivo);
        File directorio = archivo.getParentFile();
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }
        mapper.writeValue(archivo, objeto);
    }

    public static <T> T jsonAObjeto(String json, Class<T> clase) throws IOException {
        ObjectMapper mapper = createMapper();
        return mapper.readValue(json, clase);
    }

    public static <T> T leerObjetoDesdeJson(String rutaArchivo, Class<T> clase) throws IOException {
        ObjectMapper mapper = createMapper();
        File archivo = new File(rutaArchivo);
        return mapper.readValue(archivo, clase);
    }

    public static <T> List<T> leerListaDesdeJson(String rutaArchivo, Class<T> tipoElemento) throws IOException {
        ObjectMapper mapper = createMapper();
        File archivo = new File(rutaArchivo);
        JavaType tipoLista = mapper.getTypeFactory().constructCollectionType(List.class, tipoElemento);
        return mapper.readValue(archivo, tipoLista);
    }

    public static Map<String, Object> jsonAMap(String json) throws IOException {
        ObjectMapper mapper = createMapper();
        JavaType tipoMap = mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
        return mapper.readValue(json, tipoMap);
    }

    public static ObjectMapper crearMapperToleranteErrores() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper;
    }

    public static void main(String[] args) {
        try {
            // Ejemplo de creación de una lista de objetos Persona
            List<Persona> personas = new ArrayList<>();
            personas.add(new Persona("Juan", "Pérez", 30));
            personas.add(new Persona("María", "Gómez", 25));

            // Uso de objetoAJson para convertir la lista a una cadena JSON
            String json = objetoAJson(personas);
            System.out.println("JSON generado:");
            System.out.println(json);

            // Uso de guardarComoJson para guardar la lista en un archivo JSON
            guardarComoJson(personas, "./json/personas.json");
            System.out.println("\nArchivo guardado en ./json/personas.json");

            // Uso de leerListaDesdeJson para leer la lista desde el archivo JSON
            List<Persona> personasLeidas = leerListaDesdeJson("./json/personas.json", Persona.class);
            System.out.println("\nPersonas leídas desde archivo:");
            for (Persona p : personasLeidas) {
                System.out.println(p.getNombre() + " " + p.getApellido() + ", " + p.getEdad() + " años");
            }

            // Uso de jsonAMap para convertir un JSON simple a un Map
            String jsonSimple = "{\"nombre\":\"Pedro\",\"edad\":40,\"activo\":true}";
            Map<String, Object> mapa = jsonAMap(jsonSimple);
            System.out.println("\nJSON como Map:");
            for (Map.Entry<String, Object> entry : mapa.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() +
                                     " (" + entry.getValue().getClass().getSimpleName() + ")");
            }

        } catch (IOException e) {
            System.err.println("Error en operaciones JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class Persona {
        private String nombre;
        private String apellido;
        private int edad;

        public Persona() {}

        public Persona(String nombre, String apellido, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }
    }
}