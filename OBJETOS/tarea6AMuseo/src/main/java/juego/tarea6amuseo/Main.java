/*
J Carlos Torralvo
1DAW
 */
package juego.tarea6amuseo;

import java.util.List;

/**
 *
 * @author carlos
 */
public class Main {
    public static void main(String[] args) {
         // Crear un museo
        Museo museoNacional = new Museo("Museo Nacional del Prado", "Madrid, España");

        // Crear obras
        Pintura p1 = new Pintura("PN00741", "Francisco de Goya", "Romanticismo");
        Escultura e1 = new Escultura("ES00001", "Miguel Ángel", "Renacimiento");

        // Crear salas
        Fija salaF1 = new Fija("Sala Goya", "SF001", "09:00", "20:00");
        Fija salaF2 = new Fija("Sala Renacimiento", "SF002", "09:00", "18:00");

        // Añadir obras a las salas
        salaF1.añadirObra(p1);
        salaF2.añadirObra(e1);

        // Añadir salas al museo
        museoNacional.añadirSala(salaF2);
        museoNacional.añadirSala(salaF1);

        // Crear conservadores
        Escultorico e= new Escultorico("78945612B", "Ana Martínez", 5);
        Pictorico p = new Pictorico("12378945A", "Pablo López", 3);

        // Contratar conservadores
        museoNacional.contratarEmpleado(e);
        museoNacional.contratarEmpleado(p);

        // Obtener todas las obras del museo
        List<Obra> obrasDelMuseo = museoNacional.obtenerTodasLasObras();
        System.out.println("\nObras únicas en el museo:");
        for (Obra obra : obrasDelMuseo) {
            System.out.println("- " + obra.getId() + " (" + obra.getClass().getSimpleName() + ")");
        }

        System.out.println("\n--- Restauración por el conservador pictórico ---");
        // Realizar la restauración de las obras del conservador pictórico
        for (Obra obra : obrasDelMuseo) {
            p.restaurar(obra);
        }
    }
    
}
