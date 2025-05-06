/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea7f;

import java.util.Objects;

/**
 *
 * @author carlos
 */
public class Horario {
    private String registro;
    private String curso;
    private String profesor;
    private String asignatura;
    private String aula;
    private int dia;
    private int hora; 

    public Horario() {
    }

    public Horario(String registro, String curso, String profesor, String asignatura, String aula, int dia, int hora) {
        this.registro = registro;
        this.curso = curso;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.registro);
        hash = 89 * hash + Objects.hashCode(this.curso);
        hash = 89 * hash + Objects.hashCode(this.profesor);
        hash = 89 * hash + Objects.hashCode(this.asignatura);
        hash = 89 * hash + Objects.hashCode(this.aula);
        hash = 89 * hash + this.dia;
        hash = 89 * hash + this.hora;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        return Objects.equals(this.aula, other.aula);
    }

    @Override
    public String toString() {
        return "Horario{" + "registro=" + registro + ", curso=" + curso + ", profesor=" + profesor + ", asignatura=" + asignatura + ", aula=" + aula + ", dia=" + dia + ", hora=" + hora + '}';
    }
    
    
    
}
