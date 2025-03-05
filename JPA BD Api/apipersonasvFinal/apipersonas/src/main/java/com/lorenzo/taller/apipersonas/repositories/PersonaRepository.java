package com.lorenzo.taller.apipersonas.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lorenzo.taller.apipersonas.models.PersonaEntity;

@Repository
public class PersonaRepository {

    private List<PersonaEntity> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        PersonaEntity p1 = new PersonaEntity(1, "Juan", LocalDate.of(2000, 5, 10));
        PersonaEntity p2 = new PersonaEntity(2, "Ana", LocalDate.of(1980, 01, 25));

        personas.add(p1);
        personas.add(p2);
    }

    public List<PersonaEntity> obtenerPersonas() {
        return personas;
    }

    public PersonaEntity obtenerPersonaPorId(int id) {
        for (PersonaEntity p : personas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
