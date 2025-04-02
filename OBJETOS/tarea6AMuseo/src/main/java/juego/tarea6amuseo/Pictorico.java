/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Pictorico extends Conservador {
    public Pictorico(String nif, String nombre, int numHerramientas) {
        super(nif, nombre, numHerramientas);
    }

    @Override
    public void restaurar(Obra obra) {
        if (obra instanceof Pintura) {
            System.out.println("Conservador pictórico " + getNombre() + " está restaurando la pintura: " + obra.getId());
        } else {
            System.out.println("El conservador pictórico " + getNombre() + " solo puede restaurar pinturas.");
        }
    }
}