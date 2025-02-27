/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionHospital6A;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Casa
 */
public class Medico extends Empleado {

    String especialidad;
    ArrayList<Paciente> pacientesAsignados;
    private Grupo grupoProf;

    public Medico(String especialidad, ArrayList<Paciente> pacientesAsignados, double salario, LocalDate fechaCont, String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(salario, fechaCont, nombreCompleto, nif, fechaNac);
        this.especialidad = especialidad;
        this.pacientesAsignados = pacientesAsignados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Grupo getGrupoProf() {
        return grupoProf;
    }

    public void setGrupoProf(Grupo grupoProf) {
        this.grupoProf = grupoProf;
    }

    public ArrayList<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    public void setPacientesAsignados(ArrayList<Paciente> pacientesAsignados) {
        this.pacientesAsignados = pacientesAsignados;
    }

    //Metodo para tratar paciente
    public void tratarPaciente(Paciente paciente, String tratamiento) {
        /*Este metodo permite que un medico aplique un tratamiento a un paciente
        además, si el paciente no está en la lista lo añade (pacientesAsignados)
        Luego registra el tratamiento*/
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
        //metodo de pacientes, lista de tratamientos.
        paciente.agregarTratamiento(tratamiento + " (recetado por Dr./Dra. " + this.nombreCompleto + " para el paciente " + paciente.getNombreCompleto());
    }

    @Override
    public double calcularIRPF() {
        return salario * grupoProf.getPorcentajeIRPF();
    }

    @Override
    public String toString() {
        return "Medico{" + super.toString() + "especialidad=" + especialidad + ", pacientesAsignados=" + pacientesAsignados + ", grupoProf=" + grupoProf + '}';
    }

}
