package proyectosobjetos.B;

/**
 * Clase que representa una reserva de vuelo.
 * Contiene el código único de reserva, el vuelo asociado, el pasajero que reserva,
 * el tipo de vuelo y un indicador de si la reserva ha sido cancelada. [1]
 */
public class Reserva {
    private String codigoReserva;
    private Vuelo vuelo;
    private Pasajero pasajero;
    private TipoVuelo tipo;
    private boolean cancelada;

    /**
     * Constructor completo para crear una reserva.
     * @param codigoReserva Código único de la reserva.
     * @param vuelo Vuelo reservado.
     * @param pasajero Pasajero que realiza la reserva.
     * @param tipo Tipo de reserva (clase del vuelo).
     */
    public Reserva(String codigoReserva, Vuelo vuelo, Pasajero pasajero, TipoVuelo tipo) {
        this.codigoReserva = codigoReserva;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.tipo = tipo;
        this.cancelada = false;
    }

    // Métodos getter y setter.
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public TipoVuelo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVuelo tipo) {
        this.tipo = tipo;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    /**
     * Devuelve una cadena con la información de la reserva para mostrarla. 
     * @return Cadena que describe la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", vuelo=" + vuelo.getCodigo() +
                ", pasajero=" + pasajero.getNombreCompleto() +
                ", tipo=" + tipo +
                ", cancelada=" + cancelada +
                '}';
    }
}
