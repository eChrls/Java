package controller;

import entity.Alquiler;
import entity.Pelicula;
import entity.Usuario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlquilerController {

    private EntityManagerFactory emf;

    // Constructor
    public AlquilerController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Método para obtener el EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Devuelve la lista de alquileres activos (sin fecha de entrega) de un
     * usuario.
     */
    public List<Alquiler> buscarAlquileresActivosPorUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Alquiler a WHERE a.usuario = :usuario AND a.fechaEntrega IS NULL", Alquiler.class)
                    .setParameter("usuario", usuario)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Devuelve el historial completo de alquileres de un usuario.
     */
    public List<Alquiler> buscarHistorialAlquileresPorUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Alquiler a WHERE a.usuario = :usuario", Alquiler.class)
                    .setParameter("usuario", usuario)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * (Opcional) Devuelve todos los alquileres activos del sistema (para
     * admin).
     */
    public List<Alquiler> buscarAlquileresActivos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Alquiler a WHERE a.fechaEntrega IS NULL", Alquiler.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Devuelve el historial completo de alquileres del sistema (para admin).
     */
    public List<Alquiler> buscarHistorialAlquileres() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Alquiler a", Alquiler.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public boolean alquilarPelicula(Usuario usuario, Pelicula pelicula) {
        EntityManager em = getEntityManager();
        try {
            // Comprobar si ya existe un alquiler ACTIVO (sin devolver) de esa película para ese usuario
            List<Alquiler> existentes = em.createQuery(
                    "SELECT a FROM Alquiler a WHERE a.usuario = :usuario AND a.pelicula = :pelicula AND a.fechaEntrega IS NULL", Alquiler.class)
                    .setParameter("usuario", usuario)
                    .setParameter("pelicula", pelicula)
                    .getResultList();

            if (!existentes.isEmpty()) {
                return false; // Ya tiene un alquiler activo de esta película
            }

            em.getTransaction().begin();
            Alquiler nuevo = new Alquiler();
            nuevo.setUsuario(usuario);
            nuevo.setPelicula(pelicula);
            nuevo.setFechaAlquiler(new java.util.Date());
            em.persist(nuevo);
            em.getTransaction().commit();
            return true;
        } finally {
            em.close();
        }
    }

    public List<Alquiler> listarAlquileres() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Alquiler a", Alquiler.class).getResultList();
        } finally {
            em.close();
        }
    }

    public boolean devolverAlquiler(Alquiler alquiler) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Alquiler a = em.find(Alquiler.class, alquiler.getIdAlquiler());
            if (a != null && a.getFechaEntrega() == null) {
                a.setFechaEntrega(new java.util.Date());
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

}
