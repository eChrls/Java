package PaqueteDeVotaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class FuncionesVotacion {

    // Solicita los nombres de los candidatos
    public static String[] NombresCandidatos(int numCandidatos) {
        String[] nomCandidatos = new String[numCandidatos];
        for (int i = 0; i < numCandidatos; i++) {
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del candidato nº" + (i + 1));
            nomCandidatos[i] = nombre;
        }
        return nomCandidatos;
    }

    // Asigna letras mayúsculas ('A', 'B', ...) a cada candidato
    public static char[] LetrasMayusculas(int numCandidatos) {
        char[] LetrasMayusculas = new char[numCandidatos];
        for (int i = 0; i < numCandidatos; i++) {
            LetrasMayusculas[i] = (char) ('A' + i);
        }
        return LetrasMayusculas;
    }

    // Solicita los votos y los almacena en una lista hasta que el usuario ingrese '*'
    public static ArrayList<String> ListaVotos(char[] LetrasMayusculas) {
        ArrayList<String> ListaVotos = new ArrayList<>();
        String voto;

        do {
            voto = JOptionPane.showInputDialog("Introduce la letra del candidato que quieras que gane (* para terminar):");
            if (voto.equals("*")) {
                break;
            }

            // Validar que el voto es una letra válida
            if (voto.length() == 1 && esVotoValido(voto.charAt(0), LetrasMayusculas)) {
                ListaVotos.add(voto);
            } else {
                JOptionPane.showMessageDialog(null, "Voto inválido. Introduce una letra válida.");
            }
        } while (true);//no me gusta while true, pero en este caso creo que es la mejor opción

        return ListaVotos;
    }

    // Comprueba si el voto es válido
    private static boolean esVotoValido(char voto, char[] LetrasMayusculas) {
        for (char letra : LetrasMayusculas) {
            if (voto == letra) {
                return true;
            }
        }
        return false;
    }

    // Cuenta los votos y devuelve una lista con el número de votos por candidato
    public static ArrayList<Integer> RecuentoVotos(char[] LetrasMayusculas, ArrayList<String> ListaVotos) {
        ArrayList<Integer> NumeroVotos = new ArrayList<>(LetrasMayusculas.length);

        // Inicializar contador de votos a cero para cada candidato
        for (int i = 0; i < LetrasMayusculas.length; i++) {
            NumeroVotos.add(0);
        }

        // Contar votos
        for (String voto : ListaVotos) {
            char letraVoto = voto.charAt(0);
            for (int i = 0; i < LetrasMayusculas.length; i++) {
                if (LetrasMayusculas[i] == letraVoto) {
                    NumeroVotos.set(i, NumeroVotos.get(i) + 1);
                    break;
                }
            }
        }

        return NumeroVotos;
    }
}
