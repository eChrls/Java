package paqueteC;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GestorVaquerias {
    // Usamos HashMap para asociar cada vaquería con un identificador único
    private Map<String, Vaqueria> vaquerias;
    
    // Constructor
    public GestorVaquerias() {
        vaquerias = new HashMap<>();
    }
    
    // Método para guardar una vaquería con su identificador
    public void guardarVaqueria(String identificador, Vaqueria vaqueria) {
        // El método put() asocia la vaquería con su identificador
        vaquerias.put(identificador, vaqueria);
    }
    
    // Método para obtener una vaquería según su identificador
    public Vaqueria obtenerVaqueria(String identificador) {
        // El método get() devuelve la vaquería asociada al identificador
        return vaquerias.get(identificador);
    }
    
    // Método para obtener todas las vaquerías
    public Collection<Vaqueria> obtenerTodasVaquerias() {
        // El método values() devuelve una colección con todas las vaquerías
        return vaquerias.values();
    }
    
    // Método para eliminar una vaquería
    public void eliminarVaqueria(String identificador) {
        // El método remove() elimina la entrada para el identificador especificado
        vaquerias.remove(identificador);
    }
    
    // Método para verificar si existe una vaquería con un identificador dado
    public boolean existeVaqueria(String identificador) {
        // El método containsKey() verifica si existe una entrada para la clave
        return vaquerias.containsKey(identificador);
    }
    
    // Método para contar cuántas vaquerías hay registradas
    public int contarVaquerias() {
        // El método size() devuelve el número de entradas en el Map
        return vaquerias.size();
    }
}