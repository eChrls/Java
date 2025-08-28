/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Escultorico extends Conservador {
    public Escultorico(String nif, String nombre, int numHerramientas) {
        super(nif, nombre, numHerramientas);
    }

    @Override
    public void restaurar(Obra obra) {
        if (obra instanceof Escultura) {
            System.out.println("Conservador escultórico " + getNombre() + " está restaurando la escultura: " + obra.getId());
        } else {
            System.out.println("El conservador escultórico " + getNombre() + " solo puede restaurar esculturas.");
        }
    }
}