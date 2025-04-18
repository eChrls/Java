/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author carlos
 */
public final class Interino extends Profesor implements SolicitarBaja {

    private LocalDate fechaInicio;
    private LocalDate fechaCese;

    public Interino(String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
    }

    public Interino(LocalDate fechaInicio, LocalDate fechaCese, Especialidad especialidad, double complementoSalarial, String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(especialidad, complementoSalarial, numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
        this.fechaInicio = LocalDate.now();
        this.fechaCese = this.fechaInicio.plusMonths(6);
    }

    public Interino() {
        this.fechaInicio = LocalDate.now();
        this.fechaCese = this.fechaInicio.plusMonths(6);
    }

    public int calcularDiasTrabajados() {

        Period fecha = Period.between(this.fechaInicio, this.fechaCese);
        int fecha2 = fecha.getDays();
        return fecha2;
    }

    @Override
    public double calcularIRPF() {
        return this.getSalarioBase() * this.getEspecialidad().getPorcentajeIRPF();
    }
    
    @Override
    public String toString() {
        return super.toString() + "Interino{" + "fechaInicio=" + fechaInicio + ", fechaCese=" + fechaCese + '}';
    }

    @Override
    public void solicitarBaja(LocalDate fechaSolicitada) {
        this.fechaCese = fechaSolicitada;
    }

}
