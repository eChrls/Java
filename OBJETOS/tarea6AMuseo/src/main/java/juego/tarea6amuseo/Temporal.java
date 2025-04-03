/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Temporal extends Sala {
    private String fechaInicio;
    private String fechaFin;

    public Temporal(String nombre, String id, String fechaInicio, String fechaFin) {
        super(nombre, id);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Sala Temporal: " + getNombre() + " (ID: " + getId() + ")");
        System.out.println("Duración: " + fechaInicio + " - " + fechaFin);
        if (!getObras().isEmpty()) {
            System.out.println("Obras en la sala:");
            for (Obra obra : getObras()) {
                System.out.println("- " + obra.getId());
            }
        } else {
            System.out.println("La sala está vacía.");
        }
    }
}
