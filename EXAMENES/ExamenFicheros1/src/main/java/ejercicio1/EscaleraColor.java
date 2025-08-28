package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EscaleraColor {

    private static final Map<String, Integer> VALORES_CARTAS = new HashMap<>();
    private static final Map<Integer, String> NOMBRES_CARTAS = new HashMap<>();

    static {
        VALORES_CARTAS.put("A", 1);
        VALORES_CARTAS.put("2", 2);
        VALORES_CARTAS.put("3", 3);
        VALORES_CARTAS.put("4", 4);
        VALORES_CARTAS.put("5", 5);
        VALORES_CARTAS.put("6", 6);
        VALORES_CARTAS.put("7", 7);
        VALORES_CARTAS.put("8", 8);
        VALORES_CARTAS.put("9", 9);
        VALORES_CARTAS.put("10", 10);
        VALORES_CARTAS.put("J", 11);
        VALORES_CARTAS.put("Q", 12);
        VALORES_CARTAS.put("K", 13);

        NOMBRES_CARTAS.put(1, "A");
        NOMBRES_CARTAS.put(2, "2");
        NOMBRES_CARTAS.put(3, "3");
        NOMBRES_CARTAS.put(4, "4");
        NOMBRES_CARTAS.put(5, "5");
        NOMBRES_CARTAS.put(6, "6");
        NOMBRES_CARTAS.put(7, "7");
        NOMBRES_CARTAS.put(8, "8");
        NOMBRES_CARTAS.put(9, "9");
        NOMBRES_CARTAS.put(10, "10");
        NOMBRES_CARTAS.put(11, "J");
        NOMBRES_CARTAS.put(12, "Q");
        NOMBRES_CARTAS.put(13, "K");
    }

    public static void main(String[] args) {
        String inputFile = "escaleracolor.txt";
        String outputFile = "escaleracolor_resultado.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String resultado = encontrarCartaEscalera(line);
                bw.write(resultado);
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al procesar los ficheros: " + e.getMessage());
        }
    }

    private static String encontrarCartaEscalera(String manoStr) {
        String[] cartasStr = manoStr.split(" ");
        if (cartasStr.length != 4) {
            return "NADA";
        }

        List<Carta> mano = new ArrayList<>();
        String paloComun = null;
        for (String cartaStr : cartasStr) {
            String valorStr = cartaStr.substring(0, cartaStr.length() - 1);
            String paloStr = cartaStr.substring(cartaStr.length() - 1);
            mano.add(new Carta(VALORES_CARTAS.get(valorStr), paloStr));
            if (paloComun == null) {
                paloComun = paloStr;
            } else if (!paloComun.equals(paloStr)) {
                return "NADA"; // Palos diferentes
            }
        }

        if (paloComun == null) {
            return "NADA";
        }

        mano.sort(Comparator.comparingInt(Carta::getValor));

        // Buscar la carta que falta para la escalera más alta
        for (int valor = 13; valor >= 1; valor--) {
            int count = 0;
            for (Carta carta : mano) {
                if (carta.getValor() >= valor && carta.getValor() < valor + 5) {
                    count++;
                }
            }
            if (count == 4) {
                for (int v = valor; v < valor + 5; v++) {
                    boolean encontrada = false;
                    for (Carta carta : mano) {
                        if (carta.getValor() == v) {
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        return NOMBRES_CARTAS.get(v) + " " + paloComun;
                    }
                }
            }
        }

        return "NADA";
    }

    static class Carta {
        int valor;
        String palo;

        public Carta(int valor, String palo) {
            this.valor = valor;
            this.palo = palo;
        }

        public int getValor() {
            return valor;
        }

        public String getPalo() {
            return palo;
        }

        @Override
        public String toString() {
            return NOMBRES_CARTAS.get(valor) + palo;
        }
    }
}