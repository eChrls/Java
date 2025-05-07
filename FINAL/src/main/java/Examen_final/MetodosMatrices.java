package Examen_final;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Clase que contiene métodos para manipular matrices y realizar
 * operaciones relacionadas con equipos de fútbol y jugadores.
 * Incluye varios minijuegos adaptados a la temática de futbolistas.
 */
public class MetodosMatrices {

    /**
     * 1- Índice de métodos de la clase:
     * - encontrarJugadorParaRachaGoleadora: Busca un jugador para completar una secuencia de goles por estado.
     * - generarCalendarioPartidos: Crea un horario semanal aleatorio de partidos para un equipo.
     * - colocarFutbolistaEnCampo: Intenta colocar un jugador en una posición vacía del campo.
     * - futbolistasEnFila: Devuelve una lista de los jugadores en una fila específica del campo.
     * - hayAlineacionCompleta: Verifica si una formación tiene una fila completa de jugadores activos.
     * - moverJugador: Cambia la posición de un jugador en el campo si el movimiento es válido.
     * - contarEstadoEnDiagonalPrincipal: Cuenta jugadores con un estado específico en la diagonal principal de una formación.
     * - comprobarEstadosEquipos: Lee un archivo y verifica si los estados de los jugadores de cada equipo son válidos.
     * - verificarValoracionEquipo: Calcula y verifica si la valoración de un equipo (basada en goles y estado) es 21.
     * - hayCuatroEstadosIguales: Comprueba si hay cuatro jugadores seguidos con el mismo estado en cualquier dirección.
     * - identificarCalidadEquipo: Evalúa la calidad de un equipo basándose en el estado y los goles de sus jugadores.
     * - analizarCampoEntrenamiento: Analiza un archivo representando un campo para contar zonas de entrenamiento por estado.
     * - dfsZonaEntrenamiento: Método auxiliar para analizar zonas conectadas en el campo de entrenamiento (recorrido DFS).
     * - buscarNombresJugadores: Busca nombres de jugadores en una matriz tipo sopa de letras.
     * - buscarDesdePos: Método auxiliar para buscar un nombre desde una posición específica en todas direcciones.
     * - existeCaminoEstadio: Verifica si hay un camino transitable desde la entrada hasta la salida de un estadio representado en una matriz.
     * - validarAlineacion: Valida una alineación 3-3-3 (representada como un Sudoku) sin duplicados por posición.
     * - revelarAreasEntrenamiento: Simula revelar áreas adyacentes en un campo de entrenamiento basado en la condición.
     * - recorrerIzquierdaDerecha: Recorre una matriz de izquierda a derecha por filas y aplica una acción.
     * - recorrerDerechaIzquierda: Recorre una matriz de derecha a izquierda por filas y aplica una acción.
     * - recorrerArribaAbajo: Recorre una matriz de arriba a abajo por columnas y aplica una acción.
     * - recorrerAbajoArriba: Recorre una matriz de abajo a arriba por columnas y aplica una acción.
     */

