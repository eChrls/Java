package controller;

import entity.FichaTecnica;
import entity.Pelicula;
import javax.persistence.*;
import java.util.List;

/**
 * Controlador para la entidad FichaTecnica. Permite operaciones CRUD básicas y
 * consultas usando JPA.
 */
public class FichaTecnicaController {

    private EntityManagerFactory emf;

    public FichaTecnicaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Método privado para obtener un EntityManager.
     */
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crear una nueva ficha técnica.
     */
    public void crearFichaTecnica(FichaTecnica ficha) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ficha);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Buscar ficha técnica por ID.
     */
    public FichaTecnica buscarFichaTecnica(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FichaTecnica.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Listar todas las fichas técnicas.
     */
    public List<FichaTecnica> listarFichasTecnicas() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT f FROM FichaTecnica f", FichaTecnica.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Actualizar una ficha técnica existente.
     */
    public void actualizarFichaTecnica(FichaTecnica ficha) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ficha);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Eliminar una ficha técnica por ID.
     */
    public void eliminarFichaTecnica(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            FichaTecnica ficha = em.find(FichaTecnica.class, id);
            if (ficha != null) {
                em.remove(ficha);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Busca la ficha técnica asociada a una película.
     *
     * @param pelicula La película a buscar
     * @return La ficha técnica si existe, null si no hay ninguna asociada
     */
    public FichaTecnica buscarPorPelicula(Pelicula pelicula) {
        EntityManager em = getEntityManager();
        try {
            List<FichaTecnica> resultado = em.createQuery(
                    "SELECT f FROM FichaTecnica f WHERE f.pelicula = :pelicula", FichaTecnica.class)
                    .setParameter("pelicula", pelicula)
                    .getResultList();
            if (!resultado.isEmpty()) {
                return resultado.get(0); // Devuelve la primera (debería haber solo una por película)
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
}
