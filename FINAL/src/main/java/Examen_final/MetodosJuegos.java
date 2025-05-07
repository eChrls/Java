package Examen_final;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

public class MetodosJuegos {

    /**
     * 1- Índice de métodos de la clase: 
     * - encontrarCartaParaEscaleraColor:
     * Devuelve la carta que completa una escalera de color o "NADA" si no es
     * posible. 
     * - convertirNumeroACarta: Convierte un número a su representación
     * de carta (A, J, Q, K o el número). 
     * - generarHorarioCurso: Crea una matriz semanal (5 días, 6 horas) con las clases de un curso dado. 
     * - colocarFichaDomino: Coloca una ficha en el tablero si la posición está
     * vacía y es válida. 
     * - piezasEnFila: Devuelve una lista con las piezas que hay en una fila del tablero. 
     * - hayLineaCompleta: Verifica si hay alguna fila completamente marcada en el cartón de bingo. 
     * - moverFicha: Mueve una* ficha a una nueva posición si está dentro del tablero y vacía. 
     * - contarDiagonalPrincipal: Cuenta cuántas fichas iguales hay en una diagonal (↘). 
     * - comprobarBingo: Comprueba si algún cartón tiene línea completa con los números del bingo. 
     * - comprobarBlackjack: Comprueba si alguna línea del fichero tiene una suma de 21 en formato tipo KD, 10T, etc. 
     * - hayCuatroEnRaya: Comprueba si hay 4 fichas iguales seguidas (horizontal, vertical o diagonal). 
     * - identificarJugada: Dada una lista de cartas devuelve la jugada: trío, escalera, color, etc. 
     * - analizarBarcos: Lee matriz 20x20 de '1', '0', 'X' y cuenta barcos enteros, dañados hundidos. 
     * - dfsBarco: Método auxiliar para la búsqueda en profundidad de componentes de barcos. 
     * - buscarPalabrasSopa: Busca palabras de una lista en una matriz tipo sopa de letras. 
     * - buscarDesde: Método auxiliar para buscar una palabra desde una posición en todas direcciones. 
     * - existeCaminoLaberinto: Comprueba si existe un camino desde (0,0) hasta (n-1,m-1) en un laberinto
     * (0 = camino, 1 = muro) usando BFS iterativa.
     * - validarSudoku: Valida un Sudoku 9×9 comprobando que no haya duplicados en
     * filas, columnas y bloques 3×3. 
     * - revelarBuscaminas: Revela celdas en un tablero de Buscaminas sin usar recursividad: si posición es '0', hace
     * flood-fill iterativo; marca en visto[][].
     */
    /**
     * Devuelve la carta que completa una escalera de color o "NADA" si no es
     * posible
     */
        public static boolean contieneEscaleraDeColorEnFila(String mano) {
        String[] cartasArray = mano.split(" ");
        List<String> cartas = new ArrayList<>(List.of(cartasArray));
        return verificarEscaleraDeColor(cartas);
    }

