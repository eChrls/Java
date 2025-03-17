/*
Realiza un programa que permita gestionar los asientos de un teatro.
El teatro tendrá siempre el doble de columnas que de filas y no puede tener más de 5 filas,
en otro caso no se puede crear el teatro. Se debe permitir reservar un asiento ("R"),
o liberar una butaca ("L"), según su identificador (1A, 3B...). Las butacas se identifican mediante
su fila (1,2,3,4,5) y su columna (A, B, C, D ...). A la hora de imprimir el estado de las butacas
hay que seguir el siguiente esquema:
   A  B  C  D
1 L  R  L   L
2 R  R  R   L
3 ....*/
package tarea5D;
/**
 * Clase principal del programa que gestiona los asientos de un teatro.
 * Esta clase contiene el método main y se encarga de probar la funcionalidad
 * de la clase Teatro.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        // Creamos un teatro con 4 filas (tendrá 8 columnas automáticamente)
        Teatro miTeatro = new Teatro(4);
        
        System.out.println("\n--- Realizando reservas iniciales ---");
        // Probamos a reservar algunos asientos en diferentes posiciones
        miTeatro.reservarAsiento("1A"); // Esquina superior izquierda
        miTeatro.reservarAsiento("2B"); // Segunda fila, segunda columna
        miTeatro.reservarAsiento("3C"); // Tercera fila, tercera columna
        miTeatro.reservarAsiento("4D"); // Esquina inferior derecha
        
        // Mostramos el estado actual del teatro
        System.out.println("\n--- Estado inicial del teatro ---");
        miTeatro.mostrarEstado();
        
        System.out.println("\n--- Liberando un asiento ---");
        // Liberamos un asiento previamente reservado
        miTeatro.liberarAsiento("3C");
        
        // Mostramos el estado después de la liberación
        System.out.println("\n--- Estado después de liberar el asiento 3C ---");
        miTeatro.mostrarEstado();
        
        System.out.println("\n--- Prueba de reserva en asiento ocupado ---");
        // Intentamos reservar un asiento que ya está ocupado
        miTeatro.reservarAsiento("1A");
        
        System.out.println("\n--- Prueba de límite de filas ---");
        // Probamos a crear un teatro con más filas de las permitidas
        Teatro teatroInvalido = new Teatro(6);
    }
}
