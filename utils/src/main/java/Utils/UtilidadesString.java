package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Indice:
 * -> Reemplazos y conversiones
 * -> ToString-Sb para arrays y editables
 * -> Comprobar un dni
 * 1. Comparadores de Strings
 * 2. Ordenacion alfabetica
 * 3. Ordenacion por longitud
 * 1. Validacion email
 * 2. Contar ocurrencias
 * 3. Expresiones regulares
 * 1. Contar letras
 */
public class UtilidadesString {
    public static void main(String[] args) {
        ejemplosString();
    }

    public static void ejemplosString() {
        // Reemplazos
        String texto = "ejemplo texto texto";
        String reemplazado = texto.replace("texto", "palabra");
        String reemplazadoTodo = texto.replaceAll("\\s+", "-");

        // Primitivos a String
        String strFromInt = String.valueOf(42);
        String strFromDouble = String.valueOf(3.14);
        String strFromBoolean = String.valueOf(true);

        // String a Primitivos
        int intFromStr = Integer.parseInt("42");
        double doubleFromStr = Double.parseDouble("3.14");
        boolean boolFromStr = Boolean.parseBoolean("true");

        // Conversiones String-Char
        char caracter = texto.charAt(0);
        char[] arrayChars = texto.toCharArray();
        String strFromChar = String.valueOf('c');
        String strFromChar2 = Character.toString('c');

        char[] chars = { 'h', 'o', 'l', 'a' };
        String strFromCharArray = new String(chars);
    }

    /*
     * String Builders
     * RECORRER UN ARRAY
     * 
     * @Override
     * public String toString() {
     * StringBuilder sb = new StringBuilder();
     * for (int i = 0; i < TOTAL; i++) {
     * if(cartas[i] != null){
     * sb.append(cartas[i].toString()).append("\n");
     * }
     * }
     * return sb.toString();
     * }
     * 
     * DAR FORMATO ESPECIFICO
     * 
     * @Override
     * public String toString(){
     * String numeroStr;
     * numeroStr = switch (numero) {
     * case 8 -> "Sota";
     * case 9 -> "Caballo";
     * case 10 -> "Rey";
     * default -> numero.toString();
     * };
     * return numeroStr + "  de  " + palo ;
     * }
     * 
     * 
     * 
     *//*
        ****************************************************************************************************************** 
        * /*FUNCION PARA VALIDAR UN DNI DE 8 DIGITOS Y UNA LETRA
        * public boolean validar(){
        * if(numero.length() != 8){
        * return false;
        * }
        * /*Comprobacion de la letra del dni.
        * el número del DN es dividido entre 23. El resto se compara con unas tablas
        * que asignan numeros a letras
        * RESTO 0 1 2 3 4 5 6 7 8 9 10 11
        * LETRA T R W A G M Y F P D X B
        * RESTO 12 13 14 15 16 17 18 19 20 21 22
        * LETRA N J Z S Q V H L C K E
        * 
        * try{
        * int num = Integer.parseInt(numero);
        * 
        * String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        * int indice = num%23;
        * char letraCalculada = letras.charAt(indice);
        * 
        * return letraCalculada == letra;
        * 
        * }catch (NumberFormatException e){
        * return false;
        * }
        * }
        ***************************************************************************************************************
        * 
        * /**
        * Comparador para ordenar strings por orden alfabético ignorando
        * mayúsculas/minúsculas.
        */
    public static final Comparator<String> COMPARADOR_ALFABETICO = String::compareToIgnoreCase;

    /**
     * Comparador para ordenar strings por longitud.
     */
    public static final Comparator<String> COMPARADOR_LONGITUD = Comparator.comparingInt(String::length);

    /**
     * Ordena una lista de strings por el abecedario.
     *
     * @param lista lista a ordenar
     */
    public static void ordenarAlfabeticamente(List<String> lista) {
        Collections.sort(lista, COMPARADOR_ALFABETICO);
    }

    /**
     * Ordena una lista de strings por longitud (menor a mayor).
     *
     * @param lista lista a ordenar
     */
    public static void ordenarPorLongitud(List<String> lista) {
        Collections.sort(lista, COMPARADOR_LONGITUD);
    }

    /**
     * Valida si una cadena es una dirección de correo electrónico válida.
     *
     * @param email cadena a validar
     * @return true si es una dirección de correo electrónico válida
     */
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Cuenta las ocurrencias de una subcadena en una cadena.
     *
     * @param cadena    cadena principal
     * @param subcadena subcadena a buscar
     * @return número de ocurrencias
     */
    public static int contarOcurrencias(String cadena, String subcadena) {
        int count = 0;
        int index = 0;
        while ((index = cadena.indexOf(subcadena, index)) != -1) {
            count++;
            index += subcadena.length();
        }
        return count;
    }

    /**
     * Extrae todos los números de una cadena usando expresiones regulares.
     *
     * @param cadena cadena de entrada
     * @return lista de números extraídos
     */
    public static List<String> extraerNumeros(String cadena) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(cadena);
        return matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }

    /**
     * Divide una cadena en palabras y devuelve una lista de estas.
     *
     * @param cadena cadena de entrada
     * @return lista de palabras
     */
    public static List<String> dividirEnPalabras(String cadena) {
        return Arrays.asList(cadena.split("\\s+"));
    }

    /**
     * Cuenta la frecuencia de cada letra en una cadena.
     *
     * @param cadena Cadena a analizar.
     * @return Un array de enteros donde cada posición representa la frecuencia de
     *         la letra correspondiente (a=0, b=1, ..., z=25).
     */
    public static int[] contarFrecuenciaLetras(String cadena) {
        int[] frecuencia = new int[26]; // Asume solo letras del alfabeto inglés.
        cadena = cadena.toLowerCase(); // Convertir a minúsculas para simplificar el conteo.

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c >= 'a' && c <= 'z') {
                frecuencia[c - 'a']++;
            }
        }
        return frecuencia;

    }

}