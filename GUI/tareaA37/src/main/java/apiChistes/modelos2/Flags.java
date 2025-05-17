
// Igual que modelos.Flags, usado en listas de chistes.
package apiChistes.modelos2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flags {
    @JsonProperty("nsfw")     private boolean nsfw;
    @JsonProperty("religious")private boolean religious;
    @JsonProperty("political") private boolean political;
    @JsonProperty("racist")   private boolean racist;
    @JsonProperty("sexist")   private boolean sexist;
    @JsonProperty("explicit") private boolean explicit;

    // getters y setters...
}
