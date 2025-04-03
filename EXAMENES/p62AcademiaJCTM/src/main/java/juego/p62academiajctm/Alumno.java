/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author carlos
 */
public class Alumno extends Persona implements SolicitarBaja {
    private String numeroExpediente;
    private LocalDate fechaBaja;

    public Alumno(String numeroExpediente, LocalDate fechaBaja, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.numeroExpediente = numeroExpediente;
        this.fechaBaja = LocalDate.MAX;
    }

    public Alumno() {
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
        hash = 97 * hash + Objects.hashCode(this.numeroExpediente);
        hash = 97 * hash + Objects.hashCode(this.fechaBaja);
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
        return Objects.equals(this.fechaBaja, other.fechaBaja);
    }

    
    
    
    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "numeroExpediente=" + numeroExpediente + ", fechaBaja=" + fechaBaja + '}';
    }
    //puede ser un void, o devolver la fecha de baja, en este caso prefiero devolverla.
    @Override
    public LocalDate solicitarBaja() {
        this.fechaBaja = LocalDate.now();
        
        return this.fechaBaja;
        
    }
    
    
    
    
}
