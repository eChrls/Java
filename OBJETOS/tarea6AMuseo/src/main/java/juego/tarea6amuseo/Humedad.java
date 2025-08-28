/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Humedad extends Sensor{
    public final int MAX_HUM = 55;
    public final int MIN_HUM = 5;
    public int nivelHumedad;

    public Humedad(String nombre, String id) {
        super(nombre, id);
    }



    @Override
    public void alarma() {
        if (nivelHumedad > MAX_HUM || nivelHumedad < MIN_HUM){
            System.out.println("Alarma  sala" + this.getNombre() + "por nivel de humedad incorrecto");
        }
    }

    @Override
    public void mostrarDetalles() {
    }
}