    /**
     * Busca un jugador que podría completar una racha goleadora en un equipo
     * Juego original: Encontrar la carta que completa una escalera de color en poker
     */
    public static String encontrarJugadorParaRachaGoleadora(List<Futbolista> jugadores) {
        // Mapa para agrupar listas de goles por cada estado de jugador
        Map<EstadoJugador, List<Double>> porEstado = new HashMap<>();

        // Iteramos sobre cada jugador en la lista
        for (Futbolista jugador : jugadores) {
            EstadoJugador estado = jugador.getEstado(); // Obtenemos el estado del jugador
            double goles = jugador.getGolesPorPartido(); // Obtenemos los goles por partido del jugador
            // Si no existe la clave del estado en el mapa, crea una nueva lista; luego añade los goles a la lista correspondiente al estado
            porEstado.computeIfAbsent(estado, k -> new ArrayList<>()).add(goles);
        }

        // Iteramos sobre cada entrada (estado y lista de goles) en el mapa
        for (Map.Entry<EstadoJugador, List<Double>> entrada : porEstado.entrySet()) {
            List<Double> goles = entrada.getValue(); // Obtenemos la lista de goles para el estado actual
            // Verificamos si hay al menos 4 jugadores con este estado para intentar formar una racha
            if (goles.size() >= 4) {
                Collections.sort(goles); // Ordenamos la lista de goles de menor a mayor para buscar secuencias

                // Buscamos secuencias de 5 goles consecutivos donde falta solo uno
                for (double i = 0.1; i <= 1.6; i += 0.1) {
                    // Redondeamos a dos decimales para evitar problemas con la precisión de los números de punto flotante
                    i = Math.round(i * 100.0) / 100.0;

                    List<Double> secuencia = new ArrayList<>(); // Creamos una nueva lista para representar una posible secuencia de 5 goles
                    // Generamos una secuencia de 5 valores consecutivos con incrementos de 0.1, comenzando desde 'i'
                    for (int j = 0; j < 5; j++) {
                        secuencia.add(Math.round((i + j * 0.1) * 100.0) / 100.0); // Redondeamos cada valor de la secuencia
                    }

                    // Creamos una sub-lista que contiene solo los goles de la secuencia que ya existen en la lista de goles del estado actual
                    List<Double> subSecuencia = new ArrayList<>(secuencia);
                    subSecuencia.retainAll(goles); // `retainAll` mantiene solo los elementos que están presentes en ambas listas

                    // Si encontramos 4 de los 5 goles de una secuencia en la lista de goles del estado actual
                    if (subSecuencia.size() == 4) {
                        // Buscamos el valor faltante en la secuencia que no está presente en la lista de goles
                        double faltante = secuencia.stream()
                                .filter(n -> !goles.contains(n)) // Filtramos los números de la secuencia que no están en la lista de goles
                                .findFirst() // Obtenemos el primer elemento resultante del filtro (el faltante)
                                .orElse(-1.0); // Si no se encuentra ningún elemento faltante, devolvemos -1.0

                        // Si se encontró un valor faltante válido
                        if (faltante != -1.0) {
                            // Retornamos un mensaje indicando el número de goles y el estado del jugador necesario para completar la racha
                            return "Se necesita un jugador con " + faltante + " goles por partido y estado " +
                                   entrada.getKey().getDescripcion();
                        }
                    }
                }
            }
        }

        // Si no se encontró ningún jugador que pueda completar una racha goleadora
        return "No se puede completar ninguna racha goleadora";
    }

