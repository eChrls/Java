package juego.tarea6brecordempleado;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Empresa {

    Set<Empleado> empleados;

    public Empresa() {
        this.empleados = new HashSet<>();
    }

    public Empresa(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    //1. Agregar un empleado a la colección.
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);

    }

    //2. Eliminar un empleado de la colección por su ID.
    public void eliminarEmpleado(int idBuscado) {

        Iterator<Empleado> iterator = empleados.iterator();
        boolean borrado = false;
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.id() == idBuscado) {
                iterator.remove();
                borrado = true;
                break;
            }
        }
        if (!borrado) {
            System.out.println("Id no encontrado");
        }
    }

    //3. Buscar los empleados de un departamento.
    public Set<Empleado> empleadosPorDpto(String departamentoBuscado) {
        Set<Empleado> empleadosEncontrados = new HashSet<>();
        for (Empleado empleado : this.empleados) {
            if (empleado.departamento().equals(departamentoBuscado)) {
                empleadosEncontrados.add(empleado);
            }
        }

        return empleadosEncontrados;
    }

    //4. Listar todos los empleados en la colección.
    public void showAll() {
        empleados.forEach(System.out::println);
    }

    //5. Calcular el salario promedio de todos los empleados. 
    public double salarioMedioEmpleados() {
        if (empleados.isEmpty()) {
            return 0;
        }

        double salarioTotal = 0;
        for (Empleado empleado : this.empleados) {
            salarioTotal += empleado.salario();

        }
        double salarioMedio = salarioTotal / empleados.size();

        return salarioMedio;
    }

    @Override
    public String toString() {
        return "Empresa{" + "empleados=" + empleados + '}';
    }

}
