package docs;

public class ReadMe {
    /**
     * EJERCICIOS DE MAP EN JAVA
     * 
     * Este proyecto contiene tres ejercicios que demuestran el uso de la interfaz Map en Java
     * y sus implementaciones (principalmente TreeMap y HashMap). Los ejercicios están organizados
     * en tres paquetes: paquetea, paqueteb y paquetec.
     * 
     * ## PARTE A: Traductor de Palabras (paquetea)
     * 
     * Este ejercicio implementa un traductor de palabras utilizando TreeMap.
     * 
     * - Funcionamiento: Asocia palabras extranjeras (claves) con sus traducciones al español (valores).
     * - Componentes:
     *   - TreeMap<String, String>: Estructura de datos que mantiene las claves ordenadas alfabéticamente.
     *   - Métodos principales:
     *     - guardarTraduccion(): Añade una nueva traducción o sustituye una existente.
     *     - traducir(): Obtiene la traducción de una palabra.
     *     - borrarTraduccion(): Elimina una entrada del diccionario.
     *     - modificarTraduccion(): Cambia la traducción de una palabra existente.
     *     - obtenerPalabrasExtranjeras(): Devuelve una lista con todas las palabras extranjeras.
     *     - obtenerPalabrasEspanol(): Devuelve una lista con todas las traducciones.
     * 
     * ## PARTE B: Sistema de Lotería (paqueteb)
     * 
     * Este ejercicio implementa un sistema para almacenar números de décimos de lotería y sus premios.
     * 
     * - Funcionamiento: Asocia números de décimos (claves) con sus premios correspondientes (valores).
     * - Componentes:
     *   - HashMap<String, Double>: Estructura de datos que permite acceso rápido a los elementos.
     *   - Métodos principales:
     *     - registrarDecimo(): Guarda un décimo con su premio.
     *     - formatearNumeroDecimo(): Añade ceros a la izquierda para mantener el formato correcto.
     *     - consultarPremio(): Busca el premio asociado a un décimo.
     *     - generarDecimosAleatorios(): Crea múltiples décimos con premios aleatorios.
     * 
     * ## PARTE C: Gestor de Vaquerías (paquetec)
     * 
     * Este ejercicio implementa un sistema para gestionar objetos de tipo Vaquería usando identificadores únicos.
     * 
     * - Funcionamiento: Asocia identificadores únicos (claves) con objetos Vaquería (valores).
     * - Componentes:
     *   - HashMap<String, Vaqueria>: Estructura de datos para almacenar las vaquerías.
     *   - Métodos principales:
     *     - guardarVaqueria(): Asocia una vaquería con su identificador.
     *     - obtenerVaqueria(): Recupera una vaquería según su identificador.
     *     - obtenerTodasVaquerias(): Devuelve una colección con todas las vaquerías.
     *     - eliminarVaqueria(): Elimina una vaquería según su identificador.
     *     - existeVaqueria(): Verifica si existe una vaquería con un identificador dado.
     * 
     * CARACTERÍSTICAS COMUNES DE LOS MAPS:
     * 
     * 1. Almacenan pares clave-valor: Cada elemento consta de una clave única y su valor asociado.
     * 2. No permiten claves duplicadas: Si se añade una clave que ya existe, el valor anterior se reemplaza.
     * 3. Métodos principales:
     *    - put(K key, V value): Asocia la clave especificada con el valor dado.
     *    - get(Object key): Devuelve el valor asociado a la clave.
     *    - remove(Object key): Elimina la entrada para la clave especificada.
     *    - containsKey(Object key): Comprueba si el map contiene la clave especificada.
     *    - keySet(): Devuelve un conjunto con todas las claves.
     *    - values(): Devuelve una colección con todos los valores.
     *    - entrySet(): Devuelve un conjunto de pares clave-valor.
     *    - size(): Devuelve el número de entradas en el map.
     * 
     * IMPLEMENTACIONES UTILIZADAS:
     * 
     * 1. TreeMap: Mantiene las claves ordenadas según su orden natural o un comparador.
     *    Usado en el Traductor para ordenar alfabéticamente las palabras extranjeras.
     * 
     * 2. HashMap: Implementación más eficiente para operaciones básicas (get, put).
     *    Usado en el Sistema de Lotería y el Gestor de Vaquerías para acceso rápido.
     */
    
    public static void main(String[] args) {
        System.out.println("Consulta este archivo para obtener información detallada sobre los ejercicios.");
    }
}