package controller;

import entity.Usuario;
import javax.persistence.*;
import java.util.List;

/*
 * Controlador para la entidad Usuario.
 * Permite operaciones CRUD básicas usando JPA.
 */
public class UsuarioController {

    private EntityManagerFactory emf;

    // Constructor: recibe el EntityManagerFactory (debe ser único en la app)
    public UsuarioController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Crear un nuevo usuario
    public void crearUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Buscar usuario por ID
    public Usuario buscarUsuario(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Actualizar un usuario existente
    public void actualizarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
