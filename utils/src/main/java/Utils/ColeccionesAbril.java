package Utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casa
 */
public class ColeccionesAbril {
    /*
***********************************************************************************************************************************************************************************************************************************
    ArrayList
Qué es: Una lista que puede cambiar de tamaño. Imagina una fila de personas donde puedes añadir o quitar gente fácilmente.
Cómo se inicializa:
Java
ArrayList<String> listaDeNombres = new ArrayList<>();
ArrayList<Integer> listaDeNumeros = new ArrayList<>();

Instancias comunes: Crear una lista vacía para llenarla después.
Métodos comunes:
add(elemento): Añade un elemento al final.
get(indice): Obtiene el elemento en la posición indicada.
set(indice, elemento): Cambia el elemento en la posición indicada.
remove(indice): Elimina el elemento en la posición indicada.
size(): Dice cuántos elementos hay en la lista.
***********************************************************************************************************************************************************************************************************************************
LinkedList
Qué es: Otra forma de lista donde los elementos están unidos como una cadena. Añadir o quitar elementos al principio o al final es muy rápido.
Cómo se inicializa:
Java
LinkedList<String> listaEnlazadaDeNombres = new LinkedList<>();

Instancias comunes: Similar a ArrayList, crear una lista vacía.
Métodos comunes: Tiene muchos métodos similares a ArrayList (add, get, set, remove, size), pero también tiene métodos especiales para trabajar con el principio y el final de la lista 
(como addFirst, addLast, getFirst, getLast, removeFirst, removeLast).

***********************************************************************************************************************************************************************************************************************************
HashSet
Qué es: Un conjunto de elementos únicos. Imagina una bolsa donde solo puedes meter una vez cada objeto. No importa el orden en que los metes, no se guardan en ningún orden específico.
Cómo se inicializa:
Java
HashSet<String> conjuntoDeNombresUnicos = new HashSet<>();

Instancias comunes: Para guardar elementos sin repeticiones.
Métodos comunes:
add(elemento): Añade un elemento si no está ya en el conjunto.
contains(elemento): Dice si el elemento está en el conjunto.
remove(elemento): Elimina el elemento del conjunto.
size(): Dice cuántos elementos únicos hay.

    ***********************************************************************************************************************************************************************************************************************************
    TreeSet
Qué es: Un conjunto de elementos únicos, pero además los guarda ordenados. Imagina una lista de palabras que se ordenan alfabéticamente a medida que las añades.
Cómo se inicializa:
Java
TreeSet<String> conjuntoOrdenadoDeNombres = new TreeSet<>();

Instancias comunes: Para tener elementos únicos y siempre ordenados.
Métodos comunes: Similar a HashSet (add, contains, remove, size), pero los elementos se mantienen en orden.

    ***********************************************************************************************************************************************************************************************************************************
    LinkedHashSet
Qué es: Un conjunto de elementos únicos, y recuerda el orden en que los añadiste. Imagina una fila de personas donde no se repiten, y se acuerda quién llegó primero, segundo, etc.
Cómo se inicializa:
Java
LinkedHashSet<String> conjuntoConOrdenDeInsercion = new LinkedHashSet<>();

Instancias comunes: Cuando necesitas elementos únicos y también recordar el orden en que fueron añadidos.
Métodos comunes: Similar a HashSet (add, contains, remove, size), pero mantiene el orden de inserción.

    ***********************************************************************************************************************************************************************************************************************************
    HashMap
Qué es: Una colección de pares "clave-valor". Imagina un diccionario donde buscas una palabra (la clave) para encontrar su significado (el valor). Las claves deben ser únicas.
Cómo se inicializa:
Java
HashMap<String, String> diccionario = new HashMap<>();
HashMap<String, Integer> edades = new HashMap<>();

Instancias comunes: Para guardar información donde puedes buscar algo rápidamente usando una clave.
Métodos comunes:
put(clave, valor): Añade un par clave-valor al mapa.
get(clave): Obtiene el valor asociado a una clave.
containsKey(clave): Dice si el mapa tiene una clave específica.
remove(clave): Elimina el par clave-valor asociado a una clave.
size(): Dice cuántos pares clave-valor hay.

    ***********************************************************************************************************************************************************************************************************************************
    TreeMap
Qué es: Un mapa de pares "clave-valor" donde las claves se guardan ordenadas. Imagina un diccionario donde las palabras (claves) están en orden alfabético.
Cómo se inicializa:
Java
TreeMap<String, String> diccionarioOrdenado = new TreeMap<>();

Instancias comunes: Cuando necesitas un mapa donde las claves estén siempre ordenadas.
Métodos comunes: Similar a HashMap (put, get, containsKey, remove, size), pero las claves se mantienen en orden.

    ***********************************************************************************************************************************************************************************************************************************
    LinkedHashMap
Qué es: Un mapa de pares "clave-valor" que recuerda el orden en que se insertaron las claves. Imagina un diccionario que recuerda en qué orden añadiste las palabras.
Cómo se inicializa:
Java
LinkedHashMap<String, String> diccionarioConOrden = new LinkedHashMap<>();

Instancias comunes: Cuando necesitas un mapa y también recordar el orden de inserción de las claves.
Métodos comunes: Similar a HashMap (put, get, containsKey, remove, size), pero mantiene el orden de inserción de las claves.

    */
}
