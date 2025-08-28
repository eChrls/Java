package ejercicio2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LecturaJSON {

    /**
     * Lee una lista de objetos POJO desde un fichero JSON.
     *
     * @param ruta La ruta al fichero JSON.
     * @return Una lista de objetos Game leídos desde el fichero.
     * @throws IOException Si ocurre un error durante la lectura del fichero.
     */
    public static List<Game> leer(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Game>>() {
        });
    }
}
