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
public class Paciente extends Persona{
    private String numExpediente;
    private ArrayList<String>tratamientos;

    public Paciente(String numExpediente, ArrayList<String> tratamientos, String nombreCompleto, NIF nif, LocalDate fechaNac) {
        super(nombreCompleto, nif, fechaNac);
        this.numExpediente = numExpediente;
        this.tratamientos = tratamientos;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public ArrayList<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    //Metodo par añadir un tratamiento
    public void agregarTratamiento(String tratamiento){
        tratamientos.add(tratamiento);
    }

    @Override
    public String toString() {
        return super.toString() + "numExpediente=" + numExpediente + ", tratamientos=" + tratamientos + '}';
    }
    
    
    
    
    
    
    
}
