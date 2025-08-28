package apiChistes.modelos2;

// Archivo: Joke.java
// Paquete: apiChistes.modelos2
// Modela cada chiste dentro de una lista.


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



    @Override
    public String toString() {
        return setup + "\n" + delivery + "\n";
    }
}
