/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author carlos
 */
public abstract class Sala {
    private String nombre;
    private String id;
    private boolean abierta;
    private Set<Obra> obras;
    private Sensor[] sensores = new Sensor[2];

    public Sala(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.abierta = false;
        this.obras = new HashSet<>();
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

    public Set<Obra> getObras() {
        return obras;
    }
    
    public Obra getObra(String id){
        Obra ObraEncontrada = obras.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
//        if (ObraEncontrada == null) {
//         trow   
//        }
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