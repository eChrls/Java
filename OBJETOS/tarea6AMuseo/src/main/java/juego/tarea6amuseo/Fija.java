/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Fija extends Sala {
    private String horarioApertura;
    private String horarioCierre;

    public Fija(String nombre, String id, String horarioApertura, String horarioCierre) {
        super(nombre, id);
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
    }

    public String getHorarioApertura() {
        return horarioApertura;
    }

    public String getHorarioCierre() {
        return horarioCierre;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Sala Fija: " + getNombre() + " (ID: " + getId() + ")");
        System.out.println("Horario: " + horarioApertura + " - " + horarioCierre);
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