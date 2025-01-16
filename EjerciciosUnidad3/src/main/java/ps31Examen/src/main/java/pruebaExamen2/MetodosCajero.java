package pruebaExamen2;

import javax.swing.JOptionPane;

public class MetodosCajero {

    /*a) Una función para introducir un número double por JOption, controlando excepciones. 
    Esta función vuelve a pedir el dato hasta que sea un número. No recibe parámetros 
    y devuelve el double introducido. Esta función debe usarse en las opciones 2 y 3 del menú.*/
    public static double IntroducirNumero() {
        double numero = 0.0;
        String frase = "";
        String num = "";

        frase = """
                       Introduce una cantidad numérica por favor: 
                       
                       """;
        num = JOptionPane.showInputDialog(frase);

        try {

            numero = Integer.parseInt(num);

        } catch (NumberFormatException nfe) {
            System.out.println("Dato introducido incorrecto, vuelve a introducir un número");
        }
        return numero;
    }

    /*b) Una función, llamada ingresar, que recibe dos parámetros, el saldo actual y el dinero a ingresar. 
    Esta función devuelve la suma de ambas cantidades y no muestra nada por consola ni por diálogos. 
    Esta función se usa en la opción 2 del menú.*/
    public static double Ingresar(double saldoInicial, double dineroIngreso) {
        return saldoInicial + dineroIngreso;
    }

    /*c) Una función, llamada sacar, que recibe dos parámetros, el saldo actual y el dinero a retirar. 
    Esta función devuelve la resta de ambas cantidades y no muestra nada por consola ni por diálogos. 
    Esta función se usa en la opción 3 del menú.*/
    public static double Sacar(double saldoInicial, double dineroAretirar) {
        
        return saldoInicial - dineroAretirar;

    }

}
