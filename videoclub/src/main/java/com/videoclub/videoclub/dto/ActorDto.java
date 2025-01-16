package com.videoclub.videoclub.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ActorDto {
    private String nombre;
    private String apellido;
    private int edad;
    private String origen; 
    private LocalDate fechaFallecimiento;
}
