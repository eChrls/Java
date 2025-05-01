/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;

/**
 * ÍNDICE DE MÉTODOS: ----------------- 
 * 1. createDirectory: Crea un directorio * si no existe 
 * 2. createEmptyFile: Crea un archivo vacío 
 * 3. writeToTxtFile: * Escribe contenido en un archivo de texto 
 * 4. readFromTxtFile: Lee el contenido * de un archivo de texto 
 * 5. appendToTxtFile: Añade contenido a un archivo de * texto existente 
 * 6. writeToCsvFile: Escribe una lista de objetos en un archivo * CSV 
 * 7. writeToCsvFileWithHeader: Escribe una lista de objetos en un archivo * CSV con cabecera 
 * 8. readFromCsvFile: Lee el contenido de un archivo CSV
 * 9. * readFromCsvFileWithHeader: Lee el contenido de un archivo CSV con cabecera
 * 10. copyFile: Copia un archivo a una ubicación nueva 
 * 11. copyDirectory: Copia * todos los archivos de un directorio a otro 
 * 12. deleteFile: Elimina un archivo * 
 * 3. convertListToMap: Convierte una lista de arrays de strings a un Map 
 * 14. * saveObjectToCsv: Guarda un objeto específico en formato CSV 
 * 15. * readObjectFromCsv: Lee un objeto específico desde un archivo CSV
 */
public class FileUtils {

    // Crea un directorio si no existe
    // Ejemplo: boolean creado = FileUtils.createDirectory("./csv");
    public static boolean createDirectory(String pathStr) {
        Path path = Paths.get(pathStr);
        if (Files.exists(path)) {
            return true;
        }
        try {
            Files.createDirectories(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Crea un archivo vacío
    // Ejemplo: boolean creado = FileUtils.createEmptyFile("./csv/datos.csv");
    public static boolean createEmptyFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            return true;
        }
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Escribe contenido en un archivo de texto
    // Ejemplo: boolean escrito = FileUtils.writeToTxtFile("./data/texto.txt", "Hola mundo", false);
    public static boolean writeToTxtFile(String filePath, String content, boolean append) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
                writer.write(content);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lee el contenido de un archivo de texto
    // Ejemplo: String contenido = FileUtils.readFromTxtFile("./data/texto.txt");
    public static String readFromTxtFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Añade contenido a un archivo de texto existente
    // Ejemplo: boolean añadido = FileUtils.appendToTxtFile("./data/texto.txt", "Nueva línea");
    public static boolean appendToTxtFile(String filePath, String content) {
        return writeToTxtFile(filePath, content, true);
    }

    // Escribe una lista de objetos en un archivo CSV
    // Ejemplo: 
    // List<String[]> datos = new ArrayList<>();
    // datos.add(new String[]{"1", "Juan", "Madrid"});
    // datos.add(new String[]{"2", "María", "Barcelona"});
    // boolean escrito = FileUtils.writeToCsvFile("./csv/personas.csv", datos, ";");
    public static boolean writeToCsvFile(String filePath, List<String[]> data, String delimiter) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String[] row : data) {
                    writer.write(String.join(delimiter, row));
                    writer.newLine();
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Escribe una lista de objetos en un archivo CSV con cabecera
    // Ejemplo:
    // String[] cabeceras = {"ID", "Nombre", "Ciudad"};
    // List<String[]> datos = new ArrayList<>();
    // datos.add(new String[]{"1", "Juan", "Madrid"});
    // datos.add(new String[]{"2", "María", "Barcelona"});
    // boolean escrito = FileUtils.writeToCsvFileWithHeader("./csv/personas.csv", cabeceras, datos, ";");
    public static boolean writeToCsvFileWithHeader(String filePath, String[] headers, List<String[]> data, String delimiter) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(String.join(delimiter, headers));
                writer.newLine();

                for (String[] row : data) {
                    writer.write(String.join(delimiter, row));
                    writer.newLine();
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lee el contenido de un archivo CSV
    // Ejemplo: List<String[]> datos = FileUtils.readFromCsvFile("./csv/personas.csv", ";");
    public static List<String[]> readFromCsvFile(String filePath, String delimiter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String[]> data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(delimiter));
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lee el contenido de un archivo CSV con cabecera
    // Ejemplo:
    // Map<String, List<String[]>> resultado = FileUtils.readFromCsvFileWithHeader("./csv/personas.csv", ";");
    // String[] cabeceras = resultado.get("headers");
    // List<String[]> datos = resultado.get("data");
    public static Map<String, Object> readFromCsvFileWithHeader(String filePath, String delimiter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                return null;
            }

            String[] headers = headerLine.split(delimiter);

            List<String[]> data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(delimiter));
            }

            return Map.of("headers", headers, "data", data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Copia un archivo a una ubicación nueva
    // Ejemplo: boolean copiado = FileUtils.copyFile("./data/origen.txt", "./backup/copia.txt");
    public static boolean copyFile(String sourcePath, String targetPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path target = Paths.get(targetPath);

            Files.createDirectories(target.getParent());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Copia todos los archivos de un directorio a otro
    // Ejemplo: boolean copiado = FileUtils.copyDirectory("./datos", "./backup");
    public static boolean copyDirectory(String sourceDir, String targetDir) {
        try {
            createDirectory(targetDir);

            File dir = new File(sourceDir);
            File[] files = dir.listFiles();

            if (files == null) {
                return false;
            }

            for (File file : files) {
                if (file.isFile()) {
                    String targetPath = targetDir + "/" + file.getName();
                    copyFile(file.getPath(), targetPath);
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Elimina un archivo
    // Ejemplo: boolean eliminado = FileUtils.deleteFile("./data/temporal.txt");
    public static boolean deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Convierte una lista de arrays de strings a un Map con una clave determinada
    // Ejemplo:
    // List<String[]> datos = FileUtils.readFromCsvFile("./csv/personas.csv", ";");
    // Map<String, String> mapa = FileUtils.convertListToMap(datos, 0, 1); // ID -> Nombre
    public static Map<String, String> convertListToMap(List<String[]> data, int keyIndex, int valueIndex) {
        return data.stream()
                .filter(row -> row.length > Math.max(keyIndex, valueIndex))
                .collect(Collectors.toMap(
                        row -> row[keyIndex],
                        row -> row[valueIndex],
                        (v1, v2) -> v2)); // En caso de claves duplicadas, mantiene el último valor
    }

    // Guarda un objeto en formato CSV
    // Ejemplo:
    // Evento evento = new Evento(1, "event1a", "Madrid", LocalDate.now(), TipoEvento.PUBLICO);
    // boolean guardado = FileUtils.saveObjectToCsv("./csv/event1a.csv", evento.toString(), ";");
    public static boolean saveObjectToCsv(String filePath, String csvRepresentation, String delimiter) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(csvRepresentation);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lee un objeto desde un archivo CSV
    // Ejemplo:
    // String[] datosEvento = FileUtils.readObjectFromCsv("./csv/event1a.csv", ";");
    // // Luego puedes crear tu objeto con esos datos
    public static String[] readObjectFromCsv(String filePath, String delimiter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null) {
                return null;
            }
            return line.split(delimiter);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
