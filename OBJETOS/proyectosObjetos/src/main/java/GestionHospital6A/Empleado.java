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
        protected double salario;
        protected LocalDate fechaCont;
        
        
        //metodo abstracto para las clases hijas
        abstract double calcularIRPF();
    

    public Empleado(String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(nombreCompleto, nif, fechaNac);
    }

    public Empleado(double salario, LocalDate fechaCont, String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(nombreCompleto, nif, fechaNac);
        this.salario = salario;
        this.fechaCont = fechaCont;
    }

    public Empleado() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        return super.toString() + " - Salario : " + salario + " €. ";
    }

    
    
    

}
