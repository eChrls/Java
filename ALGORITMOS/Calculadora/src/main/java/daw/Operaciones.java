package daw;

public class Operaciones {
    // Metodo sumar
    //s una función que se define dentro de una clase y especifica el comportamiento 
    //de los objetos de esa clase. Puede ser una función (que devuelve un valor) o 
    //un procedimiento (que no devuelve nada).
    // Visibilidad - desde donde puedo usar - public
    // Valor de retorno - da to que devuelve el metodo.
    // Si no hay retorno -> void
    // Nombre del metodo - camelCase
    // Parametros - Si no hay parametros (). Si hay, se indica tipo de dato
    // y nombre

    public static int sumar(int num1, int num2) {
        double datoDevolver = 0;
        datoDevolver = num1 + num2;
        return (int) datoDevolver;
    }

    public static int restar(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    public static double dividir(int num1, int num2) {
        double division = 0;
        try {
            division = num1 / num2;
            return division;
        } catch (ArithmeticException ae) {
            System.out.println("El divisor no puede ser un 0");
        }

        return division;
    }

}
