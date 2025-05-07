package ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class EscrituraJSON {

    /**
     * Escribe un mapa de datos en un fichero JSON.
     *
     * @param data El mapa a escribir.
     * @param nombreFichero El nombre del fichero JSON de salida.
     * @throws IOException Si ocurre un error durante la escritura del fichero.
     */
    public static void escribir(Map<?, ?> data, String nombreFichero) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(nombreFichero), data);
    }
}
