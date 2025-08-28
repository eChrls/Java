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
import java.util.HashSet;
import java.util.Set;

public class Vaqueria {
    // Usamos un HashSet como estructura de almacenamiento
    // HashSet garantiza que no haya elementos duplicados y no mantiene un orden específico
    private Set<Vaca> vacas;

    // Constructor que inicializa el conjunto de vacas
    public Vaqueria() {
        // Inicializamos el HashSet vacío
        // El Set nos ayuda a prevenir duplicados automáticamente
        this.vacas = new HashSet<>();
    }

    // Método para conocer el número de vacas en la vaquería
    public int numeroDVacas() {
        // size() nos devuelve la cantidad de elementos en el conjunto
        return vacas.size();
    }

    // Método para añadir una vaca a la vaquería
    public boolean anadirVaca(Vaca vaca) {
        // add() devuelve true si el elemento no existía previamente
        // Si la vaca ya existe, no se añadirá
        return vacas.add(vaca);
    }

    // Método para verificar si hay vacas en la vaquería
    public boolean tieneVacas() {
        // isEmpty() comprueba si el conjunto está vacío
        return !vacas.isEmpty();
    }

    // Método para comprobar si una vaca específica está en la vaquería
    public boolean estaVaca(Vaca vaca) {
        // contains() verifica la existencia de un elemento en el conjunto
        return vacas.contains(vaca);
    }

    // Método para obtener todas las vacas como un ArrayList
    public ArrayList<Vaca> obtenerVacas() {
        // Creamos un nuevo ArrayList a partir del conjunto de vacas
        return new ArrayList<>(vacas);
    }

    // Método para dar de baja una vaca de la vaquería
    public boolean bajaVaca(Vaca vaca) {
        // remove() elimina el elemento si existe y devuelve true
        return vacas.remove(vaca);
    }
}