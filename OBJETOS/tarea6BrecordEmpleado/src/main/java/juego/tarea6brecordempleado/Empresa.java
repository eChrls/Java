/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6brecordempleado;

import java.util.HashSet;
import java.util.Set;


public class Empresa {
    Set<Empleado> empleados;

    public Empresa() {
         this.empleados = new HashSet<>();
    }

    public Empresa(Set<Empleado> empleados) {
        this.empleados = new HashSet<>();
    }
    
    
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
        
    }
    
    public void eliminarEmpleado(Empleado empleado){
        empleados.remove(empleado);
    }
    
    public Set<Empleado> empleadosPorDpto(String departamento){

              for (Empleado empleado : empleados) {

            }
        
        return empleados; 
    }
    
    public void showAll (){
        empleados.forEach(System.out::println);
    }
    
    public void salarioMedio(){
       
        
    }
    
   
    
}
