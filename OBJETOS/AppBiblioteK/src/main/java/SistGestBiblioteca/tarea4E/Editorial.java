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
    
    PRENTICE_HALL("Prentice- Hall", "New Yersey", "USA"),
    RA_MA("Ra-ma ", "Madrid", "ESP"),
    MACMILLAN("Macmillan","Londres","UK"),
    CIRCULO_ROJO("Círculo Rojo","Barcelona","ESP");

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nombre + ", " + ciudad + " (" + pais + ")";
    }
    
}
