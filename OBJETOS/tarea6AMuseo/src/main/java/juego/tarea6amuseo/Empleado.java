/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public abstract class Empleado implements Comparable {
    private String nif;
    private String nombre;

    public Empleado(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    @Override
    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }
}
