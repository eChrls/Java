/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea7b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Main {

    public static void main(String[] args) {

    }

    //Implementa un método llamado generarDatos que crea y 
    //devuelve una lista con 25 objetos usando el constructor por defecto. 
    public static List<Evento> generarDatos() {
        List<Evento> listaGenerada = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            Evento e = new Evento();
            listaGenerada.add(e);
        }
        return listaGenerada;
    }

    //Guarda los datos de la lista, en un fichero de texto llamado datoscsv.csv, dentro del directorio “./csv”. 
    //Los campos de cada registro irán separados por el caracter ";".
    public static void guardarListaEnCSV(List<Evento> lista, String nombre) {

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(nombre))) {
            for (Evento e : lista) {
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("CSV creado correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar la lista." + e.getMessage());
        }
    }

    /* Crea un directorio, "./csv2", donde se guarden en archivos individuales CSV, 
    los datos de cada una de los eventos. En este directorio deben generarse 25 ficheros 
    con el nombre que tenga el evento en su atributo id (ejemplos: event2y,csv, event1e.csv, etc).*/
    public static void crearCSVindividuales(List<Evento> lista) {
        //crea el directorio sino existe
        try {
            Path directory = Paths.get("./csv2");//primero sin S , luego con S
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            //crea csv para cada evento
            for (Evento evento : lista) {
                String nombre = evento.getNombre() + ".csv";
                Path path = directory.resolve(nombre); // convierte string en directorio

                try (BufferedWriter bw = Files.newBufferedWriter(path)) {

                    bw.write(evento.toString());
                    bw.newLine();
                    //con PrintWriter. pw.println
                } catch (IOException e) {
                    System.out.println("Error en la creacion de los archivos. Archivo : " + nombre + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear directorio : " + e.getMessage());
        }
    }

    /*Guarda los datos de la lista, en un fichero XML llamado datosxml.xml, dentro del directorio “./xml”. 
    Ayúdate del ejemplo del repositorio de clase. Incluye las dependencias necesarias en el pom.xml*/
    public static void crearFicheroXML(List<Evento> lista) {

        try {
            File directorio = new File("./xml");
            if (!directorio.exists()) {
                directorio.mkdir();
            }
            PrintWriter pw = new PrintWriter("./xml/datosxml.xml", "UTF-8");

            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"1.0\"?>");
            pw.println("<eventos>");

            for (Evento evento : lista) {
                pw.println("    <evento>");
                pw.println("        <id>" + evento.getId());
                pw.println("        <tipo>" + evento.getTipo());
                pw.println("        <nombre>" + evento.getNombre());
                pw.println("        <lugar>" + evento.getLugar());
                pw.println("        <fecha>" + evento.getFecha());
                pw.println("    </evento>");
            }

            pw.println("</eventos>");
            pw.close();
            //pw.flush(); PrintWriter y el try with resources hacen el flush

            System.out.println("Archivo XML creado correctamente");

        } catch (IOException e) {
            System.out.println("Problema creando el XML" + e.getMessage());
        }
    }

    /*Guarda los datos de la lista, en un fichero JSON llamado datosjson.json, dentro del directorio “./json”.
    Ayúdate del ejemplo del repositorio de clase. Incluye las dependencias necesarias en el pom.xml.*/
    public static void crearJson(List<Evento> lista) {
        try {
            //Crear directorio sino existe
            File directorio = new File("./json");
            if (!directorio.exists()) {
                directorio.mkdir();

            }

            PrintWriter pw = new PrintWriter("./json/datosjson.json");
            pw.println("[");
            for (Evento e : lista) {
                pw.println("{");
                pw.println("\"id\":" + e.getId() + ",");
                pw.println("\"nombre\":" + "\"" + e.getNombre() + "\",");
                pw.println("\"lugar\":" + "\"" + e.getLugar() + "\",");
                pw.println("\"tipo\":" + "\"" + e.getTipo() + "\",");
                pw.println("\"fecha\":" + "\"" + e.getFecha() + "\",");
                pw.println("},");
            }
            pw.println("]");

            pw.close();

            System.out.println("Archivo JSON creado correctamente. ");

        } catch (IOException e) {
            System.out.println("Error al crear JSON " + e.getMessage());
        }
    }

    /*Crea una carpeta “./copias” y realiza una copia de los ficheros contenidos en la carpeta "csv2" 
    dentro de ella.*/
    public static void crearCopias() {
        File directorio = new File("./copias");
        if (!directorio.exists()) {
            directorio.mkdir();

        }

        Path origen = Paths.get("./csv2");
        Path destino = Paths.get("./copias");

        //Copia solo un archivo o directorio, no el contenido del directorio
//        try {
//            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            System.out.println("Error al crear la copia. " + e.getMessage());
//        }
        //Copiar el contenido de un directorio
        try {
            File carpetaOrigen = origen.toFile(); // convierte la ruta del directorio a un objeto File
            if (carpetaOrigen.isDirectory()) {//verifica que sea un directorio
                File[] archivos = carpetaOrigen.listFiles(); //Obtiene lista de todos los archivos del directorio
                if (archivos != null) {
                    for (File archivo : archivos) {
                        Path origenPath = archivo.toPath(); //Convierte el objeto File a un objeto Path
                        Path destinoPath = destino.resolve(origenPath.getFileName()); //Indicamos la ruta destino del archivo origen
                        Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                        //Files.copy necesita dos paths y la funcion de copia. 
                    
                        System.out.println("Copiado: " + origenPath.getFileName() + " a " + destinoPath.getFileName());
                    }
                }
            }else{
                System.out.println(origen.getFileName() + " no es un directorio.");
            }

        } catch (IOException e) {
            System.out.println("Error al crear la copia " + e.getMessage());
        }

    }

    /*Hacer los metodos que hagan las funciones de lectura del archivo*/
}
