/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public class Pintura extends Obra {
    private String estilo;

    public Pintura(String id, String autor, String estilo) {
        super(id, autor);
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }
}
