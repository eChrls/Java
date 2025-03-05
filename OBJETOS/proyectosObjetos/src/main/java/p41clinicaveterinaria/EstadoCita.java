/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package p41clinicaveterinaria;

/**
 *
 * @author Casa
 */
public enum EstadoCita {
    ACTIVA("La cita está programada y pendiente de realizarse", 1),
    ANULADA("La cita ha sido cancelada", 2),
    REALIZADA("El propietario ha acudido con su mascota a la cita programada", 3),
    NOREALIZADA("La cita no fue cancelada, pero el propietario no acudió", 4);

    private final String descripcionCita;
    private final int codigoCita;

    private EstadoCita(String descripcionCita, int codigoCita) {
        this.descripcionCita = descripcionCita;
        this.codigoCita = codigoCita;
    }

    /**
     * Comprueba si la transición desde el estado actual al estado destino es
     * válida
     *
     * @param estadoDestino El estado al que se quiere cambiar
     * @return true si la transición es válida, false en caso contrario
     */
    public boolean esTransicionValida(EstadoCita estadoDestino) {
        // Una cita REALIZADA o NOREALIZADA no puede volver a activarse
        if ((this == REALIZADA || this == NOREALIZADA) && estadoDestino == ACTIVA) {
            return false;
        }

        // Una cita ANULADA no puede marcarse como REALIZADA o NOREALIZADA
        if (this == ANULADA && (estadoDestino == REALIZADA || estadoDestino == NOREALIZADA)) {
            return false;
        }

        // No se puede cambiar a un estado idéntico
        if (this == estadoDestino) {
            return false;
        }

        // En cualquier otro caso, la transición es válida
        return true;
    }

    
     /**
     * Sugiere el próximo estado lógico según el estado actual
     * @return El estado recomendado como siguiente
     */
    public EstadoCita siguienteEstadoRecomendado() {
        return switch (this) {
            case ACTIVA -> REALIZADA;
            case ANULADA -> ACTIVA;
            case REALIZADA, NOREALIZADA -> ACTIVA;
            default -> ACTIVA;
        }; // Lo normal es que una cita activa acabe siendo realizada
        // Una cita anulada podría reactivarse
        // Para una cita finalizada, lo lógico sería crear una nueva (activa)
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public int getCodigoCita() {
        return codigoCita;
    }
    
    
       /**
     * Devuelve un array con todos los posibles estados de cita
     * @return Array con todos los valores del enum
     */
    public static EstadoCita[] obtenerTodosLosEstados() {
        return EstadoCita.values();
    }

    @Override
    public String toString() {
        return codigoCita + " - " + name() + ": " + descripcionCita;
    }
    
    

}
