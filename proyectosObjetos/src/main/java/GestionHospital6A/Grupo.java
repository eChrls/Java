/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package GestionHospital6A;

/**
 *
 * @author Casa
 */
public enum Grupo {
    A(0.28), B(0.25), C(0.23), D(0.20), E(0.15);

    private final double porcentajeIRPF;

    Grupo(double porcentajeIRPF) {
        this.porcentajeIRPF = porcentajeIRPF;
    }

    public double getPorcentajeIRPF() {
        return porcentajeIRPF;
    }
}