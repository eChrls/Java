package com.mycompany.apppassword;

import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;

public class GeneraSecuencia {

    public static String DameSecuencia() {

        Scanner s = new Scanner(System.in);

        System.out.println("Introduce en numero de caracteres que desea que sea la secuencia");

        int n = s.nextInt();

        char[] cadena = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        // Usamos un String vacío para iniciar la secuencia
        String secuencia = " ";

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // Selecciona un carácter al azar del array
            char letra = cadena[random.nextInt(cadena.length)];
            // Concatenamos el char letra a secuencia
            secuencia += letra; 
           
        }

        return secuencia;
    }
}
    

