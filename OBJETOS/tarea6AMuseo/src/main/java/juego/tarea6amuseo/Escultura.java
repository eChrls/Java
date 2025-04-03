/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Escultura extends Obra {
    private String material;

    public Escultura(String id, String autor, String material) {
        super(id, autor);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}