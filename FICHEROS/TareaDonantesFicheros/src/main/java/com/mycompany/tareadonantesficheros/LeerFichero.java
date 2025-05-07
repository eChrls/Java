/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareadonantesficheros;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nuria
 */
public class LeerFichero {
     public static Optional<List<Donante>> leerJson(String ruta) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //TypeReference se usa ya que es una lista de donantes, si no fuera una lista se podria usar Donante.class
            List<Donante> donantes = mapper.readValue(new File(ruta), new TypeReference<List<Donante>>() {});
            System.out.println("Lectura hecha, cargando numero de donantes: " +donantes.size());
            return Optional.of(donantes);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo.");
            e.printStackTrace(); //que quede aqui la prueba de que me estuve rompiendo la cabeza durante una hora pa sacar por que no me leia el json xd
            return Optional.empty();
        }
    }
}
