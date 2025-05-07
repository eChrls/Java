/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen_final;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Futbolista> plantilla;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.plantilla = new ArrayList<>();
    }

    public void addFutbolista(Futbolista f) {
        plantilla.add(f);
    }

    public List<Futbolista> getPlantilla() {
        return plantilla;
    }

    public String getNombre() {
        return nombre;
    }
}
