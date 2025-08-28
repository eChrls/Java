package metodosgenericos;

import java.util.List;



public class Main {

    // Programa de ejemplo para mostrar el uso de métodos genéricos.
    public static void main(String[] args) {
        
        // Se llama al método genérico con diferentes tipos de datos.
        // El compilador sustituye el tipo genérico por el tipo de dato que se le pasa.
        // En este caso, el método se llama con un Integer y un String.
        MetodosGenericos.mostrar(10);
        MetodosGenericos.mostrar("Java");
        
        // Creación de listas de diferentes tipos de datos.
        // Se usa el método genérico para convertir un array en una lista.
        // El método genérico se llama con un array de Float y otro de String.
        Float[] arrayFloat = {1f, 2f, 3f};
        String[] arrayString = {"Java", "C++", "Python"};
        List<Float> listaFloat = MetodosGenericos.genericArrayToList(arrayFloat);
        listaFloat.forEach(e -> System.out.print(e + " "));
        System.out.println("");
        List<String> listaString = MetodosGenericos.genericArrayToList(arrayString);
        listaString.forEach(e -> System.out.print(e + " "));
        System.out.println("");

        // Primero se comparan dos tipos de datos diferentes, lo que devuelve false.
        // Luego se comparan dos tipos de datos iguales, lo que devuelve true.
        Integer value = 4;
        System.out.println(MetodosGenericos.compararTipos(value, "Java"));
        System.out.println(MetodosGenericos.compararTipos("C", "Java"));

        // Se llama al método genérico para obtener el mayor de dos números.
        System.out.println(MetodosGenericos.mayor(10, 20));
        System.out.println(MetodosGenericos.mayor(5.5, 3.3));
        System.out.println(MetodosGenericos.mayor("Hola", "Adios"));
    }

}
