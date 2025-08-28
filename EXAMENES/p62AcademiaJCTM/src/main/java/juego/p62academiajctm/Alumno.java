
package juego.p62academiajctm;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno extends Persona implements SolicitarBaja {

    private String numeroExpediente;
    private LocalDate fechaBaja;

    public Alumno(String numeroExpediente, LocalDate fechaBaja, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.numeroExpediente = numeroExpediente;
        this.fechaBaja =fechaBaja;
    }

    public Alumno() {
        this.fechaBaja=LocalDate.MAX;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.numeroExpediente) + Objects.hashCode(this.fechaBaja)
                + Objects.hashCode(this.nombre) + Objects.hashCode(this.nif) + Objects.hash(this.apellidos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.numeroExpediente, other.numeroExpediente)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return Objects.equals(this.fechaBaja, other.fechaBaja);
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "numeroExpediente=" + numeroExpediente + ", fechaBaja=" + fechaBaja + '}';
    }



    @Override
    public void solicitarBaja(LocalDate fechaSolicitada) {
        this.fechaBaja=fechaSolicitada;
    }

}
