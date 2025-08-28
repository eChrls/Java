/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Monitor extends Empleado {
    public Monitor(String nif, String nombre) {
        super(nif, nombre);
    }

    public void abrirSala(Sala sala) {
        System.out.println("Monitor " + getNombre() + " ha abierto la sala " + sala.getNombre());
        sala.setAbierta(true);
    }

    public void cerrarSala(Sala sala) {
        System.out.println("Monitor " + getNombre() + " ha cerrado la sala " + sala.getNombre());
        sala.setAbierta(false);
    }
}
