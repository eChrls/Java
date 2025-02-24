package com.lorenzo.taller.apipersonas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.taller.apipersonas.models.PersonaEntity;
import java.util.List;


public interface PersonaJpaRepository extends JpaRepository<PersonaEntity, Integer> {

    List<PersonaEntity> findByNombre(String nombre);

}
