package tarea7c;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Casa
 */
public class tarea7c {

    public static void main(String[] args) throws IOException {
        /*Procede a leer el fichero adjunto, carga los datos en una lista de objetos POJO 
        y a muestra los registros contenidos la lista usando la consola.*/
        ObjectMapper mapper = new ObjectMapper();
        //mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //mapper.registerModule(new JavaTimeModule());
        List<Precipitacion> precipitaciones = mapper.readValue(new File("precipitacionesBadajoz.json"), new TypeReference<List<Precipitacion>>() {
        });
        precipitaciones.forEach(System.out::println);

        /*Obtén una estructura Map donde para cada nombre de estación meteorológica se pueda 
        consultar la precipitación acumulada de la misma. Muestra por consola el resultado de la estructura map obtenida.*/
        Map<String, Double> map = precipitaciones.stream()
                .collect(
                        Collectors.groupingBy(Precipitacion::getEstacionMeteorologica,
                                Collectors.summingDouble(Precipitacion::getPrecipitacion))
                );

        Map<String, Double> map2 = precipitaciones.stream()
                .collect(
                        Collectors.toMap(Precipitacion::getEstacionMeteorologica, Precipitacion::getPrecipitacion, Double::sum)
                );

        map.forEach((k, v) -> System.out.println(k + v));

        /*Guarda en un fichero JSON, en la raíz del proyecto, el resultado del map. Pasa el objeto map directamente 
        a la hora de generar el archivo.*/
        File archivo = new File("./json");
        //mapper.registerModule(new JavaTimeModule());
        archivo.getParentFile().mkdirs();
        mapper.writeValue(archivo, map);

        /*Usando API Stream, muestra por consola el registro que tiene la mayor precipitación.*/
        Optional<Precipitacion> tmp = precipitaciones.stream().max(Comparator.comparingDouble(p -> p.getPrecipitacion()));

        System.out.println("Registro con más precipitacion : " + tmp);

        /*Usando API Stream, muestra por consola el número de estaciones meteorológicas que han sido leídas entre 
        el 10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.*/
        LocalDate f1 = LocalDate.of(2017, 10, 9);
        LocalDate f2 = LocalDate.of(2017, 10, 21);

        long numEstaciones = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f1) && p.getFecha().isBefore(f2)))
                .map(Precipitacion::getEstacionMeteorologica)
                .distinct()
                .count();

        List<String> estacionesFecha = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f1) && p.getFecha().isBefore(f2)))
                .map(Precipitacion::getEstacionMeteorologica)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Total de estaciones en esas fechas : " + numEstaciones);
        estacionesFecha.forEach(System.out::println);

        /*Usando API Stream, calcula la media de precipitaciones de aquellas estaciones meteorológicas leídas 
        entre el 10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.*/
        double mediaEstaciones = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f1) && p.getFecha().isBefore(f2)))
                .mapToDouble(Precipitacion::getPrecipitacion)
                .average()
                .orElse(0.0);

        System.out.printf("Media estaciones entre esas fechas : %.2f  litros/m2. ", mediaEstaciones);
        System.out.println();
// Muestra por consola el número total de registros cargados desde el fichero.
        System.out.println("Numero total de registros : " + precipitaciones.size());
// Muestra por consola el registro con la menor precipitación.
        Optional<Precipitacion> menorP = precipitaciones.stream().min(Comparator.comparingDouble(p -> p.getPrecipitacion()));
        System.out.println("Menos precipitacion = " + menorP);

// Calcula y muestra la suma total de precipitaciones durante todo el mes de octubre 2017.
        LocalDate f3 = LocalDate.of(2017, 9, 30);
        LocalDate f4 = LocalDate.of(2017, 11, 1);
        double sumaMes = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f3) && p.getFecha().isBefore(f4)))
                .mapToDouble(Precipitacion::getPrecipitacion)
                .sum();
        //map(Precipitacion::getPrecipitacion)
        // .reduce(0.0, (acumulador, valor) -> acumulador + valor);

// Calcula el número de registros por día (agrupados por fecha).
        Map<LocalDate, Long> registrosPorDia = precipitaciones.stream().collect(Collectors.groupingBy(
                Precipitacion::getFecha,
                TreeMap::new,
                Collectors.counting())
        );

        registrosPorDia.forEach((fecha, cantidad) -> System.out.println(fecha + " nº precipitaciones: " + cantidad));

// Muestra el promedio de precipitaciones por día (agrupado por fecha).
        Map<LocalDate, Double> mediaPorDia = precipitaciones.stream()
                .collect(Collectors.groupingBy(
                        Precipitacion::getFecha,
                        TreeMap::new,
                        Collectors.averagingDouble(Precipitacion::getPrecipitacion)
                )
                );
        mediaPorDia.forEach((fecha, media) -> System.out.println(fecha + " media precipitaciones: " + media));

// Muestra por consola la estación con mayor media de precipitaciones.
        Map<String, Double> promedioEstacion = precipitaciones.stream()
                .collect(Collectors.groupingBy(Precipitacion::getEstacionMeteorologica,
                        TreeMap::new,
                        Collectors.averagingDouble(Precipitacion::getPrecipitacion)
                ));
        Optional<Map.Entry<String, Double>> estacionMaxMedia = promedioEstacion.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Estacion con mayor media: " + estacionMaxMedia.orElse(null));

// Muestra el total de precipitaciones entre el 1 y el 15 de octubre (ambos incluidos).
        double totalP = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f1) && p.getFecha().isBefore(f2)))
                .mapToDouble(Precipitacion::getPrecipitacion)
                .sum();

        System.out.println("Total precipitaciones entre dos fechas : " + totalP);

// Guarda todos los registros en un fichero CSV en la raíz del proyecto.
        Path directorio = Paths.get("./csv7C");
        Files.createDirectories(directorio);

        String nombre = "registros.csv";
        String delimiter = ",";

        Path rutaCompleta = directorio.resolve(nombre);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombre))) {
            bw.write("fecha" + delimiter + "estacionMeteorologica" + delimiter + "provincia" + delimiter + "precipitacion");
            bw.newLine();

            for (Precipitacion p : precipitaciones) {
                bw.write(p.getFecha() + delimiter + p.getEstacionMeteorologica() + delimiter + p.getProvincia() + delimiter + p.getPrecipitacion());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Fichero CSV generado en: " + rutaCompleta.toAbsolutePath());
        List<Precipitacion> listaCsv = new ArrayList<>();
        // Lee un fichero CSV y carga una lista de objetos Precipitacion.
        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {

            String line;
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                Precipitacion pr = new Precipitacion(LocalDate.parse(datos[0]), datos[1], datos[2], Double.valueOf(datos[3]));
                listaCsv.add(pr);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        listaCsv.forEach(System.out::println);

        // Guarda el Map<String, Double> de precipitaciones por estación en un JSON.
        ObjectMapper om = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        PrintWriter pw = new PrintWriter(new File("./fichero.json"));
        
        pw.println(om.writeValueAsString(map));
        pw.close();
        

        // Guarda un List<Precipitacion> filtrado (por ejemplo, fechas específicas) en un JSON.
        List<Precipitacion> listaFiltrada = precipitaciones.stream()
                .filter(p -> (p.getFecha().isAfter(f1) && p.getFecha().isBefore(f2)))
                .toList();
        
       PrintWriter pw2 = new PrintWriter(new File("./fichero2.json"));
       
       pw2.println(om.writeValueAsString(listaFiltrada));
       
       pw2.close();
    }
}
