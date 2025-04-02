/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public abstract class Sala {
    private String nombre;
    private String id;
    private boolean abierta;
    private List<Obra> obras;

    public Sala(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.abierta = false;
        this.obras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void añadirObra(Obra obra) {
        this.obras.add(obra);
    }

    public void quitarObra(Obra obra) {
        this.obras.remove(obra);
    }

    // Métodos abstractos específicos para cada tipo de sala
    public abstract void mostrarDetalles();
}