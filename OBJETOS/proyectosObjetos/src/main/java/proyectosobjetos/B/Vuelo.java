package proyectosobjetos.B;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un vuelo.
 * Contiene información del código del vuelo, ciudad de origen, destino,
 * fecha y hora de salida y llegada, precio y capacidad. [1]
 */
public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraLlegada;
    private double precio;
    private int capacidad;

    /**
     * Constructor completo para crear un vuelo.
     * @param codigo Código identificador del vuelo.
     * @param origen Ciudad de origen.
     * @param destino Ciudad de destino.
     * @param fechaHoraSalida Fecha y hora de salida.
     * @param fechaHoraLlegada Fecha y hora de llegada.
     * @param precio Precio del vuelo.
     * @param capacidad Número de asientos disponibles.
     */
    public Vuelo(String codigo, String origen, String destino,
                 LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada,
                 double precio, int capacidad) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    // Métodos getter y setter para cada atributo.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public LocalDateTime getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Devuelve una representación en cadena del vuelo formateando la fecha y la hora.
     * @return Cadena con la información del vuelo.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Vuelo{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", salida=" + fechaHoraSalida.format(formatter) +
                ", llegada=" + fechaHoraLlegada.format(formatter) +
                ", precio=" + precio +
                ", capacidad=" + capacidad +
                '}';
    }
}
