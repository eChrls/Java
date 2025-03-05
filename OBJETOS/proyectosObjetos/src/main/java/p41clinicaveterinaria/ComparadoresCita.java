
package p41clinicaveterinaria;


import java.util.Comparator;

/**
 * Clase que contiene diferentes comparadores para ordenar citas según distintos criterios.
 * Estos comparadores implementan la interfaz Comparator<Cita>.
 */
public class ComparadoresCita {
    
    /**
     * Comparador para ordenar citas por nombre del propietario alfabéticamente.
     * Si los nombres son iguales, se ordena por fecha y hora.
     */
    public static class ComparadorPorNombrePropietario implements Comparator<Cita> {
        @Override
        public int compare(Cita cita1, Cita cita2) {
            // Comparamos primero por nombre de propietario
            int resultadoNombre = cita1.getNombreUsuario().compareToIgnoreCase(cita2.getNombreUsuario());
            
            // Si los nombres son iguales, comparamos por fecha y hora
            if (resultadoNombre == 0) {
                return cita1.getFechaHoraCita().compareTo(cita2.getFechaHoraCita());
            }
            
            return resultadoNombre;
        }
    }
    
    /**
     * Comparador para ordenar citas por nombre de mascota alfabéticamente.
     * Si los nombres son iguales, se ordena por fecha y hora.
     */
    public static class ComparadorPorNombreMascota implements Comparator<Cita> {
        @Override
        public int compare(Cita cita1, Cita cita2) {
            // Comparamos primero por nombre de mascota
            int resultadoNombre = cita1.getNombreMascota().compareToIgnoreCase(cita2.getNombreMascota());
            
            // Si los nombres son iguales, comparamos por fecha y hora
            if (resultadoNombre == 0) {
                return cita1.getFechaHoraCita().compareTo(cita2.getFechaHoraCita());
            }
            
            return resultadoNombre;
        }
    }
    
    /**
     * Comparador para ordenar citas por duración (de menor a mayor).
     * Si las duraciones son iguales, se ordena por fecha y hora.
     */
    public static class ComparadorPorDuracion implements Comparator<Cita> {
        @Override
        public int compare(Cita cita1, Cita cita2) {
            // Comparamos primero por duración
            int resultadoDuracion = Integer.compare(cita1.getDuracionMinutos(), cita2.getDuracionMinutos());
            
            // Si las duraciones son iguales, comparamos por fecha y hora
            if (resultadoDuracion == 0) {
                return cita1.getFechaHoraCita().compareTo(cita2.getFechaHoraCita());
            }
            
            return resultadoDuracion;
        }
    }
    
    /**
     * Comparador para ordenar citas por estado según el orden de los valores del enum.
     * Si los estados son iguales, se ordena por fecha y hora.
     */
    public static class ComparadorPorEstado implements Comparator<Cita> {
        @Override
        public int compare(Cita cita1, Cita cita2) {
            // Comparamos primero por el código del estado
            int resultadoEstado = Integer.compare(
                    cita1.getEstadoCita().getCodigoCita(), 
                    cita2.getEstadoCita().getCodigoCita());
            
            // Si los estados son iguales, comparamos por fecha y hora
            if (resultadoEstado == 0) {
                return cita1.getFechaHoraCita().compareTo(cita2.getFechaHoraCita());
            }
            
            return resultadoEstado;
        }
    }
    
    /**
     * Comparador para ordenar citas por ID.
     * Útil para obtener las citas en el orden en que fueron creadas.
     */
    public static class ComparadorPorId implements Comparator<Cita> {
        @Override
        public int compare(Cita cita1, Cita cita2) {
            return Integer.compare(cita1.getIdCita(), cita2.getIdCita());
        }
    }
}