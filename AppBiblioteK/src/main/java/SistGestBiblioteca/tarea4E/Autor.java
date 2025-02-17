/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca.tarea4E;

/**
 *
 * @author carlos
 */
public class Autor {
    private String nombreCompleto;
    private String paisOrigen;
    
    
    public Autor (String nombreCompleto){
        this.nombreCompleto = nombreCompleto; 

    }
    
    public Autor(){
        
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombreCompleto=" + nombreCompleto + ", paisOrigen=" + paisOrigen + '}';
    }
    
    
}
