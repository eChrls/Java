/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tareadonantesficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Nuria
 */
public class Main {

    public static void main(String[] args) { 
        Optional<List<Donante>> optionalDonantes = LeerFichero.leerJson("donantes.json");

        if (optionalDonantes.isPresent()) {
            List<Donante> donantes = optionalDonantes.get();

            //Apartado A
            donantes.forEach(System.out::println);

            //Apartado B
            ordenarPorDonaciones(donantes);

            //Apartado C
            Set<String> nombres = obtenerNombresMayores50(donantes);
            nombres.forEach(System.out::println);

            //Apartado D
            EscribirFichero.escribirNombres("nombresMayores50.txt", nombres);

            //Apartado G
            donantes.forEach(d -> System.out.println("ID: " + d.getId_paciente()+ " Nombre: " + d.getNombre()));
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca el id del paciente para ver sus compatibles: ");
            int idBuscado = sc.nextInt();

            List<Donante> compatibles = encontrarPacientesCompatibles(donantes, idBuscado);
            try {
                Files.createDirectories(Paths.get("donantes")); //crea el directorio solo si no existe
                String ruta = "donantes/" + idBuscado + ".json";
                EscribirFichero.escribirJson(ruta, compatibles);
            } catch (IOException e) {
                System.out.println("Error escribiendo");
            }

        }

    }

    /*Importante señore: 
    Collector: recolecta los resultados de una operacion sobre flujos de dato (convertir un stream en list, set...)
    Collections: es una clase pa trabajar con colecciones de java (list, map...) y hacerle cosas como ordenarlas, buscar elementos...
     */
    public static void ordenarPorDonaciones(List<Donante> donantes) {
        long contador = donantes.stream().sorted(Comparator.comparingInt(Donante::getNumeroDonaciones)).skip(100).count();
        System.out.println("Número de donantes sin contar los primeros 100: " + contador);
    }

    public static Set<String> obtenerNombresMayores50(List<Donante> donantes) {
        return donantes.stream().filter(d -> d.getEdad() > 50).map(Donante::getNombre).collect(Collectors.toCollection(TreeSet::new));//Como te dice que quiere una lista ordenada alfabeticamente usas un Treeset
    }

    public static List<Donante> encontrarPacientesCompatibles(List<Donante> donantes, int id) {
        Donante receptor = donantes.stream().filter(d -> d.getId_paciente()== id).findFirst().orElse(null);
        if (receptor == null) {
            System.out.println("No hay ningun donante con esa id");
            return Collections.emptyList();
        }

        return donantes.stream().filter(d -> d.getId_paciente()!= receptor.getId_paciente()).filter(d -> esCompatible(d, receptor)).collect(Collectors.toList());
    }

    private static boolean esCompatible(Donante donante, Donante receptor) {
        String d = donante.getGrupoSanguineo()+ donante.getRh();
        String r = receptor.getGrupoSanguineo()+ receptor.getRh();

        switch (r) {
            case "0-":
                return d.equals("0-");
            case "0+":
                return d.equals("0-") || d.equals("0+");
            case "A-":
                return d.equals("0-") || d.equals("A-");
            case "A+":
                return Set.of("0-", "0+", "A-", "A+").contains(d);
            case "B-":
                return d.equals("0-") || d.equals("B-");
            case "B+":
                return Set.of("0-", "0+", "B-", "B+").contains(d);
            case "AB+":
                return Set.of("0-", "0+", "B-", "B+", "A+", "A-", "AB-", "AB+").contains(d);
            case "AB-":
                return Set.of("0-", "A-", "B-", "AB-").contains(d);

            default:
                return false;
        }
    }
}
