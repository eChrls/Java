package clasegenerica;

import java.util.ArrayList;
import java.util.List;

import clasegenerica.excepciones.PilaException;

public class Pila <T> {
    // La pila se implementa como una lista de elementos de tipo T.
    // La pila no puede tener más elementos que su capacidad
    private final List<T> elementos;
    private final int capacidad;
    
    // Crea la pila con la capacidad especificada.
    // La capacidad es el número máximo de elementos que puede contener la pila.
    public Pila(int capacidad) {
        elementos = new ArrayList<>(capacidad);
        this.capacidad = capacidad;
    }

    public Pila(){
        // Llamada al constructor con capacidad 
        this(10); 
    }

    // Método para agregar un elemento a la pila
    // Este método no se declara como genérico, ya que la clase ya lo es
    // y el tipo T ya está definido en la declaración de la clase.
    public void poner(T elemento) throws PilaException {
        // Se lanza una excepción PilaException si la pila está llena.
        if (estaLlena()) {
            throw new PilaException("La pila está llena");
        }
        // Se añade el elemento a la lista de elementos
        elementos.add(elemento);
    }

    // Método para sacar el elemento que toque de la pila.
    // Este método no se declara como genérico, ya que la clase ya lo es
    // En este caso el último que se ha añadido a la pila
    public T sacar() throws PilaException {
        // Si la pila está vacía, se lanza una excepción PilaException
        // indicando que no se puede sacar un elemento.
        if (estaVacia()) {
            throw new PilaException("La pila está vacía");
        }
        // Se saca el último elemento de la lista de elementos (LIFO)
        // y se devuelve.
        return elementos.remove(elementos.size() - 1);
    }

    // Este método no es genérico, ya que no usa ningún tipo genérico.
    // Devuelve si está vacía.
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Este método no es genérico, ya que no usa ningún tipo genérico.
    // Devuelve si la pila está llena.
    public boolean estaLlena() {
        return elementos.size() >= capacidad;
    }

    // Este método no es genérico, ya que no usa ningún tipo genérico.
    // Devuelve el número de elementos que hay en la pila.
    public int numeroElementosGuardados() {
        return elementos.size();
    }

    // Este método no es genérico, ya que no usa ningún tipo genérico.
    // Devuelve la capacidad de la pila.
    // La capacidad es el número máximo de elementos que puede contener la pila.
    public int obtenerCapacidad() {
        return capacidad;
    }

    // Este método no se declara como genérico, ya que la clase ya lo es
    // y el tipo T ya está definido en la declaración de la clase.
    // Devuelve una cadena con el contenido de la pila. 
    @Override
    public String toString() {
        // Se crea un StringBuilder para construir la cadena de salida.
        // Se añade la información de la pila a la cadena.
        StringBuilder contenido = new StringBuilder();
        elementos.forEach(elemento -> contenido.append(elemento).append(", "));
        // Se elimina la última coma y espacio de la cadena.
        if (contenido.length() > 0) {
            contenido.delete(contenido.length() - 2, contenido.length());
        }
        // Se crea un StringBuilder para construir la cadena de salida.
        StringBuilder sb = new StringBuilder("Pila: ");
        sb.append("Capacidad: ").append(capacidad)
        .append(", Nº Elementos: ").append(numeroElementosGuardados())
        .append(", Contenido: ").append(contenido);
    
        return sb.toString();
    }

}
