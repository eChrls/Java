package com.videoclub.videoclub.service;

import java.util.Optional;

import com.videoclub.videoclub.repository.ActoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.videoclub.videoclub.dto.PeliculaDto;
import com.videoclub.videoclub.entity.ActoresEntity;
import com.videoclub.videoclub.entity.PeliculaEntity;
import com.videoclub.videoclub.entity.UsuarioEntity;
import com.videoclub.videoclub.repository.PeliculaRepository;
import com.videoclub.videoclub.repository.UsuarioRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service

public class VideoService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final PeliculaRepository peliculaRepository;
    private final ActoresRepository actoresRepository;

    // ==========================================================================  USUARIO ================================================================================
    //POST
    public ResponseEntity<String> addUser(UsuarioEntity usuario) {
        try {
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuario guardado" + usuarioRepository.save(usuario));
        } catch (Exception e) {
            log.error("Error al guardar el usuario", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario");
        }
    }

    //GET
    public ResponseEntity<String> getUsers() {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(usuarioRepository.findAll()));
        } catch (JsonProcessingException e) {
            log.error("Error al obtener los usuarios", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los usuarios");
        }

    }

    //DELETE
    public ResponseEntity<String> deleteUser(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado");
        } catch (Exception e) {
            log.error("Error al eliminar el usuario", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

    //PUT
    public String updateUser(Long id, UsuarioEntity usuario) {
        try {
            UsuarioEntity usuarioActual = usuarioRepository.findById(id).get();

            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setApellido(usuario.getApellido());
            usuarioActual.setEdad(usuario.getEdad());
            usuarioActual.setFechaInicio(usuario.getFechaInicio());
            usuarioActual.setDireccion(usuario.getDireccion());
            usuarioActual.setDescripcion(usuario.getDescripcion());
            usuarioActual.setSaldo(usuario.getSaldo());

            usuarioRepository.save(usuarioActual);

            return "Usuario actualizado";
        } catch (Exception e) {
            log.error("Error al actualizar el usuario", e.getMessage(), e);
            return "Error al actualizar el usuario";
        }
    }

    //GET BY NAME
    public ResponseEntity<String> getByName(String nombre) {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(usuarioRepository.findByNombre(nombre)));
        } catch (JsonProcessingException e) {
            log.error("Error al obtener el usuario", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el usuario");
        }
    }

    //===========================================================================  PELICULAS ================================================================================
    //GET PELICULAS
    public ResponseEntity<String> getPeliculas() {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(peliculaRepository.findAll()));
        } catch (JsonProcessingException e) {
            log.error("Error al obtener las peliculas", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las peliculas");
        }

    }


    //POST PELICULA
    public ResponseEntity<String> addPelicula(PeliculaDto peliculaDto) {
        try {
            Optional<UsuarioEntity> usuario = usuarioRepository.findById(peliculaDto.getIdUsuario());

            if (!usuario.isPresent()) {
                return ResponseEntity.badRequest().body("El usuario no existe");
            }


            PeliculaEntity pelicula = new PeliculaEntity(peliculaDto.getNombre(), peliculaDto.getCategoria(), peliculaDto.getDuracion(), peliculaDto.isTodosPublicos(), usuario.get());

            peliculaRepository.save(pelicula);

            return ResponseEntity.ok("Pelicula guardada");
        } catch (Exception e) {
            log.error("Error al guardar la pelicula", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la pelicula");
        }
    }

    //DELETE PELICULA
    public ResponseEntity<String> deletePelicula(Long id) {
        try {
            peliculaRepository.deleteById(id);
            return ResponseEntity.ok("Pelicula eliminada");
        } catch (Exception e) {
            log.error("Error al eliminar la pelicula", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la pelicula");
        }
    }

    //PUT PELICULA
    public ResponseEntity<String> updatePelicula(Long id, PeliculaDto peliculaDto) {
        try {
            PeliculaEntity peliculaActual = peliculaRepository.findById(id).get();

            peliculaActual.setNombre(peliculaDto.getNombre());
            peliculaActual.setCategoria(peliculaDto.getCategoria());
            peliculaActual.setDuracion(peliculaDto.getDuracion());
            peliculaActual.setTodosPublicos(peliculaDto.isTodosPublicos());
            peliculaActual.setUsuario(usuarioRepository.findById(peliculaDto.getIdUsuario()).get());

            peliculaRepository.save(peliculaActual);

            return ResponseEntity.ok("Pelicula actualizada");
        } catch (Exception e) {
            log.error("Error al actualizar la pelicula", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la pelicula");
        }
    }


    //================================================================ACTORES ===============================================================================

    //GET ACTORES
    public ResponseEntity getActores() {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(actoresRepository.findAll()));

        } catch (JsonProcessingException e) {
            log.error("Error al obtener los actores", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los actores");
        }

    }

    //DELETE ACTOR
    public ResponseEntity deleteActor (Long id) {
        try {
            actoresRepository.deleteById(id);
            return ResponseEntity.ok("Actor eliminado");
        } catch (Exception e) {
            log.error("Error al eliminar el actor", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el actor");
        }
    }   

    //UPDATE ACTOR
    public ResponseEntity updateActor(Long id, ActoresEntity actor) {
        try {
            ActoresEntity actorActual = actoresRepository.findById(id).get();

            actorActual.setNombre(actor.getNombre());
            actorActual.setApellido(actor.getApellido());
            actorActual.setEdad(actor.getEdad());
            actorActual.setOrigen(actor.getOrigen());
            actorActual.setFechaFallecimiento(actor.getFechaFallecimiento());

            actoresRepository.save(actorActual);

            return ResponseEntity.ok("Actor actualizado");
        } catch (Exception e) {
            log.error("Error al actualizar el actor", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el actor");
        }
    }    
    //ADD ACTOR
    public ResponseEntity addActor (ActoresEntity actorDto) {
        try {
            Optional<PeliculaEntity> pelicula = peliculaRepository.findById(actorDto.getIdActor());

            if (!pelicula.isPresent()) {
                return ResponseEntity.badRequest().body("La pelicula no existe");
            }
        
            ActoresEntity nuevoActor = new ActoresEntity(actorDto.getNombre(), actorDto.getApellido(), actorDto.getEdad(), actorDto.getOrigen(), actorDto.getFechaFallecimiento(), pelicula.get());

            actoresRepository.save(nuevoActor);
            
            return ResponseEntity.ok("Actor guardado");

        } catch (Exception e) {
            log.error("Error al guardar el actor", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el actor");
        }
    }

    



}









