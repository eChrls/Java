package PaqueteDeVotaciones;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SistemaVotacion {

    public static void main(String[] args) {
        int numCandidatos = 0;
        String[] nomCandidatos;
        char[] LetrasMayusculas;
        ArrayList<String> ListaVotos;
        ArrayList<Integer> NumeroVotos;

        // Solicitar el número de candidatos, asegurándose de que sea válido
        do {
            String menu = "¿Cuántos candidatos quieres que participen?";
            String num = JOptionPane.showInputDialog(null, menu);

            try {
                numCandidatos = Integer.parseInt(num);
                if (numCandidatos <= 0) {
                    JOptionPane.showMessageDialog(null, "El número debe ser mayor que cero.");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Dato introducido incorrecto, vuelve a introducir un número.");
            }
        } while (numCandidatos <= 0);

        // Inicializar arrays con el tamaño correcto
        nomCandidatos = FuncionesVotacion.NombresCandidatos(numCandidatos);
        LetrasMayusculas = FuncionesVotacion.LetrasMayusculas(numCandidatos);

        // Mostrar candidatos con sus letras asignadas
        StringBuilder candidatosInfo = new StringBuilder("Candidatos:\n");
        for (int i = 0; i < numCandidatos; i++) {
            candidatosInfo.append(LetrasMayusculas[i])
                          .append(" - ")
                          .append(nomCandidatos[i])
                          .append("\n");
        }
        JOptionPane.showMessageDialog(null, candidatosInfo.toString());

        // Registrar votos y hacer el recuento
        ListaVotos = FuncionesVotacion.ListaVotos(LetrasMayusculas);
        NumeroVotos = FuncionesVotacion.RecuentoVotos(LetrasMayusculas, ListaVotos);

        // Mostrar resultados finales
        System.out.println("Resultados:");
        for (int i = 0; i < numCandidatos; i++) {
            System.out.println(nomCandidatos[i] + " - Votos: " + NumeroVotos.get(i));
        }
    }
}
