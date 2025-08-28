package proyectosobjetos.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Clase que administra el sistema de reservas de vuelos.
 * Permite registrar vuelos, crear, modificar y cancelar reservas, buscar vuelos
 * y generar estadísticas generales del sistema. [1]
 */
public class SistemaReservaVuelos {

    // Lista de vuelos disponibles en el sistema.
    private List<Vuelo> vuelos;
    // Lista de reservas realizadas.
    private List<Reserva> reservas;
    // Objeto Random para generar códigos de reserva aleatorios.
    private Random random;

    /**
     * Constructor por defecto que inicializa las listas y el generador aleatorio. [1]
     */
    public SistemaReservaVuelos() {
        this.vuelos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Constructor alternativo que recibe listas iniciales y un objeto Random.
     * @param vuelos Lista de vuelos inicial.
     * @param reservas Lista de reservas inicial.
     * @param random Objeto Random para generar códigos.
     */
    public SistemaReservaVuelos(List<Vuelo> vuelos, List<Reserva> reservas, Random random) {
        this.vuelos = vuelos;
        this.reservas = reservas;
        this.random = random;
    }

    /**
     * Registra un vuelo en el sistema.
     * @param vuelo Vuelo a registrar.
     */
    public void registrarVuelo(Vuelo vuelo) {
        if (vuelo != null) {
            vuelos.add(vuelo);
        }
    }

    /**
     * Devuelve la lista de vuelos ordenados por fecha y hora de salida.
     * @return Lista de vuelos ordenados.
     */
    public List<Vuelo> obtenerVuelosOrdenados() {
        List<Vuelo> vuelosOrdenados = new ArrayList<>(vuelos);
        Collections.sort(vuelosOrdenados, new Comparator<Vuelo>() {
            public int compare(Vuelo v1, Vuelo v2) {
                return v1.getFechaHoraSalida().compareTo(v2.getFechaHoraSalida());
            }
        });
        return vuelosOrdenados;
    }

    /**
     * Busca un vuelo dado su código.
     * @param codigo Código del vuelo a buscar.
     * @return El vuelo encontrado, o null si no existe.
     */
    public Vuelo buscarVueloPorCodigo(String codigo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getCodigo().equalsIgnoreCase(codigo)) {
                return vuelo;
            }
        }
        return null;
    }

    /**
     * Crea una reserva para un pasajero en un vuelo específico y con un tipo concreto.
     * @param pasajero Pasajero que realiza la reserva.
     * @param codigoVuelo Código del vuelo en el que se reserva.
     * @param tipo Tipo de vuelo (clase) para la reserva.
     * @return La reserva creada.
     * @throws IllegalArgumentException si el vuelo no se encuentra.
     */
    public Reserva crearReserva(Pasajero pasajero, String codigoVuelo, TipoVuelo tipo) {
        Vuelo vuelo = buscarVueloPorCodigo(codigoVuelo);
        if (vuelo == null) {
            throw new IllegalArgumentException("Vuelo con código " + codigoVuelo + " no encontrado.");
        }
        // Se genera un código único para la reserva (por ejemplo, un número aleatorio de 5 dígitos).
        String codigoReserva = String.format("R%05d", random.nextInt(100000));
        Reserva reserva = new Reserva(codigoReserva, vuelo, pasajero, tipo);
        reservas.add(reserva);
        return reserva;
    }

    /**
     * Modifica el tipo de una reserva existente.
     * @param codigoReserva Código de la reserva a modificar.
     * @param nuevoTipo Nuevo tipo de vuelo para actualizar la reserva.
     * @return La reserva modificada.
     * @throws IllegalArgumentException si no se encuentra la reserva.
     */
    public Reserva modificarReserva(String codigoReserva, TipoVuelo nuevoTipo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                reserva.setTipo(nuevoTipo);
                return reserva;
            }
        }
        throw new IllegalArgumentException("Reserva con código " + codigoReserva + " no encontrada.");
    }

    /**
     * Cancela una reserva existente marcándola como cancelada.
     * @param codigoReserva Código de la reserva a cancelar.
     * @return true si la cancelación fue exitosa, false en caso contrario.
     */
    public boolean cancelarReserva(String codigoReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                reserva.setCancelada(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene todas las reservas realizadas por un pasajero, identificado por su pasaporte.
     * @param pasaporte Pasaporte del pasajero.
     * @return Lista de reservas del pasajero.
     */
    public List<Reserva> obtenerReservasPasajero(String pasaporte) {
        List<Reserva> lista = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getPasajero().getPasaporte().equals(pasaporte)) {
                lista.add(reserva);
            }
        }
        return lista;
    }

    /**
     * Genera estadísticas básicas del sistema.
     * @return Cadena con el total de vuelos, reservas y reservas canceladas.
     */
    public String obtenerEstadisticasSistema() {
        int totalVuelos = vuelos.size();
        int totalReservas = reservas.size();
        int canceladas = 0;
        for (Reserva r : reservas) {
            if (r.isCancelada()) {
                canceladas++;
            }
        }
        return "Total de vuelos: " + totalVuelos + "\n" +
               "Total de reservas: " + totalReservas + "\n" +
               "Reservas canceladas: " + canceladas;
    }
}
