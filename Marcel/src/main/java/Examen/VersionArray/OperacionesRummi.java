
package Examen.VersionArray;

import java.util.Random;

public class OperacionesRummi {

    // Constante para el número de fichas por color
    public static final int NUMERO_FICHAS_POR_COLOR = 13;

    // "generarTodas() que devuelva una lista con todas las fichas del juego del Rummi."
    public static Ficha[] generarTodas() {
        Ficha[] fichas = new Ficha[NUMERO_FICHAS_POR_COLOR * 4 * 2]; // 4 colores, 13 números, 2 conjuntos
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (Color color : Color.values()) {
                for (int numero = Ficha.NUMERO_FICHA_MENOR; numero <= Ficha.NUMERO_FICHA_MAYOR; numero++) {
                    fichas[index++] = new Ficha(numero, color);
                }
            }
        }
        return fichas;
    }

    // "barajarFichas(movimientos, lista) que recibe una lista de Fichas, de cualquier tamaño, y las mezcla."
    public static void barajarFichas(int movimientos, Ficha[] lista) {
        Random random = new Random();
        for (int i = 0; i < movimientos; i++) {
            int posicion1 = random.nextInt(lista.length);
            int posicion2 = random.nextInt(lista.length);
            Ficha temp = lista[posicion1];
            lista[posicion1] = lista[posicion2];
            lista[posicion2] = temp;
        }
    }

    // "sacarFichas(cantidad, lista) que recibe la cantidad de fichas a sacar de una lista de objetos Ficha y la lista de donde sacarlas..."
    public static Ficha[] sacarFichas(int cantidad, Ficha[] lista) {
        if (cantidad > lista.length) {
            throw new IllegalArgumentException("No hay suficientes fichas en la lista");
        }
        Ficha[] fichasSacadas = new Ficha[cantidad];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int posicion = random.nextInt(lista.length);
            fichasSacadas[i] = lista[posicion];
            // Eliminar la ficha sacada de la lista original
            lista[posicion] = null;
            //lista[j] = lista[j+1] desplaza cada elemento una posición hacia la izquierda. 
            //Esto significa que el elemento que estaba en la posición j + 1 se copia a la posición j, 
            //llenando así el hueco que dejó la ficha sacada.
            for (int j = posicion; j < lista.length - 1; j++) {
                lista[j] = lista[j + 1];
            }
            lista[lista.length - 1] = null;
        }
        return fichasSacadas;
    }
}