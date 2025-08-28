package daw;

public class Calculadora {

    public static void main(String[] args) {
        int opcion = 0;
        int resultado = 0;
        double resultadoDiv= 0.0;
        int num1 = 0;
        int num2 = 0;
       
        do {
            SalidaPantalla.mostrarMenu();
            opcion = EntradaDatos.leerScanner();

            switch (opcion) {
                case 1 -> {
                    num1 = EntradaDatos.leerScanner();
                    num2 = EntradaDatos.leerScanner();
                    resultado = Operaciones.sumar(num1, num2);
                    System.out.println(resultado);
                }
                case 2 -> {
                    num1 = EntradaDatos.leerScanner();
                    num2 = EntradaDatos.leerScanner();
                    resultado = Operaciones.restar(num1, num2);
                    System.out.println(resultado);
                }
                case 3 -> {
                    num1 = EntradaDatos.leerScanner();
                    num2 = EntradaDatos.leerScanner();
                    resultado = Operaciones.multiplicar(num1, num2);
                    System.out.println(resultado);
                }
                case 4 -> {
                    num1 = EntradaDatos.leerScanner();
                    num2 = EntradaDatos.leerScanner();
                    resultadoDiv = Operaciones.dividir(num1, num2);
                    if (num2 !=0){
                    System.out.println(resultadoDiv);
                    }
                }    
                                   
                case 5 -> {
                    System.out.println("Has decidido salir");
                }

                default -> {
                    System.out.println("Opción incorrecta");
                }
            }

        } while (opcion != 5);

    }
}
