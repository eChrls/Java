/*
 1. Crear tres listas:
   - Lista1: Todos los caracteres del texto convertidos a minúsculas
   - Lista2: Las posiciones de todas las vocales
   - Lista3: Las posiciones de todos los espacios y signos de puntuación

2. Operaciones a realizar:
   - Ordenar Lista1 alfabéticamente
   - Invertir el orden de Lista2
   - Encontrar la distancia media entre las posiciones en Lista2 (distancia entre vocales)
   - Eliminar de Lista1 todos los caracteres cuyas posiciones estén en Lista3
   - Crear una nueva lista (Lista4) que contenga las consonantes que aparecen más de una vez

3. Operaciones avanzadas:
   - Encontrar la vocal que más veces se repite y en qué posiciones aparece
   - Calcular el porcentaje de consonantes vs vocales en el texto original
   - Crear una lista de pares (carácter, frecuencia) ordenada por frecuencia descendente
   - Si hay más de 5 consonantes diferentes, crear dos sublistas: 
     * Una con las 3 consonantes más frecuentes y sus posiciones
     * Otra con las 3 consonantes menos frecuentes y sus posiciones

4. Mostrar:
   - Todas las listas generadas
   - La estadística de vocales y consonantes
   - La distancia media entre vocales
   - Los pares (carácter, frecuencia)
 */
package EjerciciosNavidad;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.*;

public class TextAnalyzer {
    // Texto de ejemplo para analizar
    private final String texto;
    // Listas principales requeridas por el ejercicio
    private List<Character> lista1;
    private List<Integer> lista2;
    private List<Integer> lista3;
    private List<Character> lista4;
    
    public TextAnalyzer(String texto) {
        this.texto = texto;
        this.inicializarListas();
    }
    
    private void inicializarListas() {
        // Lista1: Convertimos todos los caracteres a minúsculas
        lista1 = texto.toLowerCase().chars()
                     .mapToObj(ch -> (char)ch)
                     .collect(Collectors.toList());
        
        // Lista2: Encontramos las posiciones de todas las vocales
        lista2 = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if ("aeiouáéíóúü".indexOf(c) != -1) {
                lista2.add(i);
            }
        }
        
        // Lista3: Posiciones de espacios y signos de puntuación
        lista3 = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isWhitespace(c) || !Character.isLetterOrDigit(c)) {
                lista3.add(i);
            }
        }
    }
    
    public void ordenarLista1() {
        // Ordenamos Lista1 alfabéticamente
        Collections.sort(lista1);
    }
    
    public void invertirLista2() {
        // Invertimos el orden de la lista de posiciones de vocales
        Collections.reverse(lista2);
    }
    
    public double calcularDistanciaMediaVocales() {
        // Calculamos la distancia media entre vocales
        if (lista2.size() < 2) return 0;
        
        double sumaDistancias = 0;
        for (int i = 0; i < lista2.size() - 1; i++) {
            sumaDistancias += lista2.get(i + 1) - lista2.get(i);
        }
        return sumaDistancias / (lista2.size() - 1);
    }
    
    public void eliminarCaracteresLista3() {
        // Eliminamos de Lista1 los caracteres en las posiciones de Lista3
        List<Character> nuevaLista1 = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            if (!lista3.contains(i)) {
                nuevaLista1.add(lista1.get(i));
            }
        }
        lista1 = nuevaLista1;
    }
    
    public void crearLista4() {
        // Creamos Lista4 con consonantes que aparecen más de una vez
        Map<Character, Long> frecuencias = lista1.stream()
            .filter(c -> !"aeiouáéíóúü".contains(String.valueOf(c)))
            .filter(Character::isLetter)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        lista4 = frecuencias.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    public Map<Character, List<Integer>> encontrarVocalMasRepetida() {
        // Encontramos la vocal que más se repite y sus posiciones
        Map<Character, List<Integer>> posicionesVocales = new HashMap<>();
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if ("aeiouáéíóúü".indexOf(c) != -1) {
                posicionesVocales.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }
        }
        
        return posicionesVocales.entrySet().stream()
            .max(Map.Entry.comparingByValue(Comparator.comparingInt(List::size)))
            .map(entry -> Map.of(entry.getKey(), entry.getValue()))
            .orElse(Collections.emptyMap());
    }
    
    public Map<String, Double> calcularPorcentajeConsonantesVocales() {
        // Calculamos el porcentaje de consonantes vs vocales
        long totalLetras = texto.chars()
            .mapToObj(ch -> (char)ch)
            .filter(Character::isLetter)
            .count();
        
        double porcentajeVocales = (lista2.size() * 100.0) / totalLetras;
        double porcentajeConsonantes = 100 - porcentajeVocales;
        
        return Map.of(
            "vocales", porcentajeVocales,
            "consonantes", porcentajeConsonantes
        );
    }
    
    public List<Map.Entry<Character, Long>> obtenerFrecuenciasOrdenadas() {
        // Creamos lista de pares (carácter, frecuencia) ordenada
        return texto.toLowerCase().chars()
            .mapToObj(ch -> (char)ch)
            .filter(Character::isLetter)
            .collect(Collectors.groupingBy(
                ch -> ch,
                Collectors.counting()
            ))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
            .collect(Collectors.toList());
    }
    
    public Map<String, List<Map.Entry<Character, List<Integer>>>> obtenerConsonantesFrecuentes() {
        // Creamos sublistas de consonantes más y menos frecuentes
        Map<Character, List<Integer>> posicionesConsonantes = new HashMap<>();
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (Character.isLetter(c) && "aeiouáéíóúü".indexOf(c) == -1) {
                posicionesConsonantes.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }
        }
        
        if (posicionesConsonantes.size() <= 5) return Collections.emptyMap();
        
        List<Map.Entry<Character, List<Integer>>> ordenadas = 
            posicionesConsonantes.entrySet().stream()
                .sorted(Map.Entry.<Character, List<Integer>>comparingByValue(
                    Comparator.comparingInt(List::size)).reversed())
                .collect(Collectors.toList());
        
        return Map.of(
            "masFrecuentes", ordenadas.subList(0, 3),
            "menosFrecuentes", ordenadas.subList(ordenadas.size() - 3, ordenadas.size())
        );
    }
    
    // Métodos para obtener las listas
    public List<Character> getLista1() { return lista1; }
    public List<Integer> getLista2() { return lista2; }
    public List<Integer> getLista3() { return lista3; }
    public List<Character> getLista4() { return lista4; }
}

    

        
        
    

        
      
        
        
        
        
        
        
        
        
    
    

