/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.tarea5aset;

/**
 *
 * @author Casa
 */
import java.time.LocalDate;
import java.util.Objects;

// Utilizamos un record para simplificar la creación de la clase Vaca
// Un record automáticamente genera constructores, getters, equals, hashCode y toString
public record Vaca(int id, LocalDate fechaNacimiento, String descripcion) implements Comparable<Vaca> {
    
    // Constructor canónico con validaciones básicas
    public Vaca {
        // Validaciones de datos de entrada
        Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula");
        Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
        
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }
    }

    // Implementación de Comparable para ordenar por ID
    @Override
    public int compareTo(Vaca otraVaca) {
        // Comparamos los IDs para establecer un orden natural
        return Integer.compare(this.id, otraVaca.id);
    }
}