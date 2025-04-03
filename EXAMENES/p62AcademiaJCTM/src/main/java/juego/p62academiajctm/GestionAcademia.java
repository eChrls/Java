/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego.p62academiajctm;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static juego.p62academiajctm.Academia.contratarEmpleado;
import static juego.p62academiajctm.Academia.matricularAlumno;

/**
 *
 * @author carlos
 */
public class GestionAcademia {

    public static void main(String[] args) {

        Set<Alumno> alumnos = new HashSet<>();
        Set<Empleado> empleados = new HashSet<>();

        Academia academia = new Academia("nombre", "direccion", alumnos, empleados);
        Interino profesorInterino = new Interino("1234", 1000.00, "nombre2", "apellidos2", "nif2");
         Interino profesorInterino2 = new Interino("1234", 1000.00, "nombre2", "apellidos2", "nif2");
         Alumno alumno1 = new Alumno("1", LocalDate.MAX, "alu1", "ape1", "nif1");
         Alumno alumno2 = new Alumno("2", LocalDate.MAX, "alu2", "ape2", "nif2");
        contratarEmpleado(profesorInterino);
        contratarEmpleado(profesorInterino2);
        matricularAlumno(alumno1);
        matricularAlumno(alumno2);
        
        alumnos.add(alumno2);
        alumnos.add(alumno1);
        empleados.add(profesorInterino);
        empleados.add(profesorInterino2);
        
        for(Alumno a : alumnos){
            System.out.println(a);
        }
          for(Empleado e : empleados){
            System.out.println(e);
        }
          
          

    }
}
