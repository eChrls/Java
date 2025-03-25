
package Examen.VersionSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;

public class OperacionesRummi {

    // "generarTodas() que devuelva una lista con todas las fichas del juego del Rummi."
    public static Set<Ficha> generarTodas() {
        Set<Ficha> fichas = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (Color color : Color.values()) {
                for (int numero = Ficha.NUMERO_FICHA_MENOR; numero <= Ficha.NUMERO_FICHA_MAYOR; numero++) {
                    fichas.add(new Ficha(numero, color));
                }
            }
        }
        return fichas;
    }

    // "barajarFichas(movimientos, lista) que recibe una lista de Fichas, de cualquier tamaño, y las mezcla."
    public static Set<Ficha> barajarFichas(int movimientos, Set<Ficha> lista) {
        // Los Sets no se pueden barajar directamente, así que convertimos el Set a una lista, la barajamos y la volvemos a convertir a Set
        ArrayList<Ficha> listaFichas = new ArrayList<>(lista);
        Random random = new Random();
        for (int i = 0; i < movimientos; i++) {
            int posicion1 = random.nextInt(listaFichas.size());
            int posicion2 = random.nextInt(listaFichas.size());
            Collections.swap(listaFichas, posicion1, posicion2);
        }
        return new HashSet<>(listaFichas);
    }

    // "sacarFichas(cantidad, lista) que recibe la cantidad de fichas a sacar de una lista de objetos Ficha y la lista de donde sacarlas..."
    public static Set<Ficha> sacarFichas(int cantidad, Set<Ficha> lista) {
        if (cantidad > lista.size()) {
            throw new IllegalArgumentException("No hay suficientes fichas en la lista");
        }
        Set<Ficha> fichasSacadas = new HashSet<>();
        ArrayList<Ficha> listaFichas = new ArrayList<>(lista); // Convertimos el Set a una lista para poder sacar fichas aleatoriamente
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int posicion = random.nextInt(listaFichas.size());
            fichasSacadas.add(listaFichas.remove(posicion));
        }
        return fichasSacadas;
    }
}