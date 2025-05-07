/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen_final;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MetodosGestion {
    // Índice de métodos:
    // 1. binarySearchPorNombre
    // 2. comparatorPorNombreYGoles
    // 3. filtrarEntreFechas
    // 4. filtrarMayorGoles
    // 5. mapNombreFecha
    // 6. mapDorsalGoles
    // 7. mediaGoles
    // 8. sumaDorsales
    // 9. sumaGoles
    // 10. sumaDorsalesConSum
    // 11. modificarFecha
    // 12. contarDorsalesPares
    // 13. nombresConAMayus
    // 14. limpiarNombres
    // 15. top3PorSalario
    // 16. existeSalarioMayorA
    // 17. agruparPorInicialYPar
    // 18. futbolistaConMasGoles
    // 19. contarFutbolistasEntreFechas
    // 20. mediaGolesEntreFechas
    // 21. totalFutbolistas
    // 22. futbolistaConMenosGoles
    // 23. sumaGolesEntreFechas
    // 24. contarFutbolistasPorFecha
    // 25. mediaGolesPorFecha
    
    public static int binarySearchPorNombre(List<Futbolista> lista, Futbolista f) {
        Comparator<Futbolista> comp = Comparator.comparing(Futbolista::getNombre);
        Collections.sort(lista, comp);
        return Collections.binarySearch(lista, f, comp);
    }

    public static Comparator<Futbolista> comparatorPorNombreYGoles() {
        return Comparator.comparing(Futbolista::getNombre)
                .thenComparing(Futbolista::getGolesPorPartido);
    }

    public static List<Futbolista> filtrarEntreFechas(List<Futbolista> lista, LocalDate ini, LocalDate fin) {
        return lista.stream()
                .filter(f -> !f.getFechaFichaje().isBefore(ini) && !f.getFechaFichaje().isAfter(fin))
                .sorted(Comparator.comparing(Futbolista::getNombre))
                .toList();
    }

    public static List<Futbolista> filtrarMayorGoles(List<Futbolista> lista, double umbral) {
        return lista.stream()
                .filter(f -> f.getGolesPorPartido() > umbral)
                .toList();
    }

    public static Map<String, LocalDate> mapNombreFecha(List<Futbolista> lista) {
        return lista.stream()
                .collect(Collectors.toMap(Futbolista::getNombre, Futbolista::getFechaFichaje));
    }

    public static Map<Integer, Double> mapDorsalGoles(List<Futbolista> lista) {
        return lista.stream()
                .collect(Collectors.toMap(Futbolista::getDorsal, Futbolista::getGolesPorPartido));
    }

    public static double mediaGoles(List<Futbolista> lista) {
        return lista.stream()
                .mapToDouble(Futbolista::getGolesPorPartido)
                .average()
                .orElse(0);
    }

    public static int sumaDorsales(List<Futbolista> lista) {
        return lista.stream()
                .map(Futbolista::getDorsal)
                .reduce(0, Integer::sum);
    }

    public static double sumaGoles(List<Futbolista> lista) {
        return lista.stream()
                .mapToDouble(Futbolista::getGolesPorPartido)
                .sum();
    }

    public static int sumaDorsalesConSum(List<Futbolista> lista) {
        return lista.stream()
                .mapToInt(Futbolista::getDorsal)
                .sum();
    }

    public static List<LocalDate> modificarFecha(List<Futbolista> lista) {
        return lista.stream()
                .map(f -> f.getFechaFichaje().plusMonths(1))
                .toList();
    }

    public static long contarDorsalesPares(List<Futbolista> lista) {
        return lista.stream()
                .filter(f -> f.getDorsal() % 2 == 0)
                .count();
    }

    public static List<String> nombresConAMayus(List<Futbolista> lista) {
        return lista.stream()
                .map(Futbolista::getNombre)
                .map(n -> n.startsWith("A") ? n.toUpperCase() : n)
                .toList();
    }

    public static List<String> limpiarNombres(List<Futbolista> lista) {
        return lista.stream()
                .map(Futbolista::getNombre)
                .map(n -> n.replace(" ", "").replace(";", ""))
                .toList();
    }

    public static List<String> top3PorSalario(List<Futbolista> lista) {
        return lista.stream()
                .sorted((f1, f2) -> Double.compare(
                f2.getGolesPorPartido() * f2.getEstado().getMultiplicadorSalario(),
                f1.getGolesPorPartido() * f1.getEstado().getMultiplicadorSalario()))
                .limit(3)
                .map(Futbolista::getNombre)
                .toList();
    }

    public static boolean existeSalarioMayorA(List<Futbolista> lista, double umbral) {
        return lista.stream()
                .anyMatch(f -> f.getGolesPorPartido() * f.getEstado().getMultiplicadorSalario() > umbral);
    }

    public static Map<Character, List<Futbolista>> agruparPorInicialYPar(List<Futbolista> lista) {
        return lista.stream()
                .filter(f -> f.getDorsal() % 2 == 0)
                .filter(f -> {
                    char c = Character.toUpperCase(f.getNombre().charAt(0));
                    return c == 'A' || c == 'B' || c == 'C';
                })
                .sorted(Comparator.comparing(Futbolista::getNombre))
                .collect(Collectors.groupingBy(f -> Character.toUpperCase(f.getNombre().charAt(0))));
   
    }

    public static Optional<Futbolista> futbolistaConMasGoles(List<Futbolista> lista) {
        return lista.stream()
                    .max(Comparator.comparingDouble(Futbolista::getGolesPorPartido));
    }

    public static long contarFutbolistasEntreFechas(List<Futbolista> lista, LocalDate ini, LocalDate fin) {
        return lista.stream()
                    .filter(f -> !f.getFechaFichaje().isBefore(ini) && !f.getFechaFichaje().isAfter(fin))
                    .count();
    }

    public static double mediaGolesEntreFechas(List<Futbolista> lista, LocalDate ini, LocalDate fin) {
        return lista.stream()
                    .filter(f -> !f.getFechaFichaje().isBefore(ini) && !f.getFechaFichaje().isAfter(fin))
                    .mapToDouble(Futbolista::getGolesPorPartido)
                    .average()
                    .orElse(0.0);
    }

    public static long totalFutbolistas(List<Futbolista> lista) {
        return lista.size();
    }

    public static Optional<Futbolista> futbolistaConMenosGoles(List<Futbolista> lista) {
        return lista.stream()
                    .min(Comparator.comparingDouble(Futbolista::getGolesPorPartido));
    }

    public static double sumaGolesEntreFechas(List<Futbolista> lista, LocalDate ini, LocalDate fin) {
        return lista.stream()
                    .filter(f -> !f.getFechaFichaje().isBefore(ini) && !f.getFechaFichaje().isAfter(fin))
                    .mapToDouble(Futbolista::getGolesPorPartido)
                    .sum();
    }

    public static Map<LocalDate, Long> contarFutbolistasPorFecha(List<Futbolista> lista) {
        return lista.stream()
                    .collect(Collectors.groupingBy(
                        Futbolista::getFechaFichaje,
                        TreeMap::new,
                        Collectors.counting()
                    ));
    }

    public static Map<LocalDate, Double> mediaGolesPorFecha(List<Futbolista> lista) {
        return lista.stream()
                    .collect(Collectors.groupingBy(
                        Futbolista::getFechaFichaje,
                        TreeMap::new,
                        Collectors.averagingDouble(Futbolista::getGolesPorPartido)
                    ));
    }

}
