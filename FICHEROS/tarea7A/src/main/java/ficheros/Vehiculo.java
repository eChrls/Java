/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package ficheros;

import java.time.Year;

/**
 *
 * @author carlos
 */
public record Vehiculo(String marca, String modelo, int año, String vin, String color, String matricula) {
    @Override
    public String toString() {
        return marca + "," + modelo + "," + año + "," + vin + "," + color + "," + matricula; //sobreescribo toString para facilitar la escritura en CSV
    }
}
