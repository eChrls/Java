
// agrupa todos los indicadores (contenido explícito, político, etc.) que vienen en el JSON del chiste.
package apiChistes.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flags {
    @JsonProperty("nsfw")     private boolean nsfw;
    @JsonProperty("religious")private boolean religious;
    @JsonProperty("political") private boolean political;
    @JsonProperty("racist")   private boolean racist;
    @JsonProperty("sexist")   private boolean sexist;
    @JsonProperty("explicit") private boolean explicit;

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public boolean isReligious() {
        return religious;
    }

    public void setReligious(boolean religious) {
        this.religious = religious;
    }

    public boolean isPolitical() {
        return political;
    }

    public void setPolitical(boolean political) {
        this.political = political;
    }

    public boolean isRacist() {
        return racist;
    }

    public void setRacist(boolean racist) {
        this.racist = racist;
    }

    public boolean isSexist() {
        return sexist;
    }

    public void setSexist(boolean sexist) {
        this.sexist = sexist;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }


    
    
    
    // toString() para depuración
    @Override
    public String toString() {
        return "Flags{" +
                "nsfw=" + nsfw +
                ", religious=" + religious +
                ", political=" + political +
                ", racist=" + racist +
                ", sexist=" + sexist +
                ", explicit=" + explicit +
                '}';
    }
}
