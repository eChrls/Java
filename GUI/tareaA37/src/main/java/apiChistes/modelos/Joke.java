
// Modela un chiste individual tal como llega del API.
package apiChistes.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "error","category","type","setup","delivery","flags","safe","id","lang" })
public class Joke {
    @JsonProperty("error")    private boolean error;
    @JsonProperty("category") private String category;
    @JsonProperty("type")     private String type;
    @JsonProperty("setup")    private String setup;
    @JsonProperty("delivery") private String delivery;
    @JsonProperty("flags")    private Flags flags;
    @JsonProperty("safe")     private boolean safe;
    @JsonProperty("id")       private int id;
    @JsonProperty("lang")     private String lang;

    // getters y setters...

    // toString(): muestra setup + delivery
    @Override
    public String toString() {
        return setup + "\n" + delivery + "\n";
    }
}
