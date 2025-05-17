package InterfacesJTable.modelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase que maneja una lista de estudiantes obtenidos desde un archivo CSV
 */
public class StudentList {

    private final ArrayList<Student> studentList;

    /**
     * Constructor que carga los estudiantes desde un CSV Solo carga los
     * primeros 25 estudiantes nacidos antes de 2005
     *
     * @param csvFilePath ruta al archivo CSV con los datos de estudiantes
     */
    public StudentList(String csvFilePath) {
        studentList = new ArrayList<>();
        loadStudentsFromCSV(csvFilePath);
    }

    /**
     * Carga los estudiantes desde un archivo CSV Solo carga los primeros 25
     * estudiantes nacidos antes de 2005
     *
     * @param csvFilePath ruta al archivo CSV
     */
    private void loadStudentsFromCSV(String csvFilePath) {
        int count = 0;
        LocalDate cutoffDate = LocalDate.of(2005, 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Salta la primera línea (cabecera)
            br.readLine();

            while ((line = br.readLine()) != null && count < 25) {
                String[] data = line.split(";");
                // Asumimos estructura del CSV: Alumno/a;Localidad de residencia;Fecha de nacimiento;Unidad;Sexo;País de nacimiento
                if (data.length == 6) {
                    String nombre = data[0].trim();
                    String localidad = data[1].trim();
                    String fechaNacStr = data[2].trim();
                    String unidad = data[3].trim();
                    String sexo = data[4].trim();
                    String paisNacimiento = data[5].trim();

                    // Comprobar si nació antes de 2005
                    try {
                        LocalDate fechaNac = LocalDate.parse(fechaNacStr, formatter);
                        if (fechaNac.isBefore(cutoffDate)) {
                            // Generamos un ID simple basado en el contador
                            Student student = new Student(String.valueOf(count + 1), nombre, localidad, unidad, fechaNacStr, sexo, paisNacimiento);
                            studentList.add(student);
                            count++;
                        }
                    } catch (Exception e) {
                        // Ignorar errores de formato de fecha
                        System.err.println("Error al procesar fecha: " + fechaNacStr);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista completa de estudiantes
     *
     * @return lista de estudiantes
     */
    public ArrayList<Student> getList() {
        return studentList;
    }

    /**
     * Obtiene un estudiante por su posición en la lista
     *
     * @param index índice del estudiante en la lista
     * @return estudiante en la posición indicada o null si no existe
     */
    public Student getStudent(int index) {
        if (index >= 0 && index < studentList.size()) {
            return studentList.get(index);
        }
        return null;
    }

    /**
     * Imprime todos los estudiantes en consola (para verificación)
     */
    public void printAllStudents() {
        System.out.println("==== LISTA DE ESTUDIANTES ====");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("=============================");
    }
    //guardar cambios en el CSV
    public void saveToCSV(String csvFilePath) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(csvFilePath))) {
        // Escribe la cabecera
        pw.println("Alumno/a;Localidad de residencia;Fecha de nacimiento;Unidad;Sexo;País de nacimiento");
        for (Student student : studentList) {
            pw.printf("%s;%s;%s;%s;%s;%s\n",
                student.getNombre(),
                student.getLocalidad(),
                student.getFechaNacimiento(),
                student.getUnidad(),
                student.getSexo(),
                student.getPaisNacimiento()
            );
        }
    } catch (IOException e) {
        System.err.println("Error al guardar el CSV: " + e.getMessage());
    }
}

}
