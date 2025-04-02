/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public abstract class Conservador extends Empleado {
    private int numHerramientas;

    public Conservador(String nif, String nombre, int numHerramientas) {
        super(nif, nombre);
        this.numHerramientas = numHerramientas;
    }

    public int getNumHerramientas() {
        return numHerramientas;
    }

    // Método abstracto para restaurar, cada subclase lo implementará de forma específica
    public abstract void restaurar(Obra obra);
}
