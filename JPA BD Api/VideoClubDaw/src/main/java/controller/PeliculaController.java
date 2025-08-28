package controller;

import entity.Pelicula;
import javax.persistence.*;
import java.util.List;

/*
 * Controlador para la entidad Pelicula.
 * Permite operaciones CRUD básicas usando JPA.
 */
public class PeliculaController {

    private EntityManagerFactory emf;

    public PeliculaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void crearPelicula(Pelicula pelicula) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pelicula);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Pelicula buscarPelicula(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Pelicula.class, id);
        } finally {
            em.close();
        }
    }

    public List<Pelicula> listarPeliculas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizarPelicula(Pelicula pelicula) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pelicula);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarPelicula(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pelicula pelicula = em.find(Pelicula.class, id);
            if (pelicula != null) {
                em.remove(pelicula);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
