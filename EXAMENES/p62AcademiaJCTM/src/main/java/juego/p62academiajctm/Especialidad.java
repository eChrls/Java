/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package juego.p62academiajctm;

/**
 *
 * @author carlos
 */

public enum Especialidad {
    Secundaria("Secundaria", 0.25),
    ProfesorTecnico("PT", 0.23);

    private final String nombre; 
    private final double porcentajeIRPF;

    private Especialidad(String nombre, double porcentajeIRPF) {
        this.nombre = nombre;
        this.porcentajeIRPF = porcentajeIRPF;
    }



    public String getNombre() {
        return nombre;
    }

    public double getPorcentajeIRPF() {
        return porcentajeIRPF;
    }
}
