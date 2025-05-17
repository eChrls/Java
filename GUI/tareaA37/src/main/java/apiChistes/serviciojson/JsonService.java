
// Convierte String JSON en POJOs usando Jackson.
//Se define genéricamente para aceptar cualquier clase POJO
package apiChistes.serviciojson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonService<T> {

    // stringToPojo: parsea JSON y devuelve objeto de tipo T
    // generico para no crear un servicio por cada tipo de objeto.
    //Recibe el Json y la clase destino y devuelve esa instancia
    public T stringToPojo(String json, Class<T> clase) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clase);
    }
}
