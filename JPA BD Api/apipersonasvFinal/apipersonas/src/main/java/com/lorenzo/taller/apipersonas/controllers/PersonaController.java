package com.lorenzo.taller.apipersonas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.lorenzo.taller.apipersonas.models.PersonaEntity;
import com.lorenzo.taller.apipersonas.services.PersonaService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
    public ResponseEntity<List<PersonaEntity>> obtenerPersonas(@RequestParam(required = false) String nombre) {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.obtenerPersonas(nombre));
    }

    // GET personas/{id}
    // Devuelve una persona de la lista por su ID
    @GetMapping("/{id}")
    public PersonaEntity obtenerPersonaPorId(@PathVariable int id) {
        return personaService.obtenerPersonaPorId(id);
    }    

    @DeleteMapping("/{id}")
    public boolean eliminarPersonaPorId(@PathVariable int id) {
        return personaService.eliminarPersonaPorId(id);
    }

    @PostMapping()
    public ResponseEntity<?> insertarPersona(@RequestBody PersonaEntity personaACrear) {
        //try {
            PersonaEntity personaCreada = personaService.insertarPersona(personaACrear);
            return ResponseEntity.status(HttpStatus.CREATED).body(personaCreada);
        /* } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersona(@PathVariable int id, @RequestBody PersonaEntity personaAActualizar) {
        PersonaEntity personaActualizada = personaService.actualizarPersona(id, personaAActualizar);
        return ResponseEntity.status(HttpStatus.OK).body(personaActualizada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarPersonaParcial(@PathVariable int id, @RequestBody PersonaEntity personaAActualizar) {
        PersonaEntity personaActualizada = personaService.actualizarPersonaParcial(id, personaAActualizar);
        return ResponseEntity.status(HttpStatus.OK).body(personaActualizada);
    }
    
}
