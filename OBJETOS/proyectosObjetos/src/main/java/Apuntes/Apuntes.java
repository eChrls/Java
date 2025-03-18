
package Apuntes;

import java.util.ArrayList;
import java.util.List;

public class Apuntes {

    // HERENCIA

    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Renault", "Clio", 2015);
        Furgoneta f1 = new Furgoneta("Renault", "Kangoo", 2015, 1000);

        System.out.println(v1.toString());
        System.out.println(f1.toString());

        //En colecciones de la clase padre podemos almacenar objetos de la clase hija
        // y viceversa. En este caso, la variable vehiculo puede referirse a un objeto de
        // la clase Vehiculo o a un objeto de la clase Furgoneta. 
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(v1);
        listaVehiculos.add(f1);
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println("Lista: " + vehiculo);
        }




        // Polimorfismo
        // Polimorfismo es la capacidad de un objeto de tomar diferentes formas. En
        // Java, el polimorfismo se refiere a la capacidad de un objeto de ser tratado
        // como una instancia de su superclase. Esto significa que un objeto de una
        // subclase puede ser tratado como un objeto de su superclase. El polimorfismo
        // se logra mediante la herencia y la sobrecarga de métodos.
        // En este caso, la variable vehiculo puede referirse a un objeto de la clase
        // Vehiculo o a un objeto de la clase Furgoneta. Esto permite que el mismo
        // código funcione con diferentes tipos de objetos, lo que aumenta la
        // flexibilidad y la reutilización del código.
        
    






    }
}
