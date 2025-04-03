/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego.p62academiajctm;

import java.time.LocalDate;
/**
 *
 * @author carlos
 */
public class GestionAcademia {

    public static void main(String[] args) {

        Academia academia = new Academia("nombre", new Direccion("calle", "12123", "poblacion"));
        Interino profesorInterino = new Interino("5455", 1200.00, "nombre1", "apellidos1", "nif1");
        Interino profesorInterino2 = new Interino("1234", 1000.00, "nombre2", "apellidos2", "nif2");
        Alumno alumno1 = new Alumno("1", LocalDate.MAX, "alu1", "ape1", "nif1");
        Alumno alumno2 = new Alumno("2", LocalDate.MAX, "alu2", "ape2", "nif2");
        
        academia.contratarEmpleado(profesorInterino);
        academia.contratarEmpleado(profesorInterino2);
        academia.matricularAlumno(alumno2);
        academia.matricularAlumno(alumno1);
        
        
        for(Empleado e : academia.getEmpleados()){
            System.out.println(e);
        }
  
        for(Alumno a : academia.getAlumnos()){
            System.out.println(a);
        }
  
        



    }
}
