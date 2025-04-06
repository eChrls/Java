/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6brecordempleado;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Casa
 */
public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        Empleado e1 = new Empleado(1, "nombre1", "departamento1", 1000.00);
        Empleado e2 = new Empleado(2, "nombre2", "departamento2", 2000.00);
        Empleado e3 = new Empleado(3, "nombre3", "departamento3", 3000.00);
        Empleado e4 = new Empleado(4, "nombre4", "departamento4", 4000.00);

        
        
        empresa.agregarEmpleado(e4);
        empresa.agregarEmpleado(e3);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e1);
        System.out.println("--- Lista de todos los empleados ---");
        empresa.showAll();
        
        int idBuscado = 3; 
        System.out.println("\n--- Eliminando empleado con ID: " + idBuscado + " ---");
        empresa.eliminarEmpleado(idBuscado);
        System.out.println("\n--- Lista de empleados después de eliminar ---");
        empresa.showAll();
        
        
        String departamentoBuscado = "departamento2";
        Set<Empleado>empleadosBuscados = new HashSet<>();
        empleadosBuscados = empresa.empleadosPorDpto(departamentoBuscado);
         System.out.println("\n--- Empleados del departamento: " + departamentoBuscado + " ---");
        empleadosBuscados.forEach(System.out::println);
        
        double salarioMedio;
        salarioMedio = empresa.salarioMedioEmpleados();
        System.out.println("El salario medio de la empresa es " +  String.format("%.2f", salarioMedio));
        

    }

}
