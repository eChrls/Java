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
    SECUNDARIA(0.25),
    PT(0.23);
    
    private final String nombre;
    private final double porcentajeIRPF;

    private Especialidad() {
         this.nombre = nombre;
        this.porcentajeIRPF = porcentajeIRPF;

    }



    public double getPorcentajeIRPF() {
        return porcentajeIRPF;
    }
}

