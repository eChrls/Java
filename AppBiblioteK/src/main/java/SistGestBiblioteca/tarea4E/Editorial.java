/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca.tarea4E;

/**
 *
 * @author carlos
 */
public enum Editorial {
    
    PRENTICEHALL("Prentice- Hall", "New Yersey", "USA"),
    RAMA("Ra-ma ", "Madrid", "ESP"),
    MACMILLAN("Macmillan","Londres","UK"),
    CIRCULOROJO("Círculo Rojo","Barcelona","ESP");

    private String nombre;
    private String ciudad; 
    private String pais; 

    private Editorial(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    private Editorial() {
    }
    
}
