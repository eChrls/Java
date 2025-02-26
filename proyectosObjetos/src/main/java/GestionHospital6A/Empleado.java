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
public abstract class Empleado extends Persona {
        double Salario;
        LocalDate fechaCont;
        abstract double calcularIRPF();
    
    
    
    

    public Empleado(String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(nombreCompleto, nif, fechaNac);
    }

    public Empleado(double Salario, LocalDate fechaCont, String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(nombreCompleto, nif, fechaNac);
        this.Salario = Salario;
        this.fechaCont = fechaCont;
    }

    public Empleado() {
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public LocalDate getFechaCont() {
        return fechaCont;
    }

    public void setFechaCont(LocalDate fechaCont) {
        this.fechaCont = fechaCont;
    }

        @Override
    public String getNombreCompleto() {
        return nombreCompleto;
    }

        @Override
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

        @Override
    public NIF getNif() {
        return nif;
    }

        @Override
    public void setNif(NIF nif) {
        this.nif = nif;
    }

        @Override
    public LocalDate getFechaNac() {
        return fechaNac;
    }

        @Override
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Empleado{" + "Salario=" + Salario + ", fechaCont=" + fechaCont + '}';
    }

    
    
    

}
