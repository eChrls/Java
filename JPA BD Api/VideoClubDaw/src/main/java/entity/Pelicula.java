package entity;

import javax.persistence.*;
import java.util.List;

/*
 * Entidad Pelicula
 * Representa una película disponible en el videoclub.
 * Cada película puede tener varios alquileres (relación 1:N).
 * Cada película tiene una ficha técnica (relación 1:1).
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idPelicula;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(name = "anyo_estreno")
    private Integer anyoEstreno;

    @Column(name = "portada")
    private String portada;

    // Relación 1:N con Alquiler
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alquiler> alquileres;

    // Relación 1:1 con FichaTecnica
    @OneToOne(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private FichaTecnica fichaTecnica;

    public Pelicula() {
    }

    // Getters y setters
    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnyoEstreno() {
        return anyoEstreno;
    }

    public void setAnyoEstreno(Integer anyoEstreno) {
        this.anyoEstreno = anyoEstreno;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
