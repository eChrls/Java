/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public abstract class Sensor extends Sala{
    private int id;

    public Sensor(String nombre, String id) {
        super(nombre, id);
    }
    
    
    public abstract void alarma();
    
}
