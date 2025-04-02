/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.tarea6amuseo;

/**
 *
 * @author carlos
 */
public abstract class Obra {
    private String id;
    private String autor;
    
    public Obra(String id, String autor) {
        this.id = id;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    // Otros atributos y métodos comunes a las obras
}
