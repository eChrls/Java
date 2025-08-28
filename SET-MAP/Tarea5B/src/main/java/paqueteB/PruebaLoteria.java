/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteB;

import java.util.Scanner;

public class PruebaLoteria {
    public static void main(String[] args) {
        // Creamos una instancia del sistema de lotería
        SistemaLoteria sistema = new SistemaLoteria();
        
        // Generamos 1000 décimos aleatorios
        sistema.generarDecimosAleatorios(1000);
        System.out.println("Se han generado " + sistema.contarDecimos() + " décimos");
        
        // Creamos un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Bucle para consultar décimos
        while (true) {
            System.out.print("\nIntroduce el número del décimo (o 'salir' para terminar): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("salir")) {
                break;
            }
            
            // Consultamos el premio asociado al décimo
            Double premio = sistema.consultarPremio(input);
            
            if (premio != null) {
                System.out.printf("El décimo %s tiene un premio de %.2f euros\n", 
                                  input, premio);
            } else {
                System.out.println("El décimo introducido no está registrado");
            }
        }
        
        scanner.close();
    }
}