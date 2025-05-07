/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen_final;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Futbolista {
    private static int autoIncrement = 1;

    private int dorsal;
    private String nombre;
    private double golesPorPartido;
    private LocalDate fechaFichaje;
    private EstadoJugador estado;

    public Futbolista() {
        Random r = new Random();

        this.dorsal = autoIncrement++;
        this.golesPorPartido = Math.round(r.nextDouble(0.0, 2.0) * 100.0) / 100.0;

        char letra = (char) (r.nextInt('a', 'z' + 1));
        this.nombre = "jugador" + dorsal + letra;

        long dias = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(2100, 1, 1));
        this.fechaFichaje = LocalDate.now().plusDays(r.nextLong(dias));

        int estadoIndex = r.nextInt(0, EstadoJugador.values().length);
        this.estado = EstadoJugador.values()[estadoIndex];
    }
    public Futbolista(int dorsal, String nombre, double golesPorPartido, LocalDate fechaFichaje, EstadoJugador estado) {
    this.dorsal = dorsal;
    this.nombre = nombre;
    this.golesPorPartido = golesPorPartido;
    this.fechaFichaje = fechaFichaje;
    this.estado = estado;
}


    // Getters
    public int getDorsal() { return dorsal; }
    public String getNombre() { return nombre; }
    public double getGolesPorPartido() { return golesPorPartido; }
    public LocalDate getFechaFichaje() { return fechaFichaje; }
    public EstadoJugador getEstado() { return estado; }
}
