/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.tarea5aset;

/**
 *
 * @author Casa
 */
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class VaqueriaOrdenada {
    // Utilizamos TreeSet que mantiene los elementos ordenados
    // Usa el método compareTo de la clase Vaca para establecer el orden
    private Set<Vaca> vacas;

    // Constructor que inicializa el conjunto de vacas ordenadas
    public VaqueriaOrdenada() {
        // TreeSet ordena automáticamente según el método compareTo de Vaca
        this.vacas = new TreeSet<>();
    }

    // Los métodos son similares a la Vaqueria anterior
    public int numeroDVacas() {
        return vacas.size();
    }

    public boolean anadirVaca(Vaca vaca) {
        return vacas.add(vaca);
    }

    public boolean tieneVacas() {
        return !vacas.isEmpty();
    }

    public boolean estaVaca(Vaca vaca) {
        return vacas.contains(vaca);
    }

    public ArrayList<Vaca> obtenerVacas() {
        return new ArrayList<>(vacas);
    }

    public boolean bajaVaca(Vaca vaca) {
        return vacas.remove(vaca);
    }
}