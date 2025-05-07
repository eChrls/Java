/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareadonantesficheros;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nuria
 */
public class Donante {

    private int id_paciente;
    private String nombre;
    private String fechaNacimiento;
    private String grupoSanguineo;
    private String rh;
    private int numeroDonaciones;

    public int getId_paciente() {
        return id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public int getNumeroDonaciones() {
        return numeroDonaciones;
    }

    public int getEdad() {//En este jercicio vico fue un cabron con el formato de la fecha y a todos nos falló por ello (una vez y no más santo tomás)
        //por eso hay que hacer esta cosa "rara"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate nacimiento = LocalDate.parse(this.fechaNacimiento, formatter);
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Donante{");
        sb.append("id=").append(id_paciente);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", grupo=").append(grupoSanguineo);
        sb.append(", rh=").append(rh);
        sb.append(", donaciones=").append(numeroDonaciones);
        sb.append('}');
        return sb.toString();
    }


}
