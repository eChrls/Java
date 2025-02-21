package com.lorenzo.taller.apipersonas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.lorenzo.taller.apipersonas.models.Persona;
import com.lorenzo.taller.apipersonas.services.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    public PersonaController() {
    }

    // GET personas
    // Devuelve lista de personas
    @GetMapping()
    public List<Persona> obtenerPersonas() {
        return personaService.obtenerPersonas();
    }

    // GET personas/{id}
    // Devuelve una persona de la lista por su ID
    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable int id) {
        return personaService.obtenerPersonaPorId(id);
    }    
    
}
