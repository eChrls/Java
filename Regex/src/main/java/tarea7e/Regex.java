package tarea7e;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        // 1. Contiene AP- seguido de uno o dos dígitos
        Pattern autopistaPattern = Pattern.compile("AP-\\d{1,2}");
        pruebaFind(autopistaPattern, "Voy por la autopista AP-7 en coche.");

        // 2. Coincide exactamente con el patrón AP-Nº
        Pattern autopistaExactaPattern = Pattern.compile("^AP-\\d{1,2}$");
        pruebaMatches(autopistaExactaPattern, "AP-77");

        // 3. Matrícula exacta: 4 números + 3 letras mayúsculas
        Pattern matriculaExacta = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
        pruebaMatches(matriculaExacta, "1234ABC");

        // 4. Cadena con letra+número repetidos
        Pattern letraNumero = Pattern.compile("([a-z]\\d)+");
        pruebaFind(letraNumero, "e3r4t5x9");

        // 5. Código postal (5 dígitos)
        Pattern codigoPostal = Pattern.compile("[0-9]{5}");
        pruebaMatches(codigoPostal, "29680");

        // 6. Usuario IPasen: letras 7-8 + dígitos 3-4
        Pattern usuarioIPasen = Pattern.compile("^[a-zA-Z]{7,8}\\d{3,4}$");
        pruebaMatches(usuarioIPasen, "torralvc1234");

        // 7. Partes del usuario IPasen
        Pattern usuarioPartido = Pattern.compile("^([a-zA-Z]{7,8})(\\d{3,4})$");
        pruebaGrupos(usuarioPartido, "torralvc1234");

        // 8. Cadena de 5 caracteres que no contenga F, R, ni K
        Pattern cadenaPersonalizada = Pattern.compile("^[^FRKfrk]{5}$");
        pruebaMatches(cadenaPersonalizada, "abcde");

        // 9. Contiene las palabras "Hardware" o "Software", sin importar mayúsculas
        Pattern contieneWare = Pattern.compile("(Hardware|Software)", Pattern.CASE_INSENSITIVE);
        pruebaFind(contieneWare, "Estoy aprendiendo sobre hardware y software.");

        // 10. Número de cuenta con IBAN de 4 caracteres + 20 dígitos
        Pattern dosMayusculas = Pattern.compile("[A-Z]{2}\\d{2}\\d{20}");
        pruebaMatches(dosMayusculas, "ES7620770024003102575766");

        // 11. Dividir partes de un IBAN
        Pattern iban = Pattern.compile("^([A-Z]{2}\\d{2}) (\\d{4})(\\d{4})(\\d{2})(\\d{10})$");
        pruebaGrupos(iban, "ES76 2077 0024 00 3102575766".replace(" ", ""));
    }

    // Método auxiliar para usar matcher.find()
    public static void pruebaFind(Pattern pattern, String texto) {
        System.out.println("\nBuscando coincidencias en: \"" + texto + "\"");
        Matcher matcher = pattern.matcher(texto);
        boolean encontrado = false;
        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
            encontrado = true;
        }
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    // Método auxiliar para usar matcher.matches()
    public static void pruebaMatches(Pattern pattern, String texto) {
        System.out.println("\nComprobando coincidencia exacta con: \"" + texto + "\"");
        if (pattern.matcher(texto).matches()) {
            System.out.println("Coincide exactamente.");
        } else {
            System.out.println("No coincide exactamente.");
        }
    }

    // Método para mostrar grupos de captura
    public static void pruebaGrupos(Pattern pattern, String texto) {
        System.out.println("\nAnalizando grupos en: \"" + texto + "\"");
        Matcher matcher = pattern.matcher(texto);
        if (matcher.matches()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Grupo " + i + ": " + matcher.group(i));
            }
        } else {
            System.out.println("No se pudo hacer match con grupos.");
        }
    }
}
