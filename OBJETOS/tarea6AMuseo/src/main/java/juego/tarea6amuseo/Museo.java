/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Museo {
    private String nombre;
    private String direccion;
    private List<Sala> salas;
    private List<Empleado> empleados;

    public Museo(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.salas = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void añadirSala(Sala sala) {
        this.salas.add(sala);
    }

    public void quitarSala(Sala sala) {
        this.salas.remove(sala);
    }

    public void contratarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " contratado.");
    }

    public void despedirEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " despedido.");
    }

    public List<Obra> obtenerTodasLasObras() {
        List<Obra> todasLasObras = new ArrayList<>();
        for (Sala sala : salas) {
            todasLasObras.addAll(sala.getObras());
        }
        return todasLasObras;
    }
}