    /**
     * Verifica si una lista de cartas contiene una escalera de color.
     */
    public static boolean verificarEscaleraDeColor(List<String> cartas) {
        if (cartas == null || cartas.size() < 5) {
            return false;
        }

        Map<String, List<Integer>> porPalo = new HashMap<>();

        for (String carta : cartas) {
            String[] partes = carta.split(" ");
            if (partes.length == 2) {
                String valor = partes[0];
                String palo = partes[1];
                int num = convertirValorACNumero(valor);
                porPalo.computeIfAbsent(palo, k -> new ArrayList<>()).add(num);
            }
        }

        for (Map.Entry<String, List<Integer>> entrada : porPalo.entrySet()) {
            List<Integer> nums = entrada.getValue();
            if (nums.size() >= 5) {
                Collections.sort(nums);
                // Eliminar duplicados para verificar secuencias únicas
                List<Integer> uniqueNums = nums.stream().distinct().collect(Collectors.toList());

                if (uniqueNums.size() >= 5) {
                    for (int i = 0; i <= uniqueNums.size() - 5; i++) {
                        boolean escalera = true;
                        for (int j = 1; j < 5; j++) {
                            if (uniqueNums.get(i + j) != uniqueNums.get(i + j - 1) + 1) {
                                escalera = false;
                                break;
                            }
                        }
                        if (escalera) {
                            return true; // Se encontró una escalera de color en este palo
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * Convierte el valor de una carta (A, K, Q, J, número) a su representación numérica.
     */
    private static int convertirValorACNumero(String valor) {
        return switch (valor) {
            case "A" -> 1;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(valor);
        };
    }

    // Puedes añadir aquí el método para leer la lista desde el fichero si aún no lo tienes integrado
    public static List<String> leerManosDesdeFichero(String rutaFichero) {
        List<String> manos = new ArrayList<>();
        try {
            List<String> lineas = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(rutaFichero));
            manos.addAll(lineas);
        } catch (java.io.IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        return manos;
    }

    public static void main(String[] args) {
        String rutaFichero = "ruta/del/fichero_cartas.txt"; // Reemplaza con la ruta de tu fichero
        List<String> manos = leerManosDesdeFichero(rutaFichero);

        for (int i = 0; i < manos.size(); i++) {
            String mano = manos.get(i);
            boolean escaleraColor = contieneEscaleraDeColorEnFila(mano);
            System.out.println("Mano " + (i + 1) + ": " + mano + " - Contiene escalera de color: " + escaleraColor);
        }

        // Ejemplo de uso directo del método verificarEscaleraDeColor con una lista de cartas
        List<String> ejemploMano = List.of("3 D", "4 D", "5 D", "6 D", "7 D", "2 C");
        boolean escaleraEjemplo = verificarEscaleraDeColor(ejemploMano);
        System.out.println("\nEjemplo de mano: " + ejemploMano + " - Contiene escalera de color: " + escaleraEjemplo);
    }
}
    public static String encontrarCartaParaEscaleraColor(List<String> cartas) {
        // Agrupa las cartas por su palo. El valor es una lista de los números de las cartas de ese palo.
        Map<String, List<Integer>> porPalo = new HashMap<>();

        // Itera sobre cada carta de la lista de cartas proporcionada.
        for (String carta : cartas) {
            // Divide la carta en valor (ej: "A", "K", "5") y palo (ej: "C", "D", "P", "T").
            String valor = carta.split(" ")[0];
            String palo = carta.split(" ")[1];
            int num = switch (valor) { // Convierte el valor de la carta a un número.
                case "A" ->
                    1;
                case "J" ->
                    11;
                case "Q" ->
                    12;
                case "K" ->
                    13;
                default ->
                    Integer.parseInt(valor);
            };
            // Añade el número de la carta a la lista correspondiente a su palo.
            porPalo.computeIfAbsent(palo, k -> new ArrayList<>()).add(num);
        }

        // Itera sobre cada palo y la lista de números de cartas que tiene ese palo.
        for (Map.Entry<String, List<Integer>> entrada : porPalo.entrySet()) {
            List<Integer> nums = entrada.getValue();
            // Si hay al menos 4 cartas de este palo, intentamos encontrar una escalera de color.
            if (nums.size() >= 4) {
                // Itera sobre posibles inicios de una escalera de 5 cartas (del 1 al 10, ya que la escalera puede ser A-2-3-4-5 hasta 10-J-Q-K-A).
                for (int i = 1; i <= 10; i++) {
                    // Define una posible secuencia de 5 números consecutivos para la escalera.
                    List<Integer> escalera = List.of(i, i + 1, i + 2, i + 3, i + 4);
                    // Crea una copia de la escalera y retiene solo los números que están presentes en las cartas del palo actual.
                    List<Integer> subEscalera = new ArrayList<>(escalera);
                    subEscalera.retainAll(nums);
                    // Si tenemos 4 de las 5 cartas necesarias para la escalera.
                    if (subEscalera.size() == 4) {
                        // Busca el número faltante en la escalera que no está en las cartas del palo actual.
                        int faltante = escalera.stream().filter(n -> !nums.contains(n)).findFirst().orElse(-1);
                        // Si se encontró un número faltante válido.
                        if (faltante != -1) {
                            return convertirNumeroACarta(faltante) + " " + entrada.getKey();
                        }
                    }
                }
            }
        }

        // Si no se encontró ninguna carta que complete una escalera de color.
        return "NADA";
    }

    /**
     * Convierte un número a su representación de carta (A, J, Q, K o el
     * número).
     */
    public static String convertirNumeroACarta(int n) {
        return switch (n) {
            case 1 ->
                "A";
            case 11 ->
                "J";
            case 12 ->
                "Q";
            case 13 ->
                "K";
            default ->
                String.valueOf(n);
        };
    }

    /**
     * Crea una matriz semanal (5 días, 6 horas) con las clases de un curso
     * dado.
     */
    public static String[][] generarHorarioCurso(List<Clase> clases, String curso) {
        // Matriz para representar el horario: 5 días (lunes-viernes), 6 horas (ignorando la hora 4).
        String[][] matriz = new String[5][6];
        // Itera sobre cada clase en la lista de clases proporcionada.
        for (Clase c : clases) {
            // Verifica si la clase pertenece al curso especificado y si la hora y el día están dentro de los límites válidos.
            if (c.getCurso().equalsIgnoreCase(curso) && c.getHora() <= 7 && c.getHora() != 4 && c.getDia() <= 5) {
                // Calcula el índice de la fila (día - 1) y la columna (hora - 1, ajustando para omitir la hora 4).
                int fila = c.getDia() - 1;
                int columna = c.getHora() < 4 ? c.getHora() - 1 : c.getHora() - 2; // Saltamos la columna correspondiente a la hora 4.
                // Asigna la asignatura al horario en la posición calculada.
                matriz[fila][columna] = c.getAsignatura();
            }
        }
        return matriz;
    }

    /**
     * Coloca una ficha en el tablero si la posición está vacía y es válida.
     */
    public static boolean colocarFichaDomino(int[][] tablero, int fila, int col, int ficha) {
        // Verifica si la fila y la columna están dentro de los límites del tablero y si la celda está vacía (valor 0).
        if (fila >= 0 && fila < tablero.length && col >= 0 && col < tablero[0].length && tablero[fila][col] == 0) {
            // Coloca la ficha en la posición especificada.
            tablero[fila][col] = ficha;
            return true; // Indica que la colocación fue exitosa.
        }
        return false; // Indica que la colocación falló (posición inválida o no vacía).
    }

    /**
     * Devuelve una lista con las piezas que hay en una fila del tablero.
     */
    public static List<String> piezasEnFila(String[][] tablero, int fila) {
        // Crea una lista para almacenar las piezas encontradas en la fila.
        List<String> piezas = new ArrayList<>();
        // Itera sobre cada columna de la fila especificada.
        for (int col = 0; col < tablero[fila].length; col++) {
            // Si la celda contiene una pieza (no es nula ni vacía), la añade a la lista.
            if (tablero[fila][col] != null && !tablero[fila][col].isEmpty()) {
                piezas.add(tablero[fila][col]);
            }
        }
        return piezas; // Devuelve la lista de piezas en la fila.
    }

    /**
     * Verifica si hay alguna fila completamente marcada en el cartón de bingo.
     */
    public static boolean hayLineaCompleta(boolean[][] carton) {
        // Itera sobre cada fila del cartón de bingo.
        for (boolean[] fila : carton) {
            boolean completa = true; // Asume que la fila está completa hasta que se encuentre una celda no marcada.
            // Itera sobre cada celda de la fila actual.
            for (boolean celda : fila) {
                // Si la celda no está marcada (es false), la fila no está completa.
                if (!celda) {
                    completa = false;
                    break; // No es necesario seguir verificando la fila.
                }
            }
            // Si después de verificar todas las celdas de la fila, 'completa' sigue siendo true, se encontró una línea completa.
            if (completa) {
                return true;
            }
        }
        // Si no se encontró ninguna línea completa después de verificar todas las filas.
        return false;
    }

    /**
     * Mueve una ficha a una nueva posición si está dentro del tablero y vacía.
     */
    public static boolean moverFicha(String[][] tablero, int fActual, int cActual, int fNueva, int cNueva) {
        // Verifica si la nueva posición está dentro de los límites del tablero y si está vacía (null o vacía).
        if (fNueva >= 0 && fNueva < tablero.length && cNueva >= 0 && cNueva < tablero[0].length
                && (tablero[fNueva][cNueva] == null || tablero[fNueva][cNueva].isEmpty())) {
            // Mueve la ficha de la posición actual a la nueva posición.
            tablero[fNueva][cNueva] = tablero[fActual][cActual];
            // Marca la posición actual como vacía.
            tablero[fActual][cActual] = "";
            return true; // Indica que el movimiento fue exitoso.
        }
        return false; // Indica que el movimiento falló (nueva posición inválida o no vacía).
    }

    /**
     * Cuenta cuántas fichas iguales hay en una diagonal (↘).
     */
    public static int contarDiagonalPrincipal(String[][] tablero, String ficha) {
        int contador = 0; // Inicializa el contador de fichas iguales.
        // Itera sobre la diagonal principal de la matriz (hasta la dimensión más pequeña para evitar errores de índice).
        for (int i = 0; i < Math.min(tablero.length, tablero[0].length); i++) {
            // Si la ficha en la posición actual de la diagonal coincide con la ficha buscada, incrementa el contador.
            if (ficha.equals(tablero[i][i])) {
                contador++;
            }
        }
        return contador; // Devuelve el número total de fichas iguales encontradas en la diagonal principal.
    }

    /**
     * Comprueba si algún cartón tiene línea completa con los números del bingo.
     */
    public static void comprobarBingo(String rutaFichero) throws IOException {
        // Lee todas las líneas del archivo especificado. Cada línea representa un conjunto de números (la primera línea son los números ganadores, las siguientes son los cartones).
        List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));
        // La primera línea contiene los números ganadores del bingo, separados por espacios.
        Set<String> numerosBingo = new HashSet<>(Arrays.asList(lineas.get(0).split(" ")));

        // Itera sobre las líneas restantes del archivo, cada una representando un cartón de bingo.
        for (int i = 1; i < lineas.size(); i++) {
            // Divide la línea del cartón en un array de números (strings).
            String[] carton = lineas.get(i).split(" ");
            // Verifica si todos los números del cartón están presentes en el conjunto de números ganadores.
            if (Arrays.stream(carton).allMatch(numerosBingo::contains)) {
                System.out.println("Cartón " + i + " tiene línea.");
            } else {
                System.out.println("Cartón " + i + " no tiene línea.");
            }
        }
    }

    /**
     * Comprueba si alguna línea del fichero tiene una suma de 21 en formato
     * tipo KD, 10T, etc.
     */
    public static void comprobarBlackjack(String ruta) throws IOException {
        // Lee todas las líneas del archivo especificado. Cada línea representa una mano de cartas.
        List<String> lineas = Files.readAllLines(Paths.get(ruta));

        // Itera sobre cada línea del archivo (cada mano de cartas).
        for (String linea : lineas) {
            // Divide la línea en un array de strings, cada uno representando una carta.
            String[] cartas = linea.trim().split(" ");
            int suma = 0; // Inicializa la suma de los valores de las cartas de la mano actual.
            // Itera sobre cada carta de la mano.
            for (String carta : cartas) {
                // Elimina el palo de la carta (último carácter) para obtener solo el valor.
                String valor = carta.replaceAll("[PTDC]", "");
                // Asigna un valor numérico a la carta según su valor.
                switch (valor) {
                    case "A" ->
                        suma += 1;
                    case "J", "Q", "K" ->
                        suma += 10;
                    default ->
                        suma += Integer.parseInt(valor);
                }
            }
            // Imprime si la suma de la mano es 21 (Blackjack) o la suma obtenida.
            if (suma == 21) {
                System.out.println("Blackjack: " + linea);
            } else {
                System.out.println("No: " + suma);
            }
        }
    }

    /**
     * Comprueba si hay 4 fichas iguales seguidas (horizontal, vertical o
     * diagonal). Utiliza las letras del Enum Ficha: VACIO, AMARILLO, ROJO.
     */
    public static boolean hayCuatroEnRaya(Ficha[][] tablero) {
        int filas = tablero.length;
        int columnas = tablero[0].length;

        // Itera sobre cada celda del tablero.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Ficha actual = tablero[i][j];
                // Si la celda está vacía, no puede ser el inicio de una secuencia de 4.
                if (actual == Ficha.VACIO) {
                    continue;
                }

                // Verifica horizontalmente (hacia la derecha).
                if (j <= columnas - 4
                        && actual == tablero[i][j + 1]
                        && actual == tablero[i][j + 2]
                        && actual == tablero[i][j + 3]) {
                    return true;
                }

                // Verifica verticalmente (hacia abajo).
                if (i <= filas - 4
                        && actual == tablero[i + 1][j]
                        && actual == tablero[i + 2][j]
                        && actual == tablero[i + 3][j]) {
                    return true;
                }

                // Verifica diagonalmente (abajo-derecha).
                if (i <= filas - 4 && j <= columnas - 4
                        && actual == tablero[i + 1][j + 1]
                        && actual == tablero[i + 2][j + 2]
                        && actual == tablero[i + 3][j + 3]) {
                    return true;
                }

                // Verifica diagonalmente (arriba-derecha).
                if (i >= 3 && j <= columnas - 4
                        && actual == tablero[i - 1][j + 1]
                        && actual == tablero[i - 2][j + 2]
                        && actual == tablero[i - 3][j + 3]) {
                    return true;
                }
            }
        }
        return false; // Si no se encontraron 4 fichas iguales seguidas en ninguna dirección.
    }

    enum Ficha {
        VACIO, AMARILLO, ROJO
    }

    /**
     * Dada una lista de cartas devuelve la jugada: trío, escalera, color, etc.
     */
    public static String identificarJugada(List<String> cartas) {
        // Listas y mapas para almacenar información sobre las cartas.
        List & lt;
        Integer > valores = new ArrayList & lt; > ();
        Map & lt;String
        , Integer > palos = new HashMap & lt; > ();
        Map & lt;Integer
        , Integer > repeticiones = new HashMap & lt; > ();
        // Itera sobre cada carta de la lista.
        for (String carta : cartas) {
            // Extrae el valor (ej: "A", "K", "5") y el palo (ej: "C", "D", "P", "T").
            String valor = carta.substring(0, carta.length() - 1);
            String palo = carta.substring(carta.length() - 1);
            // Convierte el valor de la carta a un número.
            int numero = switch (valor) {
                case "A" ->
                    1;
                case "J" ->
                    11;
                case "Q" ->
                    12;
                case "K" ->
                    13;
                default ->
                    Integer.parseInt(valor);
            };
            // Almacena el valor, cuenta la frecuencia de palos y la frecuencia de valores.
            valores.add(numero);
            palos.put(palo, palos.getOrDefault(palo, 0) + 1);
            repeticiones.put(numero, repeticiones.getOrDefault(numero, 0) + 1);
        }

        // Ordena los valores de las cartas para verificar si hay una escalera.
        Collections.sort(valores);
        // Verifica si hay una escalera (valores consecutivos).
        boolean escalera = true;
        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) != valores.get(i - 1) + 1) {
                escalera = false;
            }
        }

        // Determina la jugada basándose en las combinaciones encontradas.
        if (palos.containsValue(5) && escalera) {
            return "Escalera de color";
        }
        if (palos.containsValue(5)) {
            return "Color";
        }
        if (escalera) {
            return "Escalera";
        }
        if (repeticiones.containsValue(4)) {
            return "Póker";
        }
        if (repeticiones.containsValue(3) && repeticiones.containsValue(2)) {
            return "Full"; // Trío y pareja
        }
        if (repeticiones.containsValue(3)) {
            return "Trío";
        }
        if (repeticiones.entrySet().stream().filter(entry -> entry.getValue() == 2).count() == 2) {
            return "Doble pareja";
        }
        if (repeticiones.containsValue(2)) {
            return "Pareja";
        }

        return "Carta alta"; // Si no se encontró ninguna jugada específica.
    }

    /**
     * Lee matriz 20x20 de '1', '0', 'X' y cuenta barcos enteros, dañados y
     * hundidos.
     */
    public static void analizarBarcos(String ruta) throws IOException {
        // Lee todas las líneas del archivo, que representan filas de la matriz del campo de batalla.
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        // Crea una matriz de caracteres de 20x20 para representar el campo de batalla.
        char[][] matriz = new char[20][20];
        // Llena la matriz con los caracteres de las líneas del archivo.
        for (int i = 0; i < 20; i++) {
            matriz[i] = lineas.get(i).toCharArray();
        }

        // Matriz booleana para llevar el registro de las celdas ya visitadas durante la búsqueda de barcos.
        boolean[][] visitado = new boolean[20][20];
        int enteros = 0, danados = 0, hundidos = 0; // Contadores para los diferentes tipos de barcos.

        // Itera sobre cada celda de la matriz del campo de batalla.
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                // Si la celda no ha sido visitada y contiene parte de un barco ('1' para intacto, 'X' para tocado).
                if (!visitado[i][j] && (matriz[i][j] == '1' || matriz[i][j] == 'X')) {
                    // Lista para almacenar los tipos de partes encontradas para el barco actual.
                    List<Character> barco = new ArrayList<>();
                    // Realiza una búsqueda en profundidad (DFS) para encontrar todas las partes conectadas del barco.
                    dfsBarco(matriz, visitado, i, j, barco);
                    // Clasifica el barco según las partes encontradas.
                    if (barco.contains('1') && barco.contains('X')) {
                        danados++; // Si tiene partes intactas y tocadas, está dañado.
                    } else if (barco.contains('X')) {
                        hundidos++; // Si solo tiene partes tocadas, está hundido.
                    } else {
                        enteros++; // Si solo tiene partes intactas, está entero.
                    }
                }
            }
        }

        // Imprime la cantidad de barcos de cada tipo encontrados.
        System.out.println("Enteros: " + enteros + ", Dañados: " + danados + ", Hundidos: " + hundidos);
    }

    /**
     * Método auxiliar para la búsqueda en profundidad de componentes de barcos.
     */
    private static void dfsBarco(char[][] m, boolean[][] v, int x, int y, List<Character> barco) {
        // Caso base: si la posición está fuera de los límites, ya visitada o no contiene parte de un barco.
        if (x < 0 || y < 0 || x >= 20 || y >= 20 || v[x][y] || (m[x][y] != '1' && m[x][y] != 'X')) {
            return;
        }
        // Marca la celda actual como visitada.
        v[x][y] = true;
        // Añade el tipo de parte del barco a la lista del barco actual.
        barco.add(m[x][y]);
        // Explora recursivamente las celdas adyacentes en las cuatro direcciones (arriba, abajo, izquierda, derecha).
        dfsBarco(m, v, x + 1, y, barco); // Abajo
        dfsBarco(m, v, x - 1, y, barco); // Arriba
        dfsBarco(m, v, x, y + 1, barco); // Derecha
        dfsBarco(m, v, x, y - 1, barco); // Izquierda
    }

    /**
     * Busca palabras de una lista en una matriz tipo sopa de letras.
     */
    public static void buscarPalabrasSopa(char[][] matriz, List<String> palabras) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Itera sobre cada palabra de la lista de palabras a buscar.
        for (String palabra : palabras) {
            // Convierte la palabra a mayúsculas para realizar una búsqueda sin distinción de mayúsculas y minúsculas.
            String palabraMayus = palabra.toUpperCase();
            boolean encontrada = false; // Indica si la palabra fue encontrada en la sopa de letras.

            // Itera sobre cada celda de la matriz como posible punto de inicio para la búsqueda de la palabra.
            for (int i = 0; i < filas && !encontrada; i++) {
                for (int j = 0; j < columnas && !encontrada; j++) {
                    // Intenta buscar la palabra desde la posición actual en todas las 8 direcciones.
                    encontrada = buscarDesde(matriz, i, j, palabraMayus);
                }
            }

            // Imprime si la palabra fue encontrada o no.
            if (encontrada) {
                System.out.println("Encontrada: " + palabra);
            } else {
                System.out.println("No encontrada: " + palabra);
            }
        }
    }

    /**
     * Método auxiliar para buscar una palabra desde una posición en todas
     * direcciones.
     */
    private static boolean buscarDesde(char[][] m, int x, int y, String palabra) {
        // Define las 8 posibles direcciones de movimiento para la búsqueda (horizontal, vertical y diagonal).
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}};
        int filas = m.length;
        int columnas = m[0].length;

        // Itera sobre cada una de las 8 direcciones.
        for (int[] d : dir) {
            int i = x, j = y, k = 0; // Inicializa la posición actual y el índice de la letra de la palabra.
            // Avanza en la dirección actual mientras las letras coincidan y la posición esté dentro de los límites de la matriz.
            while (k < palabra.length() && i >= 0 && j >= 0 && i < filas && j < columnas
                    && m[i][j] == palabra.charAt(k)) {
                i += d[0]; // Mueve a la siguiente fila en la dirección actual.
                j += d[1]; // Mueve a la siguiente columna en la dirección actual.
                k++; // Avanza a la siguiente letra de la palabra.
            }
            // Si se recorrió toda la palabra, significa que se encontró en esta dirección.
            if (k == palabra.length()) {
                return true;
            }
        }
        return false; // Si no se encontró la palabra en ninguna de las 8 direcciones desde esta posición.
    }

    /**
     * Comprueba si existe un camino desde (0,0) hasta (n-1,m-1) en un laberinto
     * (0 = camino, 1 = muro) usando BFS iterativa.
     */
    public static boolean existeCaminoLaberinto(int[][] laberinto) {
        int n = laberinto.length;
        int m = laberinto[0].length;
        // Si la entrada o la salida están bloqueadas, no hay camino.
        if (laberinto[0][0] == 1 || laberinto[n - 1][m - 1] == 1) {
            return false;
        }

        // Matriz booleana para marcar las celdas ya visitadas durante la búsqueda.
        boolean[][] visto = new boolean[n][m];
        // Cola para realizar la búsqueda en anchura (BFS).
        Deque<int[]> queue = new ArrayDeque<>();
        // Añade la posición inicial (entrada) a la cola y la marca como visitada.
        queue.addLast(new int[]{0, 0});
        visto[0][0] = true;

        // Define las cuatro posibles direcciones de movimiento: derecha, izquierda, abajo, arriba.
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Mientras la cola no esté vacía (todavía hay celdas por explorar).
        while (!queue.isEmpty()) {
            // Obtiene la primera posición de la cola (la celda a explorar actualmente).
            int[] p = queue.removeFirst();
            int x = p[0], y = p[1]; // Coordenadas de la celda actual.

            // Si la celda actual es la salida, se encontró un camino.
            if (x == n - 1 && y == m - 1) {
                return true;
            }

            // Explora las celdas vecinas en las cuatro direcciones.
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1]; // Calcula las coordenadas de la celda vecina.
                // Verifica si la celda vecina está dentro de los límites del laberinto, no ha sido visitada y no es un muro.
                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && !visto[nx][ny] && laberinto[nx][ny] == 0) {
                    // Marca la celda vecina como visitada.
                    visto[nx][ny] = true;
                    // Añade la celda vecina a la cola para explorarla en el futuro.
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }

        // Si la cola se vacía y no se llegó a la salida, no existe un camino.
        return false;
    }

    /**
     * Valida un Sudoku 9×9 comprobando que no haya duplicados en filas,
     * columnas y bloques 3×3.
     */
    public static boolean validarSudoku(int[][] tablero) {
        int N = 9; // Tamaño del tablero de Sudoku.

        // Verifica cada fila y cada columna.
        for (int i = 0; i < N; i++) {
            boolean[] vistoFila = new boolean[N]; // Array para rastrear los números vistos en la fila actual.
            boolean[] vistoCol = new boolean[N]; // Array para rastrear los números vistos en la columna actual.

            for (int j = 0; j < N; j++) {
                int vFila = tablero[i][j]; // Valor en la celda [i][j] (fila i, columna j).
                int vCol = tablero[j][i]; // Valor en la celda [j][i] (fila j, columna i).

                // Verifica si el valor en la fila es válido (1-9) y no se ha visto antes en esta fila.
                if (vFila < 1 || vFila > 9 || vistoFila[vFila - 1]) {
                    return false;
                }
                vistoFila[vFila - 1] = true; // Marca el valor como visto en la fila.

                // Verifica si el valor en la columna es válido (1-9) y no se ha visto antes en esta columna.
                if (vCol < 1 || vCol > 9 || vistoCol[vCol - 1]) {
                    return false;
                }
                vistoCol[vCol - 1] = true; // Marca el valor como visto en la columna.
            }
        }

        // Verifica cada bloque 3×3.
        for (int bi = 0; bi < N; bi += 3) { // Itera sobre los índices de inicio de las filas de los bloques.
            for (int bj = 0; bj < N; bj += 3) { // Itera sobre los índices de inicio de las columnas de los bloques.
                boolean[] vistoBloque = new boolean[N]; // Array para rastrear los números vistos en el bloque actual.
                // Itera dentro del bloque 3x3.
                for (int i = bi; i < bi + 3; i++) {
                    for (int j = bj; j < bj + 3; j++) {
                        int v = tablero[i][j]; // Valor en la celda actual del bloque.
                        // Verifica si el valor en el bloque es válido (1-9) y no se ha visto antes en este bloque.
                        if (v < 1 || v > 9 || vistoBloque[v - 1]) {
                            return false;
                        }
                        vistoBloque[v - 1] = true; // Marca el valor como visto en el bloque.
                    }
                }
            }
        }
        return true; // Si todas las filas, columnas y bloques son válidos.
    }

    /**
     * Revela celdas en un tablero de Buscaminas sin usar recursividad: si
     * posición es '0', hace flood-fill iterativo; marca en visto[][].
     */
    public static void revelarBuscaminas(char[][] tablero, boolean[][] visto, int fila, int col) {
        int filas = tablero.length;
        int cols = tablero[0].length;
        // Pila para realizar la búsqueda en profundidad iterativa (simulando la recursión del flood-fill).
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{fila, col}); // Añade la posición inicial a la pila.

        // Define las 8 direcciones adyacentes (incluyendo diagonales) para la expansión.
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // Mientras la pila no esté vacía (todavía hay celdas por explorar).
        while (!stack.isEmpty()) {
            // Obtiene la última posición añadida a la pila.
            int[] p = stack.pop();
            int i = p[0], j = p[1]; // Coordenadas de la celda actual.

            // Verifica si la posición actual está dentro de los límites del tablero.
            if (i < 0 || j < 0 || i >= filas || j >= cols) {
                continue;
            }
            // Si ya hemos visitado esta posición, la ignoramos para evitar bucles infinitos.
            if (visto[i][j]) {
                continue;
            }

            visto[i][j] = true; // Marca la posición actual como visitada.

            // Si la celda actual es un área libre ('0'), expande la revelación a sus vecinos.
            if (tablero[i][j] == '0') {
                for (int[] d : dirs) {
                    stack.push(new int[]{i + d[0], j + d[1]}); // Añade los vecinos a la pila para su posterior exploración.
                }
            }
// Si la celda contiene un número o una mina ('*'), simplemente la marcamos como vista y no seguimos expandiendo desde aquí.
    }
}