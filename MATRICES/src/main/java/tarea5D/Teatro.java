/**
 * Ejercicio 3
 * Clase Teatro: Representa un teatro con asientos organizados en filas y columnas.
 * Permite reservar y liberar asientos, además de mostrar el estado actual.
 * 
 * Los asientos se representan en una matriz bidimensional de valores booleanos:
 * - false: asiento libre (se muestra como "L")
 * - true: asiento ocupado (se muestra como "R")
 * 
 * Las restricciones del teatro son:
 * - El número de filas debe estar entre 1 y 5
 * - El número de columnas es siempre el doble de filas
 */
package tarea5D;

public class Teatro {
    // Matriz que representa los asientos: true = ocupado (R), false = libre (L)
    private boolean[][] asientos;
    
    private int filas;
    private int columnas;
    
    /**
     * Constructor que inicializa el teatro con un número específico de filas.
     * El número de columnas se calcula automáticamente como el doble de filas.
     */
    public Teatro(int numFilas) {
        // Controlamos que el número de filas cumpla con las restricciones
        if (numFilas > 5 || numFilas <= 0) {
            System.out.println("Error: El teatro debe tener entre 1 y 5 filas.");
            return;
        }
        
        // Inicializamos las dimensiones del teatro
        this.filas = numFilas;
        this.columnas = numFilas * 2;
        
        // Creamos la matriz de asientos
        asientos = new boolean[filas][columnas];
        
        // Inicializamos todos los asientos como libres (false)
        inicializarAsientos();
        
        System.out.println("Teatro creado con " + filas + " filas y " + columnas + " columnas.");
    }
    
    /**
     * Método privado para inicializar todos los asientos como libres (false).
     * Utiliza un bucle anidado para recorrer toda la matriz.
     */
    private void inicializarAsientos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = false;
            }
        }
    }
    
    /**
     * Método para reservar un asiento específico.
     * 
     * @param identificador Identificador del asiento (ej: "1A", "2B", "3C")
     */
    public void reservarAsiento(String identificador) {
        try {
            // Convertimos el identificador a coordenadas de la matriz
            int[] coordenadas = convertirIdentificadorACoordenadas(identificador);
            int fila = coordenadas[0];
            int columna = coordenadas[1];
            
            // Verificamos si el asiento ya está ocupado
            if (asientos[fila][columna]) {
                System.out.println("El asiento " + identificador + " ya está ocupado.");
            } else {
                // Marcamos el asiento como ocupado
                asientos[fila][columna] = true;
                System.out.println("Asiento " + identificador + " reservado correctamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método para liberar un asiento previamente reservado.
     * 
     * @param identificador Identificador del asiento (ej: "1A", "2B", "3C")
     */
    public void liberarAsiento(String identificador) {
        try {
            // Convertimos el identificador a coordenadas de la matriz
            int[] coordenadas = convertirIdentificadorACoordenadas(identificador);
            int fila = coordenadas[0];
            int columna = coordenadas[1];
            
            // Verificamos si el asiento ya está libre
            if (!asientos[fila][columna]) {
                System.out.println("El asiento " + identificador + " ya está libre.");
            } else {
                // Marcamos el asiento como libre
                asientos[fila][columna] = false;
                System.out.println("Asiento " + identificador + " liberado correctamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método privado para convertir un identificador de asiento a coordenadas de matriz.
     * Maneja la conversión de formatos como "1A", "2B", etc. a índices [fila, columna].
     * @param identificador Identificador del asiento en formato "FilaColumna"
     */
    private int[] convertirIdentificadorACoordenadas(String identificador) throws IllegalArgumentException {
        // Verificamos que el identificador tenga el formato correcto
        if (identificador == null || identificador.length() != 2) {
            throw new IllegalArgumentException("Identificador inválido: " + identificador);
        }
        
        try {
            // Extraemos la fila y columna del identificador
            int fila = Character.getNumericValue(identificador.charAt(0)) - 1; // Restamos 1 porque los arrays empiezan en 0
            char columnaLetra = identificador.charAt(1);
            int columna = columnaLetra - 'A'; // Convertimos la letra a índice (A=0, B=1, etc.)
            
            // Controlamos que las coordenadas estén dentro de los límites de la matriz
            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                throw new IllegalArgumentException("Error: El asiento " + identificador + " no existe.");
            }
            
            return new int[] {fila, columna};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Formato de identificador inválido: " + identificador);
        }
    }
    
    /**
     * Método para mostrar el estado actual del teatro.
     * Imprime una representación visual del teatro con los asientos libres (L) y ocupados (R).
     */
    public void mostrarEstado() {
        // Imprimimos el encabezado con las letras de las columnas
        System.out.print("  ");
        for (int j = 0; j < columnas; j++) {
            // Convertimos el índice numérico a letra: 0->A, 1->B, 2->C, etc.
            System.out.print(" " + (char)('A' + j) + " ");
        }
        System.out.println();
        
        // Recorremos la matriz para mostrar el estado de cada asiento
        for (int i = 0; i < filas; i++) {
            // Imprimimos el número de fila (sumamos 1 para mostrar desde 1, no desde 0)
            System.out.print((i + 1) + " ");
            
            // Recorremos cada columna de la fila actual
            for (int j = 0; j < columnas; j++) {
                // Mostramos "R" (reservado) o "L" (libre) según el estado del asiento
                char estado = asientos[i][j] ? 'R' : 'L';
                System.out.print(" " + estado + " ");
            }
            // Salto de línea al terminar cada fila
            System.out.println();
        }
    }
}