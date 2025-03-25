
package Examen;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OperacionesRummi {

    // Constante para el número de fichas por color
    public static final int NUMERO_FICHAS_POR_COLOR = 13;

    // Método para generar todas las fichas del juego
    public static List<Ficha> generarTodas() {
        List<Ficha> fichas = new ArrayList<>();
        // Genera dos conjuntos completos de fichas de cada color
        for (int i = 0; i < 2; i++) {
            for (Color color : Color.values()) {
                for (int numero = Ficha.NUMERO_FICHA_MENOR; numero <= Ficha.NUMERO_FICHA_MAYOR; numero++) {
                    fichas.add(new Ficha(numero, color));
                }
            }
        }
        return fichas;
    }

    // Método para barajar las fichas
    public static void barajarFichas(int movimientos, List<Ficha> lista) {
        Random random = new Random();
        for (int i = 0; i < movimientos; i++) {
            // Elige dos fichas aleatorias e intercambia sus posiciones
            int posicion1 = random.nextInt(lista.size());
            int posicion2 = random.nextInt(lista.size());
            Collections.swap(lista, posicion1, posicion2);
        }
    }

    // Método para sacar fichas de una lista
    public static List<Ficha> sacarFichas(int cantidad, List<Ficha> lista) {
        if (cantidad > lista.size()) {
            throw new IllegalArgumentException("No hay suficientes fichas en la lista");
        }
        List<Ficha> fichasSacadas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            // Elige una ficha aleatoria de la lista y la agrega a la lista de fichas sacadas
            int posicion = random.nextInt(lista.size());
            fichasSacadas.add(lista.remove(posicion));
        }
        return fichasSacadas;
    }
}