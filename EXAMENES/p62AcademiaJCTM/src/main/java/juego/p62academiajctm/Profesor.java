/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

/**
 *
 * @author carlos
 */
public abstract class Profesor extends Empleado {
    private Especialidad especialidad; 
    private double complementoSalarial;

    public Profesor(String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
    }

    public Profesor() {
    }

    public Profesor(Especialidad especialidad, double complementoSalarial, String numeroSeguridadSocial, double salarioBase, String nombre, String apellidos, String nif) {
        super(numeroSeguridadSocial, salarioBase, nombre, apellidos, nif);
        this.especialidad = especialidad;
        this.complementoSalarial = complementoSalarial;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public double getComplementoSalarial() {
        return complementoSalarial;
    }

    public void setComplementoSalarial(double complementoSalarial) {
        this.complementoSalarial = complementoSalarial;
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

    
    

}