    /**
     * Genera el horario semanal de partidos para un equipo específico
     * Juego original: Crear una matriz semanal de horarios de clases para un curso
     */
    public static String[][] generarCalendarioPartidos(List<Equipo> equipos, String nombreEquipo) {
        // Matriz para representar el horario semanal: 7 días, 2 franjas horarias (mañana/tarde)
        String[][] matriz = new String[7][2];

        // Buscamos el equipo cuyo nombre coincide con el proporcionado
        Equipo equipoBuscado = null;
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoBuscado = e; // Asignamos el equipo encontrado
                break; // Salimos del bucle una vez que se encuentra el equipo
            }
        }

        // Si el equipo buscado existe
        if (equipoBuscado != null) {
            Random r = new Random(); // Creamos un objeto Random para generar valores aleatorios
            // Creamos una lista de nombres de oponentes, excluyendo el equipo para el que estamos generando el horario
            List<String> oponentes = equipos.stream()
                    .map(Equipo::getNombre) // Mapeamos cada equipo a su nombre
                    .filter(n -> !n.equalsIgnoreCase(nombreEquipo)) // Filtramos los nombres que no coinciden con el equipo actual
                    .collect(Collectors.toList()); // Recolectamos los nombres filtrados en una nueva lista

            // Generamos un número aleatorio de partidos para esta semana (entre 1 y el número de oponentes, máximo 5)
            int partidosGenerados = Math.min(r.nextInt(5) + 1, oponentes.size());

            // Iteramos para generar el número de partidos aleatorios
            for (int i = 0; i < partidosGenerados; i++) {
                int dia = r.nextInt(7); // Generamos un día aleatorio de la semana (0-6)
                int franja = r.nextInt(2); // Generamos una franja horaria aleatoria (0: mañana, 1: tarde)

                // Asignamos el partido al horario solo si la franja horaria en ese día está vacía
                if (matriz[dia][franja] == null) {
                    matriz[dia][franja] = nombreEquipo + " vs " + oponentes.get(i); // Formato del partido: "Equipo vs Oponente"
                }
            }
        }

        return matriz; // Devolvemos la matriz del horario semanal
    }

    /**
     * Coloca un futbolista en el campo si la posición está vacía
     * Juego original: Colocar ficha de dominó en el tablero
     */
    public static boolean colocarFutbolistaEnCampo(Futbolista[][] campo, int fila, int col, Futbolista jugador) {
        // Verificamos si la fila y la columna están dentro de los límites del campo
        if (fila >= 0 && fila < campo.length && col >= 0 && col < campo[0].length && campo[fila][col] == null) {
            campo[fila][col] = jugador; // Colocamos al jugador en la posición especificada
            return true; // Indicamos que la colocación fue exitosa
        }
        return false; // Indicamos que la colocación falló (posición fuera de límites o no vacía)
    }

    /**
     * Devuelve una lista con los futbolistas que hay en una fila del campo
     * Juego original: Obtener piezas en una fila del tablero
     */
    public static List<Futbolista> futbolistasEnFila(Futbolista[][] campo, int fila) {
        List<Futbolista> jugadores = new ArrayList<>(); // Creamos una nueva lista para almacenar los futbolistas encontrados
        // Iteramos sobre cada columna en la fila especificada
        for (int col = 0; col < campo[fila].length; col++) {
            if (campo[fila][col] != null) {
                jugadores.add(campo[fila][col]); // Si hay un futbolista en la posición, lo añadimos a la lista
            }
        }
        return jugadores; // Devolvemos la lista de futbolistas en la fila
    }

    /**
     * Verifica si hay alguna alineación completa de jugadores activos
     * Juego original: Verificar si hay una línea completa en un cartón de bingo
     */
    public static boolean hayAlineacionCompleta(EstadoJugador[][] formacion) {
        // Iteramos sobre cada fila de la formación
        for (EstadoJugador[] fila : formacion) {
            boolean completa = true; // Asumimos que la fila está completa hasta que encontremos un jugador no activo
            // Iteramos sobre cada estado de jugador en la fila actual
            for (EstadoJugador estado : fila) {
                // Una alineación completa requiere que todos los jugadores en la fila estén activos (EstadoJugador.A)
                if (estado != EstadoJugador.A) {
                    completa = false; // Si encontramos un jugador no activo, la fila no está completa
                    break; // No necesitamos seguir verificando el resto de la fila
                }
            }
            if (completa) return true; // Si la fila resultó estar completa, devolvemos true
        }
        return false; // Si ninguna fila resultó estar completa después de verificar todas, devolvemos false
    }

    /**
     * Mueve un jugador a una nueva posición si está dentro del campo y vacía
     * Juego original: Mover una ficha a una nueva posición en un tablero
     */
    public static boolean moverJugador(Futbolista[][] campo, int fActual, int cActual, int fNueva, int cNueva) {
        // Verificamos si la nueva posición está dentro de los límites del campo, está vacía y la posición actual contiene un jugador
        if (fNueva >= 0 && fNueva < campo.length && cNueva >= 0 && cNueva < campo[0].length
            && campo[fNueva][cNueva] == null && campo[fActual][cActual] != null) {
            campo[fNueva][cNueva] = campo[fActual][cActual]; // Movemos al jugador a la nueva posición
            campo[fActual][cActual] = null; // Marcamos la posición anterior como vacía
            return true; // Indicamos que el movimiento fue exitoso
        }
        return false; // Indicamos que el movimiento falló (nueva posición inválida o no vacía, o no hay jugador en la posición actual)
    }

    /**
     * Cuenta cuántos jugadores con el mismo estado hay en la diagonal principal
     * Juego original: Contar fichas iguales en una diagonal
     */
    public static int contarEstadoEnDiagonalPrincipal(EstadoJugador[][] formacion, EstadoJugador estado) {
        int contador = 0; // Inicializamos un contador para el número de jugadores con el estado especificado
        // Iteramos sobre la diagonal principal de la matriz (hasta la dimensión más pequeña para evitar errores de índice)
        for (int i = 0; i < Math.min(formacion.length, formacion[0].length); i++) {
            if (estado == formacion[i][i]) contador++; // Si el estado del jugador en la posición diagonal coincide con el estado buscado, incrementamos el contador
        }
        return contador; // Devolvemos el número total de jugadores con el estado especificado en la diagonal principal
    }

    /**
     * Comprueba si algún equipo tiene todos sus jugadores en el mismo estado según un archivo
     * Juego original: Comprobar si algún cartón tiene línea completa con los números del bingo
     */
    public static void comprobarEstadosEquipos(String rutaFichero) throws IOException {
        // Leemos todas las líneas del archivo especificado
        List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));

        // La primera línea del archivo contiene los estados a verificar, separados por espacios
        Set<String> estadosVerificar = new HashSet<>(Arrays.asList(lineas.get(0).split(" ")));

        // Iteramos sobre las líneas restantes del archivo, cada una representando los estados de los jugadores de un equipo
        for (int i = 1; i < lineas.size(); i++) {
            String[] estados = lineas.get(i).split(" "); // Dividimos la línea en un array de estados de jugadores para el equipo actual
            // Verificamos si todos los estados del equipo actual están contenidos en el conjunto de estados válidos
            if (Arrays.stream(estados).allMatch(estadosVerificar::contains)) {
                System.out.println("Equipo " + i + " tiene todos los estados válidos.");
            } else {
                System.out.println("Equipo " + i + " tiene estados inválidos.");
            }
        }
    }

    /**
     * Verifica si un equipo tiene una valoración perfecta (21) según los goles/partido
     * Juego original: Comprobar si una mano de cartas suma 21 en blackjack
     */
    public static void verificarValoracionEquipo(String ruta) throws IOException {
        // Leemos todas las líneas del archivo especificado
        List<String> lineas = Files.readAllLines(Paths.get(ruta));

        // Iteramos sobre cada línea del archivo, representando cada línea un equipo
        for (String linea : lineas) {
            String[] jugadores = linea.trim().split(" "); // Dividimos la línea en un array de strings, cada uno representando un jugador con su estado y goles
            double suma = 0; // Inicializamos la suma de la valoración del equipo

            // Iteramos sobre cada jugador en la línea
            for (String jugador : jugadores) {
                // El formato esperado es "ED.Goles", donde E es la letra del estado y Goles son los goles por partido
                String estadoStr = jugador.substring(0, 1); // Extraemos la letra del estado del jugador
                double goles = Double.parseDouble(jugador.substring(1)); // Extraemos y convertimos a double los goles por partido

                EstadoJugador estado = null; // Inicializamos la variable para almacenar el enum EstadoJugador
                // Buscamos el enum EstadoJugador correspondiente a la cadena de estado extraída
                for (EstadoJugador e : EstadoJugador.values()) {
                    if (e.name().equals(estadoStr)) {
                        estado = e; // Asignamos el enum si la cadena coincide
                        break;
                    }
                }

                // Si se encontró un estado válido, aplicamos el multiplicador de salario
                if (estado != null) {
                    suma += goles * estado.getMultiplicadorSalario();
                } else {
                    suma += goles; // Si no se encuentra el estado
                    // usamos el valor de los goles sin modificar
                }
            }

            // Verificamos si la suma de la valoración del equipo es aproximadamente 21.0
            if (Math.abs(suma - 21.0) < 0.001) {
                System.out.println("Equipo perfecto: " + linea);
            } else {
                System.out.println("Equipo con valoración: " + suma);
            }
        }
    }

   /**
    * Comprueba si hay 4 jugadores del mismo estado seguidos en cualquier dirección
    * Juego original: Comprobar si hay 4 fichas iguales seguidas en 4 en raya
    */
    public static boolean hayCuatroEstadosIguales(EstadoJugador[][] formacion) {
        int filas = formacion.length;
        int columnas = formacion[0].length;

        // Iteramos por cada celda de la formación
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                EstadoJugador actual = formacion[i][j];
                if (actual == EstadoJugador.R) continue; // Ignoramos jugadores retirados (se considera vacío)

                // Verificamos horizontalmente (hacia la derecha)
                if (j <= columnas - 4 &&
                    actual == formacion[i][j + 1] &&
                    actual == formacion[i][j + 2] &&
                    actual == formacion[i][j + 3]) return true;

                // Verificamos verticalmente (hacia abajo)
                if (i <= filas - 4 &&
                    actual == formacion[i + 1][j] &&
                    actual == formacion[i + 2][j] &&
                    actual == formacion[i + 3][j]) return true;

                // Verificamos diagonalmente (abajo-derecha)
                if (i <= filas - 4 && j <= columnas - 4 &&
                    actual == formacion[i + 1][j + 1] &&
                    actual == formacion[i + 2][j + 2] &&
                    actual == formacion[i + 3][j + 3]) return true;

                // Verificamos diagonalmente (arriba-derecha)
                if (i >= 3 && j <= columnas - 4 &&
                    actual == formacion[i - 1][j + 1] &&
                    actual == formacion[i - 2][j + 2] &&
                    actual == formacion[i - 3][j + 3]) return true;
            }
        }
        return false; // Si no se encontraron 4 estados iguales seguidos en ninguna dirección
    }

    /**
     * Identifica la calidad de un equipo según los estados y goles de sus jugadores
     * Juego original: Identificar jugada de póker (trío, escalera, color, etc.)
     */
    public static String identificarCalidadEquipo(List<Futbolista> jugadores) {
        // Contamos la frecuencia de cada estado de jugador
        Map<EstadoJugador, Integer> estadosCount = new HashMap<>();
        // Contamos la frecuencia de jugadores en diferentes rangos de goles por partido
        Map<Integer, Integer> golesRangoCount = new HashMap<>();

        // Iteramos sobre cada jugador en la lista
        for (Futbolista jugador : jugadores) {
            EstadoJugador estado = jugador.getEstado();
            estadosCount.put(estado, estadosCount.getOrDefault(estado, 0) + 1); // Incrementamos el contador para el estado del jugador

            // Clasificamos los goles por partido en rangos (0-0.5 -> 0, 0.5-1.0 -> 1, etc.)
            int rangoGoles = (int)(jugador.getGolesPorPartido() * 2);
            golesRangoCount.put(rangoGoles, golesRangoCount.getOrDefault(rangoGoles, 0) + 1); // Incrementamos el contador para el rango de goles
        }

        // Verificamos si hay una "escalera" de talento en los rangos de goles
        List<Integer> rangosGolesOrdenados = new ArrayList<>(golesRangoCount.keySet());
        Collections.sort(rangosGolesOrdenados); // Ordenamos los rangos de goles

        boolean escaleraGoles = false;
        if (rangosGolesOrdenados.size() >= 5) {
            escaleraGoles = true;
            for (int i = 1; i < rangosGolesOrdenados.size(); i++) {
                // Comprobamos si los rangos son consecutivos
                if (rangosGolesOrdenados.get(i) != rangosGolesOrdenados.get(i - 1) + 1) {
                    escaleraGoles = false;
                    break;
                }
            }
        }

        // Evaluamos la calidad del equipo basándonos en los conteos y la escalera de goles
        if (estadosCount.getOrDefault(EstadoJugador.A, 0) >= 5 && escaleraGoles)
            return "Equipo de élite";
        if (estadosCount.getOrDefault(EstadoJugador.A, 0) >= 5)
            return "Equipo sólido";
        if (escaleraGoles)
            return "Equipo balanceado";
        if (golesRangoCount.containsValue(4))
            return "Equipo con estrella";
        if (golesRangoCount.containsValue(3))
            return "Equipo con talento";

        return "Equipo promedio"; // Si no se cumple ninguna condición anterior
    }


    /**
     * Analiza una matriz de un campo de entrenamiento para contar zonas separadas
     * Juego original: Analizar matriz de barcos para contar barcos enteros, dañados y hundidos
     */
    public static void analizarCampoEntrenamiento(String ruta) throws IOException {
        // Leemos todas las líneas del archivo que representa el campo de entrenamiento
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        // Creamos una matriz de caracteres para representar el campo (se asume una dimensión de 20x20)
        char[][] matriz = new char[20][20];
        // Llenamos la matriz con los caracteres de las líneas del archivo
        for (int i = 0; i < 20; i++) matriz[i] = lineas.get(i).toCharArray();

        // Matriz booleana para llevar el registro de las celdas ya visitadas durante el análisis
        boolean[][] visitado = new boolean[20][20];
        // Contadores para las zonas de entrenamiento de jugadores activos, lesionados y mixtos
        int activos = 0, lesionados = 0, mixtos = 0;

        // Recorremos cada celda de la matriz del campo de entrenamiento
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                // Si la celda no ha sido visitada y contiene un jugador activo ('A') o lesionado ('L')
                if (!visitado[i][j] && (matriz[i][j] == 'A' || matriz[i][j] == 'L')) {
                    List<Character> zona = new ArrayList<>(); // Lista para almacenar los tipos de jugadores en la zona actual
                    // Realizamos una búsqueda en profundidad (DFS) para encontrar todas las celdas conectadas con jugadores activos o lesionados
                    dfsZonaEntrenamiento(matriz, visitado, i, j, zona);

                    // Clasificamos la zona de entrenamiento según los tipos de jugadores encontrados
                    if (zona.contains('A') && zona.contains('L')) mixtos++; // Si hay tanto activos como lesionados, es una zona mixta
                    else if (zona.contains('L')) lesionados++; // Si solo hay lesionados, es una zona de lesionados
                    else activos++; // Si solo hay activos, es una zona de activos
                }
            }
        }

        // Imprimimos el número de zonas de cada tipo encontradas
        System.out.println("Zonas activos: " + activos + ", Zonas lesionados: " + lesionados + ", Zonas mixtas: " + mixtos);
    }

    /**
     * Método auxiliar para recorrer zonas conectadas en el campo de entrenamiento usando DFS
     */
    private static void dfsZonaEntrenamiento(char[][] m, boolean[][] v, int x, int y, List<Character> zona) {
        // Caso base: si la posición está fuera de los límites, ya visitada o no contiene un jugador activo o lesionado, detenemos la exploración
        if (x < 0 || y < 0 || x >= 20 || y >= 20 || v[x][y] || (m[x][y] != 'A' && m[x][y] != 'L')) return;

        v[x][y] = true; // Marcamos la celda actual como visitada
        zona.add(m[x][y]); // Añadimos el tipo de jugador de la celda actual a la lista de la zona

        // Exploramos recursivamente las celdas adyacentes en las cuatro direcciones (arriba, abajo, izquierda, derecha)
        dfsZonaEntrenamiento(m, v, x + 1, y, zona); // Abajo
        dfsZonaEntrenamiento(m, v, x - 1, y, zona); // Arriba
        dfsZonaEntrenamiento(m, v, x, y + 1, zona); // Derecha
        dfsZonaEntrenamiento(m, v, x, y - 1, zona); // Izquierda
    }

    /**
     * Busca nombres de jugadores en una matriz tipo sopa de letras
     * Juego original: Buscar palabras en una sopa de letras
     */
    public static void buscarNombresJugadores(char[][] matriz, List<String> nombres) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Iteramos sobre cada nombre de jugador en la lista
        for (String nombre : nombres) {
            String nombreMayus = nombre.toUpperCase(); // Convertimos el nombre a mayúsculas para la búsqueda sin distinción de casos
            boolean encontrado = false; // Variable para indicar si el nombre fue encontrado en la matriz

            // Recorremos cada celda de la matriz como punto de inicio para la búsqueda
            for (int i = 0; i < filas && !encontrado; i++) {
                for (int j = 0; j < columnas && !encontrado; j++) {
                    // Intentamos buscar el nombre desde la posición actual en todas las 8 direcciones
                    encontrado = buscarDesdePos(matriz, i, j, nombreMayus);
                }
            }

            // Imprimimos si el jugador fue encontrado o no
            if (encontrado) System.out.println("Jugador encontrado: " + nombre);
            else System.out.println("Jugador no encontrado: " + nombre);
        }
    }

    /**
     * Método auxiliar para buscar un nombre desde una posición específica en todas direcciones
     */
    private static boolean buscarDesdePos(char[][] m, int x, int y, String nombre) {
        // Definimos las 8 posibles direcciones de movimiento (horizontal, vertical y diagonal)
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}};
        int filas = m.length;
        int columnas = m[0].length;

        // Probamos cada una de las 8 direcciones
        for (int[] d : dir) {
            int i = x, j = y, k = 0; // Inicializamos la posición actual y el índice de la letra del nombre

            // Avanzamos en la dirección actual mientras las letras coincidan y estemos dentro de los límites de la matriz
            while (k < nombre.length() && i >= 0 && j >= 0 && i < filas && j < columnas &&
                   m[i][j] == nombre.charAt(k)) {
                i += d[0]; // Movemos a la siguiente fila en la dirección actual
                j += d[1]; // Movemos a la siguiente columna en la dirección actual
                k++; // Avanzamos a la siguiente letra del nombre
            }

            // Si hemos recorrido todo el nombre, significa que lo encontramos en esta dirección
            if (k == nombre.length()) return true;
        }
        return false; // Si no se encontró el nombre en ninguna de las 8 direcciones desde esta posición
    }


    /**
     * Comprueba si existe un camino desde la entrada hasta la salida del estadio
     * Juego original: Verificar si existe un camino en un laberinto
     */
    public static boolean existeCaminoEstadio(int[][] mapa) {
        int n = mapa.length;
        int m = mapa[0].length;

        // Verificamos si la entrada (0,0) o la salida (n-1, m-1) están bloqueadas (valor 1)
        if (mapa[0][0] == 1 || mapa[n - 1][m - 1] == 1) return false;

        // Matriz booleana para marcar las celdas que ya hemos visitado durante la búsqueda
        boolean[][] visto = new boolean[n][m];
        // Cola para realizar una búsqueda en anchura (BFS)
        Deque<int[]> queue = new ArrayDeque<>();

        // Añadimos la posición de inicio (entrada) a la cola y la marcamos como visitada
        queue.addLast(new int[]{0, 0});
        visto[0][0] = true;

        // Definimos las cuatro posibles direcciones de movimiento: derecha, izquierda, abajo, arriba
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Mientras la cola no esté vacía, seguimos buscando
        while (!queue.isEmpty()) {
            int[] p = queue.removeFirst(); // Obtenemos la primera posición de la cola
            int x = p[0], y = p[1]; // Coordenadas de la posición actual

            // Si la posición actual es la salida, hemos encontrado un camino
            if (x == n - 1 && y == m - 1) return true;

            // Exploramos las cuatro direcciones adyacentes
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1]; // Calculamos las coordenadas de la celda vecina

                // Verificamos si la nueva posición está dentro de los límites del mapa, no ha sido visitada y no está bloqueada (valor 0)
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visto[nx][ny] && mapa[nx][ny] == 0) {
                    visto[nx][ny] = true; // Marcamos la nueva posición como visitada
                    queue.addLast(new int[]{nx, ny}); // Añadimos la nueva posición a la cola para seguir explorando desde allí
                }
            }
        }

        // Si la cola se vacía y no hemos llegado a la salida, no existe un camino
        return false;
    }

    /**
     * Valida una alineación 3-3-3 verificando que no haya duplicados por posición (simulando un Sudoku)
     * Juego original: Validar un Sudoku 9×9
     */
    public static boolean validarAlineacion(int[][] formacion) {
        int N = 9; // Tamaño de la matriz (9x9 para una alineación 3-3-3 con dorsales del 1 al 9)

        // Verificamos cada fila y cada columna
        for (int i = 0; i < N; i++) {
            boolean[] vistoFila = new boolean[N]; // Array para rastrear los dorsales vistos en la fila actual
            boolean[] vistoCol = new boolean[N]; // Array para rastrear los dorsales vistos en la columna actual

            for (int j = 0; j < N; j++) {
                int jugadorFila = formacion[i][j]; // Dorsal del jugador en la fila i, columna j
                int jugadorCol = formacion[j][i]; // Dorsal del jugador en la columna j, fila i

                // Verificamos si el dorsal en la fila es válido (1-9) y no se ha visto antes en esta fila
                if (jugadorFila < 1 || jugadorFila > N || vistoFila[jugadorFila - 1]) return false;
                vistoFila[jugadorFila - 1] = true; // Marcamos el dorsal como visto en la fila

                // Verificamos si el dorsal en la columna es válido (1-9) y no se ha visto antes en esta columna
                if (jugadorCol < 1 || jugadorCol > N || vistoCol[jugadorCol - 1]) return false;
                vistoCol[jugadorCol - 1] = true; // Marcamos el dorsal como visto en la columna
            }
        }

        // Verificamos cada bloque 3x3
        for (int bi = 0; bi < N; bi += 3) { // Iteramos sobre los índices de inicio de las filas de los bloques
            for (int bj = 0; bj < N; bj += 3) { // Iteramos sobre los índices de inicio de las columnas de los bloques
                boolean[] vistoBloque = new boolean[N]; // Array para rastrear los dorsales vistos en el bloque actual

                // Iteramos dentro del bloque 3x3
                for (int i = bi; i < bi +3; i++) {
                    
                 for (int j = bj; j < bj + 3; j++) {
                        int jugador = formacion[i][j]; // Dorsal del jugador en la celda actual del bloque

                        // Verificamos si el dorsal en el bloque es válido (1-9) y no se ha visto antes en este bloque
                        if (jugador < 1 || jugador > N || vistoBloque[jugador - 1]) return false;
                        vistoBloque[jugador - 1] = true; // Marcamos el dorsal como visto en el bloque
                    }
                }
            }
        }
        return true; // Si todas las filas, columnas y bloques son válidos
    }
