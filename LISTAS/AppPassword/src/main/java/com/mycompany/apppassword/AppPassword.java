package com.mycompany.apppassword;

import java.util.*;

public class AppPassword {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int opcion = 0;

        System.out.println("Bienvenido a la app de seguridad");
        //hacemos menu y bucle do while
        do {
            String menu = """
                          Elija la opción de lo que desee crear: 
                          1- Pin
                          2- Contraseña
                          3- Secuencia de "n" letras
                          4- Salir
                          """;

            System.out.println(menu);
            // Capturamos la opción del usuario
            opcion = s.nextInt();
            // Condicionales para ejecutar la opción seleccionada
            if (opcion == 1) {
                // Llamamos a la clase GeneraPin y mostramos el PIN generado   
                System.out.println("Hemos generado este pin para ti:  " + GeneraPin.damePin());

            } else if (opcion == 2) {
                // Llamamos a la clase GeneraContraseña y mostramos la contraseña generada   
                System.out.println("Hemos generado esta contraseña para ti" + GeneraContraseña.DameContraseña());

            } else if (opcion == 3) {
                // Llamamos a la clase GeneraSecuencia y mostramos la secuencia generada   
                System.out.println("Hemos generado esta Secuencia para ti" + GeneraSecuencia.DameSecuencia());

            } else if (opcion < 1 || opcion > 4) {
                // Avisamos de que la opción es incorrecta si no está entre 1 y 4   
                System.out.println("Opción elegida incorrecta, vuelva a empezar");
            }// Opción 4 terminará el bucle sin ninguna acción adicional
        } while (opcion != 4);

        System.out.println("Gracias por usar la app de seguridad");
    }
}
