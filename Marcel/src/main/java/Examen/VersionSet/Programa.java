package Examen.VersionSet;


import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    public static void main(String[] args) {
        // "Genera una lista con todas las fichas del juego, invocando el método generarTodas()."
        Set<Ficha> fichasSet = OperacionesRummi.generarTodas();

        // "Usando un iterador, recorre la lista y muestra por pantalla el contenido."
        for (Ficha ficha : fichasSet) {
            System.out.println(ficha);
        }

        // "Baraja la lista anterior, usa 1000 movimientos. Muestra el contenido usando un foreach y una expresión lambda."
        Set<Ficha> fichasSetBarajado = OperacionesRummi.barajarFichas(1000, fichasSet);
        fichasSetBarajado.forEach(System.out::println);

        // "Saca 30 fichas, guardando el resultado en una nueva lista. Muestra el contenido de la nueva lista de 30 fichas, así como su tamaño. Muestra el contenido de la lista original, así como su tamaño."
        Set<Ficha> fichasSacadasSet = OperacionesRummi.sacarFichas(30, fichasSetBarajado);
        System.out.println("Fichas sacadas:");
        fichasSacadasSet.forEach(System.out::println);
        System.out.println("Tamaño de fichas sacadas: " + fichasSacadasSet.size());
        System.out.println("Fichas restantes:");
        fichasSetBarajado.forEach(System.out::println);
        System.out.println("Tamaño de fichas restantes: " + fichasSetBarajado.size());

        // "Comprueba si existe un trío, mostrando el resultado por pantalla."
        List<Ficha> trio = existeTrio(new ArrayList<>(fichasSacadasSet));
        System.out.println("Trío encontrado en posiciones: " + trio);

        // "Comprueba si existe una escalera, mostrando el resultado por pantalla."
        List<Ficha> escalera = existeEscalera(new ArrayList<>(fichasSacadasSet));
        System.out.println("Escalera encontrada en posiciones: " + escalera);
    }

    // Método para comprobar si existe un trío
    public static List<Ficha> existeTrio(List<Ficha> lista) {
        if (lista == null || lista.size() < 3) {
            return null;
        }

        for (int i = 0; i < lista.size() - 2; i++) {
            for (int j = i + 1; j < lista.size() - 1; j++) {
                for (int k = j + 1; k < lista.size(); k++) {
                    Ficha ficha1 = lista.get(i);
                    Ficha ficha2 = lista.get(j);
                    Ficha ficha3 = lista.get(k);

                    if (ficha1.getNumero() == ficha2.getNumero() &&
                            ficha1.getNumero() == ficha3.getNumero() &&
                            ficha1.getColor() != ficha2.getColor() &&
                            ficha1.getColor() != ficha3.getColor() &&
                            ficha2.getColor() != ficha3.getColor()) {
                        return List.of(ficha1, ficha2, ficha3);
                    }
                }
            }
        }
        return null;
    }

    // Método para comprobar si existe una escalera
    public static List<Ficha> existeEscalera(List<Ficha> lista) {
        if (lista == null || lista.size() < 3) {
            return null;
        }

        for (int i = 0; i < lista.size() - 2; i++) {
            for (int j = i + 1; j < lista.size() - 1; j++) {
                for (int k = j + 1; k < lista.size(); k++) {
                    Ficha ficha1 = lista.get(i);
                    Ficha ficha2 = lista.get(j);
                    Ficha ficha3 = lista.get(k);

                    if (ficha1.getColor() == ficha2.getColor() &&
                            ficha1.getColor() == ficha3.getColor()) {
                        List<Integer> numeros = List.of(ficha1.getNumero(), ficha2.getNumero(), ficha3.getNumero());
                        numeros.sort(null);

                        if (numeros.get(1) == numeros.get(0) + 1 && numeros.get(2) == numeros.get(1) + 1) {
                            return List.of(ficha1, ficha2, ficha3);
                        }
                    }
                }
            }
        }
        return null;
    }
}