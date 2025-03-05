/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionHospital6A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Casa
 */
public class Hospital {
    private String nombre; 
    private ArrayList<Empleado>empleados;
    private ArrayList<Paciente>pacientes;

    public Hospital(String nombre, ArrayList<Empleado> empleados, ArrayList<Paciente> pacientes) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.pacientes = pacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    
    
    public void agregarPaciente( Paciente paciente){
        /*Este metodo añade paciente a la lista. Y ordena la lista para una busqueda binaria posterior*/
        for(Paciente pac : pacientes){
            if (pac.getNif().toString().equals(paciente.getNif().toString())){
                System.out.println("Ya existe un paciente con nif : " + paciente.getNif());
                return;
            }
        }
        //Ordenamos por nif
        pacientes.add(paciente);
        Collections.sort(pacientes, Comparator.comparing(p -> p.getNif().toString()));
        System.out.println("Paciente agregado correctamente: " + paciente.getNombreCompleto());
        
    }
    
    
    public void agregarEmpleado(Empleado empleado){
        /*Metodo para agregar empleados (medicos o administrativos) a la lista empleados por nif*/
        for (Empleado emp : empleados){
            if(emp.getNif().toString().equals(empleado.getNif().toString())){
                System.out.println("Ya existe un empleado con nif: . " + empleado.getNif());
                return;
            }
        }
        
        empleados.add(empleado);
        System.out.println("Empleado agregado correctamente." + empleado.getNombreCompleto());
    }

    
    
    public void mostrarPacientes(){
        System.out.println("***************************LISTA DE PACIENTES************************************");
        for (Paciente pac : pacientes){
            System.out.println(pac);
            System.out.println("Tratamientos: " + pac.getTratamientos().size());
            System.out.println("*****************************************************************************************");
        }
        
    }
    
    public void mostrarEmpleados(){
        System.out.println("**************************LISTA DE EMPLEADOS**********************************");
        for(Empleado emp : empleados){
            System.out.println(emp);
            System.out.println("IRPF : " + emp.calcularIRPF()  + " €." );
            System.out.println("****************************************************************************************");
        }
    }

    public void ordenarEmpleadosPorSalario(){
        /*Metodo que ordena por salario de mayor a menor utilizando Collections.sort y Comparator*/
        Collections.sort(empleados, Comparator.comparing(Empleado::getSalario).reversed());
        System.out.println("Empleado ordenador por salario de mayor a menor************************************ ");
    }


    public Paciente buscarPacientePorNif(String num, char letra){
        /*algoritmo de busqueda binaria para encontrar al paciente por nif en una lista ordenada*/
            NIF nifBuscado = new NIF (num, letra);
            String nifString = nifBuscado.toString();
            
            int ini= 0;
            int fin = pacientes.size() -1; 
            
            while(ini <=  fin){
                int medio = (ini + fin)/2;
                String nifMedio = pacientes.get(medio).getNif().toString();
                
                int comparacion = nifMedio.compareTo(nifString);
                
                if(comparacion == 0){
                    return pacientes.get(medio);
                }  else if (comparacion < 0){
                ini = medio +1;
            }
                else{
                        fin = medio -1;
                        }
            }
            return null; // si llega aqui el paciente no se encontró
    }
    
    
    
}
