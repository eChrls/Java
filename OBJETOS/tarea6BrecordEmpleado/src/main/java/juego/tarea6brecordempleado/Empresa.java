
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
    
    //1. Agregar un empleado a la colección.
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
        
    }
    //2. Eliminar un empleado de la colección por su ID.
    public void eliminarEmpleado(int idBuscado, Set<Empleado>empleados){
        for (Empleado empleado : empleados) {
            if(empleado.id() == idBuscado){
                empleados.remove(empleado);
            }else{
                System.out.println("Id no encontrado. ");
            }
        }
        
    }
    //3. Buscar los empleados de un departamento.
    public Set<Empleado> empleadosPorDpto(String departamentoBuscado){
        Set<Empleado>empleadosEncontrados = new HashSet<>();
              for (Empleado empleado : this.empleados) {
                  if(empleado.departamento().equals(departamentoBuscado)){
                      empleadosEncontrados.add(empleado);
                  }
            }
        
        return empleadosEncontrados; 
    }
    //4. Listar todos los empleados en la colección.
    public void showAll (){
        empleados.forEach(System.out::println);
    }
    //5. Calcular el salario promedio de todos los empleados. 
    public double salarioMedioEmpleados(Set<Empleado> empleados){
        double salarioTotal = 0;
        
        for (Empleado empleado : this.empleados) {
                salarioTotal += empleado.salario();
               
        }
        double salarioMedio = salarioTotal/empleados.size();
        
        return salarioMedio; 
    }
    
   
    
}
