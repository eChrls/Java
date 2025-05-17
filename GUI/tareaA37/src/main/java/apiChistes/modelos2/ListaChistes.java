
// Contiene múltiples objetos Joke y metadatos de la lista.
package apiChistes.modelos2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaChistes {
    @JsonProperty("error")  private boolean error;
    @JsonProperty("amount") private int amount;
    @JsonProperty("jokes")  private List<Joke> jokes;

    // getJokes(): devuelve la lista de chistes
    public List<Joke> getJokes() {
        return jokes;
    }
}


