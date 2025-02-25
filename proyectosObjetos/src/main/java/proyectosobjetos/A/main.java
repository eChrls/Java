/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.main to edit this template
 */
package proyectosobjetos.A;

import java.time.LocalDate;

/**
 *
 * @author Casa
 */
public class main {
       public static void main(String[] args) {
        Evento evento = new Evento(100); // Creamos un evento con 100 dorsales

        // Registramos algunos participantes
        evento.registrarParticipante("Juan", "Pérez", LocalDate.of(2005, 8, 15), Categoria.JUVENIL, 55.3);
        evento.registrarParticipante("María", "Gómez", LocalDate.of(2010, 3, 22), Categoria.INFANTIL, 62.1);
        evento.registrarParticipante("Carlos", "Rodríguez", LocalDate.of(1998, 11, 5), Categoria.ADULTO, 48.7);

        // Mostramos los resultados ordenados por tiempo
        evento.ordenarPorTiempo();

        // Buscamos un participante por su dorsal
        Participante participanteEncontrado = evento.buscarParticipantePorDorsal(1);
        if (participanteEncontrado != null) {
            System.out.println("Participante encontrado: " + participanteEncontrado);
        } else {
            System.out.println("Participante no encontrado.");
        }
    }

}
