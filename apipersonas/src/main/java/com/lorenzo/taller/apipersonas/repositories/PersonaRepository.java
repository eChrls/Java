package com.lorenzo.taller.apipersonas.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lorenzo.taller.apipersonas.models.Persona;

@Repository
public class PersonaRepository {

    private List<Persona> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        Persona p1 = new Persona(1, "Juan", LocalDate.of(2000, 5, 10));
        Persona p2 = new Persona(2, "Ana", LocalDate.of(1980, 01, 25));

        personas.add(p1);
        personas.add(p2);
    }

    public List<Persona> obtenerPersonas() {
        return personas;
    }

    public Persona obtenerPersonaPorId(int id) {
        for (Persona p : personas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
