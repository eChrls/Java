package com.lorenzo.taller.apipersonas.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lorenzo.taller.apipersonas.models.PersonaEntity;
import com.lorenzo.taller.apipersonas.repositories.PersonaJpaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaJpaRepository personaJpaRepository;

    public PersonaService() {

    }

    public List<PersonaEntity> obtenerPersonas(String name) {
        if (name !=  null) {
            return personaJpaRepository.findByNombre(name);
        } else {
            return personaJpaRepository.findAll();
        }
    }

    public PersonaEntity obtenerPersonaPorId(int id) {
        return personaJpaRepository.findById(id).orElse(null);
    }

    public boolean eliminarPersonaPorId(int id) {
        if (personaJpaRepository.existsById(id)){
            personaJpaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public PersonaEntity insertarPersona(PersonaEntity personaACrear) {

        if (personaJpaRepository.existsById(personaACrear.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La persona a crear con ID " + personaACrear.getId() + " ya existe");
            //throw new NoSuchElementException("La persona a crear con ID " + personaACrear.getId() + " ya existe");
        }



        return personaJpaRepository.save(personaACrear);
    }

    public PersonaEntity actualizarPersona(int id, PersonaEntity personaAActualizar) {

        if (personaAActualizar.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID en la URL no coincide con el ID del cuerpo de la petición");
        }

        if (!personaJpaRepository.existsById(personaAActualizar.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La persona a actualizar con ID " + personaAActualizar.getId() + " no existe");
        }
        
        return personaJpaRepository.save(personaAActualizar);
    }

    public PersonaEntity actualizarPersonaParcial(int id, PersonaEntity personaAActualizar) {

        PersonaEntity personaExistente = personaJpaRepository.findById(id).orElse(null);

        if (personaExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La persona a actualizar con ID " + id + " no existe");
        }

        if (personaAActualizar.getNombre() != null) {
            personaExistente.setNombre(personaAActualizar.getNombre());
        }

        if (personaAActualizar.getFechaNacimiento() != null) {
            personaExistente.setFechaNacimiento(personaAActualizar.getFechaNacimiento());
        }

        return personaJpaRepository.save(personaExistente);
    }

}
