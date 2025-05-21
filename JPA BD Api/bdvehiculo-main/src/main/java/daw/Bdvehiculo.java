
package daw;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Vehiculo;

// Programa principal y métodos básicos del EntityManager
// Estos métodos permiten realizar operaciones CRUD (Create, Read, Update, Delete)
// sobre la tabla vehiculo. Lo ideal es situar
// estos métodos en una clase controladora (Controller) que se encargue de gestionar
// las operaciones CRUD de una tabla concreta.
// En este caso se ha optado por situar los métodos en la misma clase
// para simplificar el ejemplo y no crear más clases de las necesarias
// Se usa la unidad de persistencia bdvehiculo, definida en el fichero
// persistence.xml, que se encuentra en la carpeta src/main/resources/META-INF
// Se usa la clase Vehiculo, que representa la tabla vehiculo de la base de datos

public class Bdvehiculo {

    public static void main(String[] args) {
        // Se obtienen todas las instancias
        List<Vehiculo> listaVehiculos = findAll();

        // Se imprime la lista
        System.out.println("\n\nTodas las entidades ------------ ");
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v);
        }

        // Se obtiene una entidad y se imprime
        System.out.println("\n\nBuscar Vehiculo de matrícula 0034AAB ------------ ");
        // Si no existe, en este caso lanza excepción NoResultException
        Vehiculo aux = findByMatricula("0034AAB"); 
        System.out.println(aux);

        // Creación de una entidad con el constructor por defecto y usando setters
        // Es lo habitual, por si no queremos asignar todos los atributos
        // No se asigna campo "id" porque lo hará la BD con auto increment
        Vehiculo v = new Vehiculo();
        v.setBastidor("6634543Z01");
        v.setMatricula("0998FRR");
        v.setDisponible(true);
        v.setMarca("Renault");
        v.setModelo("Clio");
        v.setPrecio(14.00);

        // Siempre se inserta el vehículo porque la BD asigna id diferentes
        // aunque los atributos sean iguales a otro vehículo ya existente
        createVehiculo(v); 

        // Se obtienen todas las instancias
        listaVehiculos = findAll();
        System.out.println("\n\nTodas las entidades después de crear una nueva ------------ ");
        listaVehiculos.forEach(System.out::println);

        // Se modifica el precio del vehículo id = 1
        // Si no existe, en este caso lanza excepción NoResultException
        Vehiculo vehicModificar = findByPK(1);
        if (vehicModificar != null) {
            vehicModificar.setPrecio(138);
            modifyVehiculo(vehicModificar);
        }

        // Se obtienen todas las instancias
        listaVehiculos = findAll();
        System.out.println("\n\nTodas las entidades después de modificar una ------------ ");
        listaVehiculos.forEach(System.out::println);

        // Borrado del vehículo de matrícula 1235ACB
        Vehiculo vehicBorrar = findByMatricula("1235ACB");
        deleteVehiculo(vehicBorrar);

        // Se obtienen todas las instancias
        listaVehiculos = findAll();
        System.out.println("\n\nTodas las entidades después de borrar una ------------ ");
        listaVehiculos.forEach(System.out::println);
    }
    
    // Inserta un objeto en la tabla vehiculo. 
    public static void createVehiculo(Vehiculo v) {
        // Se crea el entityManager, siempre que se vaya a ejecutar una operación
        // que modifique la base de datos
        EntityManager em = getEntityManager();
        // En este caso es necesario iniciar una transacción en la base de datos
        // porque vamos a persistir información en la misma
        em.getTransaction().begin();
        // Se guarda el objeto en el contexto de persistencia. Es una caché intermedia
        // que permite gestionar las entidades que se van a modificar en la base de datos
        // Sirve para sincronizar la información entre la base de datos y el programa

        em.persist(v);
        // Se vuelca la información del contexto (caché intermedia) en la base de datos
        em.getTransaction().commit();
        // Cierra el entityManager
        em.close();
    }

    // Borra un registro de la tabla, aquel que tenga la misma pk que v
    // Si no existe esa pk no hace nada
    public static void deleteVehiculo(Vehiculo v) {
        EntityManager em = getEntityManager();
        Vehiculo aux = null;
        // En este caso es necesario iniciar una transacción en la base de datos
        // porque vamos a borrar información en la misma
        em.getTransaction().begin();
        // Si v no es un objeto gestionado por el contexto de persistencia
        if (!em.contains(v)) {
            // Carga v en el contexto de persistencia y se guarda en aux
            aux = em.merge(v);
        }
        // Ahora se puede borrar usando aux, porque es una entidad gestionada por la
        // caché
        em.remove(aux);
        // Se vuelca la información del contexto (caché intermedia) en la base de datos
        em.getTransaction().commit();
        // Cierra el entityManager
        em.close();
    }

    // Modifica un registro de la tabla, en concreto aquel que tenga la misma pk que v
    // Si esa pk no existe, se inserta un nuevo registro con los valores de v
    public static void modifyVehiculo(Vehiculo v) {
        EntityManager em = getEntityManager();
        // En este caso es necesario iniciar una transacción en la base de datos
        // porque vamos a persistir información en la misma
        em.getTransaction().begin();
        // Merge es un método que permite actualizar una entidad en la base de datos
        
        // Si una entidad con el mismo identificador que v existe en el
        // contexto de persistencia (caché), se actualizan sus atributos y se devuelve
        // como entidad gestionada, para guardar cambios con commit

        // Si el objeto v no existe en el contexto de persistencia, se busca en la base
        // de datos. Si existe, se actualizan sus atributos y se devuelve como entidad
        // gestionada, para guardar cambios con commit

        // Si v es una entidad nueva (no existe en la base de datos), se añade al
        // contexto de persistencia para insertar un nuevo registro (como persist)
        // y se devuelve como entidad gestionada
        
        em.merge(v);
        em.getTransaction().commit();
        em.close();

    }

    // Una entidad gestionada (managed) por el contexto de persistencia es aquella que se ha
    // cargado en la memoria intermedia y se puede modificar. Los cambios se guardan
    // automáticamente en la base de datos al hacer commit.


    // Una entidad no gestionada (detached) por el contexto de persistencia es aquella que
    // no se ha cargado en memoria intermedia y no se puede modificar. Los cambios no se guardan
    // automáticamente en la base de datos al hacer commit. Para modificar una entidad
    // no gestionada, se debe cargar previamente en el contexto de persistencia usando el método merge.


    // Para saber si una entidad está gestionada por el contexto de
    // persistencia se puede usar el método contains de EntityManager
 

   // Obtiene una entidad por clave primaria, pk. Si no existe lanza
   // una excepción NoResultException
    public static Vehiculo findByPK(int pk) {
        EntityManager em = getEntityManager();
        // Se crea el objeto Query a partir de una SQL nativa, que permite pasar
        // código SQL directamente a la base de datos
        Query q = em.createNativeQuery("Select * from vehiculo where id = ?", Vehiculo.class);
        // Se establece que el parámetro a usar en la query es la pk que se pasa como parámetro
        // al siguiente método. setparameter(1, pk) indica que el primer parámetro de la consulta
        // es pk. En este caso la consulta tiene un solo parámetro, pero podría tener más
        // y se irían numerando a partir de 1
        q.setParameter(1, pk);
        // Se ejecuta la consulta
        Vehiculo aux = (Vehiculo) q.getSingleResult();
        // Cierra el entityManager
        em.close();
        return aux;

    }

    // Este método obtiene todos los registros de la tabla. Si no hay registros
    // devuelve una lista vacía
    public static List<Vehiculo> findAll() {
        EntityManager em = getEntityManager();
        // Se crea la Query a partir del nombre de la NamedQuery de la clase Vehiculo
        Query q = em.createNamedQuery("Vehiculo.findAll");
        // Se ejecuta la consulta y se hace un casting
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) q.getResultList();
        // Cierra el entityManager
        em.close();
        return listaVehiculos;
    }

    // Devuelve un vehículo coincidente con la matrícula. Si no existe lanza 
    // una excepción NoResultException
    // Si existen varios registros con misma matrícula lanza NonUniqueResultException
    public static Vehiculo findByMatricula(String matricula) {
        EntityManager em = getEntityManager();
        // Se crea la Query a partir del nombre de la NamedQuery de la clase Vehiculo
        Query q = em.createNamedQuery("Vehiculo.findMatricula");
        // Se establece el parámetro de la consulta
        q.setParameter("matricula", matricula);
        // Se ejecuta la consulta
        Vehiculo v = (Vehiculo) q.getSingleResult();
        // Cierra el entityManager
        em.close();
        return v;
    }

    // Crea un objeto EntityManager usando una unidad de persistencia
    private static EntityManager getEntityManager() {
        // EntityManager permite realizar operaciones con la BD
        // Se obtiene a través del EntityManagerFactory y este a su vez se genera
        // a partir del nombre de establecido en el valor de la propiedad
        // persistence-unit name en el fichero de configuración de la unidad de persistencia
        // (fichero persistence.xml)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bdvehiculo");
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }

    // El contexto de persistencia es una caché intermedia que permite gestionar
    // las entidades que se van a modificar en la base de datos.
    // Se puede usar para almacenar entidades que se van a modificar y no se
    // quieren cargar en la memoria del programa. 


}
