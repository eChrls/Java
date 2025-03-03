
package p41clinicaveterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase principal que gestiona una lista de citas.
 * Implementa métodos para agregar, modificar, eliminar y buscar citas.
 */
public class GestorCitas {
    
    private List<Cita> listaCitas;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    /**
     * Constructor que inicializa la lista de citas vacía.
     */
    public GestorCitas() {
        this.listaCitas = new ArrayList<>();
    }
    
    /**
     * Agrega una cita a la lista si no se solapa con ninguna existente.
     * @param cita La cita a agregar
     * @return true si se agregó correctamente, false si hay solapamiento
     */
    public boolean agregarCita(Cita cita) {
        // Verificar solapamiento con citas existentes
        if (verificarSolapamiento(cita)) {
            return false;
        }
        
        listaCitas.add(cita);
        return true;
    }
    
    /**
     * Verifica si una cita se solapa con alguna existente.
     * @param nuevaCita La cita a verificar
     * @return true si hay solapamiento, false en caso contrario
     */
    private boolean verificarSolapamiento(Cita nuevaCita) {
        for (Cita citaExistente : listaCitas) {
            // Solo verificamos solapamiento con citas activas
            if (citaExistente.getEstadoCita() == EstadoCita.ACTIVA && 
                nuevaCita.seSolapaCon(citaExistente)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Elimina una cita de la lista.
     * @param idCita El ID de la cita a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarCita(int idCita) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getIdCita() == idCita) {
                listaCitas.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Modifica una cita existente si la nueva información no causa solapamiento.
     * @param idCita El ID de la cita a modificar
     * @param nuevaFechaHora Nueva fecha y hora (puede ser null si no cambia)
     * @param nuevoNombreUsuario Nuevo nombre de usuario (puede ser null si no cambia)
     * @param nuevoNombreMascota Nuevo nombre de mascota (puede ser null si no cambia)
     * @param nuevaDuracion Nueva duración (0 si no cambia)
     * @param nuevoMotivo Nuevo motivo (puede ser null si no cambia)
     * @return true si se modificó correctamente, false en caso contrario
     */
    public boolean modificarCita(int idCita, LocalDateTime nuevaFechaHora, 
                                String nuevoNombreUsuario, String nuevoNombreMascota, 
                                int nuevaDuracion, String nuevoMotivo) {
        
        // Buscar la cita por ID
        Cita citaExistente = buscarCitaPorId(idCita);
        if (citaExistente == null) {
            return false;
        }
        
        // Crear una copia temporal para verificar solapamiento
        Cita citaTemporal = new Cita(
            nuevoNombreUsuario != null ? nuevoNombreUsuario : citaExistente.getNombreUsuario(),
            nuevaFechaHora != null ? nuevaFechaHora : citaExistente.getFechaHoraCita(),
            nuevoNombreMascota != null ? nuevoNombreMascota : citaExistente.getNombreMascota(),
            citaExistente.getEstadoCita(),
            nuevaDuracion > 0 ? nuevaDuracion : citaExistente.getDuracionMinutos(),
            nuevoMotivo != null ? nuevoMotivo : citaExistente.getMotivoConsulta()
        );
        
        // Verificar solapamiento solo si cambia la fecha/hora o la duración
        if ((nuevaFechaHora != null || nuevaDuracion > 0) && verificarSolapamientoExcluyendo(citaTemporal, idCita)) {
            return false;
        }
        
        // Aplicar las modificaciones
        try {
            if (nuevaFechaHora != null) {
                citaExistente.setFechaHoraCita(nuevaFechaHora);
            }
            if (nuevoNombreUsuario != null) {
                citaExistente.setNombreUsuario(nuevoNombreUsuario);
            }
            if (nuevoNombreMascota != null) {
                citaExistente.setNombreMascota(nuevoNombreMascota);
            }
            if (nuevaDuracion > 0) {
                citaExistente.setDuracionMinutos(nuevaDuracion);
            }
            if (nuevoMotivo != null) {
                citaExistente.setMotivoConsulta(nuevoMotivo);
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    /**
     * Verifica solapamiento excluyendo una cita específica.
     * @param cita La cita a verificar
     * @param idExcluido El ID de la cita a excluir
     * @return true si hay solapamiento, false en caso contrario
     */
    private boolean verificarSolapamientoExcluyendo(Cita cita, int idExcluido) {
        for (Cita citaExistente : listaCitas) {
            if (citaExistente.getIdCita() != idExcluido && 
                citaExistente.getEstadoCita() == EstadoCita.ACTIVA && 
                cita.seSolapaCon(citaExistente)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Cambia el estado de una cita.
     * @param idCita El ID de la cita
     * @param nuevoEstado El nuevo estado
     * @return true si se cambió correctamente, false en caso contrario
     */
    public boolean cambiarEstadoCita(int idCita, EstadoCita nuevoEstado) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita == null || !cita.getEstadoCita().esTransicionValida(nuevoEstado)) {
            return false;
        }
        
        cita.setEstadoCita(nuevoEstado);
        return true;
    }
    
    /**
     * Busca una cita por su ID.
     * @param idCita El ID de la cita a buscar
     * @return La cita encontrada o null si no existe
     */
    public Cita buscarCitaPorId(int idCita) {
        for (Cita cita : listaCitas) {
            if (cita.getIdCita() == idCita) {
                return cita;
            }
        }
        return null;
    }
    
    /**
     * Filtra las citas por estado.
     * @param estado El estado por el que filtrar
     * @return Lista de citas que coinciden con el estado
     */
    public List<Cita> filtrarPorEstado(EstadoCita estado) {
        return listaCitas.stream()
                .filter(cita -> cita.getEstadoCita() == estado)
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra las citas por fecha.
     * @param fecha La fecha por la que filtrar
     * @return Lista de citas que coinciden con la fecha
     */
    public List<Cita> filtrarPorFecha(LocalDate fecha) {
        return listaCitas.stream()
                .filter(cita -> cita.getFechaHoraCita().toLocalDate().equals(fecha))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra las citas por nombre de propietario.
     * @param nombrePropietario El nombre por el que filtrar
     * @return Lista de citas que coinciden con el nombre
     */
    public List<Cita> filtrarPorPropietario(String nombrePropietario) {
        return listaCitas.stream()
                .filter(cita -> cita.getNombreUsuario().toLowerCase().contains(nombrePropietario.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra las citas por nombre de mascota.
     * @param nombreMascota El nombre por el que filtrar
     * @return Lista de citas que coinciden con el nombre
     */
    public List<Cita> filtrarPorMascota(String nombreMascota) {
        return listaCitas.stream()
                .filter(cita -> cita.getNombreMascota().toLowerCase().contains(nombreMascota.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene todas las citas ordenadas según un comparador.
     * @param comparador El comparador a usar
     * @return Lista de citas ordenadas
     */
    public List<Cita> obtenerCitasOrdenadas(Comparator<Cita> comparador) {
        List<Cita> citasOrdenadas = new ArrayList<>(listaCitas);
        Collections.sort(citasOrdenadas, comparador);
        return citasOrdenadas;
    }
    
    /**
     * Obtiene todas las citas ordenadas por fecha y hora.
     * @return Lista de citas ordenadas por fecha y hora
     */
    public List<Cita> obtenerCitasOrdenadasPorFechaHora() {
        List<Cita> citasOrdenadas = new ArrayList<>(listaCitas);
        Collections.sort(citasOrdenadas);
        return citasOrdenadas;
    }
    
    /**
     * Busca citas de un propietario usando búsqueda binaria.
     * @param nombrePropietario El nombre del propietario
     * @return Lista de citas del propietario
     */
    public List<Cita> buscarCitasPropietarioBinario(String nombrePropietario) {
        // Ordenamos por nombre de propietario
        List<Cita> citasOrdenadas = obtenerCitasOrdenadas(new ComparadoresCita.ComparadorPorNombrePropietario());
        
        List<Cita> resultado = new ArrayList<>();
        int indice = Collections.binarySearch(citasOrdenadas, new Cita(nombrePropietario, 
                LocalDateTime.now().plusDays(1), "", EstadoCita.ACTIVA, 30, ""), 
                new ComparadoresCita.ComparadorPorNombrePropietario());
        
        // Si encontramos exactamente el propietario
        if (indice >= 0) {
            // Buscamos hacia atrás para encontrar el primer registro con este propietario
            int primerIndice = indice;
            while (primerIndice > 0 && 
                   citasOrdenadas.get(primerIndice-1).getNombreUsuario().equalsIgnoreCase(nombrePropietario)) {
                primerIndice--;
            }
            
            // Añadimos todas las citas con este propietario
            for (int i = primerIndice; i < citasOrdenadas.size() && 
                 citasOrdenadas.get(i).getNombreUsuario().equalsIgnoreCase(nombrePropietario); i++) {
                resultado.add(citasOrdenadas.get(i));
            }
        }
        
        return resultado;
    }
    
    /**
     * Busca la cita más cercana a una fecha y hora usando búsqueda binaria.
     * @param fechaHora La fecha y hora de referencia
     * @return La cita más cercana o null si no hay citas
     */
    public Cita buscarCitaMasCercana(LocalDateTime fechaHora) {
        if (listaCitas.isEmpty()) {
            return null;
        }
        
        // Crear una cita temporal con la fecha y hora deseada
        Cita citaTemporal = new Cita("Temporal", fechaHora, "Temporal", 
                                    EstadoCita.ACTIVA, 30, "Búsqueda");
        
        // Ordenar las citas por fecha y hora
        List<Cita> citasOrdenadas = obtenerCitasOrdenadasPorFechaHora();
        
        // Realizar búsqueda binaria
        int indice = Collections.binarySearch(citasOrdenadas, citaTemporal);
        
        // Si encontramos una cita exacta
        if (indice >= 0) {
            return citasOrdenadas.get(indice);
        }
        
        // Calcular el punto de inserción
        int puntoInsercion = -indice - 1;
        
        // Si el punto de inserción es 0, la cita más cercana es la primera
        if (puntoInsercion == 0) {
            return citasOrdenadas.get(0);
        }
        
        // Si el punto de inserción es el tamaño de la lista, la cita más cercana es la última
        if (puntoInsercion == citasOrdenadas.size()) {
            return citasOrdenadas.get(citasOrdenadas.size() - 1);
        }
        
        // Comparar la distancia entre la cita anterior y la siguiente
        Cita citaAnterior = citasOrdenadas.get(puntoInsercion - 1);
        Cita citaSiguiente = citasOrdenadas.get(puntoInsercion);
        
        long distanciaAnterior = Math.abs(java.time.Duration.between(
                                        citaAnterior.getFechaHoraCita(), fechaHora).toMinutes());
        long distanciaSiguiente = Math.abs(java.time.Duration.between(
                                        fechaHora, citaSiguiente.getFechaHoraCita()).toMinutes());
        
        return distanciaAnterior <= distanciaSiguiente ? citaAnterior : citaSiguiente;
    }
    
    /**
     * Busca huecos disponibles en un día específico.
     * @param fecha La fecha donde buscar huecos
     * @return Lista de LocalDateTime con los inicios de huecos disponibles
     */
    public List<LocalDateTime> buscarHuecosDisponibles(LocalDate fecha) {
        // Verificar que no sea miércoles
        if (fecha.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            return new ArrayList<>(); // No hay huecos disponibles los miércoles
        }
        
        // Verificar que no sea una fecha pasada
        if (fecha.isBefore(LocalDate.now())) {
            return new ArrayList<>(); // No hay huecos disponibles en fechas pasadas
        }
        
        // Obtener las citas de ese día ordenadas por hora
        List<Cita> citasDelDia = filtrarPorFecha(fecha);
        citasDelDia.sort(Comparator.comparing(Cita::getFechaHoraCita));
        
        // Filtrar solo las citas activas
        citasDelDia = citasDelDia.stream()
                    .filter(cita -> cita.getEstadoCita() == EstadoCita.ACTIVA)
                    .collect(Collectors.toList());
        
        List<LocalDateTime> huecos = new ArrayList<>();
        
        // Horario de atención: 9:00 - 20:00
        LocalDateTime inicioJornada = LocalDateTime.of(fecha, LocalTime.of(9, 0));
        LocalDateTime finJornada = LocalDateTime.of(fecha, LocalTime.of(19, 30));
        
        // Si no hay citas, todo el día está disponible
        if (citasDelDia.isEmpty()) {
            LocalDateTime horaActual = inicioJornada;
            while (horaActual.isBefore(finJornada)) {
                huecos.add(horaActual);
                horaActual = horaActual.plusMinutes(30); // Incrementamos en intervalos de 30 minutos
            }
            return huecos;
        }
        
        // Verificar hueco antes de la primera cita
        LocalDateTime horaLibre = inicioJornada;
        for (Cita cita : citasDelDia) {
            // Verificar si hay hueco entre la hora libre y el inicio de la cita
            while (horaLibre.plusMinutes(30).isBefore(cita.getFechaHoraCita()) || 
                   horaLibre.plusMinutes(30).equals(cita.getFechaHoraCita())) {
                huecos.add(horaLibre);
                horaLibre = horaLibre.plusMinutes(30);
            }
            
            // Actualizar hora libre al final de la cita actual
            horaLibre = cita.calcularHoraFinalizacion();
        }
        
        // Verificar hueco después de la última cita
        while (horaLibre.plusMinutes(30).isBefore(finJornada) || 
               horaLibre.plusMinutes(30).equals(finJornada)) {
            huecos.add(horaLibre);
            horaLibre = horaLibre.plusMinutes(30);
        }
        
        return huecos;
    }
    
    /**
     * Calcula estadísticas de citas por estado.
     * @return Mapa con el número de citas por estado
     */
    public Map<EstadoCita, Integer> obtenerEstadisticasPorEstado() {
        Map<EstadoCita, Integer> estadisticas = new HashMap<>();
        
        // Inicializar contador para todos los estados
        for (EstadoCita estado : EstadoCita.values()) {
            estadisticas.put(estado, 0);
        }
        
        // Contar citas por estado
        for (Cita cita : listaCitas) {
            EstadoCita estado = cita.getEstadoCita();
            estadisticas.put(estado, estadisticas.get(estado) + 1);
        }
        
        return estadisticas;
    }
    
    /**
     * Calcula estadísticas de citas por día de la semana.
     * @return Mapa con el número de citas por día de la semana
     */
    public Map<DayOfWeek, Integer> obtenerEstadisticasPorDiaSemana() {
        Map<DayOfWeek, Integer> estadisticas = new HashMap<>();
        
        // Inicializar contador para todos los días (excepto miércoles)
        for (DayOfWeek dia : DayOfWeek.values()) {
            if (dia != DayOfWeek.WEDNESDAY) {
                estadisticas.put(dia, 0);
            }
        }
        
        // Contar citas por día de la semana
        for (Cita cita : listaCitas) {
            DayOfWeek dia = cita.getFechaHoraCita().getDayOfWeek();
            if (dia != DayOfWeek.WEDNESDAY) {
                estadisticas.put(dia, estadisticas.getOrDefault(dia, 0) + 1);
            }
        }
        
        return estadisticas;
    }
    
    /**
     * Identifica el día con más carga de trabajo.
     * @return La fecha con más citas programadas
     */
    public LocalDate obtenerDiaConMasCarga() {
        Map<LocalDate, Integer> citasPorDia = new HashMap<>();
        
        // Contar citas por día
        for (Cita cita : listaCitas) {
            if (cita.getEstadoCita() == EstadoCita.ACTIVA || cita.getEstadoCita() == EstadoCita.REALIZADA) {
                LocalDate fecha = cita.getFechaHoraCita().toLocalDate();
                citasPorDia.put(fecha, citasPorDia.getOrDefault(fecha, 0) + 1);
            }
        }
        
        // Encontrar el día con más citas
        LocalDate diaMasCarga = null;
        int maxCitas = 0;
        
        for (Map.Entry<LocalDate, Integer> entry : citasPorDia.entrySet()) {
            if (entry.getValue() > maxCitas) {
                maxCitas = entry.getValue();
                diaMasCarga = entry.getKey();
            }
        }
        
        return diaMasCarga;
    }
    
    /**
     * Sugiere el mejor momento para una nueva cita (menor tiempo de espera).
     * @param duracionMinutos Duración requerida para la cita
     * @return LocalDateTime con la fecha y hora recomendada
     */
    public LocalDateTime sugerirMejorMomento(int duracionMinutos) {
        // Comenzar desde mañana
        LocalDate fechaInicio = LocalDate.now().plusDays(1);
        
        // Buscar en los próximos 30 días
        for (int i = 0; i < 30; i++) {
            LocalDate fechaActual = fechaInicio.plusDays(i);
            
            // Saltar miércoles
            if (fechaActual.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                continue;
            }
            
            // Obtener huecos disponibles
            List<LocalDateTime> huecos = buscarHuecosDisponibles(fechaActual);
            
            // Verificar cada hueco
            for (LocalDateTime hueco : huecos) {
                // Verificar si el hueco es suficientemente grande
                boolean huecoCabe = true;
                
                LocalDateTime finPosibleCita = hueco.plusMinutes(duracionMinutos);
                
                // Verificar si la cita terminaría después del horario de atención
                if (finPosibleCita.toLocalTime().isAfter(LocalTime.of(20, 0))) {
                    huecoCabe = false;
                } else {
                    // Verificar si se solapa con alguna cita existente
                    for (Cita cita : filtrarPorFecha(fechaActual)) {
                        if (cita.getEstadoCita() == EstadoCita.ACTIVA && 
                            !(finPosibleCita.isBefore(cita.getFechaHoraCita()) || 
                              hueco.isAfter(cita.calcularHoraFinalizacion()))) {
                            huecoCabe = false;
                            break;
                        }
                    }
                }
                
                if (huecoCabe) {
                    return hueco;
                }
            }
        }
        
        // Si no encontramos hueco, sugerimos el primer hueco disponible del primer día
        return LocalDateTime.of(fechaInicio, LocalTime.of(9, 0));
    }
    
    /**
     * Obtiene todas las citas.
     * @return Lista con todas las citas
     */
    public List<Cita> obtenerTodasLasCitas() {
        return new ArrayList<>(listaCitas);
    }
    
    /**
     * Exporta un listado de citas a formato de texto.
     * @return String con el listado de citas
     */
    public String exportarListadoCitas() {
        StringBuilder sb = new StringBuilder();
        sb.append("LISTADO DE CITAS\n");
        sb.append("================\n\n");
        
        List<Cita> citasOrdenadas = obtenerCitasOrdenadasPorFechaHora();
        
        for (Cita cita : citasOrdenadas) {
            sb.append(cita.toString()).append("\n\n");
        }
        
        return sb.toString();
    }
}