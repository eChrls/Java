/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego.tarea7b;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Evento {

    private Event event;
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
            this.event = event.PRIVADO;
        } else {
            this.event = event.PUBLICO;
        }
        //El código único se implementará con un autoIncrement de instancias.
        autoIncrement++;
        this.codigoUnico = autoIncrement;

        //El nombre será un String con el formato: “event+codigo único+letra aleatoria (a-z)”. Por ejemplo: event1x, event2y, event3a, etc.
        StringBuilder sb = new StringBuilder();
        char tmpchar = (char) (r.nextInt(97, 123)); //valores ascii de a -z
        sb.append(this.event);
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
    public Evento(Event event, int codigoUnico, String nombre, String lugar, LocalDate fecha) {
        this.event = event;
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
        return event + ";" + codigoUnico + ";" + nombre + ";" + lugar + ";" + fecha;
    }

    //Implementa un método llamado generarDatos que crea y 
    //devuelve una lista con 25 objetos usando el constructor por defecto. 
    public static List<Evento> listaEventosAleatorios() {
        List<Evento> listaGenerada = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            Evento e = new Evento();
            listaGenerada.add(e);
        }
        return listaGenerada;
    }
    
    //Guarda los datos de la lista, en un fichero de texto llamado datoscsv.csv, dentro del directorio “./csv”. 
    //Los campos de cada registro irán separados por el caracter ";".
    public static void guardarListaEnCSV(List<Evento> lista, String nombre){
        
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(nombre))){
            for(Evento e : lista){
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("CSV creado correctamente");
        }catch(IOException e){
            System.out.println("Error al guardar la lista." + e.getMessage());
        }
    }
    
   /* Crea un directorio, "./csv2", donde se guarden en archivos individuales CSV, 
    los datos de cada una de los eventos. En este directorio deben generarse 25 ficheros 
    con el nombre que tenga el evento en su atributo id (ejemplos: event2y,csv, event1e.csv, etc).*/

}
