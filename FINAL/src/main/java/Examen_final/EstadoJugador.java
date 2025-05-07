/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Examen_final;


public enum EstadoJugador {
    L("Lesionado", 0.8),
    A("Activo", 1.0),
    R("Retirado", 0.5);

    private final String descripcion;
    private final double multiplicadorSalario;

    EstadoJugador(String descripcion, double multiplicadorSalario) {
        this.descripcion = descripcion;
        this.multiplicadorSalario = multiplicadorSalario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMultiplicadorSalario() {
        return multiplicadorSalario;
    }
}
