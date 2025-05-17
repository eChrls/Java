
// Envía peticiones HTTP GET y devuelve la respuesta como String JSON.
package apiChistes.conexion_http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; //-> Está en java.net.URL, parte de la biblioteca estándar de Java. 
//Permite crear un objeto a partir de una cadena y luego abrir conexiones (con openConnection()).

public class ConexionHTTP {

    // peticionHttpGet: abre conexión, lee respuesta y devuelve JSON
    //Metodo que lee la respuesta (o el error), la acumula en un StringBuilder y convierte el JSON a String.
    public static String peticionHttpGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        StringBuilder content;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                status == 200 ? con.getInputStream() : con.getErrorStream()))) {
            content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
        }
        con.disconnect();
        return content.toString();
    }
}
