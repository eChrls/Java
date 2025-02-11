
package main;


import java.util.Scanner;

public class cajero {

    public static void main(String[] args) {
    
        
        float saldoInicial = 112.34f;
        String conversion = Float.toString(saldoInicial);
        double saldoIni = Double.parseDouble(conversion);
        double num = 0.0; 
        int opcion = 0;
        double saldoFin; 
        
        
        boolean repetir = true; // Variable que controla si el menú debe mostrarse de nuevo o no
        do {
            // Menú de opciones que se muestra al usuario
            
            
            String menu = """
                        Selecciona una opción del menú:              
                        1-Mostrar el saldo
                        2-Ingresar dinero
                        3-Sacar dinero
                        """;
            System.out.println(menu); // El usuario ve el menú en la consola
            Scanner sc = new Scanner (System.in);

                opcion = sc.nextInt(); // Lee la opción seleccionada por el usuario
                    switch (opcion) {
                        case 1 -> { // Si el usuario selecciona la opción 1, se ejecuta la funcion mostrar saldo
                            System.out.printf("Su saldo es : %.2f%n", saldoIni);  
                        }    
                        case 2 -> { // Si el usuario selecciona la opción 2, se ejecuta funcion ingresar dinero
                            /*funciones.introducirNumero(num);
                            funciones.ingresar(saldoIni, saldoFin);*/
                        }
                        // Llama al método    
                        case 3 -> { // Si el usuario selecciona la opción 3, se ejecuta funcion sacar dinero
                          
                            sc.next();
                            
                            System.out.println("Por favor introduzca la cantidad a retirar: ");
                            double cantidad = sc.nextDouble();
                                if (cantidad > saldoIni ){
                                    System.out.println("Cantidad introducida incorrecta, saldo negativo. Vuelva a intentar");       
                                    }else { 
                                    
                                   /* funciones.sacar(saldoIni, cantidad);*/
                        }
                        }
                        default -> // Si el usuario selecciona una opción no válida
                        System.out.println("Por favor, selecciona una opción válida."); // Muestra mensaje para opción no válida  
                    } 
                    repetir = false; // Pone `repetir` en `false` para salir del bucle después de una ejecución válida
                    repetir = preguntarRepetirSalir(sc);// Pregunta al usuario si quiere repetir o salir
        }while (repetir);
                                  
    }   
            
        private static boolean preguntarRepetirSalir(Scanner sc) {
        String respuesta;
        do {
            System.out.print("¿Quieres repetir o salir? (escribe 'otra' o 'salir'): ");
            respuesta = sc.nextLine().trim().toLowerCase(); // Lee la respuesta y la convierte a minúsculas
        } while (!respuesta.equals("otra") && !respuesta.equals("salir")); // Repite hasta que el usuario ingrese "repetir" o "salir"

        // Si el usuario ingresa "repetir", el bucle en `main` continuará; si elige "salir", el bucle finalizará
        return respuesta.equals("otra"); // Retorna true si el usuario quiere repetir, false si quiere salir
    }
}
