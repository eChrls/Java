package com.videoclub.videoclub.entity;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actores")
public class ActoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_actor")
    private Long idActor;
    private String nombre;
    private String apellido;
    private int edad;
    private String origen; 
    private LocalDate fechaFallecimiento;
    

    

    @ManyToMany
    @JoinTable(name = "pelicula", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_actor"))

    private Set<PeliculaEntity> peliculas = new LinkedHashSet<>();
        private PeliculaEntity pelicula;
        
           public ActoresEntity(String nombre, String apellido, int edad, String origen, LocalDate fechaFallecimiento, PeliculaEntity pelicula) {
    
            this.nombre = nombre;
    
            this.apellido = apellido;
    
            this.edad = edad;
    
            this.origen = origen;
    
            this.fechaFallecimiento = fechaFallecimiento;
    
            this.pelicula = pelicula;

    }

}






