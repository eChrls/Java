package metodosgenericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    /*
        En este ejemplo se implementan métodos genéricos que permiten trabajar con
        diferentes tipos de datos sin necesidad de sobrecargar los métodos.
        Se pueden usar en cualquier clase, no solo en clases genéricas.
        La clase que contiene los métodos genéricos no necesita ser genérica.
    */
public class MetodosGenericos {


    /* 
     Todas las declaraciones de métodos genéricos tienen una sección de 
     parámetros de tipo delimitada por el diamante (<>) que preceden 
     al tipo de retorno del método( p.ej. <E>). Esta sección puede indicar varios tipos
     separados por comas (p. ej. <E,T>).
     Las variables de tipo también pueden ser devueltas y pasadas como argumento.
     En tiempo de compilación Java sustituye el dato genérico por el tipo de dato
     que detecta en la llamada a la función.
     Existen una serie de convenciones para nombrar a los tipos genéricos:

        E – Element (usado bastante por Java Collections Framework)
        K – Key (Llave, usado en mapas)
        N – Number (para números)
        T – Type (Representa un tipo, es decir, una clase)
        V – Value (representa el valor, también se usa en mapas)
        S,U,V - usado para representar otros tipos.
    */
    
    /*
        El siguiente ejemplo implementa un método genérico que muestra el toString
        y el nombre de la clase de cualquier objeto que se pase.
        Con <T> antes del tipo de retorno se indica que el método es genérico. Esto significa que el método puede trabajar
        con cualquier tipo de dato que se le pase, y ese tipo será determinado en tiempo de compilación. 
    */
    public static <T> void mostrar(T objeto){
        System.out.println("toString: " + objeto.toString() + " - nombre de la clase: " + objeto.getClass().getName());
    }
    
    /*  El siguiente método genérico <T>, devuelve una lista de un tipo genérico List<T>,
        que se genera desde un array que se pasa como parámetro, con el mismo tipo T[].
        Si se llama a la función con un array de «Float», T se sustituirá por «Float»,
        si lo hacemos con «Integer» igual, y así con cualquier tipo. 
     */
    public static <T> List<T> genericArrayToList(T[] array) {
        List<T> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(array));
        return lista;
    }
    
    /*
        Este método usa dos tipos genéricos <U,T> y comprueba si los tipos
        son iguales, devolviendo true o false.
        Se usa el método getClass() para obtener la clase del objeto y se compara
        con el método equals().
    */
    public static <U,T> boolean compararTipos(U e1, T e2){
        return e1.getClass().equals(e2.getClass());
    }

    /*  En este ejemplo se implementa un método genérico con restricción de tipo <T extends Comparable<T>>. 
        <T extends Comparable<T>> indica que el tipo T debe implementar la interfaz Comparable.
        Esto significa que el método solo puede ser llamado con tipos que implementen
        Recibe dos parámetros del mismo tipo genérico y devuelve el mayor de los dos.
    */
    public static <T extends Comparable<T>> T mayor(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }


}
