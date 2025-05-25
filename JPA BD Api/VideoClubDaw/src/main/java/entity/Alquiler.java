package entity;

import javax.persistence.*;
import java.util.Date;

/*
 * Entidad Alquiler
 * Representa el alquiler de una película por un usuario.
 * Relación N:1 con Usuario y Pelicula.
 */
@Entity
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Long idAlquiler;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_alquiler")
    private Date fechaAlquiler;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    // Relación N:1 con Usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Relación N:1 con Pelicula
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    public Alquiler() {
    }

    // Getters y setters
    public Long getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
}
