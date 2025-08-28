package ejercicio2;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MainEjercicio2 {

    public static void main(String[] args) {
        String archivoGames = "games.json";
        List<Game> juegos = null;

        try {
            juegos = LecturaJSON.leer(archivoGames);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return;
        }

        // Obtener géneros diferentes ordenados alfabéticamente
        Set<String> generosOrdenados = obtenerGenerosOrdenados(juegos);
        System.out.println("Géneros de juegos diferentes (orden alfabético):");
        imprimirSetConIterator(generosOrdenados);

        // Imprimir los tres juegos con mejor rating del género "fantasy"
        System.out.println("\nLos tres juegos con mejor rating del género 'fantasy':");
        imprimirMejoresJuegosFantasy(juegos, 3);

        // Obtener el coste total de todos los juegos de cada plataforma
        Map<String, Double> costeTotalPorPlataforma = obtenerCosteTotalPorPlataforma(juegos);
        System.out.println("\nCoste total de juegos por plataforma:");
        System.out.println(costeTotalPorPlataforma);

        // Escribir el mapa de costes a un nuevo archivo JSON
        String archivoCostes = "costes_por_plataforma.json";
        try {
            EscrituraJSON.escribir(costeTotalPorPlataforma, archivoCostes);
            System.out.println("\nCoste total por plataforma guardado en " + archivoCostes);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    /**
     * Obtiene en una estructura set todos los géneros de juegos diferentes,
     * ordenados alfabéticamente, a partir de la lista.
     */
    public static Set<String> obtenerGenerosOrdenados(List<Game> juegos) {
        return juegos.stream()
                .map(Game::getGenre)
                .collect(Collectors.toCollection(java.util.TreeSet::new));
    }

    /**
     * Imprime por pantalla un SET usando un objeto de tipo iterator.
     */
    public static void imprimirSetConIterator(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Imprime por pantalla los 'limit' juegos con mejor rating del género
     * "fantasy", a partir de la lista.
     */
    public static void imprimirMejoresJuegosFantasy(List<Game> juegos, int limit) {
        juegos.stream()
                .filter(juego -> juego.getGenre().equalsIgnoreCase("fantasy"))
                .sorted(Comparator.comparingDouble(Game::getRating).reversed())
                .limit(limit)
                .forEach(juego -> System.out.println(juego.getGame() + " (Rating: " + juego.getRating() + ")"));
    }

    /**
     * Obtiene en un map el coste total de todos los juegos de cada plataforma,
     * a partir de la lista.
     */
    public static Map<String, Double> obtenerCosteTotalPorPlataforma(List<Game> juegos) {
        return juegos.stream()
                .collect(Collectors.groupingBy(Game::getPlatform,
                        TreeMap::new, // Para mantener las plataformas ordenadas alfabéticamente en el Map
                        Collectors.summingDouble(Game::getPrice)));
    }
}
