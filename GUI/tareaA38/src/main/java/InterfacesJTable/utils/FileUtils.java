package InterfacesJTable.utils;

import InterfacesJTable.modelos.Student;
import java.util.List;

/**
 * Clase de utilidad para operaciones con archivos
 */
public class FileUtils {

    /**
     * Imprime la lista de estudiantes por consola (para verificación)
     *
     * @param studentList lista de estudiantes a imprimir
     */
    public static void printStudents(List<Student> studentList) {
        System.out.println("=== Lista de estudiantes ===");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("===========================");
    }
}
