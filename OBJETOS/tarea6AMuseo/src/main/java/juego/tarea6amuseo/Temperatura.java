/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public final class Temperatura extends Sensor{
    public final int MAX_TMP = 25;
    public final int MIN_TMP = 15;
    public int temperatura;

    public Temperatura(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void alarma() {
        if (temperatura > MAX_TMP || temperatura < MIN_TMP){
            System.out.println("Alarma  sala" + this.getNombre() + "por temperatura incorrecta");
        }
    }

    @Override
    public void mostrarDetalles() {
    }


   
    
}