/**
     * Revela áreas de un campo de entrenamiento basado en la condición de los jugadores (simulando Buscaminas)
     * Juego original: Revelar celdas en un tablero de Buscaminas
     */
    public static void revelarAreasEntrenamiento(char[][] campo, boolean[][] visto, int fila, int col) {
        int filas = campo.length;
        int cols = campo[0].length;
        // Pila para realizar una búsqueda en profundidad iterativa
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{fila, col}); // Iniciamos la búsqueda desde la posición dada

        // Definimos las 8 direcciones adyacentes (incluyendo diagonales)
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // Mientras la pila no esté vacía
        while (!stack.isEmpty()) {
            int[] p = stack.pop(); // Obtenemos la última posición añadida a la pila
            int i = p[0], j = p[1]; // Coordenadas de la posición actual

            // Verificamos si la posición actual está dentro de los límites del campo
            if (i < 0 || j < 0 || i >= filas || j >= cols) continue;
            // Si ya hemos visitado esta posición, la ignoramos
            if (visto[i][j]) continue;

            visto[i][j] = true; // Marcamos la posición actual como visitada

            // Si la celda actual es un área libre ('0'), expandimos la revelación a sus vecinos
            if (campo[i][j] == '0') {
                for (int[] d : dirs) {
                    stack.push(new int[]{i + d[0], j + d[1]}); // Añadimos los vecinos a la pila para su posterior exploración
                }
            }
            // Si la celda contiene un jugador u obstáculo (no es '0'), solo la marcamos como vista y no seguimos expandiendo desde aquí
        }
    }

    // MÉTODOS GENÉRICOS PARA MANIPULACIÓN DE MATRICES

    /**
     * Recorre una matriz de izquierda a derecha por filas y aplica una acción a cada elemento
     */
    public static <T> void recorrerIzquierdaDerecha(T[][] matriz, Consumer<T> accion) {
        // Iteramos sobre cada fila de la matriz
        for (int i = 0; i < matriz.length; i++) {
            // Iteramos sobre cada elemento de la fila, de izquierda a derecha
            for (int j = 0; j < matriz[i].length; j++) {
                accion.accept(matriz[i][j]); // Aplicamos la acción al elemento actual
            }
        }
    }

    /**
     * Recorre una matriz de derecha a izquierda por filas y aplica una acción a cada elemento
     */
    public static <T> void recorrerDerechaIzquierda(T[][] matriz, Consumer<T> accion) {
        // Iteramos sobre cada fila de la matriz
        for (int i = 0; i < matriz.length; i++) {
            // Iteramos sobre cada elemento de la fila, de derecha a izquierda
            for (int j = matriz[i].length - 1; j >= 0; j--) {
                accion.accept(matriz[i][j]); // Aplicamos la acción al elemento actual
            }
        }
    }

    /**
     * Recorre una matriz de arriba a abajo por columnas y aplica una acción a cada elemento
     */
    public static <T> void recorrerArribaAbajo(T[][] matriz, Consumer<T> accion) {
        // Iteramos sobre cada columna de la matriz
        for (int j = 0; j < matriz[0].length; j++) {
            // Iteramos sobre cada elemento de la columna, de arriba a abajo
            for (int i = 0; i < matriz.length; i++) {
                accion.accept(matriz[i][j]); // Aplicamos la acción al elemento actual
            }
        }
    }

    /**
     * Recorre una matriz de abajo a arriba por columnas y aplica una acción a cada elemento
     */
    public static <T> void recorrerAbajoArriba(T[][] matriz, Consumer<T> accion) {
        // Iteramos sobre cada columna de la matriz
        for (int j = 0; j < matriz[0].length; j++) {
            // Iteramos sobre cada elemento de la columna, de abajo a arriba
            for (int i = matriz.length - 1; i >= 0; i--) {
                accion.accept(matriz[i][j]); // Aplicamos la acción al elemento actual
            }
        }
    }
}