/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteA;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Traductor {
    // Usamos TreeMap para mantener las claves ordenadas alfabéticamente
    // TreeMap implementa la interfaz Map y mantiene las claves ordenadas
    private final Map<String, String> diccionario;
    
    // Constructor que inicializa el traductor vacío
    public Traductor() {
        // TreeMap ordenará automáticamente las palabras extranjeras (claves)
        diccionario = new TreeMap<>();
    }
    
    // Método para añadir una nueva traducción al diccionario
    public void guardarTraduccion(String palabraExtranjera, String palabraEspanol) {
        // El método put() de Map asocia una clave con un valor
        // Si la clave ya existe, el valor anterior se reemplaza
        diccionario.put(palabraExtranjera, palabraEspanol);
    }
    
    // Método para obtener la traducción de una palabra
    public String traducir(String palabraExtranjera) {
        // El método get() de Map devuelve el valor asociado a la clave
        // Si la clave no existe, devuelve null
        return diccionario.get(palabraExtranjera);
    }
    
    // Método para borrar una entrada del diccionario
    public void borrarTraduccion(String palabraExtranjera) {
        // El método remove() elimina la entrada para la clave especificada
        diccionario.remove(palabraExtranjera);
    }
    
    // Método para modificar una traducción existente
    public void modificarTraduccion(String palabraExtranjera, String nuevaTraduccion) {
        // Verificamos primero si la palabra existe en el diccionario
        if (diccionario.containsKey(palabraExtranjera)) {
            // Si existe, actualizamos su traducción
            diccionario.put(palabraExtranjera, nuevaTraduccion);
        }
    }
    
    // Método para obtener todas las palabras extranjeras (claves)
    public List<String> obtenerPalabrasExtranjeras() {
        // El método keySet() devuelve un conjunto con todas las claves
        // Lo convertimos a List para mayor facilidad de uso
        return new ArrayList<>(diccionario.keySet());
    }
    
    // Método para obtener todas las palabras en español (valores)
    public List<String> obtenerPalabrasEspanol() {
        // El método values() devuelve una colección con todos los valores
        // Lo convertimos a List para mayor facilidad de uso
        return new ArrayList<>(diccionario.values());
    }
    
    // Método para mostrar todo el contenido del diccionario
    public void mostrarDiccionario() {
        // Recorremos el Map usando un bucle for-each
        // El método entrySet() devuelve un conjunto de pares clave-valor
        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
            System.out.println(entrada.getKey() + " = " + entrada.getValue());
        }
    }
}