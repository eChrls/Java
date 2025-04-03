/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.p62academiajctm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author carlos
 */
public class Academia {
    private String nombre;
    private Direccion direccion; 
    private  Set <Alumno> alumnos;
    private Set<Empleado> empleados;

    public Academia(String nombre1, String direccion1, Set<Alumno> alumnos1, Set<Empleado> empleados1) {
    }

    public Academia(String nombre, Direccion direccion, Set<Alumno> alumnos, Set<Empleado> empleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.alumnos = alumnos;
        this.empleados = empleados;
    }
    
    public static void contratarEmpleado(Empleado empleado){
        //Elijo set porque no deberia haber dos empleados contratados iguales
        Set<Empleado>empleadosContratados = new HashSet<>();
        empleadosContratados.add(empleado);
        
    }
    
    public static void matricularAlumno(Alumno alumno){
        Set<Alumno>alumnosMatriculados = new HashSet<>();
        alumnosMatriculados.add(alumno);
    }
    
}
