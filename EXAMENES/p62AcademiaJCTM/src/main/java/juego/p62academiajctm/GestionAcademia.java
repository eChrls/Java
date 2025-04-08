/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego.p62academiajctm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        academia.contratarEmpleado(profesorInterino); // implicito
        academia.contratarEmpleado(profesorInterino2);
        academia.matricularAlumno(alumno2);
        academia.matricularAlumno(alumno1);

        for (Empleado e : academia.getEmpleados()) {
            System.out.println(e);
        }

        for (Alumno a : academia.getAlumnos()) { // implicito
            System.out.println(a);
        }
        //e) Recorre la estructura de datos de los empleados, mostrando el resultado 
        //de calcularIRPF de cada uno y además pide una prórroga para los titulares, 
        //con un número de meses de tu elección, mostrando los resultados de las ejecuciones.  
        for (Empleado e : academia.getEmpleados()) {
            System.out.println("El empleado " + e + " tiene el siguiente IRPF" + e.calcularIRPF());
            if (e instanceof Titular) {
                ((Titular) e).pedirProrroga(3);
            }
        }

        /*f) Crea una lista de objetos que se puedan dar de baja e incluye aquellos objetos susceptibles
        de darse de baja de la academia. Recorre esta lista y solicita la baja, mostrando el resultado.*/
        List<SolicitarBaja> danBaja = new ArrayList<>(academia.getAlumnos());
        for (Empleado e : academia.getEmpleados()) {
            if (e instanceof Interino) {
                danBaja.add((SolicitarBaja) e);
            }
        }

        danBaja.forEach(System.out::println);


          /*g) Crea un método de clase, llamado calcularDiasInterinos,
        que reciba una academia y devuelva una estructura de datos con el nif del interino
        y sus días trabajados.*/
        Map<String, Integer> diasInterinos = calcularDiasInterinos(academia);

        /*h) Invoca al método calcularDiasInterinos y muestra los resultados por consola.*/
        for (Map.Entry<String, Integer> entry : diasInterinos.entrySet()) {
            System.out.println("El interino con NIF: " + entry.getKey() + " ha trabajado " + entry.getValue() + " días.");
        }
    }

    
        public static Map<String, Integer> calcularDiasInterinos(Academia academia) {

        Map<String, Integer> mapaDiasTrabajados = new HashMap<>();

        for (Empleado empleado : academia.getEmpleados()) {
            if (empleado instanceof Interino) {
                Interino interino = (Interino) empleado;
                int diasTrabajados = interino.calcularDiasTrabajados();
                mapaDiasTrabajados.put(interino.getNif(), diasTrabajados);
            }
        }
        return mapaDiasTrabajados;
    }

}
