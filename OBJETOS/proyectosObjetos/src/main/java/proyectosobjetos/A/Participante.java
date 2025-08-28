/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosobjetos.A;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Casa
 */
public class Participante extends Persona implements Comparable<Participante> {

    private int dorsal;
    Categoria categoria;
    double tiempo;

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }


    public Participante(String nombre, String apellidos, LocalDate fechaNac, int dorsal, Categoria categoria, double tiempo) {
        super(nombre, apellidos, fechaNac);
        this.dorsal = dorsal;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }

    public Participante(String nombre, String apellidos, LocalDate fechaNac) {
        super(nombre, apellidos, fechaNac);
    }



    //Ojo, al hacer el compareTo con la clase TIME hay que hacerlo así, no vale de la manera clásica. 
    /* @Override
 public int compareTo(Participante otro) {
 return Time.compare(this.tiempo, otro.tiempo);
 }
    @Override
    public int compareTo(Participante otro) {
        return this.tiempo.compareTo(otro.tiempo);
    }
  */  
        // Método para comparar participantes por tiempo (para ordenarlos)
    @Override
    public int compareTo(Participante otroParticipante) {
        // Comparamos los tiempos de los participantes
        return Double.compare(this.tiempo, otroParticipante.tiempo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Participante{");
        sb.append("dorsal=").append(dorsal);
        sb.append(", categoria=").append(categoria);
        sb.append(", tiempo=").append(tiempo);
        sb.append('}');
        return sb.toString();
    }

}
