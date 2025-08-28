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
    
    
    

    public Academia() {
        this.nombre = "Academia sin nombre";
        this.alumnos = new HashSet<>();
        this.empleados= new HashSet<>();
        this.direccion= new Direccion();
    }

    
    public Academia(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleados=new HashSet<>();
        this.alumnos=new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void contratarEmpleado(Empleado empleado){
        empleados.add(empleado);
        
    }
    
    public void matricularAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    
}
