/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego.tarea7b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Evento {

    private Tipo tipo;
    private final int codigoUnico;
    private String nombre;
    private String lugar;
    private LocalDate fecha;

    int autoIncrement = 1;

    //constructor por defecto aleatorio
    public Evento() {
        Random r = new Random();

        //El evento puede ser público o privado, que se decide también aleatoriamente.
        int tmp = r.nextInt(0, 2);

        if (tmp == 0) {
            this.tipo = tipo.PRIVADO;
        } else {
            this.tipo = tipo.PUBLICO;
        }
        //El código único se implementará con un autoIncrement de instancias.
       
        this.codigoUnico = autoIncrement;
         autoIncrement++;
         
        //El nombre será un String con el formato: “tipo+codigo único+letra aleatoria (a-z)”. 
        //Por ejemplo: event1x, event2y, event3a, etc.
        StringBuilder sb = new StringBuilder();
        char tmpchar = (char) (r.nextInt('a', 'z')); 
        sb.append("event");
        sb.append(this.codigoUnico);
        sb.append(tmpchar);

        this.nombre = sb.toString();

        //El lugar será un String aleatorio de un conjunto de 10 lugares que tú decidas.
        String[] lugares = {"Marbella", "Estepona", "SanPedro", "Fuengirola", "Malaga", "Mijas", "Antequera", "Ronda", "Manilva"};
        int tmpLugar = r.nextInt(0, lugares.length);
        String stringLugar = lugares[tmpLugar];

        this.lugar = stringLugar;

        //La fecha se debe crear aleatoriamente entre el día actual y LocalDate.MAX.
        long diasTotales = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.MAX);
        long diasAleatorios = r.nextLong(diasTotales + 1);

        this.fecha = LocalDate.now().plusDays(diasAleatorios);

    }

    //constructor parametrizado
    public Evento(Tipo tipo, int codigoUnico, String nombre, String lugar, LocalDate fecha) {
        this.tipo = tipo;
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getId(){
       return codigoUnico;
    }
    
    

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
//el método toString(), de forma que devuelva los atributos de la aplicación separados por el carácter (;).

    @Override
    public String toString() {
        return tipo + ";" + codigoUnico + ";" + nombre + ";" + lugar + ";" + fecha;
    }



   
}
