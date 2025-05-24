package entity;

import javax.persistence.*;

/*
 * Entidad FichaTecnica
 * Contiene información técnica de una película.
 * Relación 1:1 con Pelicula.
 */
@Entity
@Table(name = "ficha_tecnica")
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Long idFicha;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 100)
    private String genero;

    // Relación 1:1 con Pelicula (cada ficha pertenece a una película)
    @OneToOne
    @JoinColumn(name = "id_pelicula", unique = true)
    private Pelicula pelicula;

    public FichaTecnica() {}

    // Getters y setters
    public Long getIdFicha() { return idFicha; }
    public void setIdFicha(Long idFicha) { this.idFicha = idFicha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
}
