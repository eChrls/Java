/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionHospital6A;

import java.time.LocalDate;

/**
 *
 * @author Casa
 */
public abstract class Persona {
    String nombreCompleto;
    NIF nif;
    LocalDate fechaNac; 

    public Persona() {
    }

    public Persona(String nombreCompleto, NIF nif, LocalDate fechaNac) {
        this.nombreCompleto = nombreCompleto;
        this.nif = nif;
        this.fechaNac = fechaNac;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombreCompleto=" + nombreCompleto + ", nif=" + nif + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
}
