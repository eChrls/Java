package Apartados;

public class MainEj2 {

    public static void main(String[] args) {
        // Array de ejemplo
        String[] palabras = {"Mesa", "Bueno", "MiauMi", "Rtddr", "Medioeuropeo"};

        // Obtener resultados
        int[] resultados = Ejercicio2.contarVocalesSeguidas(palabras);

        // Mostrar resultados
        System.out.print("Palabras analizadas: ");
        for (String palabra : palabras) {
            System.out.print(palabra + " ");
        }

        System.out.print("\nVocales consecutivas: {");
        for (int i = 0; i < resultados.length; i++) {
            System.out.print(resultados[i]);
            if (i < resultados.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
