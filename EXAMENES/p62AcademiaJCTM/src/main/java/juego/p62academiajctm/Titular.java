/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

import java.time.LocalDate;

/**
 *
 * @author carlos
 */
public final class Titular extends Profesor {
    private LocalDate fechaJubilacion;

    public Titular(String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
    }

    public Titular() {
    }

    public Titular(LocalDate fechaJubilacion, String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
        this.fechaJubilacion = fechaJubilacion;
    }

    public Titular(LocalDate fechaJubilacion, Especialidad especialidad, double complementoSalarial, String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(especialidad, complementoSalarial, numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
        this.fechaJubilacion = fechaJubilacion;
    }

    public LocalDate getFechaJubilacion() {
        return fechaJubilacion;
    }

    public void setFechaJubilacion(LocalDate fechaJubilacion) {
        this.fechaJubilacion = fechaJubilacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public double calcularIRPF() {
        return (this.getSalarioBase()+this.getComplementoSalarial()) * Especialidad.ProfesorTecnico.getPorcentajeIRPF();
    }
    
    public boolean pedirProrroga(int meses){
      
        LocalDate fechaTemp = this.fechaJubilacion.plusMonths(meses);

        return !fechaTemp.isAfter( LocalDate.of(2030,01,01));
    }

    @Override
    public String toString() {
        return super.toString() + "Titular{" + "fechaJubilacion=" + fechaJubilacion + '}';
    }
    
    
    
    
}
