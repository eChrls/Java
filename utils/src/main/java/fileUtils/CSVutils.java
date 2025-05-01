/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ÍNDICE DE MÉTODOS: ----------------- 
 * 1. writeCsvFromObjects: Escribe objetos * en un archivo CSV usando una función para convertir a String[] 
 * 2. * readCsvToObjects: Lee un archivo CSV y convierte cada línea a objetos usando * una función conversor 
 * 3. convertCsvToMap: Convierte un archivo CSV a un Map * usando columnas específicas como clave y valor 
 * 4. writeCsvFromMap: Escribe un * Map en un archivo CSV 
 * 5. generateIndividualCsvFiles: Genera archivos CSV * individuales para cada objeto 
 * 6. mergeCsvFiles: Fusiona varios archivos CSV * en uno solo 
 * 7. filterCsv: Filtra un archivo CSV según un predicado 
 * 8. * calculateColumnSum: Calcula la suma de una columna numérica 
 * 9. * calculateColumnAverage: Calcula el promedio de una columna numérica 
 * 10. * findMaxValueInColumn: Encuentra el valor máximo en una columna numérica 
 * 11. * findMinValueInColumn: Encuentra el valor mínimo en una columna numérica 
 * 12. * countRowsWithCondition: Cuenta las filas que cumplen una condición 
 * 13. * countRecordsBetweenDates: Cuenta registros entre dos fechas 
 * 14. * calculateAvgBetweenDates: Calcula promedio de una columna entre dos fechas
 */
public class CSVutils {

    // Escribe una lista de objetos en un archivo CSV usando una función para convertir cada objeto a un array de strings
    // Ejemplo:
    // List<Evento> eventos = generarDatos();
    // boolean escrito = CsvUtils.writeCsvFromObjects("./csv/datoscsv.csv", eventos, 
    //                  evento -> new String[]{String.valueOf(evento.getCodigo()), evento.getNombre(), 
    //                  evento.getLugar(), evento.getFecha().toString(), evento.getTipo().toString()},
    //                  ";", new String[]{"Codigo", "Nombre", "Lugar", "Fecha", "Tipo"});
    public static <T> boolean writeCsvFromObjects(String filePath, List<T> objects,
            Function<T, String[]> toStringArray,
            String delimiter, String[] headers) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                if (headers != null) {
                    writer.write(String.join(delimiter, headers));
                    writer.newLine();
                }

                for (T obj : objects) {
                    String[] fields = toStringArray.apply(obj);
                    writer.write(String.join(delimiter, fields));
                    writer.newLine();
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lee un archivo CSV y convierte cada línea a objetos usando una función conversor
    // Ejemplo:
    // List<Evento> eventos = CsvUtils.readCsvToObjects("./csv/datoscsv.csv", ";", 
    //                       fields -> new Evento(Integer.parseInt(fields[0]), fields[1], 
    //                       fields[2], LocalDate.parse(fields[3]), TipoEvento.valueOf(fields[4])),
    //                       true);
    public static <T> List<T> readCsvToObjects(String filePath, String delimiter,
            Function<String[], T> fromStringArray,
            boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<T> objects = new ArrayList<>();
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                objects.add(fromStringArray.apply(fields));
            }

            return objects;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Convierte un archivo CSV a un Map usando columnas específicas como clave y valor
    // Ejemplo:
    // Map<String, String> estacionesPrecipitacion = CsvUtils.convertCsvToMap(
    //                     "./csv/precipitaciones.csv", ";", 0, 2, true);
    public static Map<String, String> convertCsvToMap(String filePath, String delimiter,
            int keyIndex, int valueIndex,
            boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, String> map = new HashMap<>();
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length > Math.max(keyIndex, valueIndex)) {
                    map.put(fields[keyIndex], fields[valueIndex]);
                }
            }

            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Escribe un Map en un archivo CSV
    // Ejemplo:
    // Map<String, Double> estacionesPrecipitacion = obtenerPrecipitaciones();
    // boolean escrito = CsvUtils.writeCsvFromMap("./resultado.csv", estacionesPrecipitacion, 
    //                  ";", "Estación", "Precipitación(mm)");
    public static <K, V> boolean writeCsvFromMap(String filePath, Map<K, V> map,
            String delimiter,
            String keyHeader, String valueHeader) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                if (keyHeader != null && valueHeader != null) {
                    writer.write(keyHeader + delimiter + valueHeader);
                    writer.newLine();
                }

                for (Map.Entry<K, V> entry : map.entrySet()) {
                    writer.write(entry.getKey() + delimiter + entry.getValue());
                    writer.newLine();
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Genera archivos CSV individuales para cada objeto en una lista
    // Ejemplo:
    // List<Evento> eventos = generarDatos();
    // boolean generados = CsvUtils.generateIndividualCsvFiles("./csv2", eventos,
    //                    evento -> new String[]{String.valueOf(evento.getCodigo()), evento.getNombre(), 
    //                    evento.getLugar(), evento.getFecha().toString(), evento.getTipo().toString()},
    //                    evento -> evento.getNombre() + ".csv", ";");
    public static <T> boolean generateIndividualCsvFiles(String directoryPath, List<T> objects,
            Function<T, String[]> toStringArray,
            Function<T, String> filenameFunction,
            String delimiter) {
        boolean allSuccess = true;

        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        for (T obj : objects) {
            String filename = filenameFunction.apply(obj);
            String filePath = directoryPath + "/" + filename;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                String[] fields = toStringArray.apply(obj);
                writer.write(String.join(delimiter, fields));
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                allSuccess = false;
            }
        }

        return allSuccess;
    }

