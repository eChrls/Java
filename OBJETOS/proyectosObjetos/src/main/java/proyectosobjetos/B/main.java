/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosobjetos.B;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase principal que demuestra el uso del sistema de reserva de vuelos.
 */
public class main {
    public static void main(String[] args) {
        // Creamos el sistema de reservas
        SistemaReservaVuelos sistema = new SistemaReservaVuelos();

        // Registramos vuelos de ejemplo
        registrarVuelosEjemplo(sistema);

        // Mostramos los vuelos ordenados por fecha y hora
        mostrarVuelosOrdenados(sistema);

        // Buscamos un vuelo por su código
        buscarVueloPorCodigo(sistema, "IB5678");

        // Creamos un pasajero y realizamos operaciones de reserva
        Pasajero pasajero1 = new Pasajero("Juan Pérez", LocalDate.of(1985, 5, 15), "ABC123456");
        realizarOperacionesReserva(sistema, pasajero1);

        // Mostramos estadísticas del sistema
        mostrarEstadisticas(sistema);
    }

    /**
     * Registra vuelos de ejemplo en el sistema.
     */
    private static void registrarVuelosEjemplo(SistemaReservaVuelos sistema) {
        Vuelo vuelo1 = new Vuelo("IB1234", "Madrid", "Barcelona",
                LocalDateTime.of(2025, 3, 15, 10, 0),
                LocalDateTime.of(2025, 3, 15, 11, 30),
                150.0, 120);
        Vuelo vuelo2 = new Vuelo("IB5678", "Madrid", "Londres",
                LocalDateTime.of(2025, 3, 14, 14, 30),
                LocalDateTime.of(2025, 3, 14, 16, 45),
                250.0, 150);
        Vuelo vuelo3 = new Vuelo("IB9012", "Barcelona", "París",
                LocalDateTime.of(2025, 3, 16, 8, 15),
                LocalDateTime.of(2025, 3, 16, 10, 30),
                200.0, 130);

        sistema.registrarVuelo(vuelo1);
        sistema.registrarVuelo(vuelo2);
        sistema.registrarVuelo(vuelo3);
    }

    /**
     * Muestra los vuelos ordenados por fecha y hora.
     */
    private static void mostrarVuelosOrdenados(SistemaReservaVuelos sistema) {
        System.out.println("LISTA DE VUELOS ORDENADOS POR FECHA Y HORA:");
        List<Vuelo> vuelosOrdenados = sistema.obtenerVuelosOrdenados();
        for (Vuelo vuelo : vuelosOrdenados) {
            System.out.println(vuelo);
        }
    }

    /**
     * Busca un vuelo por su código y muestra el resultado.
     */
    private static void buscarVueloPorCodigo(SistemaReservaVuelos sistema, String codigo) {
        System.out.println("\nBÚSQUEDA DE VUELO POR CÓDIGO:");
        Vuelo vueloEncontrado = sistema.buscarVueloPorCodigo(codigo);
        if (vueloEncontrado != null) {
            System.out.println("Vuelo encontrado: " + vueloEncontrado);
        } else {
            System.out.println("Vuelo no encontrado");
        }
    }

    /**
     * Realiza operaciones de reserva para un pasajero.
     */
    private static void realizarOperacionesReserva(SistemaReservaVuelos sistema, Pasajero pasajero) {
        try {
            // Crear reserva
            System.out.println("\nCREACIÓN DE RESERVA:");
            Reserva reserva1 = sistema.crearReserva(pasajero, "IB5678", TipoVuelo.BUSINESS);
            System.out.println("Reserva creada: " + reserva1);

            // Modificar reserva
            System.out.println("\nMODIFICACIÓN DE RESERVA:");
            Reserva reservaModificada = sistema.modificarReserva(reserva1.getCodigoReserva(), TipoVuelo.PREMIUM);
            System.out.println("Reserva modificada: " + reservaModificada);

            // Obtener reservas del pasajero
            System.out.println("\nRESERVAS DEL PASAJERO:");
            List<Reserva> reservasPasajero = sistema.obtenerReservasPasajero(pasajero.getPasaporte());
            for (Reserva r : reservasPasajero) {
                System.out.println(r);
            }

            // Cancelar reserva
            System.out.println("\nCANCELACIÓN DE RESERVA:");
            boolean cancelacionExitosa = sistema.cancelarReserva(reservaModificada.getCodigoReserva());
            System.out.println("Cancelación exitosa: " + cancelacionExitosa);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra las estadísticas del sistema.
     */
    private static void mostrarEstadisticas(SistemaReservaVuelos sistema) {
        System.out.println("\nESTADÍSTICAS DEL SISTEMA:");
        System.out.println(sistema.obtenerEstadisticasSistema());
    }
}
