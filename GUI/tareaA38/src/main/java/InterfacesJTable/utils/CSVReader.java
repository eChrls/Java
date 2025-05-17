package InterfacesJTable.utils;

import InterfacesJTable.modelos.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para leer datos de estudiantes desde un archivo CSV Esta
 * clase maneja el análisis de datos CSV y los convierte en objetos Student
 * Necesaria para cargar datos de estudiantes desde fuentes externas
 */
public class CSVReader {

    private static final String CSV_DELIMITER = ";"; // Delimitador utilizado en el archivo CSV
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Lee datos de estudiantes desde un archivo CSV y los convierte en una
     * lista de objetos Student Filtra estudiantes nacidos antes de 2005 y
     * limita a 25 registros
     *
     * @param filePath la ruta al archivo CSV
     * @return una lista de objetos Student filtrados
     */
    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> filteredStudents = new ArrayList<>();
        int idCounter = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null && filteredStudents.size() < 25) {
                // Omitir línea de encabezado
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(CSV_DELIMITER);
                if (data.length == 6) {
                    try {
                        String nombre = data[0].trim();
                        String localidad = data[1].trim();
                        LocalDate birthDate = LocalDate.parse(data[2].trim(), DATE_FORMATTER);
                        String unidad = data[3].trim();
                        String sexo = data[4].trim();
                        String pais = data[5].trim();

                        if (birthDate.getYear() < 2005) {
                            filteredStudents.add(new Student(String.valueOf(idCounter++), nombre, localidad, unidad, data[2].trim(), sexo, pais));
                        }
                    } catch (Exception e) {
                        System.err.println("Error al procesar línea CSV: " + line + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Formato de línea CSV incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return filteredStudents;
    }
}
