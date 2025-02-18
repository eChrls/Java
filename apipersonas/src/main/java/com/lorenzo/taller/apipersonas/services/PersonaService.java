package com.lorenzo.taller.apipersonas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.taller.apipersonas.models.Persona;
import com.lorenzo.taller.apipersonas.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaService() {

    }

    public List<Persona> obtenerPersonas() {
        return personaRepository.obtenerPersonas();
    }

    public Persona obtenerPersonaPorId(int id) {
        return personaRepository.obtenerPersonaPorId(id);
    }

}