    // Fusiona varios archivos CSV en uno solo
    // Ejemplo:
    // boolean fusionado = CsvUtils.mergeCsvFiles("./csv2", "./csv/fusionado.csv", 
    //                    ".csv", true, ";");
    public static boolean mergeCsvFiles(String sourceDirectory, String targetFile,
            String extension, boolean includeFilenameAsColumn,
            String delimiter) {
        try {
            Path targetPath = Paths.get(targetFile);
            Files.createDirectories(targetPath.getParent());

            Path sourcePath = Paths.get(sourceDirectory);
            List<Path> files = Files.list(sourcePath)
                    .filter(path -> path.toString().endsWith(extension))
                    .collect(Collectors.toList());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
                for (Path file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (includeFilenameAsColumn) {
                                writer.write(file.getFileName().toString() + delimiter + line);
                            } else {
                                writer.write(line);
                            }
                            writer.newLine();
                        }
                    }
                }
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Filtra un archivo CSV según un predicado
    // Ejemplo:
    // List<String[]> filtrados = CsvUtils.filterCsv("./csv/datos.csv", ";", true,
    //                           row -> Double.parseDouble(row[2]) > 10.0);
    public static List<String[]> filterCsv(String filePath, String delimiter,
            boolean skipHeader,
            Predicate<String[]> filter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String[]> filteredData = new ArrayList<>();
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (filter.test(fields)) {
                    filteredData.add(fields);
                }
            }

            return filteredData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Calcula la suma de una columna numérica
    // Ejemplo:
    // double suma = CsvUtils.calculateColumnSum("./csv/datos.csv", ";", 2, true);
    public static double calculateColumnSum(String filePath, String delimiter,
            int columnIndex, boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            double sum = 0.0;
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length > columnIndex) {
                    try {
                        sum += Double.parseDouble(fields[columnIndex]);
                    } catch (NumberFormatException e) {
                        // Ignorar valores no numéricos
                    }
                }
            }

            return sum;
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Calcula el promedio de una columna numérica
    // Ejemplo:
    // double promedio = CsvUtils.calculateColumnAverage("./csv/datos.csv", ";", 2, true);
    public static double calculateColumnAverage(String filePath, String delimiter,
            int columnIndex, boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            double sum = 0.0;
            int count = 0;
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length > columnIndex) {
                    try {
                        sum += Double.parseDouble(fields[columnIndex]);
                        count++;
                    } catch (NumberFormatException e) {
                        // Ignorar valores no numéricos
                    }
                }
            }

            return count > 0 ? sum / count : 0.0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Encuentra el valor máximo en una columna numérica
    // Ejemplo:
    // double maximo = CsvUtils.findMaxValueInColumn("./csv/precipitaciones.csv", ";", 2, true);
    public static double findMaxValueInColumn(String filePath, String delimiter,
            int columnIndex, boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            double max = Double.MIN_VALUE;
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length > columnIndex) {
                    try {
                        double value = Double.parseDouble(fields[columnIndex]);
                        if (value > max) {
                            max = value;
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar valores no numéricos
                    }
                }
            }

            return max;
        } catch (IOException e) {
            e.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    // Encuentra el valor mínimo en una columna numérica
    // Ejemplo:
    // double minimo = CsvUtils.findMinValueInColumn("./csv/precipitaciones.csv", ";", 2, true);
    public static double findMinValueInColumn(String filePath, String delimiter,
            int columnIndex, boolean skipHeader) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            double min = Double.MAX_VALUE;
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length > columnIndex) {
                    try {
                        double value = Double.parseDouble(fields[columnIndex]);
                        if (value < min) {
                            min = value;
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar valores no numéricos
                    }
                }
            }

            return min;
        } catch (IOException e) {
            e.printStackTrace();
            return Double.MAX_VALUE;
        }
    }

    // Cuenta las filas que cumplen una condición
    // Ejemplo:
    // int cantidad = CsvUtils.countRowsWithCondition("./csv/datos.csv", ";", true,
    //               row -> Double.parseDouble(row[2]) > 10.0);
    public static int countRowsWithCondition(String filePath, String delimiter,
            boolean skipHeader,
            Predicate<String[]> condition) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int count = 0;
            String line;

            if (skipHeader) {
                reader.readLine();
            }

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (condition.test(fields)) {
                    count++;
                }
            }

            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Cuenta registros entre dos fechas
    // Ejemplo:
    // LocalDate inicio = LocalDate.of(2017, 10, 10);
    // LocalDate fin = LocalDate.of(2017, 10, 20);
    // int cantidad = CsvUtils.countRecordsBetweenDates("./csv/precipitaciones.csv", ";", 3, "yyyy-MM-dd", 
    //               inicio, fin, true);
    public static int countRecordsBetweenDates(String filePath, String delimiter,
            int dateColumnIndex, String dateFormat,
            LocalDate startDate, LocalDate endDate,
            boolean skipHeader) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        return countRowsWithCondition(filePath, delimiter, skipHeader, row -> {
            if (row.length <= dateColumnIndex) {
                return false;
            }

            try {
                LocalDate date = LocalDate.parse(row[dateColumnIndex], formatter);
                return (date.isEqual(startDate) || date.isAfter(startDate))
                        && (date.isEqual(endDate) || date.isBefore(endDate));
            } catch (Exception e) {
                return false;
            }
        });
    }
}
